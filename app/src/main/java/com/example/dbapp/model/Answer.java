package com.example.dbapp.model;

public class Answer {
    String textAnswer;
    boolean isRight;

    public Answer() {
    }

    public Answer(String textAnswer, boolean isRight) {
        this.textAnswer = textAnswer;
        this.isRight = isRight;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "textAnswer='" + textAnswer + '\'' +
                ", isRight=" + isRight +
                '}';
    }
}
