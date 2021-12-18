/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Visualizar extends JFrame implements ActionListener, MouseListener {

   JTextField t1, t2;
    JButton enc, prof, turma;
    JPanel painel_dados, painel_visualizar, painel_campo, painel_butoes, painel_tabelas;
    JTable tabelaEnc, tabelaProf, tabelaT;
    Font br;
    JScrollPane spEnc, spProf, spT;
            
    public Visualizar(){
   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TabelaS
        Object[][] dadosEnc ={{" "," "}};
        String[] nomesEnc = {"NOME DO ENCARREGADO", "CODIGO"};
        DefaultTableModel modeloEnc = new DefaultTableModel(dadosEnc,nomesEnc);
        tabelaEnc = new JTable(modeloEnc);
        tabelaEnc.setPreferredScrollableViewportSize(new Dimension(400, 500));
        tabelaEnc.setFillsViewportHeight(true);        
        
        Object[][] dadosProf ={{" "," "}};
        String[] nomesProf = {"NOME DO PROFESSOR", "DISCIPLINA"};
        DefaultTableModel modeloProf = new DefaultTableModel(dadosProf,nomesProf);
        tabelaProf = new JTable(modeloProf);
        tabelaProf.setPreferredScrollableViewportSize(new Dimension(400, 500));
        tabelaProf.setFillsViewportHeight(true);        
        
        Object[][] dadosT ={{" "," "}};
        String[] nomesT = {"NOME DA TURMA", "CODIGO"};
        DefaultTableModel modeloT = new DefaultTableModel(dadosT,nomesT);
        tabelaT = new JTable(modeloT);
        tabelaT.setPreferredScrollableViewportSize(new Dimension(400, 500));
        tabelaT.setFillsViewportHeight(true);        
        //
        //INICIALIZACOES
        spEnc = new JScrollPane(tabelaEnc);               
        spProf = new JScrollPane(tabelaProf);       
        spT = new JScrollPane(tabelaT);               
        painel_tabelas = new JPanel();
        painel_dados = new JPanel();
        painel_visualizar = new JPanel();
        painel_campo = new JPanel();
        painel_butoes = new JPanel();
        br = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
        t1 = new JTextField(15);
        t2 = new JTextField(15);
        enc = new JButton("ENCARREGADOS");
        enc.setFocusable(false);
        turma = new JButton("TURMA");
        turma.setFocusable(false);
        prof = new JButton("PROFESSORES");
        prof.setFocusable(false);
        t1.setText("NOME");
        t2.setText("NUMERO");
        //CONFIGUNRANDO FUNDOS
        painel_tabelas.setBackground(Color.WHITE);
        painel_dados.setBackground(Color.white);
        painel_visualizar.setBackground(Color.white);
        painel_butoes.setBackground(Color.white);
        painel_campo.setBackground(Color.white);
        enc.setBackground(new Color(62, 62, 62));
        turma.setBackground(new Color(62, 62, 62));
        prof.setBackground(new Color(62, 62, 62));
        enc.setForeground(Color.WHITE);
        prof.setForeground(Color.WHITE);
        turma.setForeground(Color.WHITE);
        //CONFIGURANDO DIMINSOES
        painel_tabelas.setBounds(10, 15, 410, 425);         
        painel_campo.setBounds(15, 30, 290, 100);
        painel_visualizar.setBounds(0, 0, 430, 445);
        painel_dados.setBounds(430, 0, 312, 445);
        painel_butoes.setBounds(15, 150, 290, 190);
        t1.setBounds(20, 10, 250, 30);
        t2.setBounds(20, 59, 250, 30);
        enc.setBounds(20, 15, 250, 40);
        prof.setBounds(20, 65, 250, 40);
        turma.setBounds(20, 115, 250, 40);
        painel_dados.setLayout(null);
        painel_butoes.setLayout(null);
        painel_campo.setLayout(null);
        painel_visualizar.setLayout(null);
        setBounds(350, 100, 750, 470);        
        //CONFIGURANDO BORDAS
        painel_dados.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true), "Insercao de Dados", TitledBorder.LEFT, TitledBorder.TOP, br, new Color(62, 62, 62)));
        painel_visualizar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true), "Visualizacao", TitledBorder.LEFT, TitledBorder.TOP, br, new Color(62, 62, 62)));
        painel_butoes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true), "listar", TitledBorder.LEFT, TitledBorder.TOP, br, new Color(62, 62, 62)));
        painel_campo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true), "", TitledBorder.LEFT, TitledBorder.TOP, br, new Color(62, 62, 62)));
        painel_tabelas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true), "", TitledBorder.LEFT, TitledBorder.TOP, br, new Color(62, 62, 62)));
        //ADICOES
        painel_butoes.add(enc);
        painel_butoes.add(prof);
        painel_butoes.add(turma);
        painel_campo.add(t1);
        painel_campo.add(t2);
        painel_dados.add(painel_butoes);
        painel_dados.add(painel_campo);
        painel_tabelas.add(spProf);
        painel_tabelas.add(spT);
        painel_tabelas.add(spEnc);
        painel_visualizar.add(painel_tabelas);
        add(painel_dados);
        add(painel_visualizar);
        //Eventos
        t1.addMouseListener(this);
        t2.addMouseListener(this);
        enc.addActionListener(this);
        //
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

  
    public void limpa(JTextField tf) {
        tf.setText("");
    }

    public void preenche(JTextField tf, String st) {
        tf.setText(st);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == enc) {
            spEnc.setVisible(true);
            spProf.setVisible(false);
        }
        if(ae.getSource()==prof){
            spProf.setVisible(true);
            spEnc.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == t1) {
            t1.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        t1.setText("");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == t1) {
            if (t1.getText().equals("NOME")) {
                limpa(t1);
            }
        }
        if (e.getSource() == t2) {
            if (t2.getText().equals("NUMERO")) {
                limpa(t2);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == t1) {
            if (t1.getText().equals("")) {
                preenche(t1, "NOME");
            }
        } else {
            if (t2.getText().equals("")) {
                preenche(t2, "NUMERO");
            }
        }
    }

   
}
