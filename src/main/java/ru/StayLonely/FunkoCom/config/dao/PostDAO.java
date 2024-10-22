package ru.StayLonely.FunkoCom.config.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.StayLonely.FunkoCom.config.models.Post;


import java.sql.*;
import java.util.List;

@Component
public class PostDAO {
    private final JdbcTemplate jdbcTemplate;

    private static Connection connection;

    @Autowired
    public PostDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Post> index(){
        return jdbcTemplate.query("select id, name, LEFT(content, 100) as content, isNews from news ORDER BY id DESC", new BeanPropertyRowMapper<>(Post.class));
    }

    public Post show(int id) {
        return jdbcTemplate.query("select * from news where id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Post.class)).stream().findAny().orElse(null);
    }

    public void save(Post p){
        jdbcTemplate.update("INSERT INTO news  (name, content, isNews)VALUES(?,?,?)", p.getName(), p.getContent(), p.getIsNews());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM news WHERE id=?", id);
    }

    public void update(int id, Post post) {
        jdbcTemplate.update("UPDATE news SET name = ?, content = ?, isNews = ? WHERE id = ?", post.getName(), post.getContent(), post.getIsNews(), id);

    }
}
