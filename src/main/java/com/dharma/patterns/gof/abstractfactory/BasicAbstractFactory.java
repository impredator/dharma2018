package com.dharma.patterns.gof.abstractfactory;

// class CPU
abstract class CPU {}
class EmberCPU extends CPU {}
class EnginolaCPU extends CPU {}

// class MMU
abstract class MMU {}
class EmberMMU extends MMU {}
class EnginolaMMU extends MMU {}

// factory EmberFactory
class EmberToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}

// factory Enginola
class EnginolaToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}


//Abstract factory
enum Architecture {
    ENGINOLA, EMBER
}

abstract class AbstractFactory {
    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
                break;
            case EMBER:
                factory = EMBER_TOOLKIT;
                break;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();
}

public class BasicAbstractFactory {
    public static void main(String[] args) {
        AbstractFactory emberFactory = AbstractFactory.getFactory(Architecture.EMBER);
        CPU cpu = emberFactory.createCPU();
        System.out.println(cpu);

        AbstractFactory enginolaFactory = AbstractFactory.getFactory(Architecture.ENGINOLA);
        MMU mmu = enginolaFactory.createMMU();
        System.out.println(mmu);
    }
}
