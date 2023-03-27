package com.example.accessingdatamysql.models;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
    private int questionId;
    @Column(name="libelle")
    private String libelle;

    private String response;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "question_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<Tag> tags = new HashSet<>();

    @ManyToOne
    @JoinTable(	name = "user_questions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private User userId;

    public Question() {}

    public Question(String libelle, String response) {
//        this.questionId = questionId;
        this.libelle = libelle;
        this.response = response;
//        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Questions [questionId=" + questionId + ", libelle=" + libelle + ", reponse=" + response + ", tags=" + tags+ ", createdBy=" + userId + "]";
    }
}
