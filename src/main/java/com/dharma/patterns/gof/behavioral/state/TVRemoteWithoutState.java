package com.dharma.patterns.gof.behavioral.state;

public class TVRemoteWithoutState {

    private String state = "";

    private void setState(String state) {
        this.state = state;
    }

    private void doAction() {
        if (state.equalsIgnoreCase("ON")) {
            System.out.println("TV is turned ON");
        } else if (state.equalsIgnoreCase("OFF")) {
            System.out.println("TV is turned OFF");
        }
    }

    public static void main(String args[]) {
        TVRemoteWithoutState remote = new TVRemoteWithoutState();

        remote.setState("ON");
        remote.doAction();

        remote.setState("OFF");
        remote.doAction();
    }

}
