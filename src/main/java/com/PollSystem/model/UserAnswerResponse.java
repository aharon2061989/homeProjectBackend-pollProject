package com.PollSystem.model;

import java.util.List;

public class UserAnswerResponse {
    private Long id;
    private Long userId;
    private Long questionId;
    private Long selectedAnswer;

    public UserAnswerResponse() {}



    public UserAnswerResponse(Long id, Long userId, Long questionId, Long selectedAnswer) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.selectedAnswer = selectedAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(Long selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}