package View.Visualizar;

import Controller.TurmaController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import View.Create.*;
import View.MainMenu;
import View.SubMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;

public class UpdateTurma extends JComponent implements ActionListener,MouseListener{
    private JButton btnVoltar,btnSalve;
    private JPanel inputsPanel1[] = new JPanel[5];
    private JTextField inputs[] =new JTextField[4];
    private JLabel txtLab;
    private JPanel panePrincipal, pane1,pane2,inner1;
    private JComboBox combo;
    Font s = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
    int i,confirm;
    boolean st = false;
    
    public UpdateTurma(int id,String nome,int max){
        panePrincipal = new JPanel();
        panePrincipal.setBackground(Color.white);
        panePrincipal.setLayout(null);
        panePrincipal.setBounds(0, 0, 1800, 1000);
        
        pane2 = new JPanel();
        pane2.setLayout(new BorderLayout());
        pane2.setBackground(Color.white);
        TitledBorder tb = BorderFactory.createTitledBorder("Adicionar Turma");
        tb.setTitleFont(s);
        pane2.setBorder(tb);
        //pane2.setBounds(200, 50, 300,550);
        
        Font br = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
        pane1 = new JPanel();
        pane1.setBackground(Color.white);
        pane1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true),
                "Actualizar Turma",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                br,
                new Color(62, 62, 62)));
        pane1.setBounds(370, 90, 420,450);
        pane1.setLayout(null);
        
        inner1 =  new JPanel();
        inner1.setBackground(Color.white);
        inner1.setOpaque(false);
        inner1.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        inner1.setBounds(0, 0, 420, 240);
        BoxLayout encBox = new BoxLayout(inner1,BoxLayout.Y_AXIS);
        inner1.setLayout(encBox);
        
        btnVoltar = new JButton("");
        btnVoltar.setBounds(1060, 12, 45, 45);
        DefinirBackImagem();
        btnVoltar.setBackground(Color.white);
        btnVoltar.setBorderPainted(false);
        btnVoltar.addActionListener(this);
        add(btnVoltar);
        
        for(int i=0; i<inputsPanel1.length; i++) {
            inputsPanel1[i] = new JPanel();
            inputsPanel1[i].setBackground(Color.white);
            inputsPanel1[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel1[i].setMaximumSize(new Dimension(450, 43));
            inputsPanel1[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
            inputsPanel1[i].setLayout(new GridLayout(1,1));
        }
        
        for(int i=0; i<inputs.length; i++)
            inputs[i] = new JTextField();
        
        for(int i=0; i<inputs.length; i++)
            tfProperties(inputs[i]);
        
        for(int i=0; i<inputs.length; i++)
            inputs[i].addMouseListener(this);
        
        for(int i=0; i<inputs.length; i++)
            inputsPanel1[i].add(inputs[i]);
        
        for(i=0;i<4;i++)
            pane2.add(inputsPanel1[i]);
        
        inputs[0].setText(Integer.toString(id));
        inputs[1].setText(nome);
        inputs[2].setText("Classe");
        inputs[3].setText(Integer.toString(max));
        
        btnSalve = new JButton("Actualiza Turma");
        btProperties(btnSalve);
        inputsPanel1[4].add(btnSalve);
        inputsPanel1[4].setBounds(10,400,430,45);
        pane1.add(inputsPanel1[3]);
        
        pane2.add(Box.createRigidArea(new Dimension(0,15)));
        
        for(int i=0; i<inputsPanel1.length; i++){
            inner1.add(inputsPanel1[i]);
            inner1.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        panePrincipal.add(pane1);
        pane1.add(inner1);
        panePrincipal.add(pane2);
        
        add(panePrincipal);
        show();
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
        
        if(e.getSource() == btnSalve){
            JOptionPane.showMessageDialog(null, "Actualizou com Sucesso!");
            showForm(new ViewTurma());
        }

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

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource() == inputs[0]) {
            if(inputs[0].getText().equals("ID") && st == false)
                tfChanges(inputs[0]);
            if(inputs[0].getText().equals("Nome") && st == true)
                tfChanges(inputs[0]);
        }
        
        if(me.getSource() == inputs[1]) {
            if(inputs[1].getText().equals("Nome") && st == false)
                tfChanges(inputs[1]);
            if(inputs[1].getText().equals("classe") && st == true)
                tfChanges(inputs[1]);
        }
        
        if(me.getSource() == inputs[2]) {
            if(inputs[2].getText().equals("Classe") && st == false)
                tfChanges(inputs[2]);
            if(inputs[2].getText().equals("Maximo de Alunos") && st == true)
                tfChanges(inputs[2]);
        }
        
        if(me.getSource() == inputs[3]) {
            if(inputs[3].getText().equals("Maximo de Alunos") && st == false)
                tfChanges(inputs[3]);
            
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource() == inputs[0]) {
            if(inputs[0].getText().equals("ID") || inputs[0].getText().equals("") && st == false)
                inputs[0].setText("ID");
            if(inputs[0].getText().equals("Nome") || inputs[0].getText().equals("") && st == true)
                inputs[0].setText("Nome");
        }
        
        if(me.getSource() == inputs[1]) {
            if(inputs[1].getText().equals("Nome") || inputs[1].getText().equals("") && st == false)
                inputs[1].setText("Nome");
            if(inputs[1].getText().equals("Classe") || inputs[1].getText().equals("") && st == true)
                inputs[1].setText("Classe");
        }
        
        if(me.getSource() == inputs[2]) {
            if(inputs[2].getText().equals("Classe") || inputs[2].getText().equals("") && st == false)
                inputs[2].setText("Classe");
            if(inputs[2].getText().equals("Maximo de Alunos") || inputs[2].getText().equals("") && st == true)
                inputs[2].setText("Maximo de Alunos");
        }
        
        if(me.getSource() == inputs[3]) {
            if(inputs[3].getText().equals("Maximo de Alunos") || inputs[3].getText().equals("") && st == false)
                inputs[3].setText("Maximo de Alunos");
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
