package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClasseDiscProfDAO {
    private Connection conexao;

    public ClasseDiscProfDAO() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
        }
    }
    
    public List<ClasseDiscProf> getClasseDiscProf() {
        List<ClasseDiscProf> lstAc = new ArrayList<>();
        ClasseDiscProf ac;
        ResultSet rs;

        try {
            String query = "select * from classediscprof";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ac = new ClasseDiscProf(rs.getInt("idClasse"), rs.getInt("idDisciplina"), rs.getInt("idProfessor"));
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
