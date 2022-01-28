/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package View.Visualizar;

import Model.DataAccessObject.DisciplinaDAO;
import Model.ValueObject.Disciplina;
import View.Create.*;
import View.MainMenu;
import View.SubMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;



/**
 *
 * @author Gabriel
 */
public class AddDisciplina extends JComponent implements ActionListener, MouseListener {
    
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
    
    
    private JTextField inputs[];
    private JPanel alDataPanel, inner, inputsPanel[], genderPanel, opPanel;
    
    
    
    private JPanel classDataPanel, inner1, inputsPanel1[], genderPanel1, opPanel1;
    private JLabel sexo1;
    private JRadioButton male1, female1;
    private ButtonGroup genderGroup1;
    private JButton addDisciplina, btnVoltar;
    private JTextField inputs1[];
    
    private JButton renovarSearch;
    
    private JButton update;
        

    
    public AddDisciplina() {
        
        
        masterPanel = new JPanel();
        headerPanel = new JPanel();
        leftPanel = new JPanel();

        
        // painel principal
        masterPanel.setBackground(Color.white);
        masterPanel.setBounds(0, 0, getWidth(), getHeight());
        masterPanel.setBorder(null);
        masterPanel.setLayout(new BorderLayout());
        
        
        // painel esquerdo componentes
        btPanel = new JPanel();
        //BoxLayout btLayout = new BoxLayout(btPanel,BoxLayout.Y_AXIS);
        btPanel.setBackground(null);
        //btPanel.setBounds(0, 150, 200, 200);
        
     
        btnVoltar = new JButton("");
        btnVoltar.setBounds(1060, 12, 45, 45);
        DefinirBackImagem();
        btnVoltar.setBackground(Color.white);
        btnVoltar.setBorderPainted(false);
        btnVoltar.addActionListener(this);
        add(btnVoltar);

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
        classDataPanel = new JPanel();
        classDataPanel.setBackground(Color.white);
        classDataPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true),
                "Dados da Classe",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                br,
                new Color(62, 62, 62)));
        classDataPanel.setBounds(370, 90, 420,450);
        classDataPanel.setLayout(null);
        
        inner1 =  new JPanel();
        inner1.setBackground(Color.white);
        inner1.setOpaque(false);
        inner1.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        inner1.setBounds(0, 0, 420, 140);
        BoxLayout encBox = new BoxLayout(inner1,BoxLayout.Y_AXIS);
        inner1.setLayout(encBox);
        
        
        inputs1 =  new JTextField[2];
        inputsPanel1 = new JPanel[2];
       
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
        
        
        ViewClasse viewclasse = new ViewClasse();
        
        
        inputs1[0].setText("ID");
        inputs1[1].setText("Nome");
        
        addDisciplina = new JButton("Nova Disciplina");
        addDisciplina.addActionListener(this);
        btProperties(addDisciplina);
        addDisciplina.setBounds(10, 140, 400, 43);
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
        classDataPanel.add(inner1);
        classDataPanel.add(addDisciplina);
        

        rightPanel.add(classDataPanel);
    }
    
    
     private void DefinirBackImagem() {
        BufferedImage imgb = null;
        try {
            imgb = ImageIO.read(new File(System.getProperty("user.dir") + "/src/View/img/back_to_24px.png"));
        } catch (IOException e) {
        }
        Image dimg = imgb.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnVoltar.setIcon(new ImageIcon(dimg));
    }
     
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            showForm(new ViewDisciplina());
        }
        
        if (e.getSource() == addDisciplina){
            DisciplinaDAO dDAO = new DisciplinaDAO();
            
            if(inputs1[1].getText().equalsIgnoreCase("Nome") || inputs1[1].getText().equalsIgnoreCase("") ||
                    inputs1[0].getText().equalsIgnoreCase("ID") || inputs1[0].getText().equalsIgnoreCase("")
                   ){
                JOptionPane.showMessageDialog(null, "Verifique se inseriu os dados corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }else{
                Disciplina disciplina = new Disciplina(Integer.parseInt(inputs1[0].getText()), inputs1[1].getText());
                try {
                    dDAO.adicionaDisciplina(disciplina);
          
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    //Logger.getLogger(AddClasse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
         if(e.getSource() == inputs1[0]) {
            if(inputs1[0].getText().equals("ID"))
                inputs1[0].setText("");
        }
        
        if(e.getSource() == inputs1[1]) {
            if(inputs1[1].getText().equals("Nome"))
                inputs1[1].setText("");
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == inputs1[0]) {
            if(inputs1[0].getText().equals("ID") || inputs1[0].getText().equals("") )
                inputs1[0].setText("ID");
        }
        
        if(e.getSource() == inputs1[1]) {
            if(inputs1[1].getText().equals("Nome") || inputs1[1].getText().equals(""))
                inputs1[1].setText("Nome");
        }
        
        
        // -----------------------------------------------------------------------
        

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
