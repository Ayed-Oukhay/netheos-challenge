package com.example.accessingdatamysql.payload.request;

import jakarta.annotation.Nonnull;

import java.util.Set;

public class QuestionRequest {
    @Nonnull
    private String libelle;

    @Nonnull
    private String reponse;

    private Set<String> tag;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String email) {
        this.reponse = reponse;
    }

    public Set<String> getTag() {
        return this.tag;
    }

    public void getTag(Set<String> tag) {
        this.tag = tag;
    }
}
