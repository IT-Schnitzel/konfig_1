package org.example;

import java.util.Scanner;

public class ShellEmulator {
    private final ShellConfig config;
    private final VirtualFileSystem vfs;
    private final CommandHandler commandHandler;
    private final LoggingService logger;

    public ShellEmulator(ShellConfig config) {
        this.config = config;
        this.vfs = new VirtualFileSystem(config.getFileSystemPath());
        this.commandHandler = new CommandHandler(vfs);
        this.logger = new LoggingService(config.getLogFilePath());
    }

    public void run() {
        System.out.println(config.getHostName() + ">");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(config.getHostName() + ">");
            String input = scanner.nextLine();

            logger.log(input);
            if (!commandHandler.execute(input)) {
                break;
            }
        }
        scanner.close();
    }
}

