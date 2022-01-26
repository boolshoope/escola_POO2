/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import Model.DataAccessObject.BD;
import Model.ValueObject.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isacl
 */
public class Relatorio {
    
    private BD bd = new BD();

  /*  public void VisualizarMediasNotaGlobal(int nrEstudante, AnoAcademico anoAc) {
        Matricula mat;
        Teste teste;
        Disciplina disc;
        Turma turma;
        ClasseDiscProf cdp;
        AnoAcademico ac;
        
        List <Matricula> lstMatricula = bd.getMatricula();
        List <Teste> lstTeste = bd.getTeste();
        List <Disciplina> lstDisciplina = bd.getDisciplina();
        List <Turma> lstTurma = bd.getTurma();
        List <Turma> vecAnoAcademico = bd.getTurma();
        List <ClasseDiscProf> lstClasseDiscProf = bd.getClasseDiscProf();

        int idTurma = 0, idClasse = 0, countDisc = 0, countTrim = 3, mediaF = 0;

        List<Integer> lstDiscCod = new ArrayList<>();
        List<String> lstDiscNome = new ArrayList<>();
        int[][] medTrim;
        int media[];

        //Obter o idTurma
        for (Object m : lstMatricula) {
            mat = (Matricula) m;
            if (mat.getNrEstudante() == nrEstudante && mat.getIdAnoAcademico() == anoAc.getIdAnoAcademico()) {
                idTurma = mat.getIdTurma();
            }
        }

        //Obter o idTurma
        for (Object t : lstTurma) {
            turma = (Turma) t;
            if (turma.getIdTurma() == idTurma) {
                idClasse = turma.getIdClasse();
                dadosP[5] = turma.getNome();
                dadosP[4] = turma.getIdClasse() + "a classe";
            }
        }

        //obter as disciplinas que o aluno fez no ano academico
        for (Object t : lstClasseDiscProf) {
            cdp = (ClasseDiscProf) t;
            for (Object d : lstDisciplina) {
                disc = (Disciplina) d;
                if (cdp.getIdClasse() == idClasse && cdp.getIdDisciplina() == disc.getIdDisciplina()) {
                    lstDiscCod.add(cdp.getIdDisciplina());
                    lstDiscNome.add(disc.getNome());
                    countDisc++;
                }
            }
        }

        medTrim = new int[countDisc][countTrim];
        int vecDiscPos = 0;
        for (Object t : lstTeste) {
            teste = (Teste) t;
            for (Object a : vecAnoAcademico) {
                ac = (AnoAcademico) a;
                if (teste.getNrEstudante() == nrEstudante && lstDiscCod.contains(teste.getIdDisciplina()) && ac.getIdAnoAcademico() == teste.getIdAnoAcademico()) {
                    for (int i = 0; i < lstDiscCod.size(); i++) {
                        if (lstDiscCod.get(i) == teste.getIdDisciplina()) {
                            vecDiscPos = i;
                        }
                    }
                    medTrim[vecDiscPos][ac.getTrimestre() - 1] += (teste.getNota() * (int) teste.getPeso()) / 100;
                }
            }
        }

        //calcular a media global
        media = new int[countDisc];
        for (int i = 0; i < medTrim.length; i++) {
            for (int j = 0; j < medTrim[i].length; j++) {
                media[i] += medTrim[i][j];
            }
            media[i] /= medTrim[i].length;
            mediaF += media[i];
        }
        mediaF /= medTrim.length;

        Aluno aluno;
        EncarregadoEducacao enc;
        Classe classe;
        medGlobal = mediaF + "";
        notas = new String[media.length][2];
        for (int i = 0; i < media.length; i++) {
            notas[i][0] = (String) lstDiscNome.elementAt(i);
            notas[i][1] = media[i] + "";
        }
        dadosP[3] = anoAc.getAno() + "";
        for (int i = 0; i < vecAluno.size(); i++) {
            aluno = (Aluno) vecAluno.elementAt(i);
            if (aluno.getNrEstudante() != nrEstudante) {
                continue;
            }
            for (int j = 0; j < vecEncarregado.size(); j++) {
                enc = (EncarregadoEducacao) vecEncarregado.elementAt(j);
                if (aluno.getIdEncarregadoEducacao() == enc.getIdPessoa()) {
                    dadosP[0] = aluno.getpNome() + " " + aluno.getApelido();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate = formatter.format(aluno.getDataNascimento());
                    dadosP[1] = strDate;
                    dadosP[2] = enc.getpNome() + " " + enc.getApelido();
                }
            }
        }
    }

    static String[] dadosP = new String[6];
    static String[][] notas;
    static String medGlobal;
*/
}
