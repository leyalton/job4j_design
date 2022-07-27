package ru.job4j.spammer;

public class Array {
    public void processSomethingNotNull(Object myParameter) {
        if (myParameter != null) {
            System.out.println("test");
        } else {
            throw new IllegalArgumentException("Parameter cannot be null");
        }
    }

    public static void main(String[] args) {
        Array array = new Array();
        array.processSomethingNotNull(null);
    }


}