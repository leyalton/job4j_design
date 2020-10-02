package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int position = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.objects = new Object[10];
    }

    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) this.objects[index];
    }

    public void add(T model) {
        if (position == objects.length) {
            objects = Arrays.copyOf(objects, objects.length + 10);
        }
        this.objects[position++] = model;
        this.modCount++;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final Object[] array = objects;
            private int index = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < position;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[index++];
            }
        };
    }
}