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

    public DisciplinaController() {
        BD bd = new BD();
        lstDisciplina = bd.getDisciplina();
    }

    public DefaultTableModel listItems() {
        String col[] = {"Id", "Nome"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < lstDisciplina.size(); i++) {
            int id = lstDisciplina.get(i).getIdDisciplina();
            String nome = lstDisciplina.get(i).getNome();

            Object[] data = {id, nome};
            tableModel.addRow(data);
        }
        
        return tableModel;
    }

    /*
    public void salvar() throws Exception {
        CarroDAO carro = new CarroDAO();
        carro.inserir(cr);
    }
     */
}
