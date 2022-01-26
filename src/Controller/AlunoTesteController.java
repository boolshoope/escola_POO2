/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.AlunoTesteDAO;
import Model.ValueObject.AlunoTeste;
import java.util.List;

/**
 *
 * @author isacl
 */
public class AlunoTesteController {
    public List<AlunoTeste> lstAlunoTeste;
    private AlunoTesteDAO bd;
    
    public AlunoTesteController() {
        bd = new AlunoTesteDAO();
        lstAlunoTeste = bd.getAlunoTeste();
    }
}
