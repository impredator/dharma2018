package com.dharma.patterns.gof.create.abstractfactory;

//Implementation
abstract class Cloud {

    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
    }
}

class AliYun extends Cloud {

    private String ram;
    private String hdd;
    private String cpu;

    AliYun(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}

class AWS extends Cloud {

    private String ram;
    private String hdd;
    private String cpu;

    AWS(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}

class GoogleCloud extends Cloud {

    private String ram;
    private String hdd;
    private String cpu;

    GoogleCloud(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}


//Factory
interface CloudAbstractFactory {
    Cloud createCloud();
}

class AWSFactory implements CloudAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    AWSFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Cloud createCloud() {
        return new AWS(ram, hdd, cpu);
    }

}

class AliYunFactory implements CloudAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    AliYunFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Cloud createCloud() {
        return new AliYun(ram, hdd, cpu);
    }

}

class GoogleCloudFactory implements CloudAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    GoogleCloudFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Cloud createCloud() {
        return new GoogleCloud(ram, hdd, cpu);
    }

}


//Abstract Factory
class CloudFactory {

    public static Cloud getCloud(CloudAbstractFactory factory) {
        return factory.createCloud();
    }
}


public class DemoAbstractFactory {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        Cloud aws = CloudFactory.getCloud(new AWSFactory("2 GB", "500 GB", "2.4 GHz"));
        Cloud ali = CloudFactory.getCloud(new AliYunFactory("16 GB", "1 TB", "2.9 GHz"));
        Cloud gog = CloudFactory.getCloud(new GoogleCloudFactory("128 GB", "1000 TB", "10 GHz"));
        System.out.println("Abstract Cloud AWS Config::" + aws);
        System.out.println("Abstract Cloud AliYun Config::" + ali);
        System.out.println("Abstract Cloud Google Config::" + gog);
    }
}
