/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.MatriculaDAO;
import Model.ValueObject.Matricula;
import java.util.List;

/**
 *
 * @author isacl
 */
public class MatriculaController {
    public List<Matricula> lstMatricula;
    private MatriculaDAO bd;

    public MatriculaController() {
        bd = new MatriculaDAO();
        lstMatricula = bd.getMatricula();
    }
    
    
}
