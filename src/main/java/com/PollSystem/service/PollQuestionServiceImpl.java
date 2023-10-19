package com.PollSystem.service;

import com.PollSystem.model.PollQuestion;
import com.PollSystem.repository.PollQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PollQuestionServiceImpl implements PollQuestionService{

    @Autowired
    PollQuestionRepository pollQuestionRepository;


    @Override
    public void createPollQuestion(PollQuestion pollQuestion) {
        pollQuestionRepository.createPollQuestion(pollQuestion);
    }

    @Override
    public void updatePollQuestion(PollQuestion pollQuestion) {
        pollQuestionRepository.updatePollQuestion(pollQuestion);
    }

    @Override
    public void deletePollQuestionById(Long id) {
        pollQuestionRepository.deletePollQuestionById(id);
    }

    @Override
    public PollQuestion getPollQuestion(Long questionId) {
        return pollQuestionRepository.getPollQuestion(questionId);
    }

    @Override
    public int countHowManyUserAnsweredByQuestionId(Long questionId) {
        return pollQuestionRepository.countHowManyUserAnsweredByQuestionId(questionId);
    }
    @Override
    public int countQuestionsAnsweredByUser(Long userId){
        return pollQuestionRepository.countQuestionsAnsweredByUser(userId);
    }
    @Override
    public Map<Long, Integer> getAllUserAnswersToQuestionsByUserId(Long userId){
        return pollQuestionRepository.getAllUserAnswersToQuestionsByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> getAllQuestionsAndCountSelectedOptions(){
        return pollQuestionRepository.getAllQuestionsAndCountSelectedOptions();
    }

}
