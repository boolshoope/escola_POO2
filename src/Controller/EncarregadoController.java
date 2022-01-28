/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.EncarregadoEducacaoDAO;
import Model.ValueObject.EncarregadoEducacao;
//import Model.ValueObject.Pessoa;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isacl
 */
public class EncarregadoController {
    public  List<EncarregadoEducacao> lstEnc;
    private EncarregadoEducacaoDAO bd;
    public DefaultTableModel tableModel;
    
    public EncarregadoController() {
        bd = new EncarregadoEducacaoDAO();
        lstEnc = bd.getEncarregadoEducacao();
    }
    
    public DefaultTableModel listItems() {
        String col[] = {"Id", "Nome","Apelido","Grau parentesco","Sexo","Estado Civil","tell2","tell2"};
        tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < lstEnc.size(); i++) {
            int id = lstEnc.get(i).getIdPessoa();
            String nome = lstEnc.get(i).getpNome();
            String apelido = lstEnc.get(i).getApelido();
            char sexo = lstEnc.get(i).getSexo();
            String estado = lstEnc.get(i).getEstadoCivil();
            String tel1 = lstEnc.get(i).getTel1();
            String tel2 = lstEnc.get(i).getTel2();
            String grau = lstEnc.get(i).getGrauParentesco();

            Object[] data = {id, nome, apelido,grau,sexo,estado,tel1,tel2};
            tableModel.addRow(data);
        }

        return tableModel;
    }

    public void deleteItem(int index) {
        EncarregadoEducacao d = lstEnc.get(index);
        //bd.
        tableModel.removeRow(index);
        lstEnc.remove(index);

    }
    
    public int searchItem(int id){
        int index = -1;
        
        for (int i = 0; i < lstEnc.size(); i++) {
            if (lstEnc.get(i).getIdPessoa() == id) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    public int getIdSelectedItem(int index){
        int id = lstEnc.get(index).getIdPessoa();
        return id;
    }
    
    public String getNomeSelectedItem(int index){
        String n = lstEnc.get(index).getpNome();
        return n;
    }
    
    public String getApelidoSelectedItem(int index){
        String n = lstEnc.get(index).getApelido();
        return n;
    }
    public String getTel1SelectedItem(int index){
        String n = lstEnc.get(index).getTel1();
        return n;
    }
    
    public String getTel2SelectedItem(int index){
        String n = lstEnc.get(index).getTel2();
        return n;
    }
    
    public String getBiSelectedItem(int index){
        String n = lstEnc.get(index).getNrBI();
        return n;
    }
    
    public String getEstadoSelectedItem(int index){
        String n = lstEnc.get(index).getEstadoCivil();
        return n;
    }
    
    public String getGrauSelectedItem(int index){
        String n = lstEnc.get(index).getpNome();
        return n;
    }
}
