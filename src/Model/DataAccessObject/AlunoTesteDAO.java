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
}
