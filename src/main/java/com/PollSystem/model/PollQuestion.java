package com.PollSystem.model;

import org.springframework.stereotype.Component;

public class PollQuestion {
    private Long id;
    private String questionTitle;


    public PollQuestion(){}

    public PollQuestion(Long id, String questionTitle) {
        this.id = id;
        this.questionTitle = questionTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
}
