package View.Create;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Encarregado extends JComponent implements ActionListener, MouseListener {
    
    private JPanel encDataPanel, inner1, inputsPanel1[], genderPanel1, opPanel1;
    private JLabel sexo1;
    public static JRadioButton male1, female1;
    private ButtonGroup genderGroup1;
    //private JButton addEncarregado;
    public static JTextField inputs1[];
    public static JComboBox estCivil1;
    
    public Encarregado(){
        inner1 =  new JPanel();
        inner1.setBackground(Color.white);
        inner1.setOpaque(false);
        inner1.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        inner1.setBounds(0, 0, 420, 402);
        BoxLayout encBox = new BoxLayout(inner1,BoxLayout.Y_AXIS);
        inner1.setLayout(encBox);
        
        
        inputs1 =  new JTextField[7];
        inputsPanel1 = new JPanel[7];
        
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
        inputs1[0].setEditable(false);
        inputs1[1].setText("Grau de Parentesco");
        inputs1[2].setText("Nome");
        inputs1[3].setText("Apelido");
        inputs1[4].setText("BI");
        inputs1[5].setText("Telefone 1");
        inputs1[6].setText("Telefone 2");

        genderPanel1 = new JPanel();
        genderPanel1.setPreferredSize(new Dimension(205, 43));
        genderPanel1.setMaximumSize(new Dimension(450, 43));
        genderPanel1.setOpaque(false);
        genderPanel1.setLayout(new GridLayout(2,1));

        Font s = new Font(Font.SANS_SERIF, Font.PLAIN, 15);

        sexo1 = new JLabel("Sexo:", JLabel.LEFT);
        sexo1.setFont(s);
        sexo1.setForeground(new Color(62, 62, 62));
        sexo1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        opPanel1 = new JPanel();
        opPanel1.setPreferredSize(new Dimension(205, 43));
        opPanel1.setMaximumSize(new Dimension(205, 43));
        opPanel1.setBackground(Color.black);
        opPanel1.setOpaque(false);
        BoxLayout opBox = new BoxLayout(opPanel1, BoxLayout.X_AXIS);
        opPanel1.setLayout(opBox);


        male1 = new JRadioButton("Masculino");
        male1.setFont(s);
        male1.setForeground(new Color(62, 62, 62));
        male1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        male1.setOpaque(false);

        female1 = new JRadioButton("Femenino");
        female1.setFont(s);
        female1.setForeground(new Color(62, 62, 62));
        female1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        female1.setOpaque(false);

        genderGroup1 = new ButtonGroup();
        genderGroup1.add(male1);
        genderGroup1.add(female1);

        opPanel1.add(male1);
        opPanel1.add(female1);

        genderPanel1.add(sexo1);
        genderPanel1.add(opPanel1);

        estCivil1 = new JComboBox();
        estCivil1.addItem("Estado Civil");
        estCivil1.addItem("Solteiro");
        estCivil1.addItem("Casado");
        estCivil1.addItem("Divorciado");
        estCivil1.addItem("Viuvo");
        estCivil1.setFont(s);
        estCivil1.setBackground(Color.white);
        estCivil1.setPreferredSize(new Dimension(205, 43));
        estCivil1.setMaximumSize(new Dimension(450, 43));
        estCivil1.setFocusable(false);

        for(int i=0; i<inputs1.length; i++)
            inputsPanel1[i].add(inputs1[i]);

        inner1.add(Box.createRigidArea(new Dimension(0,15)));

        for(int i=1; i<4; i++){
            inner1.add(inputsPanel1[i]);
            inner1.add(Box.createRigidArea(new Dimension(0,5)));
        }

        inner1.add(genderPanel1);
        inner1.add(Box.createRigidArea(new Dimension(0,5)));

        inner1.add(inputsPanel1[4]);
        inner1.add(Box.createRigidArea(new Dimension(0,5)));

        inner1.add(estCivil1);
        inner1.add(Box.createRigidArea(new Dimension(0,5)));

        for(int i=5; i<inputsPanel1.length; i++){
            inner1.add(inputsPanel1[i]);
            inner1.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        setSize(450, 402);
        setLayout(new BorderLayout());
        add(inner1);
        show();
    }
    
    private void addEnc() {
        /*inner1.removeAll();
        inner1.revalidate();
        inner1.repaint();

        

        addEncarregado.setBounds(10, 402, 400, 43);
        addEncarregado.setText("Voltar");*/
    }
    
    public void actionPerformed(ActionEvent e) {
        /*if(e.getSource() == addEncarregado) {
            if(addEncarregado.getText().equalsIgnoreCase("Novo Encarregado")) {
                addEnc();
            }else{
                if(addEncarregado.getText().equalsIgnoreCase("Voltar")) {
                    inner1.removeAll();
                    inner1.revalidate();
                    inner1.repaint();
                    
                    inner1.setBounds(0, 0, 420, 140);
                    
                    inputs1 =  new JTextField[7];
                    inputsPanel1 = new JPanel[7];                   
                    
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
                    inputs1[1].setText("Grau de Parentesco");
                    
                    for(int i=0; i<inputs1.length; i++)
                        inputsPanel1[i].add(inputs1[i]);
                    
                    inner1.add(Box.createRigidArea(new Dimension(0,15)));

                    for(int i=0; i<2; i++){
                        inner1.add(inputsPanel1[i]);
                        inner1.add(Box.createRigidArea(new Dimension(0,5)));
                    }
                    
                    addEncarregado.setBounds(10, 140, 400, 43);
                    addEncarregado.setText("Novo Encarregado");
                }
            }
        }*/
    }
    
    public void mouseClicked(MouseEvent e) {
        
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    public void mouseEntered(MouseEvent e) {
        
        if(e.getSource() == inputs1[0]) {
            if(inputs1[0].getText().equals("ID"))
                tfChanges(inputs1[0]);
        }
        
        if(e.getSource() == inputs1[1]) {
            if(inputs1[1].getText().equals("Grau de Parentesco"))
                tfChanges(inputs1[1]);
        }
        
        if(e.getSource() == inputs1[2]) {
            if(inputs1[2].getText().equals("Nome"))
                tfChanges(inputs1[2]);
        }
        
        if(e.getSource() == inputs1[3]) {
            if(inputs1[3].getText().equals("Apelido"))
                tfChanges(inputs1[3]);
        }
        
        if(e.getSource() == inputs1[4]) {
            if(inputs1[4].getText().equals("BI"))
                tfChanges(inputs1[4]);
        }
        
        if(e.getSource() == inputs1[5]) {
            if(inputs1[5].getText().equals("Telefone 1"))
                tfChanges(inputs1[5]);
        }
        
        if(e.getSource() == inputs1[6]) {
            if(inputs1[6].getText().equals("Telefone 2"))
                tfChanges(inputs1[6]);
        }
    }
    
    public void mouseExited(MouseEvent e) {
        
        if(e.getSource() == inputs1[0]) {
            if(inputs1[0].getText().equals("ID") || inputs1[0].getText().equals(""))
                inputs1[0].setText("ID");
        }
        
        if(e.getSource() == inputs1[1]) {
            if(inputs1[1].getText().equals("Grau de Parentesco") || inputs1[1].getText().equals(""))
                inputs1[1].setText("Grau de Parentesco");
        }
        
        if(e.getSource() == inputs1[2]) {
            if(inputs1[2].getText().equals("Nome") || inputs1[2].getText().equals(""))
                inputs1[2].setText("Nome");
        }
        
        if(e.getSource() == inputs1[3]) {
            if(inputs1[3].getText().equals("Apelido") || inputs1[3].getText().equals(""))
                inputs1[3].setText("Apelido");
        }
        
        if(e.getSource() == inputs1[4]) {
            if(inputs1[4].getText().equals("BI") || inputs1[4].getText().equals(""))
                inputs1[4].setText("BI");
        }
        
        if(e.getSource() == inputs1[5]) {
            if(inputs1[5].getText().equals("Telefone 1") || inputs1[5].getText().equals(""))
                inputs1[5].setText("Telefone 1");
        }
        
        if(e.getSource() == inputs1[6]) {
            if(inputs1[6].getText().equals("Telefone 2") || inputs1[6].getText().equals(""))
                inputs1[6].setText("Telefone 2");
        }
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
