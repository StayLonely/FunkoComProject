package ru.StayLonely.FunkoCom.config.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.StayLonely.FunkoCom.config.models.Post;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Post p = new Post();
        p.setId(resultSet.getInt("id"));
        p.setContent(resultSet.getString("content"));
        p.setIsNews(resultSet.getBoolean("getIsNews"));
        p.setName(resultSet.getString("name"));

        return p;
    }
}
