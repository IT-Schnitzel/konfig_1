package org.example.tests;

import org.example.commands.ExitCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ExitCommandTest {
    @Test
    public void testExitCommand() {
        ExitCommand exit = new ExitCommand();

        // Проверяем, что выполнение команды завершает сеанс
        boolean result = exit.execute("");

        assertFalse(result);
    }

    @Test
    public void testExitWithArguments() {
        ExitCommand exit = new ExitCommand();

        // Проверяем, что выполнение команды завершает сеанс, даже с аргументами
        boolean result = exit.execute("some argument");

        assertFalse(result);
    }

    @Test
    public void testExitWithoutArguments() {
        ExitCommand exit = new ExitCommand();

        // Проверяем, что выполнение команды завершает сеанс
        boolean result = exit.execute("");

        assertFalse(result);
    }
}
