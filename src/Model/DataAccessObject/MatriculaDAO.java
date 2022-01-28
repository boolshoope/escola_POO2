package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MatriculaDAO {
    private Connection conexao;

    public MatriculaDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public List<Matricula> getMatricula() {
        List<Matricula> lstAc = new ArrayList<>();
        Matricula ac;
        ResultSet rs;

        try {
            String query = "select * from matricula";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ac = new Matricula(rs.getInt("nrEstudante"), 
                                   rs.getInt("idTurma"), 
                                   rs.getInt("idAnoAcademico"));
                lstAc.add(ac);
            }

            rs.close();
            stmt.close();
            return lstAc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void inserir(Matricula m){
        //Implementar a query
        String query="INSERT INTO matricula(nrEstudante,idTurma,idAnoAcademico)"+
                      "VALUES(?,?,?)";                
        try {
            PreparedStatement stmt=conexao.prepareStatement(query);
            stmt.setInt(1, m.getNrEstudante());
            stmt.setInt(2, m.getIdTurma());
            stmt.setInt(3, m.getIdAnoAcademico());                     
            stmt.executeUpdate();
            stmt.close();                             
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: "+ex.getMessage());
        }
    }
}
