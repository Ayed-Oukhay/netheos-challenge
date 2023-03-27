//package com.example.accessingdatamysql.security.services.criteria;
//
//import org.hibernate.Criteria;
//import org.hibernate.Filter.*;
//import org.springdoc.api.annotations.ParameterObject;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@ParameterObject
//public class QuestionCriteria implements Serializable, Criteria {
//    private static final long serialVersionUID = 1L;
//
//    private LongFilter id;
//
//    private StringFilter libelle;
//
//    private StringFilter libelleReponse;
//
//    private Boolean distinct;
//
//    public QuestionCriteria() {}
//
//    public QuestionCriteria(QuestionCriteria other) {
//        this.id = other.id == null ? null : other.id.copy();
//        this.libelle = other.libelle == null ? null : other.libelle.copy();
//        this.libelleReponse = other.libelleReponse == null ? null : other.libelleReponse.copy();
//        this.distinct = other.distinct;
//    }
//
//    @Override
//    public QuestionCriteria copy() {
//        return new QuestionCriteria(this);
//    }
//
//    public LongFilter getId() {
//        return id;
//    }
//
//    public LongFilter id() {
//        if (id == null) {
//            id = new LongFilter();
//        }
//        return id;
//    }
//
//    public void setId(LongFilter id) {
//        this.id = id;
//    }
//
//    public StringFilter getLibelle() {
//        return libelle;
//    }
//
//    public StringFilter libelle() {
//        if (libelle == null) {
//            libelle = new StringFilter();
//        }
//        return libelle;
//    }
//
//    public void setLibelle(StringFilter libelle) {
//        this.libelle = libelle;
//    }
//
//    public StringFilter getLibelleReponse() {
//        return libelleReponse;
//    }
//
//    public StringFilter libelleReponse() {
//        if (libelleReponse == null) {
//            libelleReponse = new StringFilter();
//        }
//        return libelleReponse;
//    }
//
//    public void setLibelleReponse(StringFilter libelleReponse) {
//        this.libelleReponse = libelleReponse;
//    }
//
//    public Boolean getDistinct() {
//        return distinct;
//    }
//
//    public void setDistinct(Boolean distinct) {
//        this.distinct = distinct;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final QuestionCriteria that = (QuestionCriteria) o;
//        return (
//                Objects.equals(id, that.id) &&
//                        Objects.equals(libelle, that.libelle) &&
//                        Objects.equals(libelleReponse, that.libelleReponse) &&
//                        Objects.equals(distinct, that.distinct)
//        );
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, libelle, libelleReponse, distinct);
//    }
//
//    // prettier-ignore
//    @Override
//    public String toString() {
//        return "QuestionCriteria{" +
//                (id != null ? "id=" + id + ", " : "") +
//                (libelle != null ? "libelle=" + libelle + ", " : "") +
//                (libelleReponse != null ? "libelleReponse=" + libelleReponse + ", " : "") +
//                (distinct != null ? "distinct=" + distinct + ", " : "") +
//                "}";
//    }
//}
