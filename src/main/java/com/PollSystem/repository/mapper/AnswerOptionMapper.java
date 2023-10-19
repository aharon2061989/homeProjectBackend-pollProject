package com.PollSystem.repository.mapper;

import com.PollSystem.model.AnswerOption;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class AnswerOptionMapper implements RowMapper<AnswerOption> {

    @Override
    public AnswerOption mapRow(ResultSet rs, int rowNum) throws SQLException {
        AnswerOption answerOption = new AnswerOption(
                rs.getLong("answer_option_id"),
                rs.getString("first_answer_option"),
                rs.getString("second_answer_option"),
                rs.getString("third_answer_option"),
                rs.getString("fourth_answer_option"),
                rs.getLong("question_id")
        );
        return answerOption;
    }
}