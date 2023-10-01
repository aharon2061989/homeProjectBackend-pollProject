package com.PollSystem.model;

public class AnswerOption {
    private Long id;
    private String firstAnswerOption;
    private String secondAnswerOption;
    private String thirdAnswerOption;
    private String fourthAnswerOption;
    private Long questionId;

    public AnswerOption() {
    }

    public AnswerOption(Long id, String firstAnswerOption, String secondAnswerOption, String thirdAnswerOption, String fourthAnswerOption, Long questionId) {
        this.id = id;
        this.firstAnswerOption = firstAnswerOption;
        this.secondAnswerOption = secondAnswerOption;
        this.thirdAnswerOption = thirdAnswerOption;
        this.fourthAnswerOption = fourthAnswerOption;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstAnswerOption() {
        return firstAnswerOption;
    }

    public void setFirstAnswerOption(String firstAnswerOption) {
        this.firstAnswerOption = firstAnswerOption;
    }

    public String getSecondAnswerOption() {
        return secondAnswerOption;
    }

    public void setSecondAnswerOption(String secondAnswerOption) {
        this.secondAnswerOption = secondAnswerOption;
    }

    public String getThirdAnswerOption() {
        return thirdAnswerOption;
    }

    public void setThirdAnswerOption(String thirdAnswerOption) {
        this.thirdAnswerOption = thirdAnswerOption;
    }

    public String getFourthAnswerOption() {
        return fourthAnswerOption;
    }

    public void setFourthAnswerOption(String fourthAnswerOption) {
        this.fourthAnswerOption = fourthAnswerOption;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
