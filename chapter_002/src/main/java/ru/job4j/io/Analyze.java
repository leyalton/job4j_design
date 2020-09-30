package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analyze {
    public void unavailable(String source, String target) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            while (reader.ready()) {
                String status = reader.readLine();
                if (status.startsWith("400") || status.startsWith("500")) {
                    writer.print(status.split(" ")[1] + ";");
                    count++;
                } else if ((!status.startsWith("400") && count % 2 != 0)
                        || (!status.startsWith("500") && count % 2 != 0)) {
                    writer.println(status.split(" ")[1]);
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analyze().unavailable("server.log", "target.csv");
    }
}