package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DisciplinaDAO {
    private Connection conexao;

    public DisciplinaDAO() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
        }
    }
    
    public List<Disciplina> getDisciplina() {
        List<Disciplina> lstAc = new ArrayList<>();
        Disciplina ac;
        ResultSet rs;

        try {
            String query = "select * from disciplina";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ac = new Disciplina(rs.getInt("idDisciplina"), rs.getString("nome"));
                lstAc.add(ac);
            }

            rs.close();
            stmt.close();
            return lstAc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void adicionaDisciplina(Disciplina disciplina) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        /*ps = conn.prepareStatement("insert into disciplina(idClasse, nome) values("+disciplina.getIdClasse()
        +",'"+disciplina.getNome()+"')");*/
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("insert into disciplina(idDisciplina, nome) values (?,?)");
            ps.setInt(1, disciplina.getIdDisciplina());
            ps.setString(2, disciplina.getNome());
            ps.execute();
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    
    public void atualizarDisciplina(Disciplina disciplina)throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("update disciplina set nome = ?" + "WHERE idDisciplina = ?");
            ps.setString(1, disciplina.getNome());
            ps.setInt(2, disciplina.getIdDisciplina());
            ps.execute();
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    public void deleteDisciplina(Disciplina disciplina)throws SQLException{
                Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("delete from disciplina WHERE idDisciplina = ?");
            ps.setInt(1, disciplina.getIdDisciplina());
            ps.execute();
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
