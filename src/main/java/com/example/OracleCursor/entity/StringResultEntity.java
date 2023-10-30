package com.example.OracleCursor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StringResultEntity {

    @Id
    private Long id;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}