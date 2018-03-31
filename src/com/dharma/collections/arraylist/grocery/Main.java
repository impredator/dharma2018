package com.dharma.collections.arraylist.grocery;

import java.util.Scanner;

class Operator {
    private static Scanner scanner = new Scanner(System.in);
    private static Grocery grocery;

    public Operator(Grocery grocery) {
        this.grocery = grocery;
    }

    public static void printInstruction() {
        System.out.println("0. Instructions  1. List Items 2. Add Items 3. Modify Items 4. Remove Items 5. Search Items 6. Quit");
    }

    public void waitingForInput() {
        boolean quit = false;
        int choice = 0;

        while (!quit) {

            System.out.println("Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstruction();
                    break;
                case 1:
                    this.grocery.grocery();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }

        }
    }

    public static void addItem() {
        System.out.println("Enter the Item");
        grocery.groceryItemAdd(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Enter position to Modify: ");
        int position = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter The Item:");
        String item = scanner.next();
        grocery.modifyGroceryList(position - 1, item);
    }

    public static void removeItem() {
        System.out.println("Enter position to Remove: ");
        int position = scanner.nextInt();
        grocery.removeGroceryItem(position);
    }

    public static void searchItem() {
        System.out.println("Enter the item to Search ");
        String item = scanner.next();
        grocery.findGroceryItem(item);
    }

}

public class Main {
    private static Grocery grocery = new Grocery();
    private static Operator operator = new Operator(grocery);

    private static void printGroceryInstruction() {
        grocery.grocery();
        operator.printInstruction();
    }

    public static void main(String[] args) {
        printGroceryInstruction();
        operator.waitingForInput();
    }
}
