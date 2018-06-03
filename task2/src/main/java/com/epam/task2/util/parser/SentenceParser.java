package com.epam.task2.util.parser;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.entity.TextUnit;
import com.epam.task2.entity.TextUnitType;
import com.epam.task2.manager.ResourceManager;

public class SentenceParser extends TextParser {

    private static final String REGEX_SENTENCE = "regex.sentence";
    @Override
    public TextUnit parse(String text) {
        CompositeUnitEntity parsedText = new CompositeUnitEntity(TextUnitType.PARAGRAPH);
        String[] sentences = text.split(ResourceManager.getProperty(REGEX_SENTENCE));

        for(String sentence : sentences){
            parsedText.addChildTextUnit(nextParser.parse(sentence));
        }
        return parsedText;
    }
}
