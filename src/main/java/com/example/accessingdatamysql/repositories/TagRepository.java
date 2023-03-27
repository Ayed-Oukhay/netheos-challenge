package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.models.ERole;
import com.example.accessingdatamysql.models.ETag;
import com.example.accessingdatamysql.models.Role;
import com.example.accessingdatamysql.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Optional<Tag> findByLibelle(ETag tag);
}
