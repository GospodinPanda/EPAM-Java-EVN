package com.epam.task2.util.parser;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.entity.LeafUnit;
import com.epam.task2.entity.TextUnit;
import com.epam.task2.entity.TextUnitType;
import com.epam.task2.manager.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends TextParser {
    private static final String REGEX_PARAGRAPH = "regex.paragraph";
    private static final String REGEX_CODE = "regex.code";

    @Override
    public TextUnit parse(String text) {
        CompositeUnitEntity parsedText = new CompositeUnitEntity(TextUnitType.TEXT);
        List<String> paragraphs = new ArrayList<>();
        Matcher matcher = Pattern.compile(ResourceManager.getProperty(REGEX_PARAGRAPH)).matcher(text);
        while (matcher.find()){
            paragraphs.add(matcher.group());
        }

        for (String paragraph : paragraphs) {
            matcher = Pattern.compile(ResourceManager.getProperty(REGEX_CODE),Pattern.MULTILINE).matcher(paragraph);
            if (matcher.find()) {
                parsedText.addChildTextUnit(new LeafUnit(TextUnitType.CODE, paragraph));
            } else {
                parsedText.addChildTextUnit(nextParser.parse(paragraph));
            }
        }
        return parsedText;
    }
}
