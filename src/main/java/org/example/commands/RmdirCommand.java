package org.example.commands;

import org.example.VirtualFileSystem;

public class RmdirCommand implements Command {
    private final VirtualFileSystem vfs;

    public RmdirCommand(VirtualFileSystem vfs) {
        this.vfs = vfs;
    }

    @Override
    public boolean execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("Usage: rmdir <directory_name>");
            return false;
        }

        String dirName = args.trim();
        boolean success = vfs.removeDirectory(dirName);

        if (success) {
            System.out.println("Directory " + dirName + " removed.");
            return true;
        } else {
            System.out.println("Failed to remove directory: " + dirName);
            return false;
        }
    }
}
