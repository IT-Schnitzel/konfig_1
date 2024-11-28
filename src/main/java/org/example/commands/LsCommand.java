package org.example.commands;

import org.example.VirtualFileSystem;

import java.nio.file.Files;
import java.nio.file.Path;

public class LsCommand implements Command {
    private final VirtualFileSystem vfs;

    public LsCommand(VirtualFileSystem vfs) {
        this.vfs = vfs;
    }

    @Override
    public boolean execute(String args) {
        try {
            Files.list(vfs.getCurrentDirectory())
                    .forEach(path -> System.out.println(path.getFileName()));
        } catch (Exception e) {
            System.out.println("Error listing directory: " + e.getMessage());
        }
        return true;
    }
}

