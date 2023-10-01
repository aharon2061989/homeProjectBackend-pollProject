package com.PollSystem.model;

public class UserAnswerRequest {
    private Long userId;
    private Long questionId;
    private Long answerOptionId;
    private Long selectedAnswer;

    public UserAnswerRequest() {}

    public UserAnswerRequest(Long userId, Long questionId, Long answerOptionId, Long selectedAnswer) {
        this.userId = userId;
        this.questionId = questionId;
        this.answerOptionId = answerOptionId;
        this.selectedAnswer = selectedAnswer;
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

    public UserAnswer toUserAnswer(){
        return new UserAnswer(
                null,
                this.userId,
                this.questionId,
                this.answerOptionId,
                this.selectedAnswer
        );
    }


}
