package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AlunoTesteDAO {
    private Connection conexao;

    public AlunoTesteDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public List<AlunoTeste> getAlunoTeste() {
        List<AlunoTeste> lstAc = new ArrayList<>();
        AlunoTeste ac;
        ResultSet rs;

        try {
            String query = "select * from alunoteste";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ac = new AlunoTeste(rs.getInt("nrEstudante"), rs.getInt("idTeste"), rs.getFloat("nota"), rs.getString("comentario"));
                lstAc.add(ac);
            }

            rs.close();
            stmt.close();
            return lstAc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void saveData(AlunoTeste at){
        String query="INSERT INTO alunoTeste(nrEstudante,idTeste,nota,comentario) VALUES(?,?,?,?)";                
        try {
            PreparedStatement stmt=conexao.prepareStatement(query);
            stmt.setInt(1, at.getNrEstudante());
            stmt.setInt(2, at.getIdTeste());
            stmt.setFloat(3, at.getNota());                     
            stmt.setString(3, at.getComentario());                     
            stmt.executeUpdate();
            stmt.close();                             
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: "+ex.getMessage());
        }
    }   
}
