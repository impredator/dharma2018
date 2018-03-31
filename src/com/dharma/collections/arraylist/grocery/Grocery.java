package com.dharma.collections.arraylist.grocery;

import java.util.ArrayList;

public class Grocery {

    int[] total;
    ArrayList<String> grocery = new ArrayList<>();

    public void groceryItemAdd(String item) {
        grocery.add(item);
    }

    public void grocery() {
        System.out.println("You have " + grocery.size() + " items");

        for (String groceryItem : grocery) {
            System.out.println(groceryItem);
        }
    }

    public void modifyGroceryList(int position, String newItem) {
        grocery.set(position, newItem);
        System.out.println("Grocery Item" + (position + 1) + "has been modified");
    }

    public void removeGroceryItem(int position) {
        String theItem = grocery.get(position);
        grocery.remove(position);
        System.out.println("Item" + theItem + "Removed");
    }

    public String findGroceryItem(String item) {
        int position = grocery.indexOf(item);
        if (position >= 0) {
            System.out.println(position);
            return grocery.get(position);
        }

        return null;
    }
}