package com.epam.task2.controller;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.logic.ParserLogic;
import com.epam.task2.logic.TextLogic;
import com.epam.task2.manager.FileManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static Logger LOGGER = LogManager.getLogger(Runner.class);
    private static final String FILE_PATH = "C:\\Users\\SomSom\\IdeaProjects\\Task2\\src\\main\\resources\\text.txt";
    private static final String TEST = "The if-then-else statement provides an secondary path of execution when an \"if\" clause evaluates to false. You could use an if-then-else statement in the applyBrakes method to take some action if the brakes are applied when the bicycle is not in motion. In this case, the action is to simply print an error message stating that the bicycle has already stopped.\n" +
            "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion. One possible implementation of the applyBrakes method could be as follows:\n" +
            "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion.\n";


    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String text = fileManager.getTextFromFile(FILE_PATH);
        CompositeUnitEntity parsedText = (CompositeUnitEntity) ParserLogic.parse(text);
        LOGGER.info(parsedText);
        TextLogic textLogic = new TextLogic();
        CompositeUnitEntity parsedTest = textLogic.replaceOnLength(TEST, 6, 4, "ireplacer");
        LOGGER.info(parsedTest.getContent());
        LOGGER.info(textLogic.findNumberSentencesWithReapeats(TEST));
    }


}
