package com.dharma.patterns.gof.structure.decorator;

// 1. 接口
interface Widget {
    void draw();
}

// 3. 核心功能（必选）
class TextField implements Widget {
    private int width, height;

    TextField(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void draw() {
        System.out.println("TextField: " + width + ", " + height);
    }
}

// 2. 装饰器基类
abstract class Decorator implements Widget {
    // 4. 接受主类对象为参数
    private Widget widget;

    Decorator(Widget widget) {
        this.widget = widget;
    }

    // 5. 代理
    public void draw() {
        widget.draw();
    }
}

// 6. 装饰器（实现）
class BorderDecorator extends Decorator {
    BorderDecorator(Widget widget) {
        super(widget);
    }
    public void draw() {
        // 7. 代理
        super.draw();
        System.out.println("  BorderDecorator");
    }
}

// 6. 装饰器（实现）
class ScrollDecorator extends Decorator {
    ScrollDecorator(Widget widget) {
        super(widget);
    }
    public void draw() {
        super.draw();
        System.out.println("  ScrollDecorator");
    }
}

public class DecoratorWidget {
    public static void main(String[] args) {
        // 8. 客户端动态装饰
        Widget widget = new BorderDecorator(new BorderDecorator(new ScrollDecorator(new TextField(80, 24))));
        widget.draw();
    }
}
