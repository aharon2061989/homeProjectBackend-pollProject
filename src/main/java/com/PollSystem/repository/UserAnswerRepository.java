package com.PollSystem.repository;

import com.PollSystem.model.PollQuestion;
import com.PollSystem.model.UserAnswer;
import com.PollSystem.model.UserAnswerRequest;

import java.util.List;
import java.util.Map;

public interface UserAnswerRepository {
    Long createUserAnswer(UserAnswer userAnswer);
    void updateUserAnswer(UserAnswer userAnswer);
    void deleteUserAnswer(Long id);
    UserAnswer getUserAnswerById(Long answerId);
    List<UserAnswer> getAllUserAnswersByUserId(Long userId);
    List<PollQuestion> getAllUserQuestionsByUserId(Long userId);


    List<Map<String, Object>> countUsersAnswerPerAnswerOption(Long questionId);
}
