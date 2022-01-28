package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EncarregadoEducacaoDAO {
    private Connection conexao;

    public EncarregadoEducacaoDAO() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
        }
    }
    
    public List<EncarregadoEducacao> getEncarregadoEducacao() {
        List<EncarregadoEducacao> lstAl = new ArrayList<>();
        EncarregadoEducacao al;
        ResultSet rs;

        try {
            String query = "select * from pessoa p,encarregadoeducacao e where p.idPessoa = e.idPessoa";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                al = new EncarregadoEducacao(getPessoa(rs.getInt("idPessoa")), rs.getString("grauParentesco"));
                lstAl.add(al);
            }

            rs.close();
            stmt.close();
            return lstAl;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    private Pessoa getPessoa(int id) {
        
        Pessoa p = null;
        EncarregadoEducacao E = null;
        ResultSet rs;

        try {
            String query = "select * from pessoa p,encarregadoeducacao e where p.idPessoa =e." + id;
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                p = new Pessoa(rs.getInt("idPessoa"), rs.getString("pNome"), rs.getString("apelido"),
                        rs.getString("sexo").charAt(0), rs.getString("nrBI"), rs.getString("estadoCivil"),
                        rs.getString("tel1"), rs.getString("tel2"));
                E = new EncarregadoEducacao( p, rs.getString("grauParentesco"));
            }

            rs.close();
            stmt.close();
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void actualizar(Pessoa person) {
        if(person != null ) {
           String query = "update pessoa set IdPessoa=? , pNome=?, apelido = ?, sexo=? ,nrBI = ?, estadoCivil = ?, tel1 = ? tel2 = ? where id=?";
            try {
                PreparedStatement stmt=conexao.prepareStatement(query);

                stmt.setInt(1, person.getIdPessoa());
                stmt.setString(2, person.getpNome());
                stmt.setString(3, person.getApelido());
                stmt.setString(4, Character.toString(person.getSexo())); 
                stmt.setString(5, person.getNrBI());
                stmt.setString(6, person.getEstadoCivil());
                stmt.setString(7, person.getTel1());
                stmt.setString(8, person.getTel2());
                stmt.execute();

                System.out.println("Encarregado actualizado com sucesso ");
                stmt.close(); 
            } catch(SQLException e) {
                 System.out.println("Erro de acualizacao do Encarregado: "+e.getMessage());
            }
        } else 
            System.out.println("Encaregado por parametro esta vazio ");
    }
    
    public void remove(Pessoa person){
	try{
            String query = "delete from pessoa where id=?";
	PreparedStatement stmt=conexao.prepareStatement(query);
	stmt.setInt(1, person.getIdPessoa());
	stmt.execute();
	stmt.close();
	}catch(SQLException e){
		throw new RuntimeException(e);
	}
    }
    
    public void inserir(EncarregadoEducacao person){
        //Implementar a query
        String query="INSERT INTO pessoa(idPessoa,pNome,apelido,sexo,nrBI,estadoCivil,tel1,tel2) VALUES(?,?,?,?,?,?,?,?)";
        String query1="INSERT INTO encarregadoeducacao(idPessoa,grauParentesco) VALUES (?,?)";
        try {
            PreparedStatement stmt=conexao.prepareStatement(query);
            PreparedStatement stm=conexao.prepareStatement(query1);
            stmt.setInt(1, person.getIdPessoa());
            stmt.setString(2, person.getpNome());
            stmt.setString(3, person.getApelido());
            stmt.setString(4, Character.toString(person.getSexo()));
            stmt.setString(5, person.getNrBI());
            stmt.setString(6, person.getEstadoCivil());
            stmt.setString(7, person.getTel1());
            stmt.setString(8, person.getTel2());
            stm.setInt(1, person.getIdPessoa());
            stm.setString(1, person.getGrauParentesco());
            stmt.executeUpdate();
            stmt.close();
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: "+ex.getMessage());
        }
    }
}
