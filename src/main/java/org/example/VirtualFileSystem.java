package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class VirtualFileSystem implements VirtualFileSystemRmDir {
    private File currentDirectory;
    private Path root;
    private Path current;

    public VirtualFileSystem(String zipPath) {
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
    @Override
    public void VirtualFileSystemImpl(String rootPath) {
        this.currentDirectory = new File(rootPath);
    }

    @Override
    public boolean removeDirectory(String dirName) {
        File target = new File(currentDirectory, dirName);
        if (target.exists() && target.isDirectory()) {
            String[] contents = target.list();
            System.out.println(contents);
            if (contents == null || contents.length == 0) {
                return target.delete();
            }
            else {
                System.out.println("non-empty");
            }
        }
        return false;
    }
}
