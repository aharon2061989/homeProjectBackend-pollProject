package com.PollSystem.repository;

import com.PollSystem.model.PollQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PollQuestionRepositoryImpl implements PollQuestionRepository {

    private static final String POLL_QUESTION_TABLE_NAME = "poll_question";

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    private PollQuestionMapper pollQuestionMapper;

    @Override
    public void createPollQuestion(PollQuestion pollQuestion) {
        String sql = "INSERT INTO " + POLL_QUESTION_TABLE_NAME + " " + "(question_title, first_answer_option, second_answer_option,third_answer_option, fourth_answer_option) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                pollQuestion.getQuestionTitle(),
                pollQuestion.getFirstAnswerOption(),
                pollQuestion.getSecondAnswerOption(),
                pollQuestion.getThirdAnswerOption(),
                pollQuestion.getFourthAnswerOption()
        );
    }

    @Override
    public void updatePollQuestion(PollQuestion pollQuestion) {
        String sql = "UPDATE " + POLL_QUESTION_TABLE_NAME + " SET question_title=?, first_answer_option=?, second_answer_option=?, third_answer_option=?, fourth_answer_option=?";
        jdbcTemplate.update(
                sql,
                pollQuestion.getQuestionTitle(),
                pollQuestion.getFirstAnswerOption(),
                pollQuestion.getSecondAnswerOption(),
                pollQuestion.getThirdAnswerOption(),
                pollQuestion.getFourthAnswerOption()
        );
    }

    @Override
    public void deletePollQuestionById(Long id) {
        String sql = "DELETE FROM " + POLL_QUESTION_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public PollQuestion getPollQuestionById(Long id) {
        return null;
    }

//    @Override
//    public PollQuestion getPollQuestionById(Long id) {
//        String sql = "SELECT * FROM " + POLL_QUESTION_TABLE_NAME + " WHERE id=?";
//        try {
//            return jdbcTemplate.queryForObject(sql, pollQuestionMapper, id);
//        }
//        catch (EmptyResultDataAccessException e) {
//            System.out.println("Empty Data Warning");
//            return null;
//        }
//    }
}
