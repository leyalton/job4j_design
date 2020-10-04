package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private final ForwardLinked<T> linked = new ForwardLinked<>();
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public T pop() {
        Iterator<T> it = linked.iterator();
        T rsl = it.next();
        linked.deleteFirst();
        size--;
        return rsl;
    }

    public void push(T value) {
        linked.addFirst(value);
        size++;
    }
}