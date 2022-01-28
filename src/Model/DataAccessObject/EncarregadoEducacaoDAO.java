package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EncarregadoEducacaoDAO {
    private Connection conexao;

    public EncarregadoEducacaoDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public List<EncarregadoEducacao> getEncarregadoEducacao() {
        List<EncarregadoEducacao> lstAl = new ArrayList<>();
        EncarregadoEducacao al;
        ResultSet rs;

        try {
            String query = "select * from encarregadoeducacao";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                al = new EncarregadoEducacao(getPessoa(rs.getInt("idPessoa")), rs.getString("grauParentesco"));
                lstAl.add(al);
            }

            rs.close();
            stmt.close();
            return lstAl;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void inserir(EncarregadoEducacao e){
        //Implementar a query
        String query="INSERT INTO encarregadoeducacao(idPessoa,grauParentesco)"+
                     "VALUES(?,?)";              
        try {
            PreparedStatement stmt=conexao.prepareStatement(query);
            stmt.setInt(1, e.getIdPessoa());
            stmt.setString(2, e.getGrauParentesco());                     
            stmt.executeUpdate();
            stmt.close();                             
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: "+ex.getMessage());
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