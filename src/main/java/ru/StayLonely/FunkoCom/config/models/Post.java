package ru.StayLonely.FunkoCom.config.models;

public class Post {
    private Integer id;
    private String name;
    private String content;
    private boolean isNews;
    private String userId;


    public Post (){

    }
    public Post(int id, String name, String content, boolean isNews, String userId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.isNews = isNews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsNews() {
        return isNews;
    }

    public void setIsNews(boolean news) {
        isNews = news;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
