package com.epam.task2.util.parser;

import com.epam.task2.entity.TextUnit;

public abstract class TextParser {
    TextParser nextParser;
    public  void setNextParser(TextParser nextParser){
        this.nextParser = nextParser;
    }

    public abstract TextUnit parse(String text);
}
