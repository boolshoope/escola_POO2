/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.*;
import Model.ValueObject.AnoAcademico;
import Model.ValueObject.Turma;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isacl
 */
public class AnoAcController {

    public List<AnoAcademico> lstAnoAc;
    public DefaultTableModel tableModel;
    private AnoAcademicoDAO bd;

    public AnoAcController() {
        bd = new AnoAcademicoDAO();
        lstAnoAc = bd.getAnoAcademico();
    }

    public DefaultTableModel listItems() {
        String col[] = {"Id", "Ano", "Trimestre"};
        tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < lstAnoAc.size(); i++) {
            int id = lstAnoAc.get(i).getIdAnoAcademico();
            int ano = lstAnoAc.get(i).getAno();
            int trim = lstAnoAc.get(i).getTrimestre();

            Object[] data = {id, ano, trim};
            tableModel.addRow(data);
        }

        return tableModel;
    }

    public void deleteItem(int index) {
        AnoAcademico d = lstAnoAc.get(index);
        //bd.
        tableModel.removeRow(index);
        lstAnoAc.remove(index);

    }

    public int searchItem(int nome) {
        int index = -1;

        for (int i = 0; i < lstAnoAc.size(); i++) {
            if (lstAnoAc.get(i).getAno() == nome) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int getIdSelectedItem(int index) {
        int id = lstAnoAc.get(index).getIdAnoAcademico();
        return id;
    }
    
    public AnoAcademico searchItemAnoAcRelatorio(int nome) {
        AnoAcademico ac = null;

        for (int i = 0; i < lstAnoAc.size(); i++) {
            System.out.println(lstAnoAc.get(i).getAno() + "");
            if (lstAnoAc.get(i).getAno() == nome) {
                ac = lstAnoAc.get(i);
                break;
            }
        }
        return ac;
    }
}
