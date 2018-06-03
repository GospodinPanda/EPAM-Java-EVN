package com.epam.task2.entity;

public abstract class TextUnit {
    String content;

    public abstract TextUnitType getType();

    public abstract void setType(TextUnitType type);

    public abstract boolean isLeafTextUnit();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
