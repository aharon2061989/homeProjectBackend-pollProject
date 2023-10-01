package com.PollSystem.repository;

import com.PollSystem.model.AnswerOption;
import com.PollSystem.repository.mapper.AnswerOptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AnswerOptionRepositoryImpl implements AnswerOptionRepository{

    private static final String ANSWER_OPTION_TABLE_NAME = "answer_option";

    Logger logger = LoggerFactory.getLogger(AnswerOptionRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    AnswerOptionMapper answerOptionMapper;

    @Override
    public void createAnswerOption(AnswerOption answerOption, Long questionId) {
        String sql = "INSERT INTO " + ANSWER_OPTION_TABLE_NAME + " (first_answer_option, second_answer_option, third_answer_option, fourth_answer_option, question_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                answerOption.getFirstAnswerOption(),
                answerOption.getSecondAnswerOption(),
                answerOption.getThirdAnswerOption(),
                answerOption.getFourthAnswerOption(),
                questionId
        );
    }

    @Override
    public void deleteAnswerOption(Long id) {
        String sql = "DELETE FROM answer_option WHERE answer_option_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public AnswerOption getAnswerOptionsByQuestionId(Long questionId) {
        String sql = "SELECT * FROM answer_option WHERE answer_option_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, answerOptionMapper, questionId);
        }
        catch (EmptyResultDataAccessException e){
           logger.info("warning, empty result data");
            return null;
        }
    }
}
