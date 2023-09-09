package com.PollSystem.service;

import com.PollSystem.model.PollQuestion;
import com.PollSystem.repository.PollQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollQuestionServiceImpl implements PollQuestionService{

    @Autowired
    PollQuestionRepository pollQuestionRepository;

//    @Autowired
//    private PollQuestionMapper pollQuestionMapper;

    @Override
    public void createPollQuestion(PollQuestion pollQuestion) {

    }

    @Override
    public void updatePollQuestion(PollQuestion pollQuestion) {

    }

    @Override
    public void deletePollQuestionById(Long id) {

    }

    @Override
    public PollQuestion getPollQuestionById(Long id) {
        return null;
    }
}
