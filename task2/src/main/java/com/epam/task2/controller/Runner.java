package com.epam.task2.controller;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.logic.ParserLogic;
import com.epam.task2.logic.TextLogic;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Runner {
    private static final String FILE_NAME = "C:\\Users\\SomSom\\IdeaProjects\\Task2\\src\\main\\resources\\text.txt";
    private static Logger LOGGER = LogManager.getLogger(Runner.class);
    private static final String TEST = "If this test evaluates to false (meaning that the bicycle is not in motion), control jumps to the end of the if-then statement.\n" +
            "In addition, the opening and closing braces are optional, provided that the \"then\" clause contains only one statement:";
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fr = new FileReader(new File(FILE_NAME));
            int c;
            while ((c = fr.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            LOGGER.error("Input/Output exception");
        }
        String text = stringBuilder.toString();

        CompositeUnitEntity parsedText = (CompositeUnitEntity) ParserLogic.parse(text);
        System.out.println(parsedText.toString());
        TextLogic textLogic = new TextLogic();
        CompositeUnitEntity parsedTest =   textLogic.replaceOnLength(TEST,1,4,"ireplacer");

    }



}
