package com.PollSystem.service;

import com.PollSystem.model.AnswerOption;
import com.PollSystem.repository.AnswerOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerOptionServiceImpl implements AnswerOptionService{

    @Autowired
    AnswerOptionRepository answerOptionRepository;
    @Override
    public void createAnswerOption(AnswerOption answerOption, Long questionId) {
        answerOptionRepository.createAnswerOption(answerOption, questionId);
    }

    @Override
    public void deleteAnswerOption(Long id) {
        answerOptionRepository.deleteAnswerOption(id);
    }


    @Override
    public AnswerOption getAnswerOptionsByQuestionId(Long questionId) {
        return answerOptionRepository.getAnswerOptionsByQuestionId(questionId);
    }
}
