/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author isacl
 */
public class Teste extends JFrame {

    JPanel panTeste, panNotas, pan;
    JPanel[] panDadosTeste = new JPanel[5], panDadosNotas = new JPanel[3];
    JLabel[] lblDadosTeste = new JLabel[5], lblDadosNotas = new JLabel[3];
    JTextField txtTipo, txtPeso, txtNota, txtNomeAluno;
    JTextField txtComentario;
    JComboBox cboDisc, cboAno;
    JTable tabAluno;
    String[] columnNames = {"Name", "Nota", "Comentario"};

    public Teste() {
        //panel
        panTeste = new JPanel();
        panTeste.setLayout(new BoxLayout(panTeste, BoxLayout.Y_AXIS));
        panTeste.setBorder(BorderFactory.createTitledBorder("Dados do Teste"));
        panNotas = new JPanel();
        panNotas.setLayout(new BoxLayout(panNotas, BoxLayout.Y_AXIS));
        panNotas.setBorder(BorderFactory.createTitledBorder("Notas"));

        pan = new JPanel(new FlowLayout(FlowLayout.LEFT));

        for (int i = 0; i < panDadosTeste.length; i++) {
            switch (i) {
                case 0:
                    panDadosTeste[i] = new JPanel();
                    lblDadosTeste[i] = new JLabel("Disciplina");
                    cboDisc = new JComboBox();
                    AddPanDadosTeste(panDadosTeste[i], lblDadosTeste[i], cboDisc);
                    break;
                case 1:
                    panDadosTeste[i] = new JPanel();
                    lblDadosTeste[i] = new JLabel("Tipo");
                    txtTipo = new JTextField(40);
                    AddPanDadosTeste(panDadosTeste[i], lblDadosTeste[i], txtTipo);
                    break;
                case 2:
                    panDadosTeste[i] = new JPanel();
                    lblDadosTeste[i] = new JLabel("Peso");
                    txtPeso = new JTextField(10);
                    pan.add(txtPeso);

                    panDadosTeste[i].setLayout(new BoxLayout(panDadosTeste[i], BoxLayout.Y_AXIS));
                    panDadosTeste[i].setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
                    lblDadosTeste[i].setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
                    //txt.setColumns(20);

                    panDadosTeste[i].add(lblDadosTeste[i]);
                    panDadosTeste[i].add(pan);

                    //AddPanDadosTeste(panDadosTeste[i], lblDadosTeste[i], txtPeso);
                    break;
                case 3:
                    panDadosTeste[i] = new JPanel();
                    lblDadosTeste[i] = new JLabel("Data Realizacao");
                    txtPeso = new JTextField();
                    AddPanDadosTeste(panDadosTeste[i], lblDadosTeste[i], txtPeso);
                    break;
                case 4:
                    panDadosTeste[i] = new JPanel();
                    lblDadosTeste[i] = new JLabel("Ano Academico");
                    cboAno = new JComboBox();
                    AddPanDadosTeste(panDadosTeste[i], lblDadosTeste[i], cboAno);
                    break;
            }
        }

        for (int i = 0; i < panDadosNotas.length; i++) {
            switch (i) {
                case 0:
                    panDadosNotas[i] = new JPanel();
                    lblDadosNotas[i] = new JLabel("Nome do Aluno");
                    txtNomeAluno = new JTextField();
                    AddPanDadosTeste(panDadosNotas[i], lblDadosNotas[i], txtNomeAluno);
                    break;
                case 1:
                    panDadosNotas[i] = new JPanel();
                    lblDadosNotas[i] = new JLabel("Nota");
                    txtNota = new JTextField(10);
                    AddPanDadosTeste(panDadosNotas[i], lblDadosNotas[i], txtNota);
                    break;
                case 2:
                    panDadosNotas[i] = new JPanel();
                    lblDadosNotas[i] = new JLabel("Comentario");
                    txtComentario = new JTextField();
                    AddPanDadosTeste(panDadosNotas[i], lblDadosNotas[i], txtComentario);
                    break;
            }
        }

        //table
        String[][] data = {
            {"Kundan Kumar Jha", "4031", "CSE"},
            {"Anand Jha", "6014", "IT"}
        };

        tabAluno = new JTable(data, columnNames);
        JScrollPane sp = new JScrollPane(tabAluno);
        sp.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        //add elements to panel
        for (int i = 0; i < panDadosTeste.length; i++) {
            panTeste.add(panDadosTeste[i]);
        }

        for (int i = 0; i < panDadosNotas.length; i++) {
            panNotas.add(panDadosNotas[i]);
        }

        panNotas.add(sp);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(panTeste);
        add(panNotas);
        setSize(800, 800);
        show();

        /*
        int size = panNotas.getSize().height - panTeste.getSize().height;
        panDadosTeste[panDadosTeste.length - 1].setBorder(BorderFactory.createEmptyBorder(0, 20, size, 0));
        System.out.println(panTeste.getSize().toString());
         */
    }

    private void AddPanDadosTeste(JPanel pan, JLabel lbl, JTextField txt) {
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        pan.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        lbl.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        //txt.setColumns(20);

        pan.add(lbl);
        pan.add(txt);
    }

    private void AddPanDadosTeste(JPanel pan, JLabel lbl, JComboBox cbo) {
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        pan.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        lbl.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pan.add(lbl);
        pan.add(cbo);
    }

}
