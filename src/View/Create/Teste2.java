/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import javax.swing.*;

/**
 *
 * @author isacl
 */
public class Teste2 extends JComponent {

    JPanel panTeste, panNotas;
    JLabel[] lblDadosTeste = new JLabel[5], lblDadosNotas = new JLabel[4];
    JComboBox cboDisc, cboAno;
    JTextField txtTipo, txtPeso, txtNota, txtNomeAluno, txtData;
    JTextField txtComentario;
    JTable tabAluno;
    JButton btnAdd = new JButton("Adicionar");

    public Teste2() {
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
                    lblDadosTeste[i] = new JLabel("Disciplina");
                    cboDisc = new JComboBox();
                    AddPanDadosTeste(lblDadosTeste[i], cboDisc, i);
                    break;
                case 1:
                    lblDadosTeste[i] = new JLabel("Tipo");
                    txtTipo = new JTextField();
                    AddPanDadosTeste(lblDadosTeste[i], txtTipo, i);
                    break;
                case 2:
                    lblDadosTeste[i] = new JLabel("Peso");
                    txtPeso = new JTextField(10);
                    AddPanDadosTeste(lblDadosTeste[i], txtPeso, i);
                    break;
                case 3:
                    lblDadosTeste[i] = new JLabel("Data Realizacao");
                    txtData = new JTextField();
                    AddPanDadosTeste(lblDadosTeste[i], txtData, i);
                    break;
                case 4:
                    lblDadosTeste[i] = new JLabel("Ano Academico");
                    cboAno = new JComboBox();
                    AddPanDadosTeste(lblDadosTeste[i], cboAno, i);
                    break;
            }
        }

        for (int i = 0; i < lblDadosNotas.length; i++) {
            switch (i) {
                case 0:
                    lblDadosNotas[i] = new JLabel("Nome do Aluno");
                    txtNomeAluno = new JTextField();
                    AddPanDadosNotas(lblDadosNotas[i], txtNomeAluno, i);
                    break;
                case 1:
                    lblDadosNotas[i] = new JLabel("Nota");
                    txtNota = new JTextField();
                    AddPanDadosNotas(lblDadosNotas[i], txtNota, i);
                    break;
                case 2:
                    lblDadosNotas[i] = new JLabel("Comentario");
                    txtComentario = new JTextField();
                    AddPanDadosNotas(lblDadosNotas[i], txtComentario, i);
                    btnAdd.setBounds(950, 53 + i * 54, 100, 30);
                    add(btnAdd);
                    break;
                case 3:
                    lblDadosNotas[i] = new JLabel("Lista de Alunos");
                    String[][] data = {
                        {"Kundan Kumar Jha", "4031", "CSE"},
                        {"Anand Jha", "6014", "IT"}
                    };
                    String[] columnNames = {"Name", "Nota", "Comentario"};
                    
                    tabAluno = new JTable(data, columnNames);

                    JScrollPane sp = new JScrollPane(tabAluno);
                    sp.setBounds(465, 56 + i * 54, 602, 350);
                    add(sp);
                    break;
            }
        }

        /*
        tabAluno = new JTable(data, columnNames);
        JScrollPane sp = new JScrollPane(tabAluno);
         */
        //panTeste.add(btn);
        setSize(1100, 600);
        add(panTeste);
        add(panNotas);

        show();
    }

    private void AddPanDadosTeste(JLabel lbl, JTextField txt, int i) {
        lbl.setBounds(30, 40 + i * 53, 150, 17);
        txt.setBounds(30, 56 + i * 54, 218, 27);

        add(lbl);
        add(txt);
    }

    private void AddPanDadosTeste(JLabel lbl, JComboBox txt, int i) {
        lbl.setBounds(30, 40 + i * 53, 150, 17);
        txt.setBounds(30, 56 + i * 54, 218, 27);

        add(lbl);
        add(txt);
    }

    private void AddPanDadosNotas(JLabel lbl, JTextField txt, int i) {
        lbl.setBounds(465, 40 + i * 53, 150, 17);
        txt.setBounds(465, 56 + i * 54, 218, 27);

        add(lbl);
        add(txt);
    }
}
