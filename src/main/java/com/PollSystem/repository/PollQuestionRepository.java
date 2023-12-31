package com.PollSystem.repository;

import com.PollSystem.model.PollQuestion;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface PollQuestionRepository {
    void createPollQuestion(PollQuestion pollQuestion);
    void updatePollQuestion(PollQuestion pollQuestion);
    void deletePollQuestionById(Long id);
    PollQuestion getPollQuestion(Long questionId);
    int countHowManyUserAnsweredByQuestionId(Long questionId);
    int countQuestionsAnsweredByUser(Long userId);
    Map<Long, Integer> getAllUserAnswersToQuestionsByUserId(Long userId);

    List<Map<String, Object>> getAllQuestionsAndCountSelectedOptions();
}
