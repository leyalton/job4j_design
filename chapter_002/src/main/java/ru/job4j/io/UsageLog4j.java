package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte one = 1;
        short two = 2;
        char three = 't';
        long four = 4;
        float five = 5;
        double six = 6;
        int seven = 7;
        boolean eight = true;
        LOG.debug("oneVar : {}, twoVar : {}, threeVar : {}, fourVar : {}, fiveVar : {}, sixVar : {}, sevenVar : {}, eightVar : {}", one, two, three, four, five, six, seven, eight);
    }
}