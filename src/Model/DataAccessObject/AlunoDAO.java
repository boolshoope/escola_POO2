package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AlunoDAO {
    private Connection conexao;

    public  AlunoDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Selects">
    public List<Aluno> getAluno() {
        List<Aluno> lstAl = new ArrayList<>();
        Aluno al;
        ResultSet rs;

        try {
            String query = "select * from aluno";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                al = new Aluno(getPessoa(rs.getInt("idPessoa")),
                                rs.getInt("nrEstudante"),
                                rs.getDate("dataNascimento"), rs.getInt("idEncarregadoEducacao"));
                lstAl.add(al);
            }

            rs.close();
            stmt.close();
            return lstAl;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void inserir(Aluno a){
        //Implementar a query
        
        String query="INSERT INTO aluno(idPessoa,nrEstudante,dataNascimento,idEncarregadoEducacao)"+
                      "VALUES(?,?,?,?)";                
        try {
            PreparedStatement stmt=conexao.prepareStatement(query);
            stmt.setInt(1, a.getIdPessoa());
            stmt.setInt(2, a.getNrEstudante());
            stmt.setDate(3, a.getDataNascimento());
            stmt.setInt(4, a.getIdEncarregadoEducacao());
            stmt.executeUpdate();
            stmt.close();                             
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: "+ex.getMessage());
        }
    }
    
    public Pessoa getPessoa(int id) {
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
