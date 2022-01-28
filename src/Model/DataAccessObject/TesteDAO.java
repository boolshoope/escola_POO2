package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TesteDAO {
    private Connection conexao;

    public TesteDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public List<Teste> getTeste() {
        List<Teste> lstAc = new ArrayList<>();
        Teste ac;
        ResultSet rs;

        try {
            String query = "select * from teste";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //int idTeste, String tipo, Date dataRealizacao, float peso, int idAnoAcademico, int idDisciplina
                ac = new Teste(rs.getInt("idTeste"), rs.getString("tipo"),
                        rs.getDate("dataRealizacao"), rs.getFloat("peso"), rs.getInt("idAnoAcademico"), rs.getInt("idDisciplina"));
                lstAc.add(ac);
            }

            rs.close();
            stmt.close();
            return lstAc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
