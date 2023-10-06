package com.PollSystem.repository;

import com.PollSystem.model.PollQuestion;
import com.PollSystem.repository.mapper.PollQuestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PollQuestionRepositoryImpl implements PollQuestionRepository {

    private static final String POLL_QUESTION_TABLE_NAME = "poll_question";

    Logger logger = LoggerFactory.getLogger(PollQuestionRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PollQuestionMapper pollQuestionMapper;

    @Override
    public void createPollQuestion(PollQuestion pollQuestion) {
        String sql = "INSERT INTO " + POLL_QUESTION_TABLE_NAME + " " + " (question_title) values (?)";
        jdbcTemplate.update(
                sql,
                pollQuestion.getQuestionTitle()
        );
    }



    @Override
    public void updatePollQuestion(PollQuestion pollQuestion) {
        String sql = "UPDATE " + POLL_QUESTION_TABLE_NAME + " SET question_title=?, first_answer_option=?, second_answer_option=?, third_answer_option=?, fourth_answer_option=? WHERE ID=?";
        jdbcTemplate.update(
                sql,
                pollQuestion.getQuestionTitle()
        );
    }

    @Override
    public void deletePollQuestionById(Long id) {
        String sql = "DELETE FROM " + POLL_QUESTION_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public PollQuestion getPollQuestion(Long id) {
        String sql = "SELECT * FROM " + POLL_QUESTION_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, pollQuestionMapper, id);
        }
        catch (EmptyResultDataAccessException e) {
            logger.info("Empty Data Warning");
            return null;
        }
    }
    @Override
    public int countHowManyUserAnsweredByQuestionId(Long questionId){
        String sql = "SELECT COUNT(DISTINCT user_id) AS user_answer_count FROM user_answer WHERE question_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, questionId);
        int userAnswerCount = 0;
        if (count != null){
            userAnswerCount = count;
        }
        return userAnswerCount;
    }

    @Override
    public int countQuestionsAnsweredByUser(Long userId) {
        String sql = "SELECT COUNT (DISTINCT question_id) FROM user_answer WHERE user_id = ?";
        logger.info("SQL Query: {} with userId: {}", sql, userId);
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, userId);
        if (count != null){
            return count;
        }
        else {
            count = 0;
        }
        return count;
    }
    @Override
    public Map<Long, Integer> getAllUserAnswersToQuestionsByUserId(Long userId) {
        String sql = "SELECT question_id, selected_answer FROM user_answer WHERE user_id = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, userId);

        Map<Long, Integer> userAnswers = new HashMap<>();
        for (Map<String, Object> row : rows) {
            Long questionId = (Long) row.get("question_id");
            Integer selectedAnswer = (Integer) row.get("selected_answer");
            userAnswers.put(questionId, selectedAnswer);
        }
        return userAnswers;
    }
    @Override
    public Map<Long, Long> countUsersPerAnswerOption(Long questionId) {
        String sql = "SELECT answer_option_id, COUNT(DISTINCT user_id) FROM user_answer WHERE question_id = ? GROUP BY answer_option_id";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, questionId);
        Map<Long, Long> countMap = new HashMap<>();

        for (Map<String, Object> row : rows) {
            Long answerOptionId = ((Number) row.get("answer_option_id")).longValue();
            Long userCount = ((Number) row.get("count")).longValue();
            countMap.put(answerOptionId, userCount);
        }

        return countMap;
    }




}
