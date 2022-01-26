/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.AlunoDAO;
import Model.ValueObject.Aluno;
import java.util.List;

/**
 *
 * @author isacl
 */
public class AlunoController {
    public List<Aluno> lstAluno;
    private AlunoDAO bd;
    
    public AlunoController() {
        bd = new AlunoDAO();
        lstAluno = bd.getAluno();
    }
}
