package com.PollSystem.repository;

import com.PollSystem.model.PollQuestion;

import java.util.List;
import java.util.Map;

public interface PollQuestionRepository {
    void createPollQuestion(PollQuestion pollQuestion);
    void updatePollQuestion(PollQuestion pollQuestion);
    void deletePollQuestionById(Long id);
    PollQuestion getPollQuestion(Long questionId);

    int countHowManyUserAnsweredByQuestionId(Long questionId);
}
