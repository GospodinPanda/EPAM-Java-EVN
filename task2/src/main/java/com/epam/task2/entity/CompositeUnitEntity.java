package com.epam.task2.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeUnitEntity extends TextUnit {
    private static Logger LOGGER = LogManager.getLogger(CompositeUnitEntity.class);
    private List<TextUnit> childs;

    public CompositeUnitEntity() {
        childs = new ArrayList<>();
    }

    public void setChilds(List<TextUnit> childUnits) {
        this.childs = childUnits;
    }

    public List<TextUnit> getChildTextUnits() {
        return childs;
    }

    public void addChildTextUnit(TextUnit textComponent) {
        this.childs.add(textComponent);
    }


    public void removeChildTextUnit(TextUnit textComponent) {
        childs.remove(textComponent);
    }


    public int size() {
        return childs.size();
    }


    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public String getContent() {
        StringBuilder content = new StringBuilder();
        for (TextUnit textEntity : childs) {
            if (textEntity.isLeaf()) {
                LeafUnit leaf = (LeafUnit) textEntity;
                content.append(leaf.getContent());
            } else {
                CompositeUnitEntity entity = (CompositeUnitEntity) textEntity;
                content.append(entity.getContent());
            }
        }
        return content.toString();
    }

    @Override
    public void setContent(String content) {
        LOGGER.warn("There is no set method for Composite units");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeUnitEntity)) return false;
        CompositeUnitEntity that = (CompositeUnitEntity) o;
        return Objects.equals(childs, that.childs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childs);
    }


    @Override
    public String toString() {
        return "CompositeUnitEntity{" +
                "childs=" + childs +
                '}';
    }
}