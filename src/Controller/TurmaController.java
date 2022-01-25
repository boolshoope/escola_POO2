/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.*;
import Model.ValueObject.Classe;
import Model.ValueObject.Turma;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isacl
 */
public class TurmaController {

    public List<Turma> lstTurma;
    public List<Classe> lstClasse;
    public DefaultTableModel tableModel;
    private TurmaDAO bd;
    private ClasseDAO bd1;

    public TurmaController() {
        bd = new TurmaDAO();
        bd1 = new ClasseDAO();
        lstTurma = bd.getTurma();
        lstClasse = bd1.getClasse();
    }

    public DefaultTableModel listItems() {
        String col[] = {"Id", "Nome", "Maximo de alunos", "Classe"};
        tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < lstTurma.size(); i++) {
            int id = lstTurma.get(i).getIdClasse();
            String nome = lstTurma.get(i).getNome();
            int max = lstTurma.get(i).getMaxAlunos();
            String classe = "";
            for (int j = 0; j < lstClasse.size(); j++) {
                if (lstTurma.get(i).getIdClasse() == lstClasse.get(j).getIdClasse()) {
                    classe = lstClasse.get(j).getNome();
                }
            }

            Object[] data = {id, nome, max, classe};
            tableModel.addRow(data);
        }

        return tableModel;
    }

    public void deleteItem(int index) {
        Turma d = lstTurma.get(index);
        //bd.
        tableModel.removeRow(index);
        lstTurma.remove(index);

    }

    public int searchItem(String nome) {
        int index = -1;

        for (int i = 0; i < lstTurma.size(); i++) {
            if (lstTurma.get(i).getNome().equals(nome)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int getIdSelectedItem(int index) {
        int id = lstTurma.get(index).getIdClasse();
        return id;
    }
}
