package com.example.accessingdatamysql.models;

import jakarta.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tag_id")
    private int idTag;
    @Enumerated(EnumType.STRING)
    @Column(name="libelle")
    private ETag libelle;

    public Tag() {}

    public Tag(ETag libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return idTag;
    }

    public void setId(int idTag) {
        this.idTag = idTag;
    }

    public ETag getName() {
        return libelle;
    }

    public void setName(ETag libelle) {
        this.libelle = libelle;
    }
}
