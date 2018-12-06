package com.dharma.patterns.gof.behavioral.state;

class Player {
    private String name;
    private int money;

    Player(String n, int m) {
        name = n;
        money = m;
    }

    public String getName() {
        return name;
    }

    public int getWorth() {
        return money;
    }

    public void debit(int m) {
        money -= m;
    }

    public void credit(int m) {
        money += m;
    }
}

class Property {
    private String name;
    private int price;
    private int rent;
    private Player owner;

    Property(String name) {
        this.name = name;
        price = 100;
        rent = 10;
    }

    public String getName() {
        return name;
    }

    private int getPrice() {
        return price;
    }

    private int getRent() {
        return rent;
    }

    private Player getOwner() {
        return owner;
    }

    private void setOwner(Player p) {
        owner = p;
    }

    void landOnBy(Player p) {
        System.out.print(p.getName() + " landed on " + name);
        if (getOwner() == null) {
            System.out.print(" - not owned\n" + p.getName());
            if (p.getWorth() < getPrice()) {
                System.out.println(" does not have enough money to purchase");
            } else {
                p.debit(getPrice());
                setOwner(p);
                System.out.println(" bought " + getName());
            }
        } else {
            System.out.println(" - owned by " + getOwner().getName());
            if (p != getOwner()) {
                p.debit(getRent());
                getOwner().credit(getRent());
                System.out.println(getOwner().getName() + " now has "
                        + getOwner().getWorth() + " dollars");
            }
        }
        System.out.println(p.getName() + " has " + p.getWorth()
                + " dollars");
    }
}

public class PropertyLend {
    public static void main(String[] args) {
        Player p1 = new Player("Tom", 50);
        Player p2 = new Player("   Dick", 500);

        Property prop = new Property("Boardwalk");
        prop.landOnBy(p1);
        prop.landOnBy(p2);
        prop.landOnBy(p1);
        prop.landOnBy(p2);
        prop.landOnBy(p1);
    }
}
