package com.PollSystem.service;

import com.PollSystem.model.PollQuestion;

import java.util.List;
import java.util.Map;

public interface PollQuestionService {
    void createPollQuestion(PollQuestion pollQuestion);
    void updatePollQuestion(PollQuestion pollQuestion);
    void deletePollQuestionById(Long id);
    PollQuestion getPollQuestion(Long id);
    int countHowManyUserAnsweredByQuestionId(Long questionId);

    int countQuestionsAnsweredByUser(Long userId);

    Map<Long, Integer> getAllUserAnswersToQuestionsByUserId(Long userId);

    Map<Long, Long> countUsersPerAnswerOption(Long questionId);
}
