package com.epam.task2.controller;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.logic.ParserLogic;
import com.epam.task2.logic.TextLogic;
import com.epam.task2.manager.FileManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final String FILE_PATH = "..\\Task2\\src\\main\\resources\\text.txt";
    private static final String TEST_FILE_PATH = "..\\Task2\\src\\main\\resources\\test.txt";
    private static Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String text = fileManager.getTextFromFile(FILE_PATH);
        CompositeUnitEntity parsedText = (CompositeUnitEntity) ParserLogic.parse(text);
        LOGGER.info(parsedText.getContent());
        TextLogic textLogic = new TextLogic();
        CompositeUnitEntity parsedTest = textLogic.replaceOnLength(fileManager.getTextFromFile(TEST_FILE_PATH), 6, 4, "ireplacer");
        LOGGER.info(parsedTest.getContent());
        LOGGER.info(textLogic.findNumberSentencesWithReapeats(fileManager.getTextFromFile(TEST_FILE_PATH)));
    }


}
