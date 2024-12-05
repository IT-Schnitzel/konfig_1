package org.example.tests;

import org.example.VirtualFileSystem;
import org.example.commands.RmdirCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RmdirCommandTest {
    @Test
    public void testRemoveExistingDirectory() {
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        // Эмулируем успешное удаление директории
        Mockito.doNothing().when(vfs).removeDirectory("folder1");

        RmdirCommand rmdir = new RmdirCommand(vfs);
        boolean result = rmdir.execute("folder1");

        assertTrue(result);
    }

    @Test
    public void testRemoveNonExistingDirectory() {
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        Mockito.doThrow(new IllegalArgumentException("Directory does not exist"))
                .when(vfs).removeDirectory("nonexistent");

        RmdirCommand rmdir = new RmdirCommand(vfs);
        boolean result = rmdir.execute("nonexistent");

        assertTrue(result);
    }

    @Test
    public void testRemoveEmptyArgument() {
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        Mockito.doThrow(new IllegalArgumentException("No directory specified"))
                .when(vfs).removeDirectory("");

        RmdirCommand rmdir = new RmdirCommand(vfs);
        boolean result = rmdir.execute("");

        assertTrue(result);
    }
}
