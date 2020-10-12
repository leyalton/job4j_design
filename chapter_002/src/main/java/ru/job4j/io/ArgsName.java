package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ArgsName {

    private Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    /**
     * Принцип работы такой:
     * каждый элемент массива разбивается на
     * 2 части с учетом разделителя "="
     * и укладывается в HashMap, без "-"
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments to parse");
        }
        values = Arrays.stream(args)
                .map(line -> line.split("="))
                .collect(Collectors.toMap(a -> a[0].substring(1), a -> a[1]));
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}