/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import Controller.*;
import Model.ValueObject.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isacl
 */
public class Relatorio {

    private TurmaController ctrlTurma = new TurmaController();
    private MatriculaController ctrlMat = new MatriculaController();
    private TesteController ctrlTeste = new TesteController();
    private AlunoTesteController ctrlAlunoTeste = new AlunoTesteController();
    private DisciplinaController ctrlDisc = new DisciplinaController();
    private AnoAcController ctrlAnoAc = new AnoAcController();
    private ClasseDiscProfController ctrlClasseDiscProf = new ClasseDiscProfController();
    private AlunoController ctrlAluno = new AlunoController();
    private EncarregadoController ctrlEncarregado = new EncarregadoController();

    public void VisualizarMediasNotaGlobal(int nrEstudante, AnoAcademico anoAc) {
        Model.ValueObject.Matricula mat;
        Teste teste;
        AlunoTeste alunoTeste;
        Disciplina disc;
        Turma turma;
        ClasseDiscProf cdp;
        AnoAcademico ac;

        List<Model.ValueObject.Matricula> lstMatricula = ctrlMat.lstMatricula;
        List<Teste> lstTeste = ctrlTeste.lstTeste;
        List<AlunoTeste> lstAlunoTeste = ctrlAlunoTeste.lstAlunoTeste;
        List<Disciplina> lstDisciplina = ctrlDisc.lstDisciplina;
        List<Turma> lstTurma = ctrlTurma.lstTurma;
        List<AnoAcademico> lstAnoAcademico = ctrlAnoAc.lstAnoAc;
        List<ClasseDiscProf> lstClasseDiscProf = ctrlClasseDiscProf.lstClasseDiscProf;
        List<Aluno> lstAluno = ctrlAluno.lstAluno;
        List<EncarregadoEducacao> lstEncarregado = ctrlEncarregado.lstEnc;

        int idTurma = 0, idClasse = 0, countDisc = 0, countTrim = 3, mediaF = 0;

        List<Integer> lstDiscCod = new ArrayList<>();
        List<String> lstDiscNome = new ArrayList<>();
        int[][] medTrim;
        int media[];

        //Obter o idTurma
        for (Object m : lstMatricula) {
            mat = (Model.ValueObject.Matricula) m;
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
            for (Object a : lstAnoAcademico) {
                ac = (AnoAcademico) a;
                for (Object at : lstAlunoTeste) {
                    alunoTeste = (AlunoTeste) at;

                    if (alunoTeste.getNrEstudante() == nrEstudante && alunoTeste.getIdTeste() == teste.getIdTeste()
                            && lstDiscCod.contains(teste.getIdDisciplina()) && ac.getIdAnoAcademico() == teste.getIdAnoAcademico()) {
                        for (int i = 0; i < lstDiscCod.size(); i++) {
                            if (lstDiscCod.get(i) == teste.getIdDisciplina()) {
                                vecDiscPos = i;
                            }
                        }
                        medTrim[vecDiscPos][ac.getTrimestre() - 1] += (alunoTeste.getNota() * (int) teste.getPeso()) / 100;
                    }
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
        medGlobal = mediaF + "";
        notas = new String[media.length][2];
        for (int i = 0; i < media.length; i++) {
            notas[i][0] = lstDiscNome.get(i);
            notas[i][1] = media[i] + "";
        }
        dadosP[3] = anoAc.getAno() + "";
        for (int i = 0; i < lstAluno.size(); i++) {
            aluno = lstAluno.get(i);
            if (aluno.getNrEstudante() != nrEstudante) {
                continue;
            }
            for (int j = 0; j < lstEncarregado.size(); j++) {
                enc = lstEncarregado.get(j);
                if (aluno.getIdEncarregadoEducacao() == enc.getIdPessoa()) {
                    dadosP[0] = aluno.getpNome() + " " + aluno.getApelido();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate = formatter.format(aluno.getDataNascimento());
                    dadosP[1] = strDate;
                    dadosP[2] = enc.getpNome() + " " + enc.getApelido();
                }
            }
        }
        listItems();
    }

    static String[] dadosP = new String[6];
    public String[][] notas;
    static String medGlobal;

    public void GerarCertificado() {
        VisualizarMediasNotaGlobal(100, new AnoAcademico(1, 2020, 1));
        String path = System.getProperty("user.dir") + "/certif.pdf";
        String IMAGE = System.getProperty("user.dir") + "/src/View/img/certifBg.jpg";
        Document doc = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path));
            //PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();

            Font fontH1 = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Font fontH2 = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL);
            Font fontH3 = new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL);
            Font fontB = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);

            Paragraph p = new Paragraph(new Phrase("\n\nUNIVERSIDADE EDUARDO MONDLANE\nEscola Completa da Feng\n\n", fontH2));
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph(new Phrase("CERTIFICADO\n\n", fontH1));
            p.setAlignment(1);
            doc.add(p);

            p = new Paragraph("Eu, Isac Matusse, Diretor da Escola Completa da Feng, certifico, em cumprimento do despacho exarado em requerimento"
                    + " que fica arquivado na secreataria da escola que, " + dadosP[0] + ", nascido(a) aos " + dadosP[1] + " com o Encarregado"
                    + " de Educação " + dadosP[2] + " no ano lectivo de " + dadosP[3] + " frequentou nessa escola a " + dadosP[4]
                    + " com as seguintes classificações:\n\n");
            p.setAlignment(3);
            p.setIndentationLeft(20);
            p.setIndentationRight(25);
            doc.add(p);

            PdfPTable table = new PdfPTable(2);

            PdfPCell cel1 = new PdfPCell(new Paragraph("Disciplina", fontH3));
            PdfPCell cel2 = new PdfPCell(new Paragraph("Nota", fontH3));
            cel1.setBorder(Rectangle.NO_BORDER);
            cel2.setBorder(Rectangle.NO_BORDER);

            table.addCell(cel1);
            table.addCell(cel2);

            cel1 = new PdfPCell(new Paragraph("\n"));
            cel2 = new PdfPCell(new Paragraph("\n"));
            cel1.setBorder(Rectangle.NO_BORDER);
            cel2.setBorder(Rectangle.NO_BORDER);

            table.addCell(cel1);
            table.addCell(cel2);

            for (int i = 0; i < notas.length; i++) {
                cel1 = new PdfPCell(new Paragraph(notas[i][0], fontH3));
                cel2 = new PdfPCell(new Paragraph(notas[i][1], fontH3));
                cel1.setBorder(Rectangle.NO_BORDER);
                cel2.setBorder(Rectangle.NO_BORDER);

                table.addCell(cel1);
                table.addCell(cel2);

                cel1 = new PdfPCell(new Paragraph("\n"));
                cel2 = new PdfPCell(new Paragraph("\n"));
                cel1.setBorder(Rectangle.NO_BORDER);
                cel2.setBorder(Rectangle.NO_BORDER);

                table.addCell(cel1);
                table.addCell(cel2);
            }
            cel1 = new PdfPCell(new Paragraph("Media", fontB));
            cel2 = new PdfPCell(new Paragraph(medGlobal, fontB));
            cel1.setBorder(Rectangle.NO_BORDER);
            cel2.setBorder(Rectangle.NO_BORDER);

            table.addCell(cel1);
            table.addCell(cel2);

            doc.add(table);

            p = new Paragraph("\n\n    Foi-lhe atribuido(a) a media final de " + medGlobal + " Valores que consta na pauta de frequancia de " + dadosP[3]
                    + ", " + dadosP[4] + ", na turma " + dadosP[5] + ".\n"
                    + "    E por ser verdade mandei passar o seguinte certificado que assino e autentico com o selo branco em use nessa escola");
            p.setAlignment(3);
            p.setIndentationLeft(20);
            p.setIndentationRight(25);
            doc.add(p);

            PdfContentByte canvas = writer.getDirectContentUnder();
            Image image = Image.getInstance(IMAGE);
            image.scaleAbsolute(595, 842);
            image.setAbsolutePosition(0, 0);
            canvas.addImage(image);

            doc.close();
            Desktop.getDesktop().open(new File(path));

        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public DefaultTableModel tableModel;

    public void listItems() {
        String col[] = {"Disciplina", "Media"};
        tableModel = new DefaultTableModel(col, 0);

        String disc, nota;
        for (int i = 0; i < notas.length; i++) {
            disc = notas[i][0];
            nota = notas[i][1];
            Object[] data = {disc, nota};
            tableModel.addRow(data);
        }
    }

}
