package com.epam.task2.entity;

public abstract class TextUnit {

    public abstract boolean isLeaf();

    public abstract String getContent();

    public abstract void setContent(String content);

    public abstract int size();
}
