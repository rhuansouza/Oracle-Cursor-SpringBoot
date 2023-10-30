package com.example.OracleCursor.repository;

import com.example.OracleCursor.entity.SysRefCursorResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRefCursorResultRepository extends JpaRepository<SysRefCursorResultEntity, Long> {

    @Procedure(procedureName = "getSysRefCursorResult")
    List<SysRefCursorResultEntity> getSysRefCursorResult();
}