/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.BD;
import Model.ValueObject.Disciplina;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isacl
 */
public class DisciplinaController {

    public List<Disciplina> lstDisciplina;
    public DefaultTableModel tableModel;
    private BD bd;

    public DisciplinaController() {
        bd = new BD();
        lstDisciplina = bd.getDisciplina();
    }

    public DefaultTableModel listItems() {
        String col[] = {"Id", "Nome"};
        tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < lstDisciplina.size(); i++) {
            int id = lstDisciplina.get(i).getIdDisciplina();
            String nome = lstDisciplina.get(i).getNome();

            Object[] data = {id, nome};
            tableModel.addRow(data);
        }

        return tableModel;
    }

    public void deleteItem(int index) {
        Disciplina d = lstDisciplina.get(index);
        //bd.
        tableModel.removeRow(index);
        lstDisciplina.remove(index);

    }
    
    public int searchItem(String nome){
        int index = -1;
        
        for (int i = 0; i < lstDisciplina.size(); i++) {
            if (lstDisciplina.get(i).getNome().equals(nome)) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    public int getIdSelectedItem(int index){
        int id = lstDisciplina.get(index).getIdDisciplina();
        return id;
    }
    /*
    public void salvar() throws Exception {
        CarroDAO carro = new CarroDAO();
        carro.inserir(cr);
    }
     */
}
