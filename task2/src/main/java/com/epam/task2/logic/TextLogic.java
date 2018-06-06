package com.epam.task2.logic;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.entity.TextUnit;
import com.epam.task2.entity.TextUnitType;

import java.util.List;

public class TextLogic {

    public CompositeUnitEntity replaceOnLength(String text, int sentenceNumber, int length, String replacer) {
        CompositeUnitEntity parsedText = (CompositeUnitEntity) ParserLogic.parse(text);
        List<TextUnit> paragraphs = parsedText.getChildTextUnits();
        for (TextUnit paragraph : paragraphs) {

            CompositeUnitEntity currentParagraph = (CompositeUnitEntity) paragraph;
            if(currentParagraph.size()>=sentenceNumber) {
                List<TextUnit> senteces = currentParagraph.getChildTextUnits();
                CompositeUnitEntity currentSentence = (CompositeUnitEntity) senteces.get(sentenceNumber-1);
                System.out.println(currentSentence);
                List<TextUnit> words = currentSentence.getChildTextUnits();
                for (TextUnit word : words) {
                    if (word.getType() == TextUnitType.WORD && word.getContent().length() == (length)) {
                        word.setContent(replacer);
                    }
                }
                break;
            } else {sentenceNumber=sentenceNumber-currentParagraph.size();}
        }
        return parsedText;
    }
}
