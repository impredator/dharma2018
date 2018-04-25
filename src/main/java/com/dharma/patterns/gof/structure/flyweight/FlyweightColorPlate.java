package com.dharma.patterns.gof.structure.flyweight;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

class ColorPlate extends Canvas {
    private Color curColor = getColor();
    private static Color[] colors = {Color.black, Color.blue, Color.cyan,
            Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.red,
            Color.magenta, Color.orange, Color.pink, Color.white, Color.yellow};

    //Flyweight: the color changing and painting
    ColorPlate(ThreadPool tp) {
        tp.register(this);
    }

    private static Color getColor() {
        return colors[(int) (Math.random() * 1000) % colors.length];
    }

    public void changeColor() {
        curColor = getColor();
        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(curColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}

class ThreadPool {
    private Vector boxes = new Vector();
    private int pause;

    class HandlerThread extends Thread {
        public void run() {
            while (true) {
                ((ColorPlate) boxes.elementAt(
                        (int) (Math.random() * 1000) % boxes.size())).changeColor();
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    ThreadPool(int p) {
        pause = p;
    }

    public void register(ColorPlate r) {
        boxes.addElement(r);
    }

    public void start() {
        int NUM_THREADS = 8;
        for (int i = 0; i < NUM_THREADS; i++) {
            new HandlerThread().start();
        }
    }
}

public class FlyweightColorPlate {
    public static void main(String[] args) {
        int size = 8;
        int pause = 100;
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            pause = Integer.parseInt(args[1]);
        }
        ThreadPool tp = new ThreadPool(pause);
        Frame frame = new Frame("ColorPlatees - 8 shared HandlerThreads");
        frame.setLayout(new GridLayout(size, size));
        for (int i = 0; i < size * size; i++) {
            frame.add(new ColorPlate(tp));
        }
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tp.start();
    }
}

