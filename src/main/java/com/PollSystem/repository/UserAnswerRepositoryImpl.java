package com.PollSystem.repository;

import com.PollSystem.model.PollQuestion;
import com.PollSystem.model.UserAnswer;
import com.PollSystem.repository.mapper.PollQuestionMapper;
import com.PollSystem.repository.mapper.UserAnswerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserAnswerRepositoryImpl implements UserAnswerRepository{

    private static final String USER_ANSWER_TABLE_NAME = "user_answer";
    private static final String POLL_QUESTION_TABLE_NAME = "poll_question";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(UserAnswerRepositoryImpl.class);

    @Autowired
    private UserAnswerMapper userAnswerMapper;

    @Autowired
    private PollQuestionMapper pollQuestionMapper;

    @Override
    public Long createUserAnswer(UserAnswer userAnswer) {
        String sql = "INSERT INTO " + USER_ANSWER_TABLE_NAME + " (question_id, user_id, answer_option_id, selected_answer) values (?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                userAnswer.getQuestionId(),
                userAnswer.getUserId(),
                userAnswer.getAnswerOptionId(),
                userAnswer.getSelectedAnswer()
        );
        Long userAnswerId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
        return userAnswerId;
    }


    @Override
    public void updateUserAnswer(UserAnswer userAnswer) {
        String sql = "UPDATE " + USER_ANSWER_TABLE_NAME + " SET selectedAnswer=? WHERE answer_id=?";
        jdbcTemplate.update(
                sql,
                userAnswer.getSelectedAnswer(),
                userAnswer.getId()
        );
    }

    @Override
    public void deleteUserAnswer(Long id) {
        String sql = "SELECT * FROM " +  USER_ANSWER_TABLE_NAME + " WHERE answer_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public UserAnswer getUserAnswerById(Long answerId) {
        String sql = "SELECT * FROM " + USER_ANSWER_TABLE_NAME + " WHERE answer_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, userAnswerMapper, answerId);
        }
        catch (EmptyResultDataAccessException e){
            logger.info("empty data warning");
            return null;
        }

    }

    @Override
    public List<UserAnswer> getAllUserAnswersByUserId(Long userId) {
        String sql = "SELECT * FROM " + USER_ANSWER_TABLE_NAME + " WHERE user_id=?";
        try {
            return jdbcTemplate.query(sql, userAnswerMapper, userId);
        }
        catch (EmptyResultDataAccessException e){
            logger.info("empty data warning");
            return null;
        }
    }

    @Override
    public List<PollQuestion> getAllUserQuestionsByUserId(Long id) {
        String sql = "SELECT * FROM " + POLL_QUESTION_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.query(sql, pollQuestionMapper, id);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> countUsersAnswerPerAnswerOption(Long questionId){
        String sql = "SELECT " +
                " COUNT(CASE WHEN selected_answer = 1 THEN 1 ELSE NULL END) AS answer_option_1, " +
                " COUNT(CASE WHEN selected_answer = 2 THEN 2 ELSE NULL END) AS answer_option_2, " +
                " COUNT(CASE WHEN selected_answer = 3 THEN 3 ELSE NULL END) AS answer_option_3, " +
                " COUNT(CASE WHEN selected_answer = 4 THEN 4 ELSE NULL END) AS answer_option_4 " +
                " FROM user_answer WHERE question_id = ?";
        return jdbcTemplate.queryForList(sql, questionId);
    }
}
