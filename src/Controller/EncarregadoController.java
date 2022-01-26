/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.EncarregadoEducacaoDAO;
import Model.ValueObject.EncarregadoEducacao;
import java.util.List;

/**
 *
 * @author isacl
 */
public class EncarregadoController {
    public List<EncarregadoEducacao> lstEnc;
    private EncarregadoEducacaoDAO bd;
    
    public EncarregadoController() {
        bd = new EncarregadoEducacaoDAO();
        lstEnc = bd.getEncarregadoEducacao();
    }
}
