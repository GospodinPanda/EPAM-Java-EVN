package com.epam.task2.util.parser;

import com.epam.task2.entity.*;
import com.epam.task2.manager.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceUnitParser extends TextParser {
    private final static String REGEX_UNIT ="regex.unit";
    private final static String REGEX_PUNCTUATION ="regex.punctuation";

    @Override
    public TextUnit parse(String text) {
        CompositeUnitEntity parsedSentence = new CompositeUnitEntity(TextUnitType.SENTENCE);
        List<String> sentenceParts = new ArrayList<>();
        Matcher matcher = Pattern.compile(ResourceManager.getProperty(REGEX_UNIT)).matcher(text);
        while (matcher.find()){
            sentenceParts.add(matcher.group());
        }
        for(String sentencePart: sentenceParts){
            if(!sentencePart.matches(ResourceManager.getProperty(REGEX_PUNCTUATION))){
                parsedSentence.addChildTextUnit(nextParser.parse(sentencePart));
            }else{
                parsedSentence.addChildTextUnit(new LeafUnit(TextUnitType.PUNCTUATION_CHAR,sentencePart));
            }
        }
        return parsedSentence;
}}
