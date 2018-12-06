package com.dharma.collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + price;
    }

}

class Products implements Iterable {

    private List<Product> grocery = null;

    public Products() {
        grocery = new ArrayList<>();
        grocery.add(new Product(1, "Iphone", 8000L));
        grocery.add(new Product(2, "Huawei", 3000L));
        grocery.add(new Product(3, "Mi mix2", 4000L));
        grocery.add(new Product(4, "Essential", 5000L));
    }

    @Override
    public Iterator<Product> iterator() {
        return grocery.iterator();
    }

}

public class GroceryIterator {
    public static void main(String[] args) {
        Products grocery = new Products();
        for (Object product : grocery) {
            System.out.println(product);
        }
    }
}
