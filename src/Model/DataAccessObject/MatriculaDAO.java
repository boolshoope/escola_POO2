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
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
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
                ac = new Matricula(rs.getInt("nrEstudante"), rs.getInt("idTurma"), rs.getInt("idAnoAcademico"));
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
