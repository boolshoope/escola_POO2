/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataAccessObject.AlunoDAO;
import Model.ValueObject.Aluno;
import Model.ValueObject.AnoAcademico;
import Model.ValueObject.Matricula;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author isacl
 */
public class AlunoController {

    public List<Aluno> lstAluno;
    private MatriculaController ctrlMat;
    private AnoAcController ctrlAnoAc;
    private AlunoDAO bd;

    public AlunoController() {
        bd = new AlunoDAO();
        lstAluno = bd.getAluno();
        ctrlMat = new MatriculaController();
        ctrlAnoAc = new AnoAcController();
    }

    public int searchItem(int nrEst) {
        int index = -1;

        for (int i = 0; i < lstAluno.size(); i++) {
            if (lstAluno.get(i).getNrEstudante() == nrEst) {
                index = i;
                break;
            }
        }
        return index;
    }

    public String[] searchItemCertificado(int nrEst) {
        String[] dados = null;
        for (int i = 0; i < lstAluno.size(); i++) {
            if (lstAluno.get(i).getNrEstudante() == nrEst) {
                dados = new String[3];
                dados[0] = lstAluno.get(i).getpNome() + " " + lstAluno.get(i).getApelido();
                dados[1] = lstAluno.get(i).getDataNascimento().toString();
                dados[2] = lstAluno.get(i).getSexo() + "";
                break;
            }
        }
        return dados;
    }

    public List<String> getAnoAcFrequentado(int nrEst) {
        List<String> dados = new ArrayList();
        Matricula mat;
        Aluno al;
        AnoAcademico ac;
        for (int i = 0; i < lstAluno.size(); i++) {
            al = lstAluno.get(i);
            if (al.getNrEstudante() == nrEst) {
                for (int j = 0; j < ctrlAnoAc.lstAnoAc.size(); j++) {
                    ac = ctrlAnoAc.lstAnoAc.get(j);
                    for (int k = 0; k < ctrlMat.lstMatricula.size(); k++) {
                        mat = ctrlMat.lstMatricula.get(k);
                        if (ac.getIdAnoAcademico() == mat.getIdAnoAcademico() && mat.getNrEstudante() == nrEst) {
                            dados.add(ac.getAno() + "");
                        }
                    }
                }
            }
        }

        Set<String> set = new HashSet<>(dados);
        dados.clear();
        dados.addAll(set);

        return dados;
    }
}
