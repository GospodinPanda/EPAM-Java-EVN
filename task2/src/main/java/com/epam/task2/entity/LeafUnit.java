package com.epam.task2.entity;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeafUnit)) return false;
        LeafUnit leafUnit = (LeafUnit) o;
        return getContent().equals( leafUnit.getContent()) && getType() == leafUnit.getType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getType());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
