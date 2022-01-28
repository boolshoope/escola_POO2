/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.ProfessorDAO;
import Model.ValueObject.Classe;
import Model.ValueObject.Professor;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class ProfessorController {
    public List<Professor> lstProfessor;
    public DefaultTableModel tableModel;
    private ProfessorDAO bd;
    
    public ProfessorController() {
        bd = new ProfessorDAO();
        lstProfessor = bd.getProfessor();
    }
    
    
    public DefaultTableModel listItems() {
        String col[] = {"Id", "Nome", "Apelido",
                        "Sexo", "BI", "Estado Civil",
                        "Tel-1", "Tel-2", "Grau Academico"};
        tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < lstProfessor.size(); i++) {
            int id = lstProfessor.get(i).getIdPessoa();
            String nome = lstProfessor.get(i).getpNome();
            String apelido = lstProfessor.get(i).getApelido();
            char sexo = lstProfessor.get(i).getSexo();
            String nrBI = lstProfessor.get(i).getNrBI();
            String estadoCivil = lstProfessor.get(i).getEstadoCivil();
            String tel1 = lstProfessor.get(i).getTel1();
            String tel2 = lstProfessor.get(i).getTel2();
            String grauAcademico = lstProfessor.get(i).getGrauAcademico();
            Object[] data = {id, nome};
            tableModel.addRow(data);
        }
        return tableModel;
    }
    public void deleteItem(int index) {
        Professor d = lstProfessor.get(index);
        //bd.
        tableModel.removeRow(index);
        lstProfessor.remove(index);
    }
    
    public int searchItem(String nome){
        int index = -1;
        
        for (int i = 0; i < lstProfessor.size(); i++) {
            if (lstProfessor.get(i).getpNome().equals(nome)) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    public int getIdSelectedItem(int index){
        int id = lstProfessor.get(index).getIdPessoa();
        return id;
    }
}
