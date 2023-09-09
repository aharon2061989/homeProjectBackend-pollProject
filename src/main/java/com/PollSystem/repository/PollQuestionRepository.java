package com.PollSystem.repository;

import com.PollSystem.model.PollQuestion;

public interface PollQuestionRepository {
    void createPollQuestion(PollQuestion pollQuestion);
    void updatePollQuestion(PollQuestion pollQuestion);
    void deletePollQuestionById(Long id);
    PollQuestion getPollQuestionById(Long id);
}
