package com.dharma.patterns.gof.structure.adapter;

class Volt {

    private int volts;

    Volt(int v) {
        this.volts = v;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

}

class Socket {
    Volt getVolt() {
        return new Volt(120);
    }
}

//转换到不同强度的电压
interface SocketAdapter {

    Volt get120Volt();

    Volt get12Volt();

    Volt get3Volt();
}

//1. 继承
class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolt();
        return convertVolt(v, 40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }

}

//2. 组合
class SocketObjectAdapterImpl implements SocketAdapter{

    private Socket sock = new Socket();

    @Override
    public Volt get120Volt() {
        return sock.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v= sock.getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3Volt() {
        Volt v= sock.getVolt();
        return convertVolt(v,40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }
}

public class DemoAdapter {
    public static class AdapterPatternTest {

        public static void main(String[] args) {

            testClassAdapter();
            testObjectAdapter();
        }

        private static void testObjectAdapter() {
            SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
            Volt v3 = getVolt(sockAdapter, 3);
            Volt v12 = getVolt(sockAdapter, 12);
            Volt v120 = getVolt(sockAdapter, 120);
            System.out.println("v3 volts using Object Adapter=" + v3.getVolts());
            System.out.println("v12 volts using Object Adapter=" + v12.getVolts());
            System.out.println("v120 volts using Object Adapter=" + v120.getVolts());
        }

        private static void testClassAdapter() {
            SocketAdapter sockAdapter = new SocketClassAdapterImpl();
            Volt v3 = getVolt(sockAdapter, 3);
            Volt v12 = getVolt(sockAdapter, 12);
            Volt v120 = getVolt(sockAdapter, 120);
            System.out.println("v3 volts using Class Adapter=" + v3.getVolts());
            System.out.println("v12 volts using Class Adapter=" + v12.getVolts());
            System.out.println("v120 volts using Class Adapter=" + v120.getVolts());
        }

        private static Volt getVolt(SocketAdapter sockAdapter, int i) {
            switch (i) {
                case 3:
                    return sockAdapter.get3Volt();
                case 12:
                    return sockAdapter.get12Volt();
                case 120:
                    return sockAdapter.get120Volt();
                default:
                    return sockAdapter.get120Volt();
            }
        }
    }
}
