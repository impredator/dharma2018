package com.dharma.patterns.gof.behavioral.command.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class IntegerBox {
    private final List<Integer> list = new ArrayList<>();

    public void add(int in) {
        list.add(in);
    }

    public List getData() {
        return list;
    }
}

public class DemoBeforeIterator {

    public static void main(String[] args) {
        IntegerBox box = new IntegerBox();
        for (int i = 9; i > 0; --i) {
            box.add(i);
        }

        //用户可以攻击，篡改内部数据
        Collection integerList = box.getData();
        for (Object anIntegerList : integerList) {
            System.out.print(anIntegerList + "  ");
        }
        System.out.println();
        integerList.clear();
        integerList = box.getData();
        System.out.println("size of data is: " + integerList.size());
    }
}
