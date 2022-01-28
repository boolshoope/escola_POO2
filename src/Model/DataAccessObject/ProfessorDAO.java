package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProfessorDAO {
    private Connection conexao;

    public ProfessorDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public List<Professor> getProfessor() {
        List<Professor> lstAl = new ArrayList<>();
        Professor al;
        ResultSet rs;

        try {
            String query = "select * from professor";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                al = new Professor(getPessoa(rs.getInt("idPessoa")), rs.getString("grauAcademico"));
                lstAl.add(al);
            }

            rs.close();
            stmt.close();
            return lstAl;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
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
}
