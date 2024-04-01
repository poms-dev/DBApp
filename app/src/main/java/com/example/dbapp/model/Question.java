package com.example.dbapp.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Question {

    String textQuestion;
    List<Answer> answers;

    public Question() {
    }

    public Question(String textQuestion, List<Answer> answers) {
        this.textQuestion = textQuestion;
        this.answers = answers;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
