package com.dharma.patterns.gof.structure.composite;

//1. 基础
interface Component {
    void traverse();
}

//2. 叶子
class Primitive implements Component {
    private int value;

    Primitive(int val) {
        value = val;
    }

    public void traverse() {
        System.out.print(value + "  ");
    }
}

// 2. 叶子
abstract class Composite implements Component {
    // 3. 组合
    private Component[] children = new Component[9];
    private int total = 0;
    private int value;

    Composite(int val) {
        value = val;
    }

    // 3. 组合
    public void add(Component c) {
        children[total++] = c;
    }

    public void traverse() {
        System.out.print(value + "  ");
        for (int i = 0; i < total; i++) {
            // 4. 多态
            children[i].traverse();
        }
    }
}

class Row extends Composite {
    Row(int val) {
        super(val);
    }

    public void traverse() {
        System.out.print("Row");
        super.traverse();
    }
}

class Column extends Composite {
    Column(int val) {
        super(val);
    }

    public void traverse() {
        System.out.print("Col");
        super.traverse();
    }
}

public class DemoCompositeTable {
    public static void main(String[] args) {
        Composite first = new Row(1);
        Composite second = new Column(2);
        Composite third = new Column(3);
        Composite fourth = new Row(4);
        Composite fifth = new Row(5);
        first.add(second);
        first.add(third);
        third.add(fourth);
        third.add(fifth);
        first.add(new Primitive(6));
        second.add(new Primitive(7));
        third.add(new Primitive(8));
        fourth.add(new Primitive(9));
        fifth.add(new Primitive(10));
        first.traverse();
    }
}