package org.example.commands;


import org.example.VirtualFileSystem;

import java.nio.file.Files;
import java.nio.file.Path;

public class RmdirCommand implements Command {
    private final VirtualFileSystem vfs;

    public RmdirCommand(VirtualFileSystem vfs) {
        this.vfs = vfs;
    }

    @Override
    public boolean execute(String args) {
        try {
            Path dir = vfs.getCurrentDirectory().resolve(args);
            if (Files.isDirectory(dir)) {
                Files.delete(dir);
                System.out.println("Directory removed: " + args);
            } else {
                System.out.println("Directory not found: " + args);
            }
        } catch (Exception e) {
            System.out.println("Error removing directory: " + e.getMessage());
        }
        return true;
    }
}
