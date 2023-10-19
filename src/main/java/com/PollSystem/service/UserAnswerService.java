package com.PollSystem.service;

import com.PollSystem.model.PollQuestion;
import com.PollSystem.model.UserAnswer;
import com.PollSystem.model.UserAnswerRequest;
import com.PollSystem.model.UserAnswerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserAnswerService {
    ResponseEntity<?> createUserAnswer(UserAnswerRequest userAnswerRequest);
    void updateUserAnswer(UserAnswer userAnswer);
    void deleteUserAnswerById(Long id);
    UserAnswer getUserAnswerById(Long answerId);
    List<UserAnswer> getAllUserAnswersByUserId(Long userId);


    List<PollQuestion> getAllUserQuestionsByUserId(Long userId);

    List<Map<String, Object>> countUsersAnswerPerAnswerOption(Long questionId);
}