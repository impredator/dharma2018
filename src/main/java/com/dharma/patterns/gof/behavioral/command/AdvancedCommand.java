package com.dharma.patterns.gof.behavioral.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SimpleCommand {
    private int state;

    SimpleCommand(int state) {
        this.state = state;
    }

    public void add(Integer value) {
        state += value;
    }

    public void addTwoOperands(Integer firstValue, Integer secondValue) {
        state = state + firstValue + secondValue;
    }

    public int getState() {
        return state;
    }
}

class ReflectCommand {
    private Object receiver;
    private Method action;
    private Object[] args;

    ReflectCommand(Object obj, String methodName, Object[] arguments) {
        this.receiver = obj;
        this.args = arguments;
        Class[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        try {
            action = obj.getClass().getMethod(methodName, argTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public Object execute() {
        try {
            //执行动态传入的方法action和参数args
            action.invoke(receiver, args);
            //执行getState方法，返回结果
            return receiver.getClass().getMethod("getState").invoke(receiver);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class AdvancedCommand {
    public static void main(String[] args) {
        SimpleCommand[] simpleCommands = {new SimpleCommand(1), new SimpleCommand(2)};

        //静态执行命令
        System.out.print("Normal call results: ");
        simpleCommands[0].add(3);
        System.out.print(simpleCommands[0].getState() + " ");
        simpleCommands[1].addTwoOperands(4, 5);
        System.out.print(simpleCommands[1].getState());

        //基于反射动态执行命令
        ReflectCommand[] reflectCommands = {
                new ReflectCommand(simpleCommands[0], "add", new Integer[]{3}),
                new ReflectCommand(simpleCommands[1], "addTwoOperands", new Integer[]{4, 5})
        };
        System.out.print("\nReflection results:  ");
        for (ReflectCommand command : reflectCommands) {
            System.out.print(command.execute() + " ");
        }
        System.out.println();
    }
}
