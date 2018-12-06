package com.dharma.patterns.gof.structure.facade;

// 1. 子系统
class PointCartesian {
    private double x, y;

    PointCartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

// 1. 子系统
    class PointPolar {
    private double radius, angle;

    PointPolar(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public void rotate(int angle) {
        this.angle += angle % 360;
    }

    public String toString() {
        return "[" + radius + "@" + angle + "]";
    }
}

// 1. 识别核心业务，move和rotate
class Point {
    // 2. Design a "wrapper" class
    private PointCartesian pointCartesian;

    Point(double x, double y) {
        pointCartesian = new PointCartesian(x, y);
    }

    public String toString() {
        return pointCartesian.toString();
    }

    // 4. Wrapper maps
    public void move(int x, int y) {
        pointCartesian.move(x, y);
    }

    public void rotate(int angle, Point o) {
        double x = pointCartesian.getX() - o.pointCartesian.getX();
        double y = pointCartesian.getY() - o.pointCartesian.getY();
        PointPolar pointPolar = new PointPolar(Math.sqrt(x * x + y * y), Math.atan2(y, x) * 180 / Math.PI);
        pointPolar.rotate(angle);
        System.out.println("  PointPolar is " + pointPolar);
        String str = pointPolar.toString();
        int i = str.indexOf('@');
        double r = Double.parseDouble(str.substring(1, i));
        double a = Double.parseDouble(str.substring(i + 1, str.length() - 1));
        pointCartesian = new PointCartesian(r * Math.cos(a * Math.PI / 180) + o.pointCartesian.getX(),
                r * Math.sin(a * Math.PI / 180) + o.pointCartesian.getY());
    }
}

class Line {
    private Point o, e;

    Line(Point ori, Point end) {
        o = ori;
        e = end;
    }

    public void move(int x, int y) {
        o.move(x, y);
        e.move(x, y);
    }

    public void rotate(int angle) {
        e.rotate(angle, o);
    }

    public String toString() {
        return "origin is " + o + ", end is " + e;
    }
}

public class FacadeShape {
    public static void main(String[] args) {
        // 3. 使用门面，而不直接使用子系统
        Line lineA = new Line(new Point(2, 4), new Point(5, 7));
        lineA.move(-2, -4);
        System.out.println("after move:  " + lineA);
        lineA.rotate(45);
        System.out.println("after rotate: " + lineA);
        Line lineB = new Line(new Point(2, 1), new Point(2.866, 1.5));
        lineB.rotate(30);
        System.out.println("30 degrees to 60 degrees: " + lineB);
    }
}
