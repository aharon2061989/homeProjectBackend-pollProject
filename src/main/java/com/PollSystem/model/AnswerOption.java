package com.PollSystem.model;

public class AnswerOption {
    private Long answerOptionId;
    private String AnswerOption1;
    private String AnswerOption2;
    private String AnswerOption3;
    private String AnswerOption4;
    private Long questionId;

    public AnswerOption() {
    }

    public AnswerOption(Long answerOptionId, String AnswerOption1, String AnswerOption2, String AnswerOption3, String AnswerOption4, Long questionId) {
        this.answerOptionId = answerOptionId;
        this.AnswerOption1 = AnswerOption1;
        this.AnswerOption2 = AnswerOption2;
        this.AnswerOption3 = AnswerOption3;
        this.AnswerOption4 = AnswerOption4;
        this.questionId = questionId;
    }

    public Long getId() {
        return answerOptionId;
    }

    public String getAnswerOption1() {
        return AnswerOption1;
    }

    public void setAnswerOption1(String answerOption1) {
        AnswerOption1 = answerOption1;
    }

    public String getAnswerOption2() {
        return AnswerOption2;
    }

    public void setAnswerOption2(String answerOption2) {
        AnswerOption2 = answerOption2;
    }

    public String getAnswerOption3() {
        return AnswerOption3;
    }

    public void setAnswerOption3(String answerOption3) {
        AnswerOption3 = answerOption3;
    }

    public String getAnswerOption4() {
        return AnswerOption4;
    }

    public void setAnswerOption4(String answerOption4) {
        AnswerOption4 = answerOption4;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}