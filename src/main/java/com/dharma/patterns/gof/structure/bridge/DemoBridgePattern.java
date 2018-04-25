package com.dharma.patterns.gof.structure.bridge;

interface Color {
    void applyColor();
}

class RedColor implements Color {

    public void applyColor() {
        System.out.println("red.");
    }
}

class GreenColor implements Color {

    public void applyColor() {
        System.out.println("green.");
    }
}

abstract class Shape {
    //组合
    Color color;

    Shape(Color c) {
        this.color = c;
    }

    abstract public void applyColor();
}

class Triangle extends Shape {

    Triangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }

}

class Pentagon extends Shape {

    Pentagon(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }

}

public class DemoBridgePattern {

    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }

}
