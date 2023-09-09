package com.PollSystem.model;

public class PollQuestion {
    private Long id;
    private String questionTitle;
    private String firstAnswerOption;
    private String secondAnswerOption;
    private String thirdAnswerOption;
    private String fourthAnswerOption;

    public PollQuestion(){}

    public PollQuestion(Long id, String questionTitle, String firstAnswerOption, String secondAnswerOption, String thirdAnswerOption, String fourthAnswerOption) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.firstAnswerOption = firstAnswerOption;
        this.secondAnswerOption = secondAnswerOption;
        this.thirdAnswerOption = thirdAnswerOption;
        this.fourthAnswerOption = fourthAnswerOption;
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
}
