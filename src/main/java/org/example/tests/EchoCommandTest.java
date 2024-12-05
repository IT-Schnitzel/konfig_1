package org.example.tests;

import org.example.commands.EchoCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EchoCommandTest {
    @Test
    public void testEchoText() {
        EchoCommand echo = new EchoCommand();
        boolean result = echo.execute("Hello, World!");
        assertTrue(result);
    }

    @Test
    public void testEchoEmptyString() {
        EchoCommand echo = new EchoCommand();
        boolean result = echo.execute("");

        // Проверяем, что команда выполнена успешно
        assertTrue(result);
    }

    @Test
    public void testEchoSpecialCharacters() {
        EchoCommand echo = new EchoCommand();
        boolean result = echo.execute("!@#$%^&*()_+{}|:\"<>?");

        // Проверяем, что команда выполнена успешно
        assertTrue(result);
    }
}
