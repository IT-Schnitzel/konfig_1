package org.example.tests;

import org.example.VirtualFileSystem;
import org.example.commands.LsCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LsCommandTest {
    @Test
    public void testListFilesInDirectory() {
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        // Эмуляция содержимого текущей директории
        Mockito.doReturn(new String[]{"file1.txt", "file2.txt"}).when(vfs).getCurrentDirectory();

        LsCommand ls = new LsCommand(vfs);
        boolean result = ls.execute("");

        // Проверяем, что команда выполнена успешно
        assertTrue(result);
    }

    @Test
    public void testListFilesInEmptyDirectory() {
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        // Эмуляция пустой директории
        Mockito.doReturn(new String[]{}).when(vfs).getCurrentDirectory();

        LsCommand ls = new LsCommand(vfs);
        boolean result = ls.execute("");

        assertTrue(result);
    }

    @Test
    public void testListFilesWithNestedDirectories() {
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        // Эмуляция содержимого с вложенными директориями
        Mockito.doReturn(new String[]{"folder1/", "folder2/", "file.txt"}).when(vfs).getCurrentDirectory();

        LsCommand ls = new LsCommand(vfs);
        boolean result = ls.execute("");

        assertTrue(result);
    }
}
