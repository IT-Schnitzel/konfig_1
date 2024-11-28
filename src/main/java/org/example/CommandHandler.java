package org.example;

import org.example.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private final Map<String, Command> commands;

    public CommandHandler(VirtualFileSystem vfs) {
        commands = new HashMap<>();
        commands.put("ls", new LsCommand(vfs));
        commands.put("cd", new CdCommand(vfs));
        commands.put("exit", new ExitCommand());
        commands.put("rmdir", new RmdirCommand(vfs));
        commands.put("echo", new EchoCommand());
    }

    public boolean execute(String input) {
        // Разбиваем команду на имя и аргументы
        String[] parts = input.trim().split(" ", 2);
        String commandName = parts[0].toLowerCase(); // Приводим имя команды к нижнему регистру
        String args = parts.length > 1 ? parts[1].trim() : ""; // Аргументы обрезаем

        // Ищем команду в зарегистрированных
        Command command = commands.get(commandName);
        if (command != null) {
            try {
                // Выполняем команду
                return command.execute(args);
            } catch (Exception e) {
                // Логируем и обрабатываем исключение
                System.err.println("Error executing command '" + commandName + "': " + e.getMessage());
                e.printStackTrace();
                return true; // Не завершаем программу из-за ошибки
            }
        } else {
            System.out.println("Unknown command: " + commandName);
            return true; // Продолжаем работу
        }
    }
}


