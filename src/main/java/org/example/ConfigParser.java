package org.example;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;

public class ConfigParser {
    public static ShellConfig loadConfig(String path) {
        YAMLMapper mapper = new YAMLMapper();
        try {
            return mapper.readValue(new File(path), ShellConfig.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration: " + e.getMessage());
        }
    }
}

