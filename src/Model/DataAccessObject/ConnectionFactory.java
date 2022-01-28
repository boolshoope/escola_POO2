/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author isacl
 */
public class ConnectionFactory {

    private Connection conexao;

    public Connection getConnection() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
            
            
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
        }
        return conexao;
    }

    // <editor-fold defaultstate="collapsed" desc="Selects">
    

    

    

    

    private Pessoa getPessoa(int id) {
        Pessoa p = null;
        ResultSet rs;

        try {
            String query = "select * from pessoa where idPessoa =" + id;
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                p = new Pessoa(rs.getInt("idPessoa"), rs.getString("pNome"), rs.getString("apelido"),
                        rs.getString("sexo").charAt(0), rs.getString("nrBI"), rs.getString("estadoCivil"),
                        rs.getString("tel1"), rs.getString("tel2"));
            }

            rs.close();
            stmt.close();
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    

    

    

    

    

    

    

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Inserts">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Updates">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Delete">
    // </editor-fold>
}
