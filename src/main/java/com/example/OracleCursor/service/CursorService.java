package com.example.OracleCursor.service;

import com.example.OracleCursor.entity.Pessoa;
import oracle.jdbc.internal.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CursorService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CursorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pessoa> chamarCursorOracle() throws SQLException {
        Connection connection = jdbcTemplate.getDataSource().getConnection();
        CallableStatement callableStatement = connection.prepareCall("{call your_procedure_name(?)}");
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR); // O primeiro parâmetro é o cursor de saída
        //.setInt(2, 123); // Seus parâmetros de entrada, se houver

        callableStatement.execute();
        ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

        List<Pessoa> resultados = new ArrayList<>();

        while (resultSet.next()) {
            Pessoa pessoa = new Pessoa();
            // Configure os campos do objeto com base nas colunas do cursor
            pessoa.setNome(resultSet.getString("nome"));
            pessoa.setIdade(resultSet.getString("idade"));
            System.out.println("Analista: " + pessoa.getNome());
            resultados.add(pessoa);
        }
        System.out.println("lista "+resultados);
        resultSet.close();
        callableStatement.close();
        connection.close();

        return resultados;
    }
}
