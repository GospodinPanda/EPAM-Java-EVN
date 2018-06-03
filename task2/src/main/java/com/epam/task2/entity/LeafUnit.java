package com.epam.task2.entity;

public class LeafUnit extends TextUnit {
    private TextUnitType type;

    public LeafUnit(TextUnitType type, String content) {
        this.type = type;
        this.content = content;
    }

    public LeafUnit() {
    }

    @Override
    public TextUnitType getType() {
        return type;
    }

    @Override
    public void setType(TextUnitType type) {
        this.type = type;
    }

    @Override
    public boolean isLeafTextUnit() {
        return true;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
