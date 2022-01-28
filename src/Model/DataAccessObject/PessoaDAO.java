package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PessoaDAO {
    private Connection conexao;

    public  PessoaDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }   
    
    public List<Pessoa> getPessoa() {
        List<Pessoa> lstAc = new ArrayList<>();
        Pessoa ac;
        ResultSet rs;

        try {
            String query = "select * from pessoa";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ac = new Pessoa(rs.getInt("idPessoa"), rs.getString("pNome"),
                                rs.getString("apelido"), rs.getString("sexo").charAt(0),
                                rs.getString("nrBI"), rs.getString("estadoCivil"),
                                rs.getString("tel1"), rs.getString("tel2"));
                lstAc.add(ac);
            }

            rs.close();
            stmt.close();
            return lstAc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void inserir(Pessoa p){
        //Implementar a query
        String query="INSERT INTO pessoa(idPessoa,pNome,apelido,sexo,nrBI,estadoCivil,tel1,tel2)"+
                        "VALUES(?,?,?,?,?,?,?,?)";                
        try {
            PreparedStatement stmt=conexao.prepareStatement(query);
            stmt.setInt(1, p.getIdPessoa());
            stmt.setString(2, p.getpNome());
            stmt.setString(3, p.getApelido());
            stmt.setString(4, ""+p.getSexo());
            stmt.setString(5, p.getNrBI());
            stmt.setString(6, p.getEstadoCivil());
            stmt.setString(7, p.getTel1());
            stmt.setString(8, p.getTel2());
            stmt.executeUpdate();
            stmt.close();                             
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: "+ex.getMessage());
        }
    }
}
