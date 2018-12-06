package com.dharma.patterns.gof.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class NextIntegerBox {
    private List<Integer> list = new ArrayList<>();

    public class Iterator {
        private NextIntegerBox box;
        private java.util.Iterator iterator;
        private int value;

        Iterator(NextIntegerBox integerBox) {
            box = integerBox;
        }

        public void first() {
            iterator = box.list.iterator();
            next();
        }

        public void next() {
            try {
                value = (Integer) iterator.next();
            } catch (NoSuchElementException ex) {
                value = -1;
            }
        }

        public boolean isDone() {
            return value == -1;
        }

        public int currentValue() {
            return value;
        }
    }

    public void add(int in) {
        list.add(in);
    }

    public Iterator getIterator() {
        return new Iterator(this);
    }
}

public class DemoIterator {
    public static void main(String[] args) {
        NextIntegerBox integerBox = new NextIntegerBox();
        for (int i = 9; i > 0; --i) {
            integerBox.add(i);
        }
        // getData方法改为Iterator，用户不能直接操作数据
        NextIntegerBox.Iterator firstItr = integerBox.getIterator();
        NextIntegerBox.Iterator secondItr = integerBox.getIterator();
        for (firstItr.first(); !firstItr.isDone(); firstItr.next()) {
            System.out.print(firstItr.currentValue() + "  ");
        }
        System.out.println();
        for (firstItr.first(), secondItr.first(); !firstItr.isDone(); firstItr.next(), secondItr.next()) {
            System.out.print(firstItr.currentValue() + " " + secondItr.currentValue() + "  ");
        }
    }
}
