package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClasseDAO {
    private Connection conexao;

    public ClasseDAO() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
        }
    }
    
    public List<Classe> getClasse() {
        List<Classe> lstAc = new ArrayList<>();
        Classe ac;
        ResultSet rs;

        try {
            String query = "select * from classe";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ac = new Classe(rs.getInt("idClasse"), rs.getString("nome"));
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
