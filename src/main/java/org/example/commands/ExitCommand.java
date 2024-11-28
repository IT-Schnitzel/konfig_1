package org.example.commands;


public class ExitCommand implements Command {
    @Override
    public boolean execute(String args) {
        System.out.println("Exiting...");
        return false; // Сигнал для завершения
    }
}

