package com.PollSystem.repository.mapper;

import com.PollSystem.model.PollQuestion;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PollQuestionMapper implements RowMapper<PollQuestion> {
    @Override
    public PollQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        PollQuestion pollQuestion = new PollQuestion(
                rs.getLong("id"),
                rs.getString("question_title")
        );
        return pollQuestion;
    }
}
