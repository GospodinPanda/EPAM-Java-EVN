package com.epam.task2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeUnitEntity extends TextUnit{
    private List<TextUnit> childs;
    private TextUnitType type;

    public CompositeUnitEntity( TextUnitType type) {
        childs = new ArrayList<>();
        this.type = type;
    }

    public void setChilds(List<TextUnit> childUnits){
        this.childs = childUnits;
    }

    public void addChildTextUnit(TextUnit textComponent) {
        this.childs.add(textComponent);
    }


    public void removeChildTextUnit(TextUnit textComponent) {
        childs.remove(textComponent);
    }


    public List<TextUnit> getChildTextUnits() {
        return null;
    }


    public int size() {
        return childs.size();
    }

    @Override
    public TextUnitType getType() {
        return type;
    }

    @Override
    public void setType(TextUnitType type) {
        this.type=type;
    }

    @Override
    public boolean isLeafTextUnit() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeUnitEntity)) return false;
        CompositeUnitEntity that = (CompositeUnitEntity) o;
        return Objects.equals(childs, that.childs) &&
                getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(childs, getType());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
