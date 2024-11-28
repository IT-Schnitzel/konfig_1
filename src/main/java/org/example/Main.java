package org.example;


public class Main {
    public static void main(String[] args) {
        ShellConfig config = ConfigParser.loadConfig("D:\\Универ\\2_курс\\Java\\konfig_1\\src\\main\\resources\\config.yaml");
        ShellEmulator emulator = new ShellEmulator(config);
        emulator.run();
    }
}

