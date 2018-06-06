package com.epam.task2.entity;

import com.epam.task2.manager.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeUnitEntity extends TextUnit {
    private final static String SPACE = " ";
    private final static String NEW_LINE = "\n";
    private final static String TABULATION = "\t";
    private final static String PUNCT_WITH_SPACE_BEFORE = "regex.punctuation.before";
    private final static String PUNCT_WITH_NO_SPACE_AFTER = "regex.punctuation.after";

    private List<TextUnit> childs;
    private TextUnitType type;

    public CompositeUnitEntity(TextUnitType type) {
        childs = new ArrayList<>();
        this.type = type;
    }

    public void setChilds(List<TextUnit> childUnits) {
        this.childs = childUnits;
    }

    public void addChildTextUnit(TextUnit textComponent) {
        this.childs.add(textComponent);
    }


    public void removeChildTextUnit(TextUnit textComponent) {
        childs.remove(textComponent);
    }


    public List<TextUnit> getChildTextUnits() {
        return childs;
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
        this.type = type;
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
    public String getContent(){
        StringBuilder content=new StringBuilder();
        for (TextUnit textEntity : childs) {
            if(textEntity.isLeafTextUnit()) {
                LeafUnit leaf= (LeafUnit) textEntity;
                content.append( leaf.getContent());
            }else{
                CompositeUnitEntity entity = (CompositeUnitEntity) textEntity;
                content.append(entity.getContent());
            }
        }
        return content.toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(childs, getType());
    }


    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        int top = childs.size();

        for (int i = 0; i < top; i++) {
            TextUnit childTextComponent = childs.get(i);

            switch (childTextComponent.getType()) {

                case WORD:
                    if (i != top - 1) {
                        if (i > 0 && childs.get(i - 1).toString().matches(ResourceManager.getProperty(PUNCT_WITH_NO_SPACE_AFTER))) {
                            text.append(childTextComponent);
                        } else {
                            text.append(SPACE).append(childTextComponent);
                        }
                    }
                    break;
                case PARAGRAPH:
                case CODE:
                    text.append(TABULATION).append(childTextComponent);
                    if (i != top - 1) {
                        text.append(NEW_LINE);
                    }
                    break;
                case PUNCTUATION_CHAR:
                    if (childTextComponent.toString().matches(ResourceManager.getProperty(PUNCT_WITH_SPACE_BEFORE))) {
                        text.append(SPACE).append(childTextComponent);
                    } else {
                        text.append(childTextComponent);
                    }
                    break;
                case SENTENCE:
                case TEXT:
                case LETTER:
                    text.append(childTextComponent);
                    break;
            }
        }
        //return new String(text).trim();
        return new String(text);
    }
}