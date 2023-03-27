package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<Question> findByQuestionId(Integer questionId);
    @Query("select q from Question q")
    List<Question> getAll();

//    @Query("select q from Question q where q.libelle like '%:word%'")
    List<Question> findByLibelleContainingIgnoreCase(String word);


    Boolean existsByQuestionId(Integer questionId);
}

