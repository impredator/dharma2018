package com.dharma.patterns.gof.behavioral.visitor;

import java.lang.reflect.Method;

interface ReflectElement {
    void accept(ReflectiveVisitor v);
}

class This implements ReflectElement {
    public void accept(ReflectiveVisitor v) {
        v.visit(this);
    }

    public String me() {
        return "This";
    }
}

class That implements ReflectElement {
    public void accept(ReflectiveVisitor v) {
        v.visit(this);
    }

    public String that() {
        return "That";
    }
}

class TheOther implements ReflectElement {
    public void accept(ReflectiveVisitor v) {
        v.visit(this);
    }

    public String theOther() {
        return "TheOther";
    }
}

abstract class ReflectiveVisitor {
    abstract public void visit(Object o);

    public void visitTheOther(TheOther e) {
        System.out.println("ReflectiveVisitor: do Base on " + e.theOther());
    }

    Method getMethod(Class source) {
        Class  clazz = source;
        Method methodName   = null;
        while (methodName == null  &&  clazz != Object.class) {
            String clazzName = clazz.getName();
            clazzName = "visit" + clazzName.substring(clazzName.lastIndexOf('.') + 1);
            try {
                methodName = getClass().getMethod(clazzName, clazz);
            } catch (NoSuchMethodException ex) {
                clazz = clazz.getSuperclass();
            }
        }
        if (clazz == Object.class) {
            Class[] interfaces = source.getInterfaces();
            for (Class intface : interfaces) {
                String interfaceName = intface.getName();
                interfaceName = "visit" + interfaceName.substring(interfaceName.lastIndexOf('.') + 1);
                try {
                    methodName = getClass().getMethod(interfaceName, intface);
                } catch (NoSuchMethodException ex) {
                }
            }
        }
        if (methodName == null)
            try {
                methodName = getClass().getMethod("visitObject", Object.class);
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
        return methodName;
    }
}

class ReflectiveUpVisitor extends ReflectiveVisitor {
    public void visit(Object o) {
        try {
            getMethod(o.getClass()).invoke(this, o);
        } catch (Exception ex) {
            System.out.println( "UpVisitor - no appropriate visit() method" );
        }
    }

    public void visitThis(This element) {
        System.out.println("UpVisitor: do Up on " + element.me());
    }

    public void visitObject(Object o) {
        System.out.println("UpVisitor: generic visitObject() method");
    }
}

class ReflectiveDownVisitor extends ReflectiveVisitor {
    public void visit(Object o) {
        try {
            getMethod(o.getClass()).invoke(this, o);
        } catch (Exception ex) {
            System.out.println( "DownVisitor - no appropriate visit() method" );
        }
    }

    public void visitThat(That element) {
        System.out.println("DownVisitor: do Down on " + element.that());
    }
}

public class RefectedVisitor {
    public static void main( String[] args ) {
        ReflectElement[] list = {new This(), new That(), new TheOther()};
        ReflectiveUpVisitor up = new ReflectiveUpVisitor();
        ReflectiveDownVisitor down = new ReflectiveDownVisitor();
        for (ReflectElement element : list) {
            element.accept(up);
        }
        for (ReflectElement element : list) {
            element.accept(down);
        }
    }
}
