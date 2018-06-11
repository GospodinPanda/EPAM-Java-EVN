package com.epam.task2.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    private static Logger LOGGER = LogManager.getLogger(FileManager.class);

    public String getTextFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fr = new FileReader(new File(filePath));
            int c;
            while ((c = fr.read()) != -1) {
                stringBuilder.append((char) c);
            }
            fr.close();
        } catch (IOException e) {
            LOGGER.error("Input/Output exception");
        }
        return stringBuilder.toString();
    }
}
