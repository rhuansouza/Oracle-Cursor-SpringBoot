package com.example.OracleCursor.entity;

import jakarta.persistence.*;

import java.sql.Clob;

@Entity
@NamedStoredProcedureQuery(
        name = "get_clob_data",
        procedureName = "get_clob_data",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_entrada"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = void.class, name = "p_clob")
        }
)

public class ClobData {

    @Id
    private Long id;

    private Clob clob;

    public Clob getClob() {
        return clob;
    }

    public void setClob(Clob clob) {
        this.clob = clob;
    }
}
