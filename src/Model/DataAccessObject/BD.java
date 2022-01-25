/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author isacl
 */
public class BD {

    private Connection conexao;

    public BD() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Selects">
    public List<Aluno> getAluno() {
        List<Aluno> lstAl = new ArrayList<>();
        Aluno al;
        ResultSet rs;

        try {
            String query = "select * from aluno";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                al = new Aluno(getPessoa(rs.getInt("idPessoa")), rs.getInt("nrEstudante"),
                        rs.getDate("dataNascimento"), rs.getInt("idEncarregadoEducacao"));
                lstAl.add(al);
            }

            rs.close();
            stmt.close();
            return lstAl;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EncarregadoEducacao> getEncarregadoEducacao() {
        List<EncarregadoEducacao> lstAl = new ArrayList<>();
        EncarregadoEducacao al;
        ResultSet rs;

        try {
            String query = "select * from encarregadoeducacao";
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

    public List<Professor> getProfessor() {
        List<Professor> lstAl = new ArrayList<>();
        Professor al;
        ResultSet rs;

        try {
            String query = "select * from professor";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                al = new Professor(getPessoa(rs.getInt("idPessoa")), rs.getString("grauAcademico"));
                lstAl.add(al);
            }

            rs.close();
            stmt.close();
            return lstAl;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    private Pessoa getPessoa(int id) {
        Pessoa p = null;
        ResultSet rs;

        try {
            String query = "select * from pessoa where idPessoa =" + id;
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                p = new Pessoa(rs.getInt("idPessoa"), rs.getString("pNome"), rs.getString("apelido"),
                        rs.getString("sexo").charAt(0), rs.getString("nrBI"), rs.getString("estadoCivil"),
                        rs.getString("tel1"), rs.getString("tel2"));
            }

            rs.close();
            stmt.close();
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    public List<Teste> getTeste() {
        List<Teste> lstAc = new ArrayList<>();
        Teste ac;
        ResultSet rs;

        try {
            String query = "select * from teste";
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //int idTeste, String tipo, Date dataRealizacao, float peso, int idAnoAcademico, int idDisciplina
                ac = new Teste(rs.getInt("idTeste"), rs.getString("tipo"),
                        rs.getDate("dataRealizacao"), rs.getFloat("peso"), rs.getInt("idAnoAcademico"), rs.getInt("idDisciplina"));
                lstAc.add(ac);
            }

            rs.close();
            stmt.close();
            return lstAc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Inserts">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Updates">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Delete">
    // </editor-fold>
}
