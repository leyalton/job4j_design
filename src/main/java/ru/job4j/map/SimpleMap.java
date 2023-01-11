package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        expand();
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        if (count >= capacity * LOAD_FACTOR) {
            capacity = capacity * 2;
            MapEntry<K, V>[] tmp = new MapEntry[capacity];
            for (MapEntry<K, V> kvMapEntry : table) {
                if (kvMapEntry != null) {
                    int index = getIndex(kvMapEntry.key);
                    tmp[index] = new MapEntry<>(kvMapEntry.key, kvMapEntry.value);
                }
            }
            table = tmp;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return (table[index] != null
                &&
                Objects.hashCode(key) == Objects.hashCode(table[index].key)
                &&
                Objects.equals(key, table[index].key)) ? table[index].value : null;
    }


    private boolean isKeyEqual(K key, int index) {
        return table[index] != null && Objects.hashCode(key) == Objects.hashCode(table[index].key) && Objects.equals(key, table[index].key);
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = getIndex(key);
        if (isKeyEqual(key, index)) {
            table[index] = null;
            count--;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < table.length && table[point] == null) {
                    point++;
                }
                return point < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    K key = table[point].key;
                    point++;
                    return key;
                }
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}