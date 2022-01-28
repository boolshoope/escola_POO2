package View.Create;

import Controller.MatriculaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class editAluno extends JComponent implements ActionListener, MouseListener {
    private String path = System.getProperty("user.dir") + "/src/View/img/";
    
    private JPanel rightPanel;
    
    public static JButton btSearch;
    public static JPanel searchPanel;
    public static JTextField search;
    
    public static ButtonGroup genderGroup;
    public static JLabel sexo;
    public static JRadioButton male, female;
    public static JButton matricular;
    public static JTextField inputs[];
    public static JPanel alDataPanel, inner, inputsPanel[], genderPanel, opPanel;
    public static JComboBox estCivil;
    public static JComboBox classe;
    
    public static JButton update;
    
    public editAluno() {
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setLayout(null);
        
        searchPanel = new JPanel();
        BoxLayout searchBox = new BoxLayout(searchPanel, BoxLayout.X_AXIS);
        searchPanel.setLayout(searchBox);
        searchPanel.setBounds(428, 245, 243, 43);
        searchPanel.setBackground(Color.white);
        searchPanel.setBorder(BorderFactory.createLineBorder(new Color(62, 62, 62), 
                                1, true));
        
        search = new JTextField("pesquisar");
        search.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
        Font f3 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
        search.setFont(f3);
        search.setBackground(Color.white);
        search.setPreferredSize(new Dimension(200,43));
        search.setMaximumSize(new Dimension(200,43));
        
        btSearch = new JButton("");
        btSearch.setPreferredSize(new Dimension(44,43));
        btSearch.setMaximumSize(new Dimension(44,43));
        btSearch.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btSearch.setForeground(Color.white);
        btSearch.setBackground(new Color(62, 62, 62));
        btSearch.setFocusable(false);
        btSearch.addActionListener(this);
        btSearch.setIcon(new ImageIcon(path+"iconsSearch.png"));
        
        // add search ao painel
        searchPanel.add(search);
        searchPanel.add(btSearch);
        
        
        rightPanel.add(searchPanel);
        
        setSize(1100, 570);
        setLayout(new BorderLayout());
        add(rightPanel);
        show();
    }
    
    public void editAlunoPage() {
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();
        
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
        alDataPanel.setBounds(325, 10, 450,510);
        alDataPanel.setLayout(null);
        
        inner =  new JPanel();
        inner.setBackground(Color.white);
        inner.setOpaque(false);
        inner.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        inner.setBounds(0, 0, 450, 510);
        BoxLayout alBox = new BoxLayout(inner,BoxLayout.Y_AXIS);
        inner.setLayout(alBox);
        
        inputs =  new JTextField[8];
        inputsPanel = new JPanel[8];
        
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
        
        inputs[0].setText("Numero de Estudante");
        inputs[1].setText("Nome");
        inputs[2].setText("Apelido");
        inputs[3].setText("BI");
        inputs[4].setText("Data de Nascimento");
        inputs[5].setText("Telefone 1");
        inputs[6].setText("Telefone 2");
        inputs[7].setText("Nome do Encarregado");
        
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
        
        for(int i=0; i<inputs.length; i++)
            inputsPanel[i].add(inputs[i]);
        
        for(int i=0; i<3; i++){
            inner.add(inputsPanel[i]);
            inner.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        inner.add(genderPanel);
        inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        inner.add(inputsPanel[3]);
        inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        inner.add(estCivil);
        inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        for(int i=4; i<inputsPanel.length; i++){
            inner.add(inputsPanel[i]);
            inner.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        inner.add(classe);
        inner.add(Box.createRigidArea(new Dimension(0,5)));
        
        alDataPanel.add(inner);
        
        update = new JButton("ACTUALIZAR");
        btProperties(update);
        update.setBounds(785, 467, 200, 43);
        
        rightPanel.add(alDataPanel);
        rightPanel.add(update);
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
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btSearch) {
            editAlunoPage();
            MatriculaController.editAluno();
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    public void mouseEntered(MouseEvent e) {
        
        // -----------------------------------------------------------------------
        
        if(e.getSource() == inputs[0]) {
            if(inputs[0].getText().equals("Numero de Estudante"))
                tfChanges(inputs[0]);
        }
        
        if(e.getSource() == inputs[1]) {
            if(inputs[1].getText().equals("Nome"))
                tfChanges(inputs[1]);
        }
        
        if(e.getSource() == inputs[2]) {
            if(inputs[2].getText().equals("Apelido"))
                tfChanges(inputs[2]);
        }
        
        if(e.getSource() == inputs[3]) {
            if(inputs[3].getText().equals("BI"))
                tfChanges(inputs[3]);
        }
        
        if(e.getSource() == inputs[4]) {
            if(inputs[4].getText().equals("Data de Nascimento"))
                tfChanges(inputs[4]);
        }
        
        if(e.getSource() == inputs[5]) {
            if(inputs[5].getText().equals("Telefone 1"))
                tfChanges(inputs[5]);
        }
        
        if(e.getSource() == inputs[6]) {
            if(inputs[6].getText().equals("Telefone 2"))
                tfChanges(inputs[6]);
        }
        
        if(e.getSource() == inputs[7]) {
            if(inputs[7].getText().equals("Nome do Encarregado"))
                tfChanges(inputs[7]);
        }
    }
    
    public void mouseExited(MouseEvent e) {
        
        // -----------------------------------------------------------------------
        
        if(e.getSource() == inputs[0]) {
            if(inputs[0].getText().equals("Numero de Estudante") || inputs[0].getText().equals(""))
                inputs[0].setText("Numero de Estudante");
        }
        
        if(e.getSource() == inputs[1]) {
            if(inputs[1].getText().equals("Nome") || inputs[1].getText().equals(""))
                inputs[1].setText("Nome");
        }
        
        if(e.getSource() == inputs[2]) {
            if(inputs[2].getText().equals("Apelido") || inputs[2].getText().equals(""))
                inputs[2].setText("Apelido");
        }
        
        if(e.getSource() == inputs[3]) {
            if(inputs[3].getText().equals("BI") || inputs[3].getText().equals(""))
                inputs[3].setText("BI");
        }
        
        if(e.getSource() == inputs[4]) {
            if(inputs[4].getText().equals("Data de Nascimento") || inputs[4].getText().equals(""))
                inputs[4].setText("Data de Nascimento");
        }
        
        if(e.getSource() == inputs[5]) {
            if(inputs[5].getText().equals("Telefone 1") || inputs[5].getText().equals(""))
                inputs[5].setText("Telefone 1");
        }
        
        if(e.getSource() == inputs[6]) {
            if(inputs[6].getText().equals("Telefone 2") || inputs[6].getText().equals(""))
                inputs[6].setText("Telefone 2");
        }
        
        if(e.getSource() == inputs[7]) {
            if(inputs[7].getText().equals("Nome do Encarregado") || inputs[7].getText().equals(""))
                inputs[7].setText("Nome do Encarregado");
        }
    }
    
    private void tfChanges(JTextField tfd) {
        tfd.setText("");
    }
}
