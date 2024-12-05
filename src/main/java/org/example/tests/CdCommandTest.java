package org.example.tests;

import org.example.VirtualFileSystem;
import org.example.commands.CdCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CdCommandTest {
    @Test
    public void testChangeToExistingDirectory() {
        // Мок виртуальной файловой системы
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        // Эмуляция успешной смены директории
        Mockito.doReturn(true).when(vfs).changeDirectory("folder1");

        // Создаем команду cd
        CdCommand cd = new CdCommand(vfs);

        // Выполняем команду cd
        boolean result = cd.execute("folder1");

        // Проверяем, что команда выполнена успешно
        assertTrue(result);
    }

    @Test
    public void testChangeToNonExistingDirectory() {
        // Мок виртуальной файловой системы
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        // Эмуляция неудачной смены директории
        Mockito.doReturn(false).when(vfs).changeDirectory("nonexistent");

        // Создаем команду cd
        CdCommand cd = new CdCommand(vfs);

        // Выполняем команду cd
        boolean result = cd.execute("nonexistent");

        // Проверяем, что команда завершилась с ошибкой
        assertFalse(result);
    }

    @Test
    public void testChangeToParentDirectory() {
        // Мок виртуальной файловой системы
        VirtualFileSystem vfs = Mockito.mock(VirtualFileSystem.class);

        // Эмуляция успешной смены директории на родительскую
        Mockito.doReturn(true).when(vfs).changeDirectory("..");

        // Создаем команду cd
        CdCommand cd = new CdCommand(vfs);

        // Выполняем команду cd
        boolean result = cd.execute("..");

        // Проверяем, что команда выполнена успешно
        assertTrue(result);
    }
}
