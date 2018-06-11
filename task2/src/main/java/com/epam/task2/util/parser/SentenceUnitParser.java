package com.epam.task2.util.parser;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.entity.LeafUnit;
import com.epam.task2.entity.TextUnit;
import com.epam.task2.manager.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceUnitParser extends TextParser {
    private final static String REGEX_UNIT = "regex.unit";

    @Override
    public TextUnit parse(String text) {
        CompositeUnitEntity parsedSentence = new CompositeUnitEntity();
        List<String> sentenceParts = new ArrayList<>();
        Matcher matcher = Pattern.compile(ResourceManager.getProperty(REGEX_UNIT)).matcher(text);
        while (matcher.find()) {
            sentenceParts.add(matcher.group());
        }
        for (String sentencePart : sentenceParts) {
            parsedSentence.addChildTextUnit(new LeafUnit(sentencePart));
        }
        return parsedSentence;
    }
}
