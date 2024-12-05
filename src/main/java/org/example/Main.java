package org.example;


public class Main {
    public static void main(String[] args) {
        ShellConfig config = ConfigParser.loadConfig("D:\\Универ\\2_курс\\Java\\konfig_1\\src\\main\\resources\\config.yaml");
        ShellEmulator emulator = new ShellEmulator(config);
        emulator.run();

        VirtualFileSystem vfs = new VirtualFileSystem("D:\\konfig\\filesystem.zip");
        CommandHandler handler = new CommandHandler(vfs);
        handler.execute("ls");
        handler.execute("cd filesystem/fonts");
        handler.execute("ls");
        handler.execute("rmdir testdir");
        handler.execute("echo Hello, world!");
        handler.execute("unknownCommand");
    }
}

