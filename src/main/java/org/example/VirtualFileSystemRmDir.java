package org.example;

public interface VirtualFileSystemRmDir {
    void VirtualFileSystemImpl(String rootPath);
    boolean removeDirectory(String dirName);
}
