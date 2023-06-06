package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MaxMinTest {
    private final List<Integer> listInteger = new ArrayList<>();
    private final List<String> listString = new ArrayList<>();
    MaxMin maxMinTest = new MaxMin();

    @BeforeEach
    void setUp() {
        listInteger.add(8);
        listInteger.add(4);
        listInteger.add(15);
        listString.add("1");
        listString.add("12");
        listString.add("1234");
    }

    @Test
    void whenCheckMaxInteger() {
        assertThat(listInteger.get(2)).isEqualTo(maxMinTest.max(listInteger, Integer::compareTo));
    }

    @Test
    void whenCheckMinInteger() {
        assertThat(listInteger.get(1)).isEqualTo(maxMinTest.min(listInteger, Integer::compareTo));
    }

    @Test
    void whenCheckMinString() {
        assertThat(listString.get(0)).isEqualTo(maxMinTest.min(listString, String::compareTo));
    }

    @Test
    void whenCheckMaxString() {
        assertThat(listString.get(2)).isEqualTo(maxMinTest.max(listString, String::compareTo));
    }
}