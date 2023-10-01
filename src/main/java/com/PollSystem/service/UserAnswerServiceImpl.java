package com.PollSystem.service;

import com.PollSystem.model.*;
import com.PollSystem.repository.UserAnswerRepository;
import com.PollSystem.userProject.UserProjectResponse;
import com.PollSystem.userProject.UserProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImpl implements UserAnswerService{

    Logger logger = LoggerFactory.getLogger(UserAnswerServiceImpl.class);

    @Autowired
    UserAnswerRepository userAnswerRepository;

    @Autowired
    UserProjectService userProjectService;


    @Override
    public ResponseEntity<?> createUserAnswer(UserAnswerRequest userAnswerRequest) {
        Long userId = userAnswerRequest.getUserId();
        UserProjectResponse userResponse = userProjectService.getUser(userAnswerRequest.getUserId());
        Boolean isRegistered = userProjectService.checkUserRegistration(userId);

        if (isRegistered != null && isRegistered){
            UserAnswer userAnswer = userAnswerRequest.toUserAnswer();
            Long userAnswerId = userAnswerRepository.createUserAnswer(userAnswer);
            UserAnswerResponse answerResponse = new UserAnswerResponse();
            answerResponse.setId(userAnswerId);
            answerResponse.setUserId(userAnswer.getUserId());
            answerResponse.setQuestionId(userAnswer.getQuestionId());
            answerResponse.setSelectedAnswer(userAnswer.getSelectedAnswer());
            return  ResponseEntity.ok(answerResponse);
        }
        else{
            return ResponseEntity.badRequest().body("user is not registered, register to be able answer a question.");
        }
    }


    @Override
    public void updateUserAnswer(UserAnswer userAnswer) {
        userAnswerRepository.updateUserAnswer(userAnswer);
    }

    @Override
    public void deleteUserAnswerById(Long id) {
        userAnswerRepository.deleteUserAnswer(id);
    }

    @Override
    public UserAnswer getUserAnswerById(Long answerId) {
        return userAnswerRepository.getUserAnswerById(answerId);
    }

    @Override
    public List<UserAnswer> getAllUserAnswersByUserId(Long userId) {
        return userAnswerRepository.getAllUserAnswersByUserId(userId);
    }

    @Override
    public List<PollQuestion> getAllUserQuestionsByUserId(Long userId){
        return userAnswerRepository.getAllUserQuestionsByUserId(userId);
    }



}
