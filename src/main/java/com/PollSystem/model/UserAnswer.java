package com.PollSystem.model;

import java.util.List;

public class UserAnswer {
    private Long id;
    private Long userId;
    private Long questionId;
    private Long answerOptionId;
    private Long selectedAnswer;

    public UserAnswer() {}

    public UserAnswer(Long id, Long userId, Long questionId, Long answerOptionId, Long selectedAnswer) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.answerOptionId = answerOptionId;
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

    public Long getAnswerOptionId() {
        return answerOptionId;
    }

    public void setAnswerOptionId(Long answerOptionId) {
        this.answerOptionId = answerOptionId;
    }

    public Long getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(Long selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public UserAnswerResponse toUserAnswerResponse(Long id, Long userId, Long questionId, Long selectedAnswer){
        return new UserAnswerResponse(id, userId, questionId, selectedAnswer);
    }
}
