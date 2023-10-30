package com.example.OracleCursor.repository;

import com.example.OracleCursor.entity.ClobData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface ClobDataRepository extends JpaRepository<ClobData, Long> {

    @Procedure(procedureName = "get_clob_data")
    String getClobData(String p_entrada);


}
