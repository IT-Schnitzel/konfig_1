package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VirtualFileSystem {
    private Path root;
    private Path current;

    public VirtualFileSystem(String zipPath) {
        // Распаковать zip в временную директорию
        root = FileSystemUtils.unzipToTempDirectory(zipPath);
        current = root;
    }

    public Path getCurrentDirectory() {
        return current;
    }

    public void changeDirectory(String path) {
        Path newPath = current.resolve(path).normalize();
        if (Files.isDirectory(newPath)) {
            current = newPath;
        } else {
            throw new IllegalArgumentException("Directory not found: " + path);
        }
    }

    public void removeDirectory(String name) {
        Path dir = current.resolve(name);
        if (Files.isDirectory(dir)) {
            try {
                FileSystemUtils.deleteDirectory(dir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Directory not found: " + name);
        }
    }
}
