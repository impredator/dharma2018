package com.dharma.patterns.gof.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface IPublisher {

    void register(ISubscriber obj);

    void unregister(ISubscriber obj);

    void notifyObservers();

    Object getUpdate(ISubscriber obj);

}

interface ISubscriber {

    void update();

    void setPublisher(IPublisher publisher);
}

class MyPublisher implements IPublisher {

    private List<ISubscriber> subscribers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    MyPublisher() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void register(ISubscriber obj) {
        if (obj == null) throw new NullPointerException("Null Subscriber");
        synchronized (MUTEX) {
            if (!subscribers.contains(obj)) {
                subscribers.add(obj);
            }
        }
    }

    @Override
    public void unregister(ISubscriber obj) {
        synchronized (MUTEX) {
            subscribers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<ISubscriber> subscribersLocal;

        //同步用于保证在消息发布之后注册的观察者不会被通知
        synchronized (MUTEX) {
            if (!changed) return;
            subscribersLocal = new ArrayList<>(this.subscribers);
            this.changed = false;
        }
        for (ISubscriber obj : subscribersLocal) {
            obj.update();
        }

    }

    @Override
    public Object getUpdate(ISubscriber obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }

}

class MyTopicSubscriber implements ISubscriber {

    private String name;
    private IPublisher topic;

    MyTopicSubscriber(String nm) {
        this.name = nm;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null) {
            System.out.println(name + ":: No new message");
        } else
            System.out.println(name + ":: Consuming message::" + msg);
    }

    @Override
    public void setPublisher(IPublisher sub) {
        this.topic = sub;
    }

}

public class DemoObserver {
    public static void main(String[] args) {
        //发布者
        MyPublisher publisher = new MyPublisher();

        //订阅者
        ISubscriber tom = new MyTopicSubscriber("Tom");
        ISubscriber michael = new MyTopicSubscriber("Michael");
        ISubscriber jerry = new MyTopicSubscriber("Jerry");

        //注册订阅者
        publisher.register(tom);
        publisher.register(michael);
        publisher.register(jerry);

        //添加发布者
        tom.setPublisher(publisher);
        michael.setPublisher(publisher);
        jerry.setPublisher(publisher);

        //更新

        tom.update();

        //发送消息
        publisher.postMessage("New Message");
    }

}
