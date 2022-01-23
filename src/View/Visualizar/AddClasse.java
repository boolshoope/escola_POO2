/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package View.Visualizar;

import View.Create.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Gabriel
 */
public class AddClasse extends JComponent implements ActionListener, MouseListener {
    
    private JPanel masterPanel;
    private JPanel headerPanel;
    private JPanel leftPanel;
    private JLabel headerLabel, usr, img;
    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    
    private JButton[] northButton, btSearch;
    private JPanel btPanel, searchPanel;
    private JTextField search;
    
    private JPanel rightPanel;
    
    private ButtonGroup genderGroup;
    
    
    private JButton registrar;
    private JTextField inputs[];
    private JPanel alDataPanel, inner, inputsPanel[], genderPanel, opPanel;
    
    
    
    private JPanel profDataPanel, inner1, inputsPanel1[], genderPanel1, opPanel1;
    private JLabel sexo1;
    private JRadioButton male1, female1;
    private ButtonGroup genderGroup1;
    private JButton addProfessor;
    private JTextField inputs1[];
    
    private JButton renovarSearch;
    
    private JButton update;
        
    private boolean st = false;
    private boolean st2 = false;
    
    public AddClasse() {
        
        
        masterPanel = new JPanel();
        headerPanel = new JPanel();
        leftPanel = new JPanel();
        northButton = new JButton[3];
        
        // painel principal
        masterPanel.setBackground(Color.white);
        masterPanel.setBounds(0, 0, getWidth(), getHeight());
        masterPanel.setBorder(null);
        masterPanel.setLayout(new BorderLayout());
        
        
        // painel esquerdo componentes
        btPanel = new JPanel();
        //BoxLayout btLayout = new BoxLayout(btPanel,BoxLayout.Y_AXIS);
        btPanel.setBackground(null);
        btPanel.setLayout(new GridLayout(1,northButton.length));
        //btPanel.setBounds(0, 150, 200, 200);
        
     

        // righ panel
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setLayout(null);
        
        matricularPage();
        
        masterPanel.add(BorderLayout.CENTER, rightPanel);
        
        //cont.add(masterPanel);
        //setVisible(true);
        
        setSize(1100, 620);
        setLayout(new BorderLayout());
        add(masterPanel);
        show();
        
    }
    
    public void matricularPage(){
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();
        

        Font br = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
        profDataPanel = new JPanel();
        profDataPanel.setBackground(Color.white);
        profDataPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true),
                "Dados da Classe",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                br,
                new Color(62, 62, 62)));
        profDataPanel.setBounds(370, 10, 420,450);
        profDataPanel.setLayout(null);
        
        inner1 =  new JPanel();
        inner1.setBackground(Color.white);
        inner1.setOpaque(false);
        inner1.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        inner1.setBounds(0, 0, 420, 140);
        BoxLayout encBox = new BoxLayout(inner1,BoxLayout.Y_AXIS);
        inner1.setLayout(encBox);
        
        
        inputs1 =  new JTextField[7];
        inputsPanel1 = new JPanel[7];
        st2 = true;
        
        for(int i=0; i<inputsPanel1.length; i++) {
            inputsPanel1[i] = new JPanel();
            inputsPanel1[i].setBackground(Color.white);
            inputsPanel1[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel1[i].setMaximumSize(new Dimension(450, 43));
            inputsPanel1[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
            inputsPanel1[i].setLayout(new GridLayout(1,1));
        }
        
        for(int i=0; i<inputs1.length; i++)
            inputs1[i] = new JTextField();
        
        for(int i=0; i<inputs1.length; i++)
            tfProperties(inputs1[i]);
        
        for(int i=0; i<inputs1.length; i++)
            inputs1[i].addMouseListener(this);
        
        inputs1[0].setText("ID");
        inputs1[1].setText("Classe");
        
        addProfessor = new JButton("Novo Classe");
        addProfessor.addActionListener(this);
        btProperties(addProfessor);
        addProfessor.setBounds(10, 140, 400, 43);
        //addEncarregado.setPreferredSize(new Dimension(205,43));
        //addEncarregado.setMaximumSize(new Dimension(420,43));
        //addEncarregado.set
        
        for(int i=0; i<inputs1.length; i++)
            inputsPanel1[i].add(inputs1[i]);
        
        inner1.add(Box.createRigidArea(new Dimension(0,15)));
        
        for(int i=0; i<2; i++){
            inner1.add(inputsPanel1[i]);
            inner1.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        //inner1.add(addEncarregado);
        profDataPanel.add(inner1);
        profDataPanel.add(addProfessor);
        
        registrar = new JButton("REGISTRAR");
        btProperties(registrar);
        registrar.setBounds(475, 473, 150, 43);

        rightPanel.add(registrar);
        rightPanel.add(profDataPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
        private void tfChanges(JTextField tfd) {
        tfd.setText("");
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
    
    private void btProperties(JButton button) {
        Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
        
        //button.setSize(200, 50);
        button.setPreferredSize(new Dimension(200,50));
        button.setMaximumSize(new Dimension(200,50));
        //button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        button.setFont(f2);
        button.setForeground(Color.white);
        button.setBackground(new Color(62, 62, 62));
        button.setFocusable(false);
    }
    
    
}
