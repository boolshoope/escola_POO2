package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class ClasseDAO {
    private Connection conexao;
    
    public ClasseDAO() {
        try{
            conexao = BD.getConexao();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
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
    
    public void adicionaClasse(Classe classe) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        /*ps = conn.prepareStatement("insert into classe(idClasse, nome) values("+classe.getIdClasse()
        +",'"+classe.getNome()+"')");*/
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("insert into classe(idClasse, nome) values (?,?)");
            ps.setInt(1, classe.getIdClasse());
            ps.setString(2, classe.getNome());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Classe Adicionada com Sucesso!");
            
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
    
    
    public void atualizarClasse(Classe classe)throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("update classe set nome = ?" + " WHERE idClasse = ?");
            ps.setString(1, classe.getNome());
            ps.setInt(2, classe.getIdClasse());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Classe Atualizada com Sucesso!");
            
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
    
    
    public void deleteClasse(Classe classe)throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement("delete from classe WHERE idClasse = ?");
            ps.setInt(1, classe.getIdClasse());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Classe removida com Sucesso!");
            
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
