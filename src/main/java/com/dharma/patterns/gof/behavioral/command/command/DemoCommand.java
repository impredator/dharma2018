package com.dharma.patterns.gof.behavioral.command.command;

import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}

class DomesticEngineer implements Command {
    public void execute() {
        System.out.println("take out the trash");
    }
}

class Politician implements Command {
    public void execute() {
        System.out.println("take money from the rich, take votes from the poor");
    }
}

class Programmer implements Command {
    public void execute() {
        System.out.println("sell the bugs, charge extra for the fixes");
    }
}

public class DemoCommand {
    private static List produceRequests() {
        List<Command> queue = new ArrayList<>();
        queue.add(new DomesticEngineer());
        queue.add(new Politician());
        queue.add(new Programmer());
        return queue;
    }

    private static void workOffRequests(List queue) {
        for (Object command : queue) {
            ((Command)command).execute();
        }
    }

    public static void main( String[] args ) {
        List queue = produceRequests();
        workOffRequests(queue);
    }
}
