package com.dharma.patterns.gof.bridge;

import java.util.Random;

class SNode {
    public int value;
    public SNode prev, next;

    SNode(int i) {
        value = i;
    }
}

//接口，有一个实现对象，代理所有请求到这个对象
class SStack {
    //实现对象
    private SStackImpl impl;

    SStack(String s) {
        if (s.equals("array")) {
            impl = new SStackArray();
        } else if (s.equals("list")) {
            impl = new SStackList();
        } else {
            System.out.println("Stack: unknown parameter");
        }
    }

    public SStack() {
        this("array");
    }

    public void push(int in) {
        impl.push(in);
    }

    public int pop() {
        return impl.pop();
    }

    public int top() {
        return impl.top();
    }

    public boolean isEmpty() {
        return impl.isEmpty();
    }

    public boolean isFull() {
        return impl.isFull();
    }
}

//装饰接口类（handle）
class SStackHanoi extends SStack {
    private int totalRejected = 0;

    SStackHanoi() {
        super("array");
    }

    public SStackHanoi(String s) {
        super(s);
    }

    public int reportRejected() {
        return totalRejected;
    }

    public void push(int in) {
        if (!isEmpty() && in > top()) {
            totalRejected++;
        } else {
            super.push(in);
        }
    }
}

class SStackFIFO extends SStack {
    private SStackImpl stackImpl = new SStackList();

    SStackFIFO() {
        super("array");
    }

    public SStackFIFO(String s) {
        super(s);
    }

    public int pop() {
        while (!isEmpty()) {
            stackImpl.push(super.pop());
        }
        int ret = stackImpl.pop();
        while (!stackImpl.isEmpty()) {
            push(stackImpl.pop());
        }
        return ret;
    }
}

//实现（body）基类
interface SStackImpl {
    void push(int i);

    int pop();

    int top();

    boolean isEmpty();

    boolean isFull();
}

//分别实现
class SStackArray implements SStackImpl {
    private int[] items;
    private int total = -1;

    SStackArray() {
        this.items = new int[12];
    }

    public SStackArray(int cells) {
        this.items = new int[cells];
    }

    public void push(int i) {
        if (!isFull()) {
            items[++total] = i;
        }
    }

    public boolean isEmpty() {
        return total == -1;
    }

    public boolean isFull() {
        return total == items.length - 1;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return items[total];
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return items[total--];
    }
}

class SStackList implements SStackImpl {
    private SNode last;

    public void push(int i) {
        if (last == null) {
            last = new SNode(i);
        } else {
            last.next = new SNode(i);
            last.next.prev = last;
            last = last.next;
        }
    }

    public boolean isEmpty() {
        return last == null;
    }

    public boolean isFull() {
        return false;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return last.value;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int ret = last.value;
        last = last.prev;
        return ret;
    }
}

public class BridgeDisk {
    public static void main(String[] args) {
        SStack[] stacks = {new SStack("array"), new SStack("list"), new SStackFIFO(), new SStackHanoi()};
        for (int i = 1, num; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                stacks[j].push(i);
            }
        }
        Random rn = new Random();
        for (int i = 1, num; i < 15; i++) {
            stacks[3].push(rn.nextInt(20));
        }

        for (int i = 0, num; i < stacks.length; i++) {
            while (!stacks[i].isEmpty()) {
                System.out.print(stacks[i].pop() + "  ");
            }
            System.out.println();
        }
        System.out.println("total rejected is " + ((SStackHanoi) stacks[3]).reportRejected());
    }
}
