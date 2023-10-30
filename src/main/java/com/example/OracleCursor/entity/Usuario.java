package com.example.OracleCursor.entity;

import jakarta.persistence.*;
import lombok.Data;

@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
        name = Usuario.xcxp_buscar_usuario_teste_prc,
        procedureName = "xcxp_buscar_usuario_teste_prc",
        resultClasses = Usuario.class,
        parameters = {
                @StoredProcedureParameter(type = void.class, mode = ParameterMode.REF_CURSOR)
        }
)})
@Data
@Entity
public class Usuario {



    public static final String xcxp_buscar_usuario_teste_prc = "buscarUsuario";
    @Id
    private Long ID;
    public String NM_USUARIO;
    public String CD_MATRICULA;
    public String NR_CELULAR;
    public String DS_EMAIL;

}
