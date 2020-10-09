package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args[0] == null || args[1] == null) {
            throw new IllegalArgumentException("Root folder or extension to find is null. Use java -jar dir.jar ROOT_FOLDER EXTENSION_TO_FIND");
        }
        File path = new File(args[0]);
        File ext = new File(args[1]);
        Path start = Paths.get(String.valueOf(path));
        search(start, String.valueOf(ext)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}