package com.epam.task2.logic;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.entity.TextUnit;
import com.epam.task2.entity.TextUnitType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextLogic {

    public CompositeUnitEntity replaceOnLength(String text, int sentenceNumber, int length, String replacer) {
        CompositeUnitEntity parsedText = (CompositeUnitEntity) ParserLogic.parse(text);
        List<TextUnit> paragraphs = parsedText.getChildTextUnits();
        for (TextUnit paragraph : paragraphs) {
            CompositeUnitEntity currentParagraph = (CompositeUnitEntity) paragraph;
            if (currentParagraph.size() >= sentenceNumber) {
                List<TextUnit> sentences = currentParagraph.getChildTextUnits();
                CompositeUnitEntity currentSentence = (CompositeUnitEntity) sentences.get(sentenceNumber - 1);
                System.out.println(currentSentence);
                List<TextUnit> words = currentSentence.getChildTextUnits();
                for (TextUnit word : words) {
                    if (word.getType() == TextUnitType.WORD && word.getContent().length() == (length)) {
                        word.setContent(replacer);
                    }
                }
                break;
            } else {
                sentenceNumber = sentenceNumber - currentParagraph.size();
            }
        }
        return parsedText;
    }

    public int findNumberSentencesWithReapeats(String text) {
        CompositeUnitEntity parsedText = (CompositeUnitEntity) ParserLogic.parse(text);
        List<TextUnit> paragraphs = parsedText.getChildTextUnits();
        int sentencesNumber = 0;
        for (TextUnit paragraph : paragraphs) {
            CompositeUnitEntity currentParagraph = (CompositeUnitEntity) paragraph;
            List<TextUnit> sentences = currentParagraph.getChildTextUnits();
            for (TextUnit sentence : sentences) {
                CompositeUnitEntity currentSentence = (CompositeUnitEntity) sentence;
                List<TextUnit> words = currentSentence.getChildTextUnits();
                Set<TextUnit> wordsCounter = new HashSet<TextUnit>();
                for (TextUnit word : words) {
                    if (word.getType() == TextUnitType.WORD) {
                        if (!wordsCounter.add(word)) {
                            sentencesNumber++;
                            break;
                        }
                    }
                }

            }
        }
        return sentencesNumber;
    }
}
