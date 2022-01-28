/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.TesteDAO;
import Model.ValueObject.Teste;
import java.util.List;

/**
 *
 * @author isacl
 */
public class TesteController {
    
    
    public List<Teste> lstTeste;
    private TesteDAO bd;
    
    public TesteController() {
        bd = new TesteDAO();
        lstTeste = bd.getTeste();
    }
}
