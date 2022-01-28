package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AnoAcademicoDAO {
    private Connection conexao;

    public AnoAcademicoDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public List<AnoAcademico> getAnoAcademico() {
        List<AnoAcademico> lstAc = new ArrayList<>();
        AnoAcademico ac;
        ResultSet rs;

        try {
            String query = "select * from anoacademico";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ac = new AnoAcademico(rs.getInt("idAnoAcademico"), rs.getInt("ano"), rs.getInt("trimestre"));
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
