package com.projectmaking.Model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String content;

    @Range(min = 1,max = 5)
    private Integer starsRating;

    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    public Comment(String content, Integer starsRating) {
        this.content = content;
        this.starsRating = starsRating;
    }

    public Comment() {//jpa only
         }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStarsRating() {
        return starsRating;
    }

    public void setStarsRating(Integer starsRating) {
        this.starsRating = starsRating;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", starsRating=" + starsRating +
                ", date=" + date +
                '}';
    }
}
