package com.epam.task2.util.parser;
import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.entity.LeafUnit;
import com.epam.task2.entity.TextUnitType;
import com.epam.task2.manager.ResourceManager;
import com.epam.task2.entity.TextUnit;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends TextParser {
    private static final String REGEX_PARAGRAPH = "regex.paragraph";
    private static final String REGEX_CODE = "regex.code";
    @Override
    public TextUnit parse(String text) {
        String[] paragraphs = text.split(ResourceManager.getProperty(REGEX_PARAGRAPH));
        CompositeUnitEntity parsedText = new CompositeUnitEntity(TextUnitType.TEXT);
        Matcher matcher = Pattern.compile(ResourceManager.getProperty(REGEX_CODE)).matcher(text);
        for(String paragraph:paragraphs){
            if(matcher.find()){
                parsedText.addChildTextUnit(new LeafUnit(TextUnitType.CODE,paragraph));
            }else {
                parsedText.addChildTextUnit(nextParser.parse(paragraph));
            }
        }
        return parsedText;
    }
}
