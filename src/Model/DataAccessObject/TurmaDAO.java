package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TurmaDAO {
    private Connection conexao;

    public TurmaDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public List<Turma> getTurma() {
        List<Turma> lstAc = new ArrayList<>();
        Turma ac;
        ResultSet rs;

        try {
            String query = "select * from turma";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ac = new Turma(rs.getInt("idTurma"), rs.getString("nome"),
                                rs.getInt("maxAlunos"), rs.getInt("idClasse"));
                lstAc.add(ac);
            }

            rs.close();
            stmt.close();
            return lstAc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void inserir(Turma t){
        //Implementar a query
        String query="INSERT INTO turma(nome,maxAlunos,idClasse)"+
                     "VALUES(?,?,?)";                
        try {
            PreparedStatement stmt=conexao.prepareStatement(query);
            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getMaxAlunos());
            stmt.setInt(3, t.getIdClasse());                     
            stmt.executeUpdate();
            stmt.close();                             
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: "+ex.getMessage());
        }
    }
}
