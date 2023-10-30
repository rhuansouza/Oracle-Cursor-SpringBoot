package com.example.OracleCursor.controller;

import com.example.OracleCursor.entity.Pessoa;

import com.example.OracleCursor.repository.StringResultRepository;
import com.example.OracleCursor.repository.SysRefCursorResultRepository;
import com.example.OracleCursor.repository.UsuarioRepository;
import com.example.OracleCursor.service.ClobDataService;
import com.example.OracleCursor.service.CursorService;
import com.google.gson.Gson;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api")
public class UsuarioController {

    private final StringResultRepository stringResultRepository;
    private final CursorService cursorService;
    private final ClobDataService clobDataService;

    private final SysRefCursorResultRepository sysRefCursorResultRepository;



    private UsuarioRepository usuarioRepository;

    EntityManager entityManager;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository,
                             StringResultRepository stringResultRepository,
                             SysRefCursorResultRepository sysRefCursorResultRepository,
                             CursorService cursorService,
                             ClobDataService clobDataService,
                             EntityManager entityManager
                             ) {
        this.usuarioRepository = usuarioRepository;
        this.stringResultRepository = stringResultRepository;
        this.sysRefCursorResultRepository = sysRefCursorResultRepository;
        this.cursorService  = cursorService;
        this.clobDataService =  clobDataService;
        this.entityManager = entityManager;

    }

    @GetMapping("/status")
    public ResponseEntity<String> status() throws SQLException, IOException {
        //List<Usuario> listaUsuario =  this.usuarioRepository.xcxp_buscar_usuario_teste_prc();
        String retorno = stringResultRepository.getStringResult();
        System.out.println("Saida "+retorno);


        String retornoClob = clobDataService.getClobData();

        System.out.println("retorno de clob "+retornoClob);

        Gson gson = new Gson();
        Pessoa p = gson.fromJson(retornoClob, Pessoa.class);
        System.out.println("vai converter json string em Objeto Pessoa");
        System.out.println("convertido: "+p.getNome());
        System.out.println("convertido: "+p.getIdade());
        System.out.println("===================");
        cursorService.chamarCursorOracle();



        //List<SysRefCursorResultEntity> lista = sysRefCursorResultRepository.getSysRefCursorResult();

        return ResponseEntity.ok("UP");
    }


}
