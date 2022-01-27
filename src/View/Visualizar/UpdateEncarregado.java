/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Visualizar;

/**
 *
 * @author Basilio
 */

import View.Visualizar.ViewEncarregado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.MainMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.TitledBorder;


public class UpdateEncarregado extends JComponent implements ActionListener,MouseListener  {
       
    private JPanel masterPanel, paneAdd;
    private JPanel inputsPane[] = new JPanel[9];
    private JLabel headerLabel, usr, img;
    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    private JButton Button[] = new JButton[3];
    private String texto[] = {"Id","Nome","Apelido","Numero de BI","Sexo","Estado Civil","Telefone 1","Telefone 2"};
    private String msg[] = {"Solteiro","Casado","Viuvo","Divorciado"};
    private JTextField inputs[] = new JTextField[6];
    private JComboBox estCivil1;
    private JRadioButton male, female;
    private ButtonGroup grupo;
    private JLabel txtLab[] = new JLabel[3]; 
    private String path = System.getProperty("user.dir") + "/src/View/img/";
    Font br = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
    Font s = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
    private Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
    int i, idEncarregado = 1;
    boolean st = false;
    
    public UpdateEncarregado(){
        masterPanel = new JPanel();
        masterPanel.setBackground(Color.white);
        masterPanel.setLayout(null);
        masterPanel.setBounds(0, 0, 1800, 1000);
        
        paneAdd = new JPanel();
        paneAdd.setBackground(Color.white);
        paneAdd.setLayout(null);
        TitledBorder tb = BorderFactory.createTitledBorder("Actualizar Encarregado");
        tb.setTitleFont(f2);
        paneAdd.setBorder(tb);
        paneAdd.setBounds(20, 10, 1000,550);
        
        
        for(int i=0; i<inputsPane.length; i++) {
            inputsPane[i] = new JPanel();
            inputsPane[i].setBackground(Color.white);
            inputsPane[i].setPreferredSize(new Dimension(205, 43));
            inputsPane[i].setMaximumSize(new Dimension(450, 43));
            inputsPane[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
            inputsPane[i].setLayout(new GridLayout(1,1));
        }
        
        for(i=0; i < inputs.length;i++){
            inputs[i] = new JTextField();
            tfProperties(inputs[i]);
        }
        
        for(int i=0; i<inputs.length; i++) {
            inputs[i].addMouseListener(this);
        }
        
        for(i=0; i<inputs.length; i++)
            inputsPane[i].add(inputs[i]);
        
        for(i=0; i<inputsPane.length;i++)
            paneAdd.add(inputsPane[i]);
        
        
        for(int i=0; i<inputs.length; i++) {
            inputs[i].addMouseListener(this);
        }
        
        inputs[0].setText("Alone");
        inputs[1].setText("Quintal");
        inputs[2].setText("1105052643M");
        inputs[3].setText("16/05/2000");
        inputs[4].setText("852507986");
        inputs[5].setText("877085181");
        
        txtLab[0] = new JLabel("ID do Encarregado: \t       "+idEncarregado);
        txtLab[0].setFont(s);
        txtLab[0].setForeground(new Color(62, 62, 62));
        txtLab[0].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputsPane[8].add(txtLab[0]);
        
        txtLab[1] = new JLabel("Sexo:", JLabel.LEFT);
        txtLab[1].setFont(s);
        txtLab[1].setForeground(new Color(62, 62, 62));
        txtLab[1].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputsPane[6].add(txtLab[1]);
        
        txtLab[2] = new JLabel("Estado Civil");
        txtLab[2].setFont(s);
        txtLab[2].setForeground(new Color(62, 62, 62));
        txtLab[2].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputsPane[7].add(txtLab[2]);
        
        male = new JRadioButton("Masculino");
        male.setFont(s);
        male.setForeground(new Color(62, 62, 62));
        male.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        male.setOpaque(false);
        inputsPane[6].add(male);
        
        female = new JRadioButton("Femenino");
        female.setFont(s);
        female.setForeground(new Color(62, 62, 62));
        female.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        female.setOpaque(false);
        inputsPane[6].add(female);
        
        grupo = new ButtonGroup();
        grupo.add(male);
        grupo.add(female);
        
        estCivil1 = new JComboBox(msg);
        estCivil1.setFont(s);
        estCivil1.setBackground(Color.white);
        estCivil1.setPreferredSize(new Dimension(205, 43));
        estCivil1.setMaximumSize(new Dimension(450, 43));
        estCivil1.setFocusable(false);
        inputsPane[7].add(estCivil1);
        
        Button[0] = new JButton("Voltar");
        Button[1] = new JButton("Limpar");
        Button[2] = new JButton("Guardar");
        
        
        for(i=0;i<Button.length;i++){
            btlProperties(Button[i]);
            Button[i].addActionListener(this);
        }
        
        inputsPane[0].setBounds(50, 100, 360, 40);
        inputsPane[1].setBounds(50, 170, 160, 40);
        inputsPane[2].setBounds(50, 240, 360, 40);
        inputsPane[3].setBounds(50, 310, 320, 40);
        inputsPane[4].setBounds(600, 240, 320, 40);
        inputsPane[5].setBounds(600, 310,320, 40);
        inputsPane[6].setBounds(600, 30, 320, 40);
        inputsPane[7].setBounds(600, 100, 320, 40);
        inputsPane[8].setBounds(50, 30, 360, 40);
        
        
        Button[0].setBounds(70, 500,120, 40);
        Button[1].setBounds(620, 500,120, 40);
        Button[2].setBounds(820, 500,120, 40);
        
        txtLab[1].setBounds(50,190,60,40);
        
        for(i=0; i<Button.length;i++)
            masterPanel.add(Button[i]);
        
        masterPanel.add(paneAdd);
        add(masterPanel);
        
        show();
        
    }
    
    private void tfProperties(JTextField tf) {
        Font text = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
        tf.setFont(text);
        tf.setPreferredSize(new Dimension(200, 30));
        tf.setMaximumSize(new Dimension(200, 30));
        tf.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        tf.setBackground(Color.white);
        tf.setForeground(new Color(62, 62, 62));
        tf.setLocation(0, 0);
        tf.setOpaque(true);
    }
    
    private void btlProperties(JButton btl){
        btl.setPreferredSize(new Dimension(44,43));
        btl.setMaximumSize(new Dimension(44,43));
        btl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btl.setForeground(Color.white);
        btl.setBackground(new Color(62, 62, 62));
        btl.setFocusable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Button[0]){
            showForm(new ViewEncarregado());
        }
        
        
        if(ae.getSource() == Button[1]){
            inputs[0].setText("Nome");
            inputs[1].setText("Apelido");
            inputs[2].setText("Numero de BI");
            inputs[3].setText("Data de Nascimento");
            inputs[4].setText("Telefone 1");
            inputs[5].setText("Telefone 2");
        }
        
        if(ae.getSource() == Button[2]){
            JOptionPane.showMessageDialog(null, "Actualizado com Sucesso!");
            showForm(new ViewEncarregado());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource() == inputs[0]) {
            if(inputs[0].getText().equals("Nome") && st == false)
                tfChanges(inputs[0]);
            if(inputs[0].getText().equals("Apelido") && st == true)
                tfChanges(inputs[0]);
        }
        
        if(me.getSource() == inputs[1]) {
            if(inputs[1].getText().equals("Apelido") && st == false)
                tfChanges(inputs[1]);
            if(inputs[1].getText().equals("Numero de BI") && st == true)
                tfChanges(inputs[1]);
        }
        
        if(me.getSource() == inputs[2]) {
            if(inputs[2].getText().equals("Numero de BI") && st == false)
                tfChanges(inputs[2]);
            if(inputs[2].getText().equals("Data de Nascimento") && st == true)
                tfChanges(inputs[2]);
        }
        
        if(me.getSource() == inputs[3]) {
            if(inputs[3].getText().equals("Data de Nascimento") && st == false)
                tfChanges(inputs[3]);
            if(inputs[3].getText().equals("Telefone 1") && st == true)
                tfChanges(inputs[3]);
        }
        
        if(me.getSource() == inputs[4]) {
            if(inputs[4].getText().equals("Telefone 1") && st == false)
                tfChanges(inputs[4]);
            if(inputs[4].getText().equals("Telefone 2") && st == true)
                tfChanges(inputs[4]);
        }
        
        if(me.getSource() == inputs[5]) {
            if(inputs[5].getText().equals("Telefone 2") && st == false)
                tfChanges(inputs[5]);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource() == inputs[0]) {
            if(inputs[0].getText().equals("Nome") || inputs[0].getText().equals("") && st == false)
                inputs[0].setText("Nome");
            if(inputs[0].getText().equals("Apelido") || inputs[0].getText().equals("") && st == true)
                inputs[0].setText("Apelido");
        }
        
        if(me.getSource() == inputs[1]) {
            if(inputs[1].getText().equals("Apelido") || inputs[1].getText().equals("") && st == false)
                inputs[1].setText("Apelido");
            if(inputs[1].getText().equals("Numero de BI") || inputs[1].getText().equals("") && st == true)
                inputs[1].setText("Numero de BI");
        }
        
        if(me.getSource() == inputs[2]) {
            if(inputs[2].getText().equals("BI") || inputs[2].getText().equals("") && st == false)
                inputs[2].setText("Numero de BI");
            if(inputs[2].getText().equals("Data de Nascimento") || inputs[2].getText().equals("") && st == true)
                inputs[2].setText("Data de Nascimento");
        }
        
        if(me.getSource() == inputs[3]) {
            if(inputs[3].getText().equals("Data de Nascimento") || inputs[3].getText().equals("") && st == false)
                inputs[3].setText("Data de Nascimento");
            if(inputs[3].getText().equals("Telefone 1") || inputs[3].getText().equals("") && st == true)
                inputs[3].setText("Telefone 1");
        }
        
        if(me.getSource() == inputs[4]) {
            if(inputs[4].getText().equals("Telefone 1") || inputs[4].getText().equals("") && st == false)
                inputs[4].setText("Telefone 1");
            if(inputs[4].getText().equals("Telefone 2") || inputs[4].getText().equals("") && st == true)
                inputs[4].setText("Telefone 2");
        }
        
        if(me.getSource() == inputs[5]) {
            if(inputs[5].getText().equals("Telefone 2") || inputs[5].getText().equals("") && st == false)
                inputs[5].setText("Telefone 2");
        }
    }
    
    private void tfChanges(JTextField tfd) {
        tfd.setText("");
    }
    
    private void showForm(Component com) {
        BorderLayout layout = (BorderLayout) MainMenu.main.getLayout();
        if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
            MainMenu.main.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        }

        MainMenu.main.add(com, BorderLayout.CENTER);
        MainMenu.main.repaint();
        MainMenu.main.revalidate();
    }
    
}
