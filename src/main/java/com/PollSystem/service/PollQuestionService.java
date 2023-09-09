package com.PollSystem.service;

import com.PollSystem.model.PollQuestion;

public interface PollQuestionService {
    void createPollQuestion(PollQuestion pollQuestion);
    void updatePollQuestion(PollQuestion pollQuestion);
    void deletePollQuestionById(Long id);
    PollQuestion getPollQuestionById(Long id);
}
