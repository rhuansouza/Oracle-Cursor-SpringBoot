package com.example.OracleCursor.entity;


import jakarta.persistence.*;

@Entity
@NamedStoredProcedureQuery(
        name = "getSysRefCursorResult",
        procedureName = "your_procedure_name",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "p_result")
        }
)
public class SysRefCursorResultEntity {

    @Id
    @Column(name = "column_name1")
    private Long columnName1;

    @Column(name = "column_name2")
    private String columnName2;

    // Getters and setters
}

