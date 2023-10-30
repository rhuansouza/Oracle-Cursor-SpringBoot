package com.example.OracleCursor.repository;

import com.example.OracleCursor.entity.Usuario;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.io.Serializable;
import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Serializable> {


    @Procedure
    List<Usuario> xcxp_buscar_usuario_teste_prc();
}
