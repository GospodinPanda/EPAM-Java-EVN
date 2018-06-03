package com.epam.task2.logic;

import com.epam.task2.entity.TextUnit;
import com.epam.task2.util.parser.LetterParser;
import com.epam.task2.util.parser.ParagraphParser;
import com.epam.task2.util.parser.SentenceParser;
import com.epam.task2.util.parser.SentenceUnitParser;

public class ParserLogic {
    private static ParagraphParser paragraphParser = new ParagraphParser();

    static {
        SentenceParser sentenceParser = new SentenceParser();
        SentenceUnitParser sentenceUnitParser = new SentenceUnitParser();
        LetterParser letterParser = new LetterParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(sentenceUnitParser);
        sentenceUnitParser.setNextParser(letterParser);
    }

    public static TextUnit parse(String text) {
        return paragraphParser.parse(text);
    }
}
