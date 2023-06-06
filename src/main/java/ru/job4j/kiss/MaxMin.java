package ru.job4j.kiss;

import java.util.*;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return loop(value, comparator, false);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return loop(value, comparator, true);
    }

    public <T> T loop(List<T> value, Comparator<T> comparator, boolean extremum) {
        T num = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            boolean result = comparator.compare(num, value.get(i)) > 0;
            if (extremum && result) {
                num = value.get(i);
            } else if (!extremum && !result) {
                num = value.get(i);
            }
        }
        return num;
    }
}
