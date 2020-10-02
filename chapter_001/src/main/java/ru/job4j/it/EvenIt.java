package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    int value = 0;


    public EvenIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data[value] % 2 != 0) {
            value++;
            if (value >= data.length) {
                value = data.length - 1;
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[value++];
    }
}