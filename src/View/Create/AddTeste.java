/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import Controller.AlunoController;
import Controller.AnoAcController;
import Controller.ClasseController;
import Controller.ClasseDiscProfController;
import Controller.DisciplinaController;
import Controller.MatriculaController;
import Controller.TurmaController;
import Model.ValueObject.Aluno;
import Model.ValueObject.AnoAcademico;
import Model.ValueObject.Classe;
import Model.ValueObject.ClasseDiscProf;
import Model.ValueObject.Disciplina;
import Model.ValueObject.Turma;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author isacl
 */
public class AddTeste extends JComponent implements ActionListener {

    JPanel panTeste, panNotas;
    JLabel[] lblDadosTeste = new JLabel[7], lblDadosNotas = new JLabel[4];
    JComboBox cboDisc, cboAno, cboClasse, cboTurma;
    JTextField txtTipo, txtPeso, txtNota, txtNomeAluno, txtData;
    JTextField txtComentario;
    JTable tabAluno;
    JButton btnAdd = new JButton("Adicionar");

    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    private Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);

    private ClasseController ctrlClasse = new ClasseController();
    private TurmaController ctrlTurma = new TurmaController();
    private DisciplinaController ctrlDisciplina = new DisciplinaController();
    private AnoAcController ctrlAnoAc = new AnoAcController();
    private ClasseDiscProfController ctrlCDP = new ClasseDiscProfController();
    private MatriculaController ctrlMat = new MatriculaController();
    private AlunoController ctrlAluno = new AlunoController();

    public AddTeste() {
        panTeste = new JPanel();
        panTeste.setLayout(new BoxLayout(panTeste, BoxLayout.Y_AXIS));
        panTeste.setBorder(BorderFactory.createTitledBorder("Dados do Teste"));
        panTeste.setBounds(14, 15, 421, 569);

        panNotas = new JPanel();
        panNotas.setLayout(new BoxLayout(panNotas, BoxLayout.Y_AXIS));
        panNotas.setBorder(BorderFactory.createTitledBorder("Notas"));
        panNotas.setBounds(448, 15, 638, 569);

        for (int i = 0; i < lblDadosTeste.length; i++) {
            switch (i) {
                case 0:
                    lblDadosTeste[i] = new JLabel("Classe");
                    cboClasse = new JComboBox();
                    cboClasse.addActionListener(this);
                    AddPanDadosTeste(lblDadosTeste[i], cboClasse, i, 180);
                    break;
                case 1:
                    lblDadosTeste[i] = new JLabel("Turma");
                    cboTurma = new JComboBox();
                    cboTurma.addActionListener(this);
                    AddPanDadosTeste(lblDadosTeste[i], cboTurma, 0, 180, 210);
                    break;
                case 2:
                    lblDadosTeste[i] = new JLabel("Disciplina");
                    cboDisc = new JComboBox();
                    cboDisc.addActionListener(this);
                    AddPanDadosTeste(lblDadosTeste[i], cboDisc, 1, 180);
                    break;
                case 3:
                    lblDadosTeste[i] = new JLabel("Ano Academico");
                    cboAno = new JComboBox();
                    cboAno.addActionListener(this);
                    AddPanDadosTeste(lblDadosTeste[i], cboAno, 1, 180, 210);
                    break;
                case 4:
                    lblDadosTeste[i] = new JLabel("Tipo");
                    txtTipo = new JTextField();
                    AddPanDadosTeste(lblDadosTeste[i], txtTipo, 2, 150);
                    break;
                case 5:
                    lblDadosTeste[i] = new JLabel("Peso");
                    txtPeso = new JTextField(10);
                    AddPanDadosTeste(lblDadosTeste[i], txtPeso, 3, 150);
                    break;
                case 6:
                    lblDadosTeste[i] = new JLabel("Data Realizacao");
                    txtData = new JTextField();
                    AddPanDadosTeste(lblDadosTeste[i], txtData, 4, 200);
                    break;
            }
        }

        for (int i = 0; i < lblDadosNotas.length; i++) {
            switch (i) {
                case 0:
                    lblDadosNotas[i] = new JLabel("Número de Estudante");
                    txtNomeAluno = new JTextField();
                    AddPanDadosNotas(lblDadosNotas[i], txtNomeAluno, i, 200);
                    break;
                case 1:
                    lblDadosNotas[i] = new JLabel("Nota");
                    txtNota = new JTextField();
                    AddPanDadosNotas(lblDadosNotas[i], txtNota, i, 150);
                    break;
                case 2:
                    lblDadosNotas[i] = new JLabel("Comentario");
                    txtComentario = new JTextField();
                    AddPanDadosNotas(lblDadosNotas[i], txtComentario, i, 350);
                    btnAdd.setBounds(950, 53 + i * 54, 100, 30);
                    add(btnAdd);
                    break;
                case 3:
                    lblDadosNotas[i] = new JLabel("Lista de Alunos");
                    String[][] data = {
                        {"", "", "", ""}
                    };
                    String[] columnNames = {"Nr. Est", "Name", "Nota", "Comentario"};

                    tabAluno = new JTable(data, columnNames);
                    tabAluno.setFont(f2);

                    JScrollPane sp = new JScrollPane(tabAluno);
                    sp.setBounds(465, 96 + i * 54, 602, 310);
                    add(sp);
                    break;
            }
        }

        for (int i = 0; i < ctrlClasse.lstClasse.size(); i++) {
            cboClasse.addItem(ctrlClasse.lstClasse.get(i).getNome());
        }

        for (int i = 0; i < ctrlAnoAc.lstAnoAc.size(); i++) {
            cboAno.addItem(ctrlAnoAc.lstAnoAc.get(i).getAno() + "-" + ctrlAnoAc.lstAnoAc.get(i).getTrimestre());
        }

        setSize(1100, 600);
        add(panTeste);
        add(panNotas);

        show();
    }

    private void AddPanDadosTeste(JLabel lbl, JTextField txt, int i, int column) {
        lbl.setBounds(30, 50 + i * 65, 150, 17);
        txt.setBounds(30, 76 + i * 65, column, 27);

        add(lbl);
        add(txt);
        lbl.setFont(f1);
        txt.setFont(f2);
    }

    private void AddPanDadosTeste(JLabel lbl, JComboBox txt, int i, int column) {
        lbl.setBounds(30, 50 + i * 65, 150, 17);
        txt.setBounds(30, 76 + i * 65, column, 27);

        add(lbl);
        add(txt);
        lbl.setFont(f1);
        txt.setFont(f2);
    }

    private void AddPanDadosTeste(JLabel lbl, JComboBox txt, int i, int column, int posX) {
        lbl.setBounds(30 + posX, 50 + i * 65, 150, 17);
        txt.setBounds(30 + posX, 76 + i * 65, column, 27);

        add(lbl);
        add(txt);
        lbl.setFont(f1);
        txt.setFont(f2);
    }

    private void AddPanDadosNotas(JLabel lbl, JTextField txt, int i, int column) {
        lbl.setBounds(465, 50 + i * 65, 180, 17);
        txt.setBounds(465, 76 + i * 65, column, 27);

        add(lbl);
        add(txt);
        lbl.setFont(f1);
        txt.setFont(f2);
    }

    private Disciplina disc;
    private ClasseDiscProf cdp;
    private Classe classe;
    private Aluno al;
    private Turma turm;
    private int cboAnoVal;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cboClasse) {
            cboDisc.setEnabled(false);
            cboTurma.removeAllItems();
            for (int i = 0; i < ctrlClasse.lstClasse.size(); i++) {
                for (int j = 0; j < ctrlTurma.lstTurma.size(); j++) {
                    if (ctrlClasse.lstClasse.get(i).getIdClasse() == ctrlTurma.lstTurma.get(j).getIdClasse()
                            && ctrlClasse.lstClasse.get(i).getNome().equals(cboClasse.getSelectedItem())) {
                        cboTurma.addItem(ctrlTurma.lstTurma.get(j).getNome());
                    }
                }
            }
        }

        //String[] data = cboAno.getSelectedItem().toString().split("-");
        //cboAnoVal = Integer.parseInt(data[0]);
        if (e.getSource() == cboTurma) {
            cboDisc.removeAllItems();
            cboDisc.setEnabled(true);
            for (int i = 0; i < ctrlDisciplina.lstDisciplina.size(); i++) {
                disc = ctrlDisciplina.lstDisciplina.get(i);
                for (int j = 0; j < ctrlClasse.lstClasse.size(); j++) {
                    classe = ctrlClasse.lstClasse.get(j);
                    for (int k = 0; k < ctrlCDP.lstClasseDiscProf.size(); k++) {
                        cdp = ctrlCDP.lstClasseDiscProf.get(k);
                        if (disc.getIdDisciplina() == cdp.getIdDisciplina() && classe.getIdClasse() == cdp.getIdClasse()
                                && classe.getNome().equals(cboClasse.getSelectedItem())) {
                            cboDisc.addItem(disc.getNome());
                        }
                    }
                }
            }

            for (AnoAcademico anoAc : ctrlAnoAc.lstAnoAc) {
                for (Model.ValueObject.Matricula mat : ctrlMat.lstMatricula) {
                    if (mat.getIdAnoAcademico() == anoAc.getIdAnoAcademico()) {
                        for (Turma tur : ctrlTurma.lstTurma) {
                            for (Aluno al : ctrlAluno.lstAluno) {
                                if (tur.getIdTurma() == mat.getIdTurma() && tur.getNome().equals(cboTurma.getSelectedItem())
                                        && mat.getNrEstudante() == al.getNrEstudante()) {
                                    System.out.println(al.getpNome());
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
