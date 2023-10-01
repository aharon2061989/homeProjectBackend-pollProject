package com.PollSystem.userProject;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProjectMapper implements RowMapper<UserProjectResponse> {
    @Override
    public UserProjectResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserProjectResponse userProjectResponse = new UserProjectResponse(
                rs.getLong("id"),
                rs.getBoolean("registered")
        );
        return userProjectResponse;
    }
}
