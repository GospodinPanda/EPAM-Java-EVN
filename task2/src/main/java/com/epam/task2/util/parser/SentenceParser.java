package com.epam.task2.util.parser;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.entity.TextUnit;
import com.epam.task2.entity.TextUnitType;
import com.epam.task2.manager.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends TextParser {

    private static final String REGEX_SENTENCE = "regex.sentence";

    @Override
    public TextUnit parse(String text) {
        CompositeUnitEntity parsedText = new CompositeUnitEntity(TextUnitType.PARAGRAPH);
        List<String> sentences = new ArrayList<>();
        Matcher matcher = Pattern.compile(ResourceManager.getProperty(REGEX_SENTENCE)).matcher(text);
        while (matcher.find()) {
            sentences.add(matcher.group());
        }


        for (String sentence : sentences) {
            parsedText.addChildTextUnit(nextParser.parse(sentence));
        }
        return parsedText;
    }
}
