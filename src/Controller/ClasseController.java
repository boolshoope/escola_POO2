/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.*;
import Model.ValueObject.Classe;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isacl
 */
public class ClasseController {
    public List<Classe> lstClasse;
    public DefaultTableModel tableModel;
    private ClasseDAO bd;

    public ClasseController() {
        bd = new ClasseDAO();
        lstClasse = bd.getClasse();
    }

    public DefaultTableModel listItems() {
        String col[] = {"Id", "Nome"};
        tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < lstClasse.size(); i++) {
            int id = lstClasse.get(i).getIdClasse();
            String nome = lstClasse.get(i).getNome();

            Object[] data = {id, nome};
            tableModel.addRow(data);
        }
        return tableModel;
    }

    public void deleteItem(int index) {
        Classe d = lstClasse.get(index);
        //bd.
        tableModel.removeRow(index);
        lstClasse.remove(index);
    }
    
    public int searchItem(String nome){
        int index = -1;
        
        for (int i = 0; i < lstClasse.size(); i++) {
            if (lstClasse.get(i).getNome().equals(nome)) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    public int getIdSelectedItem(int index){
        int id = lstClasse.get(index).getIdClasse();
        return id;
    }
    
}
