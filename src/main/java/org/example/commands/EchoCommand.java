package org.example.commands;


public class EchoCommand implements Command {
    @Override
    public boolean execute(String args) {
        System.out.println(args);
        return true;
    }
}

