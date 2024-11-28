package org.example.commands;

import org.example.VirtualFileSystem;

public class CdCommand implements Command {
    private final VirtualFileSystem vfs;

    public CdCommand(VirtualFileSystem vfs) {
        this.vfs = vfs;
    }

    @Override
    public boolean execute(String args) {
        try {
            vfs.changeDirectory(args);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }
}
