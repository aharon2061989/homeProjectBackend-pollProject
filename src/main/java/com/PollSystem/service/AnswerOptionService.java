package com.PollSystem.service;

import com.PollSystem.model.AnswerOption;

import java.util.List;

public interface AnswerOptionService {
    void createAnswerOption(AnswerOption answerOption, Long questionId);
    void deleteAnswerOption(Long id);
    AnswerOption getAnswerOptionsByQuestionId(Long id);

}
