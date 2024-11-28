package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class LoggingService {
    private final Path logFile;

    public LoggingService(String logFilePath) {
        this.logFile = Paths.get(logFilePath);
    }

    public void log(String action) {
        String logEntry = "<log><timestamp>" + LocalDateTime.now() + "</timestamp><action>" + action + "</action></log>";
        try {
            Files.writeString(logFile, logEntry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

