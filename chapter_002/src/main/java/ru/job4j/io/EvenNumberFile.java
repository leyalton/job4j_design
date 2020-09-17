package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static boolean evenNumber(int num) {
        boolean rsl = false;
        if(num % 2 == 0 && (num > 48 || num < 57)){
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
           if(evenNumber(read)){
                    text.append((char) read);
                }
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}