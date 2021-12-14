/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Visualizar extends JFrame {

    public Visualizar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 100, 750, 470);
        JPanel painel_dados = new JPanel();
        JPanel painel_visualizar = new JPanel();
        JPanel painel_campo = new JPanel();
        JLabel Num = new JLabel("Numero           ");
        JLabel Nome = new JLabel("Nome              ");
        JTextField t1 = new JTextField(15);
        JTextField t2 = new JTextField(15);
        JButton enc = new JButton("Encarregados");
        JButton turma = new JButton("Turma");
        JButton prof = new JButton("Professores");
        JPanel painel_butoes = new JPanel();
        painel_dados.setBackground(Color.gray);
        painel_visualizar.setBackground(Color.gray);
        painel_butoes.setBackground(Color.gray);
        painel_campo.setBackground(Color.gray);
        painel_campo.setBounds(15, 30, 290, 100);
        painel_visualizar.setBounds(0, 0, 430, 445);
        painel_dados.setBounds(430, 0, 312, 445);
        painel_butoes.setBounds(15, 150, 290, 190);
        enc.setBounds(20, 15, 250, 40);
        prof.setBounds(20, 65, 250, 40);
        turma.setBounds(20, 115, 250, 40);
        painel_dados.setLayout(null);
        painel_butoes.setLayout(null);
        painel_dados.setBorder(BorderFactory.createTitledBorder("Insercao de Dados"));
        painel_visualizar.setBorder(BorderFactory.createTitledBorder("Visualizacao"));
        painel_butoes.setBorder(BorderFactory.createTitledBorder("listar"));
        painel_campo.setBorder(BorderFactory.createTitledBorder(""));
        painel_butoes.add(enc);
        painel_butoes.add(prof);
        painel_butoes.add(turma);
        painel_campo.add(t1);
        painel_campo.add(Nome);
        painel_campo.add(t2);
        painel_campo.add(Num);
        painel_dados.add(painel_butoes);
        painel_dados.add(painel_campo);
        add(painel_dados);
        add(painel_visualizar);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

}