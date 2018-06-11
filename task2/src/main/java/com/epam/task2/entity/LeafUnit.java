package com.epam.task2.entity;

import java.util.Objects;

public class LeafUnit extends TextUnit {
    String content;


    public LeafUnit(String content) {
        this.content = content;
    }

    public LeafUnit() {
    }


    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeafUnit)) return false;
        LeafUnit leafUnit = (LeafUnit) o;
        return getContent().equals(leafUnit.getContent());
    }

    @Override
    public int hashCode() {

        return Objects.hash(content);
    }

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
