package com.example.OracleCursor.repository;

import com.example.OracleCursor.entity.StringResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface StringResultRepository extends JpaRepository<StringResultEntity, Long>{


    @Procedure(procedureName = "get_ola_prc")
    String getStringResult();
}