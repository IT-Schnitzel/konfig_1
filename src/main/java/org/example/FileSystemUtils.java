package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileSystemUtils {
    public static Path unzipToTempDirectory(String zipPath) {
        Path tempDir;
        try {
            tempDir = Files.createTempDirectory("vfs");
            try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(zipPath)))) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    Path newFile = tempDir.resolve(entry.getName());
                    if (entry.isDirectory()) {
                        Files.createDirectories(newFile);
                    } else {
                        Files.createDirectories(newFile.getParent());
                        Files.copy(zis, newFile, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
            return tempDir;
        } catch (IOException e) {
            throw new RuntimeException("Failed to unzip file system: " + e.getMessage());
        }
    }

    public static void deleteDirectory(Path dir) throws IOException {
        Files.walk(dir)
                .sorted((a, b) -> b.compareTo(a)) // Удаление в обратном порядке
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to delete: " + path.toString());
                    }
                });
    }
}
