package com.PollSystem.repository;

import com.PollSystem.model.AnswerOption;

import java.util.List;

public interface AnswerOptionRepository {
    void createAnswerOption(AnswerOption answerOption,Long questionId);
    void deleteAnswerOption(Long id);
    AnswerOption getAnswerOptionsByQuestionId(Long questionId);
}