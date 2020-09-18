package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static boolean filter(String file) {
        return file.contains("404");
    }

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                if (filter(line)){
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}