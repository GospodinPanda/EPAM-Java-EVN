package com.epam.task2.util.parser;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.entity.LeafUnit;
import com.epam.task2.entity.TextUnit;
import com.epam.task2.entity.TextUnitType;

public class LetterParser extends TextParser {
    @Override
    public TextUnit parse(String text) {
        CompositeUnitEntity parsedWord = new CompositeUnitEntity(TextUnitType.WORD);
        int length = text.length();

        for (int i = 0; i < length; i++) {
            parsedWord.addChildTextUnit(new LeafUnit( TextUnitType.LETTER,text.substring(i, i + 1)));
        }
        return parsedWord;
    }



}
