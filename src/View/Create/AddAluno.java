package View.Create;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import Controller.MatriculaController;
import java.text.ParseException;

public class AddAluno extends JComponent implements ActionListener, MouseListener {
    private String path = System.getProperty("user.dir") + "/src/View/img/";
    
    private JPanel rightPanel;
    
    private ButtonGroup genderGroup;
    public static JLabel sexo;
    public static JRadioButton male, female;
    public static JButton matricular;
    public static JTextField inputs[];
    private static JPanel alDataPanel, inner, inputsPanel[], genderPanel, opPanel;
    public static JComboBox estCivil;
    public static JComboBox classe;
    public static JComboBox anoAcademico;
    
    private static JPanel encDataPanel, inner1, inputsPanel1[], genderPanel1, opPanel1;
    public static JButton addEncarregado;
    public static JTextField inputs1[];
    
    private static JPanel encPainel;
    
    public AddAluno() {
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setLayout(null);
        
        addAluno();
        
        Font br = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
        encDataPanel = new JPanel();
        encDataPanel.setBackground(Color.white);
        encDataPanel.setBorder(BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true),
                        "Dados do Encarregado", 
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        br,
                        new Color(62, 62, 62)));
        encDataPanel.setBounds(570, 10, 420,450);
        encDataPanel.setLayout(null);
        
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
        
        inputs1[0].setText("ID");
        inputs1[1].setText("Grau de Parentesco");
        inputs1[1].setEditable(false);
        
        addEncarregado = new JButton("Novo Encarregado");
        addEncarregado.addActionListener(this);
        btProperties(addEncarregado);
        addEncarregado.setBounds(10, 140, 400, 43);
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
        
        encPainel = new JPanel();
        encPainel.setBackground(Color.white);
        encPainel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        encPainel.setBounds(0,0,420, 140);
        encPainel.setLayout(new BorderLayout());
        encPainel.setOpaque(false);
        
        encPainel.add(inner1);
        
        //inner1.add(addEncarregado);
        encDataPanel.add(encPainel);
        encDataPanel.add(addEncarregado);
        
        matricular = new JButton("MATRICULAR");
        matricular.addActionListener(this);
        btProperties(matricular);
        matricular.setBounds(475, 473, 150, 43);
        
        rightPanel.add(alDataPanel);
        rightPanel.add(matricular);
        rightPanel.add(encDataPanel);
        
        setSize(1100, 570);
        setLayout(new BorderLayout());
        add(rightPanel);
        show();
    }
    
    private void addAluno() {
        Font br = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
        alDataPanel = new JPanel();
        alDataPanel.setBackground(Color.white);
        alDataPanel.setBorder(BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(62, 62, 62), 1, true),
                        "Dados do Aluno", 
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        br,
                        new Color(62, 62, 62)));
        alDataPanel.setBounds(110, 10, 450,450);
        alDataPanel.setLayout(null);
        
        inner =  new JPanel();
        inner.setBackground(Color.white);
        inner.setOpaque(false);
        inner.setBorder(BorderFactory.createEmptyBorder(13, 10, 10, 10));
        inner.setBounds(0, 0, 450, 450);
        BoxLayout alBox = new BoxLayout(inner,BoxLayout.Y_AXIS);
        inner.setLayout(alBox);
        
        inputs =  new JTextField[6];
        inputsPanel = new JPanel[6];
        
        for(int i=0; i<inputsPanel.length; i++) {
            inputsPanel[i] = new JPanel();
            inputsPanel[i].setBackground(Color.white);
            inputsPanel[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel[i].setMaximumSize(new Dimension(450, 43));
            inputsPanel[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
            inputsPanel[i].setLayout(new GridLayout(1,1));
        }
        
        for(int i=0; i<inputs.length; i++)
            inputs[i] = new JTextField();
        
        for(int i=0; i<inputs.length; i++)
            tfProperties(inputs[i]);
        
        for(int i=0; i<inputs.length; i++) {
            inputs[i].addMouseListener(this);
        }
        
        inputs[0].setText("Nome");
        inputs[1].setText("Apelido");
        inputs[2].setText("BI");
        inputs[3].setText("Data de Nascimento");
        inputs[4].setText("Telefone 1");
        inputs[5].setText("Telefone 2");
        
        genderPanel = new JPanel();
        genderPanel.setPreferredSize(new Dimension(205, 43));
        genderPanel.setMaximumSize(new Dimension(450, 43));
        genderPanel.setOpaque(false);
        genderPanel.setLayout(new GridLayout(2,1));
        
        Font s = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
        
        sexo = new JLabel("Sexo:", JLabel.LEFT);
        sexo.setFont(s);
        sexo.setForeground(new Color(62, 62, 62));
        sexo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        opPanel = new JPanel();
        opPanel.setPreferredSize(new Dimension(205, 43));
        opPanel.setMaximumSize(new Dimension(205, 43));
        opPanel.setBackground(Color.black);
        opPanel.setOpaque(false);
        BoxLayout opBox = new BoxLayout(opPanel, BoxLayout.X_AXIS);
        opPanel.setLayout(opBox);
        
        
        male = new JRadioButton("Masculino");
        male.setFont(s);
        male.setForeground(new Color(62, 62, 62));
        male.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        male.setOpaque(false);
        
        female = new JRadioButton("Femenino");
        female.setFont(s);
        female.setForeground(new Color(62, 62, 62));
        female.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        female.setOpaque(false);
        
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        opPanel.add(male);
        opPanel.add(female);
        
        genderPanel.add(sexo);
        genderPanel.add(opPanel);
        
        estCivil = new JComboBox();
        estCivil.addItem("Estado Civil");
        estCivil.addItem("Solteiro");
        estCivil.addItem("Casado");
        estCivil.addItem("Divorciado");
        estCivil.addItem("Viuvo");
        estCivil.setFont(s);
        estCivil.setBackground(Color.white);
        estCivil.setPreferredSize(new Dimension(205, 43));
        estCivil.setMaximumSize(new Dimension(450, 43));
        estCivil.setFocusable(false);
        
        classe = new JComboBox();
        classe.setBackground(Color.white);
        classe.setPreferredSize(new Dimension(205, 43));
        classe.setMaximumSize(new Dimension(450, 43));
        classe.setFocusable(false);
        classe.setFont(s);
        
        classe.addItem("Classe");
        MatriculaController.loadClasse();
        
        anoAcademico = new JComboBox();
        anoAcademico.setBackground(Color.white);
        anoAcademico.setPreferredSize(new Dimension(205, 43));
        anoAcademico.setMaximumSize(new Dimension(450, 43));
        anoAcademico.setFocusable(false);
        anoAcademico.setFont(s);
        
        anoAcademico.addItem("Ano Academico");
        MatriculaController.loadAnoAcademico();
        
        for(int i=0; i<inputs.length; i++)
            inputsPanel[i].add(inputs[i]);
        
        //inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        for(int i=0; i<2; i++){
            inner.add(inputsPanel[i]);
            inner.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        inner.add(genderPanel);
        inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        inner.add(inputsPanel[2]);
        inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        inner.add(estCivil);
        inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        for(int i=3; i<inputsPanel.length; i++){
            inner.add(inputsPanel[i]);
            inner.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        inner.add(classe);
        inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        inner.add(anoAcademico);
        
        alDataPanel.add(inner);
    }
    
    public static void showForm(Component com) {
        BorderLayout layout = (BorderLayout) encPainel.getLayout();
        if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
            encPainel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        }

        encPainel.add(com, BorderLayout.CENTER);
        encPainel.repaint();
        encPainel.revalidate();
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == matricular) {
            try {
                MatriculaController.matricular();
            } catch(ParseException p) {
                System.out.println(p.getMessage());
            }
        }
        
        if(e.getSource() == addEncarregado) {
            if(addEncarregado.getText().equalsIgnoreCase("Novo Encarregado")) {
                encPainel.setBounds(0,0,420, 402);
                addEncarregado.setBounds(10, 402, 400, 43);
                addEncarregado.setText("INSERIR");
                showForm(new Encarregado());
            }else{
                if(addEncarregado.getText().equalsIgnoreCase("INSERIR")) {
                    BorderLayout layout = (BorderLayout) encPainel.getLayout();
                    if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
                        encPainel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                    }
                    
                    //encPainel.add(inner1);
                    encPainel.repaint();
                    encPainel.revalidate();
                    
                    encPainel.setBounds(0,0,420, 140);
                    inner1.setBounds(0, 0, 420, 140);
                    
                    encPainel.add(inner1);
                    
                    addEncarregado.setBounds(10, 140, 400, 43);
                    addEncarregado.setText("Novo Encarregado");
                    
                    MatriculaController.addEnc();
                }
            }
        }
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
        
        // -----------------------------------------------------------------------
        
        if(e.getSource() == inputs[0]) {
            if(inputs[0].getText().equals("Nome"))
                tfChanges(inputs[0]);
        }
        
        if(e.getSource() == inputs[1]) {
            if(inputs[1].getText().equals("Apelido"))
                tfChanges(inputs[1]);
        }
        
        if(e.getSource() == inputs[2]) {
            if(inputs[2].getText().equals("BI"))
                tfChanges(inputs[2]);
        }
        
        if(e.getSource() == inputs[3]) {
            if(inputs[3].getText().equals("Data de Nascimento"))
                tfChanges(inputs[3]);
        }
        
        if(e.getSource() == inputs[4]) {
            if(inputs[4].getText().equals("Telefone 1"))
                tfChanges(inputs[4]);
        }
        
        if(e.getSource() == inputs[5]) {
            if(inputs[5].getText().equals("Telefone 2"))
                tfChanges(inputs[5]);
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
        
        // -----------------------------------------------------------------------
        
        if(e.getSource() == inputs[0]) {
            if(inputs[0].getText().equals("Nome") || inputs[0].getText().equals(""))
                inputs[0].setText("Nome");
        }
        
        if(e.getSource() == inputs[1]) {
            if(inputs[1].getText().equals("Apelido") || inputs[1].getText().equals(""))
                inputs[1].setText("Apelido");
        }
        
        if(e.getSource() == inputs[2]) {
            if(inputs[2].getText().equals("BI") || inputs[2].getText().equals(""))
                inputs[2].setText("BI");
        }
        
        if(e.getSource() == inputs[3]) {
            if(inputs[3].getText().equals("Data de Nascimento") || inputs[3].getText().equals(""))
                inputs[3].setText("Data de Nascimento");
        }
        
        if(e.getSource() == inputs[4]) {
            if(inputs[4].getText().equals("Telefone 1") || inputs[4].getText().equals(""))
                inputs[4].setText("Telefone 1");
        }
        
        if(e.getSource() == inputs[5]) {
            if(inputs[5].getText().equals("Telefone 2") || inputs[5].getText().equals(""))
                inputs[5].setText("Telefone 2");
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
