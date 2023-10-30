package com.example.OracleCursor.service;


import com.example.OracleCursor.repository.ClobDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClobDataService {

    private final ClobDataRepository clobDataRepository;

    @Autowired
    public ClobDataService(ClobDataRepository clobDataRepository) {
        this.clobDataRepository = clobDataRepository;
    }

    public String  getClobData() {
        String  clobData = clobDataRepository.getClobData("testes");
        clobDataRepository.getClobData("teste");
        return clobData;
    }
}
