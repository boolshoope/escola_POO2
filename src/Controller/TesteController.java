/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.TesteDAO;
import Model.ValueObject.Teste;
import Model.ValueObject.TesteAux;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isacl
 */
public class TesteController {

    public List<Teste> lstTeste;
    public List<TesteAux> lstTesteTab;
    private TesteDAO bd;
    public DefaultTableModel tableModel;

    public TesteController() {
        bd = new TesteDAO();
        lstTeste = bd.getTeste();
        lstTesteTab = new ArrayList<>();
    }

    public DefaultTableModel listItems() {
        String col[] = {"Nr. Est", "Name", "Nota", "Comentario"};
        tableModel = new DefaultTableModel(col, 0);
        int id;
        String nome, comentario;
        float nota;
        for (int i = 0; i < lstTesteTab.size(); i++) {
            id = lstTesteTab.get(i).getNrEstudante();
            nome = lstTesteTab.get(i).getNome();
            nota = lstTesteTab.get(i).getNota();
            comentario = lstTesteTab.get(i).getComentario();
            Object[] data = {id, nome, nota, comentario};
            tableModel.addRow(data);
        }
        return tableModel;
    }
    
    public void saveData(){
        
    }

    public int searchItem(int nome) {
        int index = -1;

        for (int i = 0; i < lstTesteTab.size(); i++) {
            if (lstTesteTab.get(i).getNrEstudante() == nome) {
                index = i;
                break;
            }
        }

        return index;
    }
    
    public void setElement(int pos, int nrEst, String nome, float nota, String com){
        TesteAux t = new TesteAux(nrEst, nome, nota, com);
        lstTesteTab.set(pos, t);
    }
}
