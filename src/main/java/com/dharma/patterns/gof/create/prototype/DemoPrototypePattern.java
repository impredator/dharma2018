package com.dharma.patterns.gof.create.prototype;

import java.util.ArrayList;
import java.util.List;

class Employees implements Cloneable {

    private List<String> empList;

    Employees() {
        empList = new ArrayList<>();
    }

    private Employees(List<String> list) {
        this.empList = list;
    }

    public void loadData() {
        //db ops
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() {
        List<String> temp = new ArrayList<>();
        for (String s : this.getEmpList()) {
            temp.add(s);
        }
        return new Employees(temp);
    }

}

public class DemoPrototypePattern {

    public static void main(String[] args) {
        //TODO: extract prototype factory
        Employees emps = new Employees();
        emps.loadData();

        Employees empsNew = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");

        Employees empsNew1 = (Employees) emps.clone();
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: " + emps.getEmpList());
        System.out.println("empsNew List: " + list);
        System.out.println("empsNew1 List: " + list1);
    }

}
