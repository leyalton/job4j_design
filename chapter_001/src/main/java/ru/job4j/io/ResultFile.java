package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int r = 0; r < size; r++) {
                table[i][r] = (i + 1) * (r + 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        ResultFile resultFile = new ResultFile();
        int[][] table = resultFile.multiple(2);
        try (FileOutputStream out = new FileOutputStream("matrix.txt")) {
            out.write(Arrays.deepToString(table).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}