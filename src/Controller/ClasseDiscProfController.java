/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.ClasseDiscProfDAO;
import Model.ValueObject.ClasseDiscProf;
import java.util.List;

/**
 *
 * @author isacl
 */
public class ClasseDiscProfController {

    public List<ClasseDiscProf> lstClasseDiscProf;
    private ClasseDiscProfDAO bd;

    public ClasseDiscProfController() {
        bd = new ClasseDiscProfDAO();
        lstClasseDiscProf = bd.getClasseDiscProf();
    }
}
