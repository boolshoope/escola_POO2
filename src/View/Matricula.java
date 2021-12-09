package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Matricula extends JFrame implements ActionListener {
    private JPanel masterPanel;
    private JPanel headerPanel;
    private JPanel leftPanel;
    private JLabel headerLabel, usr, img;
    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    
    private JButton leftButton[], btSearch;
    private JPanel btPanel, searchPanel;
    private JTextField search;
    
    private JPanel rightPanel;
    
    private ButtonGroup genderGroup;
    private JLabel sexo;
    private JRadioButton male, female;
    private JButton matricular;
    private JTextField inputs[];
    private JPanel alDataPanel, inner, inputsPanel[], genderPanel, opPanel;
    private JComboBox estCivil;
    
    private JPanel encDataPanel, inner1, inputsPanel1[], genderPanel1, opPanel1;
    private JLabel sexo1;
    private JRadioButton male1, female1;
    private ButtonGroup genderGroup1;
    private JButton addEncarregado;
    private JTextField inputs1[];
    private JComboBox estCivil1;
    
    private JButton renovarSearch;
    
    private JButton update;
    
    private String path = System.getProperty("user.dir") + "/src/View/img/";;
    
    public Matricula() {
        super("Matricula do Aluno");
        setBounds(200,200,1100,620);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container cont = getContentPane();
        cont.setLayout(null);
        
        masterPanel = new JPanel();
        headerPanel = new JPanel();
        leftPanel = new JPanel();
        leftButton = new JButton[4];
        
        // header label 1
        img = new JLabel("");
        
        // header label 2
        headerLabel = new JLabel("MATRICULAR ALUNO", JLabel.CENTER);
        headerLabel.setFont(f1);
        headerLabel.setForeground(Color.white);
        
        // header label 3
        usr = new JLabel("USERNAME", JLabel.RIGHT);
        usr.setFont(f1);
        usr.setForeground(Color.white);
        usr.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        
        // painel principal
        masterPanel.setBackground(Color.white);
        masterPanel.setBounds(0, 0, getWidth(), getHeight());
        masterPanel.setBorder(null);
        masterPanel.setLayout(null);
        
        // header panel
        headerPanel.setBackground(new Color(62, 62, 62));
        headerPanel.setBounds(0, 0, getWidth(), 50);
        headerPanel.setBorder(null);
        headerPanel.setLayout(new GridLayout(1,3));
        
        // painel esquerdo
        leftPanel.setBackground(new Color(148, 148, 148));
        leftPanel.setBounds(0, 50, 200, 534);
        leftPanel.setBorder(null);
        leftPanel.setLayout(null);
        
        
        // painel esquerdo componentes
        btPanel = new JPanel();
        BoxLayout btLayout = new BoxLayout(btPanel,BoxLayout.Y_AXIS);
        btPanel.setBackground(null);
        btPanel.setLayout(btLayout);
        btPanel.setBounds(0, 150, 200, 200);
        
        
        leftButton[0] = new JButton("MATRICULAR");
        leftButton[1] = new JButton("RENOVAR");
        leftButton[2] = new JButton("EDITAR ALUNO");
        leftButton[3] = new JButton("VOLTAR");
       
        
        for(int i=0; i<leftButton.length; i++)
              leftButton[i].addActionListener(this);
        
        
        for(int i=0; i<leftButton.length; i++)
            btProperties(leftButton[i]);
        
        // add botoes ao painel
        for(int i=0; i<leftButton.length; i++)
            btPanel.add(leftButton[i]);
        
        // add componentes ao left panel
        leftPanel.add(btPanel);
        
        // righ panel
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setLayout(null);
        rightPanel.setBounds(200, 50, getWidth()-200, 534);
        
        matricularPage();
        
        // add componentes ao header panel
        headerPanel.add(img);
        headerPanel.add(headerLabel);
        headerPanel.add(usr);
        
        // add componentes ao painel principal
        masterPanel.add(headerPanel);
        masterPanel.add(leftPanel);
        masterPanel.add(rightPanel);
        
        cont.add(masterPanel);
        setVisible(true);
    }
    
    private void renovarPageHome() {
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();
        
        headerLabel.setText("RENOVAR MATRICULA");
        
        searchPanel = new JPanel();
        BoxLayout searchBox = new BoxLayout(searchPanel, BoxLayout.X_AXIS);
        searchPanel.setLayout(searchBox);
        searchPanel.setBounds(328, 245, 243, 43);
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
        
        renovarSearch = new JButton("");
        renovarSearch.setPreferredSize(new Dimension(44,43));
        renovarSearch.setMaximumSize(new Dimension(44,43));
        renovarSearch.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        renovarSearch.setForeground(Color.white);
        renovarSearch.setBackground(new Color(62, 62, 62));
        renovarSearch.setFocusable(false);
        renovarSearch.addActionListener(this);
        renovarSearch.setIcon(new ImageIcon(path + "iconsSearch.png"));
        
        // add search ao painel
        searchPanel.add(search);
        searchPanel.add(renovarSearch);
        
        rightPanel.add(searchPanel);
    }
    
    private void editAlunoPageHome() {
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();
        
        headerLabel.setText("EDITAR DADOS");
        
        searchPanel = new JPanel();
        BoxLayout searchBox = new BoxLayout(searchPanel, BoxLayout.X_AXIS);
        searchPanel.setLayout(searchBox);
        searchPanel.setBounds(328, 245, 243, 43);
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
        btSearch.setIcon(new ImageIcon(path + "iconsSearch.png"));
        
        // add search ao painel
        searchPanel.add(search);
        searchPanel.add(btSearch);
        
        rightPanel.add(searchPanel);
    }
    
    private void editAlunoPage() {
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
        alDataPanel.setBounds(225, 10, 450,510);
        alDataPanel.setLayout(null);
        
        inner =  new JPanel();
        inner.setBackground(Color.white);
        inner.setOpaque(false);
        inner.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        inner.setBounds(0, 0, 450, 510);
        BoxLayout alBox = new BoxLayout(inner,BoxLayout.Y_AXIS);
        inner.setLayout(alBox);
        
        inputs =  new JTextField[8];
        inputsPanel = new JPanel[8];
        
        for(int i=0; i<inputsPanel.length; i++) {
            inputsPanel[i] = new JPanel();
            inputsPanel[i].setBackground(Color.white);
            inputsPanel[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel[i].setMaximumSize(new Dimension(205, 43));
            inputsPanel[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
        }
        
        for(int i=0; i<inputs.length; i++)
            inputs[i] = new JTextField();
        
        for(int i=0; i<inputs.length; i++)
            tfProperties(inputs[i]);
        
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
        genderPanel.setMaximumSize(new Dimension(205, 43));
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
        estCivil.setMaximumSize(new Dimension(205, 43));
        estCivil.setFocusable(false);
        
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
        
        alDataPanel.add(inner);
        
        update = new JButton("ACTUALIZAR");
        btProperties(update);
        update.setBounds(685, 467, 200, 43);
        
        rightPanel.add(alDataPanel);
        rightPanel.add(update);
    }
    
    private void matricularPage() {
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();
        
        headerLabel.setText("MATRICULAR ALUNO");
        
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
        encDataPanel.setBounds(470, 10, 420,450);
        encDataPanel.setLayout(null);
        
        inner1 =  new JPanel();
        inner1.setBackground(Color.white);
        inner1.setOpaque(false);
        inner1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        inner1.setBounds(0, 0, 450, 400);
        BoxLayout encBox = new BoxLayout(inner1,BoxLayout.Y_AXIS);
        inner1.setLayout(encBox);
        
        
        inputs1 =  new JTextField[2];
        inputsPanel1 = new JPanel[2];
        
        for(int i=0; i<inputsPanel1.length; i++) {
            inputsPanel1[i] = new JPanel();
            inputsPanel1[i].setBackground(Color.white);
            inputsPanel1[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel1[i].setMaximumSize(new Dimension(205, 43));
            inputsPanel1[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
        }
        
        for(int i=0; i<inputs1.length; i++)
            inputs1[i] = new JTextField();
        
        for(int i=0; i<inputs1.length; i++)
            tfProperties(inputs1[i]);
        
        inputs1[0].setText("ID");
        inputs1[1].setText("Grau de Parentesco");
        
        addEncarregado = new JButton("Novo Encarregado");
        addEncarregado.addActionListener(this);
        btProperties(addEncarregado);
        addEncarregado.setBounds(123, 403, 205, 40);
        
        for(int i=0; i<inputs1.length; i++)
            inputsPanel1[i].add(inputs1[i]);
        
        inner1.add(Box.createRigidArea(new Dimension(0,15)));
        
        for(int i=0; i<2; i++){
            inner1.add(inputsPanel1[i]);
            inner1.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        encDataPanel.add(addEncarregado);
        encDataPanel.add(inner1);
        
        matricular = new JButton("MATRICULAR");
        btProperties(matricular);
        matricular.setBounds(375, 473, 150, 43);
        
        rightPanel.add(alDataPanel);
        rightPanel.add(matricular);
        rightPanel.add(encDataPanel);
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
        alDataPanel.setBounds(10, 10, 450,450);
        alDataPanel.setLayout(null);
        
        inner =  new JPanel();
        inner.setBackground(Color.white);
        inner.setOpaque(false);
        inner.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        inner.setBounds(0, 0, 450, 450);
        BoxLayout alBox = new BoxLayout(inner,BoxLayout.Y_AXIS);
        inner.setLayout(alBox);
        
        inputs =  new JTextField[6];
        inputsPanel = new JPanel[6];
        
        for(int i=0; i<inputsPanel.length; i++) {
            inputsPanel[i] = new JPanel();
            inputsPanel[i].setBackground(Color.white);
            inputsPanel[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel[i].setMaximumSize(new Dimension(205, 43));
            inputsPanel[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
        }
        
        for(int i=0; i<inputs.length; i++)
            inputs[i] = new JTextField();
        
        for(int i=0; i<inputs.length; i++)
            tfProperties(inputs[i]);
        
        inputs[0].setText("Nome");
        inputs[1].setText("Apelido");
        inputs[2].setText("BI");
        inputs[3].setText("Data de Nascimento");
        inputs[4].setText("Telefone 1");
        inputs[5].setText("Telefone 2");
        
        genderPanel = new JPanel();
        genderPanel.setPreferredSize(new Dimension(205, 43));
        genderPanel.setMaximumSize(new Dimension(205, 43));
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
        estCivil.setMaximumSize(new Dimension(205, 43));
        estCivil.setFocusable(false);
        
        for(int i=0; i<inputs.length; i++)
            inputsPanel[i].add(inputs[i]);
        
        inner.add(Box.createRigidArea(new Dimension(0,15)));
        
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
        
        alDataPanel.add(inner);
    }
    
    private void addEnc() {
        inner1.removeAll();
        inner1.revalidate();
        inner1.repaint();

        inputs1 =  new JTextField[7];
        inputsPanel1 = new JPanel[7];

        for(int i=0; i<inputsPanel1.length; i++) {
            inputsPanel1[i] = new JPanel();
            inputsPanel1[i].setBackground(Color.white);
            inputsPanel1[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel1[i].setMaximumSize(new Dimension(205, 43));
            inputsPanel1[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
        }

        for(int i=0; i<inputs1.length; i++)
            inputs1[i] = new JTextField();

        for(int i=0; i<inputs1.length; i++)
            tfProperties(inputs1[i]);

        inputs1[0].setText("ID");
        inputs1[1].setText("Grau de Parentesco");
        inputs1[2].setText("Nome");
        inputs1[3].setText("Apelido");
        inputs1[4].setText("BI");
        inputs1[5].setText("Telefone 1");
        inputs1[6].setText("Telefone 2");

        genderPanel1 = new JPanel();
        genderPanel1.setPreferredSize(new Dimension(205, 43));
        genderPanel1.setMaximumSize(new Dimension(205, 43));
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
        genderGroup1.add(male);
        genderGroup1.add(female);

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
        estCivil1.setMaximumSize(new Dimension(205, 43));
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

        addEncarregado.setText("Voltar");
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftButton[0])
            matricularPage();
        
        if(e.getSource() == leftButton[1])
            renovarPageHome();
        
        if(e.getSource() == leftButton[2])
            editAlunoPageHome();
        
        /*if(e.getSource() == leftButton[3])
        */    
        
        if(e.getSource() == btSearch)
            editAlunoPage();
        
        if(e.getSource() == addEncarregado) {
            if(addEncarregado.getText().equalsIgnoreCase("Novo Encarregado")) {
                addEnc();
            }else{
                if(addEncarregado.getText().equalsIgnoreCase("Voltar")) {
                    inner1.removeAll();
                    inner1.revalidate();
                    inner1.repaint();
                    
                    inputs1 =  new JTextField[2];
                    inputsPanel1 = new JPanel[2];

                    for(int i=0; i<inputsPanel1.length; i++) {
                        inputsPanel1[i] = new JPanel();
                        inputsPanel1[i].setBackground(Color.white);
                        inputsPanel1[i].setPreferredSize(new Dimension(205, 43));
                        inputsPanel1[i].setMaximumSize(new Dimension(205, 43));
                        inputsPanel1[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
                    }

                    for(int i=0; i<inputs1.length; i++)
                        inputs1[i] = new JTextField();

                    for(int i=0; i<inputs1.length; i++)
                        tfProperties(inputs1[i]);

                    inputs1[0].setText("ID");
                    inputs1[1].setText("Grau de Parentesco");
                    
                    for(int i=0; i<inputs1.length; i++)
                        inputsPanel1[i].add(inputs1[i]);

                    inner1.add(Box.createRigidArea(new Dimension(0,15)));

                    for(int i=0; i<2; i++){
                        inner1.add(inputsPanel1[i]);
                        inner1.add(Box.createRigidArea(new Dimension(0,5)));
                    }
                    
                    addEncarregado.setText("Novo Encarregado");
                }
            }
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
}
