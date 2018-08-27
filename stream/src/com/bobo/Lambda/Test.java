package com.bobo.Lambda;

enum Signal {
    GREEN, YELLOW, RED
}
public class Test {
    Signal color = Signal.RED;
    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.change();
        System.out.println(test.color);
    }
}