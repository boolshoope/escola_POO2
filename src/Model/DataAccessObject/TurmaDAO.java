package Model.DataAccessObject;

import Model.ValueObject.Turma;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TurmaDAO {
    private Connection conexao;

    public TurmaDAO() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
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
                ac = new Turma(rs.getInt("idTurma"), rs.getString("nome"), rs.getInt("maxAlunos"), rs.getInt("idClasse"));
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
