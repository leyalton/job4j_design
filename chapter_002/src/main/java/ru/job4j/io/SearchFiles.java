package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {
    private final List<Path> pathsList = new ArrayList<>();
    Predicate<Path> filter;

    SearchFiles(Predicate<Path> filter) {
        this.filter = filter;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (filter.test(file)) {
            pathsList.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getPaths() {
        return pathsList;
    }
}