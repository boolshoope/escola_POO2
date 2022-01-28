package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class AnoAcademicoDAO {
    private Connection conexao;
    
    public AnoAcademicoDAO() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
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
    
    public void adicionaAc(AnoAcademico ac) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        /*ps = conn.prepareStatement("insert into classe(idClasse, nome) values("+classe.getIdClasse()
        +",'"+classe.getNome()+"')");*/
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("insert into anoacademico(idAnoAcademico, ano, trimestre) values (?,?,?)");
            ps.setInt(1, ac.getIdAnoAcademico());
            ps.setInt(2, ac.getAno());
            ps.setInt(3, ac.getTrimestre());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Ano Academico adicionado com Sucesso!");
            
        }catch(Exception e){
            
           JOptionPane.showMessageDialog(null, "O ID nao pode ser duplicado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            
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
    
    
    public void atualizarAc(AnoAcademico ac)throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("update anoacademico set ano = ?, trimestre = ?" + " WHERE idAnoAcademico = ?");
            ps.setInt(1, ac.getAno());
            ps.setInt(2, ac.getTrimestre());
            ps.setInt(3, ac.getIdAnoAcademico());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Ano Academico Atualizado com Sucesso!");
            
            
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
    
    
    public void deleteAc(AnoAcademico ac)throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("delete from anoacademico WHERE IdAnoAcademico = ?");
            ps.setInt(1, ac.getIdAnoAcademico());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Ano Academico removido com Sucesso!");
            
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
