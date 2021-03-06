package View.Create;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
//import org.jdatepicker.DateModel;
//import org.jdatepicker.JDatePanel;
//import org.jdatepicker.UtilDateModel;
//import org.jdatepicker.JDatePicker;

public class Matricula extends JComponent implements ActionListener, MouseListener {

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
    private JComboBox classe;

    private JPanel encDataPanel, inner1, inputsPanel1[], genderPanel1, opPanel1;
    private JLabel sexo1;
    private JRadioButton male1, female1;
    private ButtonGroup genderGroup1;
    private JButton addEncarregado;
    private JTextField inputs1[];
    private JComboBox estCivil1;

    private JButton renovarSearch;

    private JButton update;

    private String path = System.getProperty("user.dir") + "/src/View/img/";

    private boolean st = false;
    private boolean st2 = false;

    //UtilDateModel model;
    //JDatePanel datePanel;
    //JDatePicker datePicker;
    public Matricula() {
        //super("Matricula do Aluno");
        //setBounds(200,200,1100,620);
        //setLocationRelativeTo(null);
        //setResizable(false);

        //Container cont = getContentPane();
        //cont.setLayout(null);
        masterPanel = new JPanel();
        headerPanel = new JPanel();
        leftPanel = new JPanel();
        leftButton = new JButton[3];

        // painel principal
        masterPanel.setBackground(Color.white);
        masterPanel.setBounds(0, 0, getWidth(), getHeight());
        masterPanel.setBorder(null);
        masterPanel.setLayout(new BorderLayout());

        // painel esquerdo componentes
        btPanel = new JPanel();
        //BoxLayout btLayout = new BoxLayout(btPanel,BoxLayout.Y_AXIS);
        btPanel.setBackground(null);
        btPanel.setLayout(new GridLayout(1, leftButton.length));
        //btPanel.setBounds(0, 150, 200, 200);

        leftButton[0] = new JButton("MATRICULAR");
        leftButton[1] = new JButton("RENOVAR");
        leftButton[2] = new JButton("EDITAR ALUNO");

        for (int i = 0; i < leftButton.length; i++) {
            leftButton[i].addActionListener(this);
        }

        for (int i = 0; i < leftButton.length; i++) {
            btProperties(leftButton[i]);
        }

        // add botoes ao painel
        for (int i = 0; i < leftButton.length; i++) {
            btPanel.add(leftButton[i]);
        }

        // righ panel
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setLayout(null);

        matricularPage();

        masterPanel.add(BorderLayout.NORTH, btPanel);
        masterPanel.add(BorderLayout.CENTER, rightPanel);

        //cont.add(masterPanel);
        //setVisible(true);
        setSize(1100, 620);
        setLayout(new BorderLayout());
        add(masterPanel);
        show();
    }

    private void renovarPageHome() {
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();

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
        search.setPreferredSize(new Dimension(200, 43));
        search.setMaximumSize(new Dimension(200, 43));

        renovarSearch = new JButton("");
        renovarSearch.setPreferredSize(new Dimension(44, 43));
        renovarSearch.setMaximumSize(new Dimension(44, 43));
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
        search.setPreferredSize(new Dimension(200, 43));
        search.setMaximumSize(new Dimension(200, 43));

        btSearch = new JButton("");
        btSearch.setPreferredSize(new Dimension(44, 43));
        btSearch.setMaximumSize(new Dimension(44, 43));
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
        alDataPanel.setBounds(325, 10, 450, 510);
        alDataPanel.setLayout(null);

        inner = new JPanel();
        inner.setBackground(Color.white);
        inner.setOpaque(false);
        inner.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        inner.setBounds(0, 0, 450, 510);
        BoxLayout alBox = new BoxLayout(inner, BoxLayout.Y_AXIS);
        inner.setLayout(alBox);

        inputs = new JTextField[7];
        inputsPanel = new JPanel[8];
        st = false;

        for (int i = 0; i < inputsPanel.length; i++) {
            inputsPanel[i] = new JPanel();
            inputsPanel[i].setBackground(Color.white);
            inputsPanel[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel[i].setMaximumSize(new Dimension(450, 43));
            inputsPanel[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
            inputsPanel[i].setLayout(new GridLayout(1, 1));
        }

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = new JTextField();
        }

        for (int i = 0; i < inputs.length; i++) {
            tfProperties(inputs[i]);
        }

        for (int i = 0; i < inputs.length; i++) {
            inputs[i].addMouseListener(this);
        }

        inputs[0].setText("Numero de Estudante");
        inputs[1].setText("Nome");
        inputs[2].setText("Apelido");
        inputs[3].setText("BI");
        inputs[4].setText("Telefone 1");
        inputs[5].setText("Telefone 2");
        inputs[6].setText("Nome do Encarregado");

        /*
        model = new UtilDateModel();
        datePanel = new JDatePanel(model);
        datePicker = new JDatePicker(model);
        datePicker.setPreferredSize(new Dimension(205,43));
        datePicker.setMaximumSize(new Dimension(450,43));
        datePicker.setBackground(Color.white);
        datePicker.setOpaque(false);
         */
        genderPanel = new JPanel();
        genderPanel.setPreferredSize(new Dimension(205, 43));
        genderPanel.setMaximumSize(new Dimension(450, 43));
        genderPanel.setOpaque(false);
        genderPanel.setLayout(new GridLayout(2, 1));

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

        for (int i = 0; i < 4; i++) {
            inputsPanel[i].add(inputs[i]);
        }

        //inputsPanel[4].add(datePicker);
        for (int i = 4; i < inputs.length; i++) {
            inputsPanel[i + 1].add(inputs[i]);
        }

        for (int i = 0; i < 3; i++) {
            inner.add(inputsPanel[i]);
            inner.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        inner.add(genderPanel);
        inner.add(Box.createRigidArea(new Dimension(0, 5)));

        inner.add(inputsPanel[3]);
        inner.add(Box.createRigidArea(new Dimension(0, 5)));

        inner.add(estCivil);
        inner.add(Box.createRigidArea(new Dimension(0, 5)));

        for (int i = 4; i < inputsPanel.length; i++) {
            inner.add(inputsPanel[i]);
            inner.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        alDataPanel.add(inner);

        update = new JButton("ACTUALIZAR");
        btProperties(update);
        update.setBounds(785, 467, 200, 43);

        rightPanel.add(alDataPanel);
        rightPanel.add(update);
    }

    private void matricularPage() {
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();

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
        encDataPanel.setBounds(570, 10, 420, 450);
        encDataPanel.setLayout(null);

        inner1 = new JPanel();
        inner1.setBackground(Color.white);
        inner1.setOpaque(false);
        inner1.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        inner1.setBounds(0, 0, 420, 140);
        BoxLayout encBox = new BoxLayout(inner1, BoxLayout.Y_AXIS);
        inner1.setLayout(encBox);

        inputs1 = new JTextField[7];
        inputsPanel1 = new JPanel[7];
        st2 = true;

        for (int i = 0; i < inputsPanel1.length; i++) {
            inputsPanel1[i] = new JPanel();
            inputsPanel1[i].setBackground(Color.white);
            inputsPanel1[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel1[i].setMaximumSize(new Dimension(450, 43));
            inputsPanel1[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
            inputsPanel1[i].setLayout(new GridLayout(1, 1));
        }

        for (int i = 0; i < inputs1.length; i++) {
            inputs1[i] = new JTextField();
        }

        for (int i = 0; i < inputs1.length; i++) {
            tfProperties(inputs1[i]);
        }

        for (int i = 0; i < inputs1.length; i++) {
            inputs1[i].addMouseListener(this);
        }

        inputs1[0].setText("ID");
        inputs1[1].setText("Grau de Parentesco");

        addEncarregado = new JButton("Novo Encarregado");
        addEncarregado.addActionListener(this);
        btProperties(addEncarregado);
        addEncarregado.setBounds(10, 140, 400, 43);
        //addEncarregado.setPreferredSize(new Dimension(205,43));
        //addEncarregado.setMaximumSize(new Dimension(420,43));
        //addEncarregado.set

        for (int i = 0; i < inputs1.length; i++) {
            inputsPanel1[i].add(inputs1[i]);
        }

        inner1.add(Box.createRigidArea(new Dimension(0, 15)));

        for (int i = 0; i < 2; i++) {
            inner1.add(inputsPanel1[i]);
            inner1.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        //inner1.add(addEncarregado);
        encDataPanel.add(inner1);
        encDataPanel.add(addEncarregado);

        matricular = new JButton("MATRICULAR");
        btProperties(matricular);
        matricular.setBounds(475, 473, 150, 43);

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
        alDataPanel.setBounds(110, 10, 450, 450);
        alDataPanel.setLayout(null);

        inner = new JPanel();
        inner.setBackground(Color.white);
        inner.setOpaque(false);
        inner.setBorder(BorderFactory.createEmptyBorder(13, 10, 10, 10));
        inner.setBounds(0, 0, 450, 450);
        BoxLayout alBox = new BoxLayout(inner, BoxLayout.Y_AXIS);
        inner.setLayout(alBox);

        inputs = new JTextField[7];
        inputsPanel = new JPanel[8];
        st = true;

        for (int i = 0; i < inputsPanel.length; i++) {
            inputsPanel[i] = new JPanel();
            inputsPanel[i].setBackground(Color.white);
            inputsPanel[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel[i].setMaximumSize(new Dimension(450, 43));
            inputsPanel[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
            inputsPanel[i].setLayout(new GridLayout(1, 1));
        }

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = new JTextField();
        }

        for (int i = 0; i < inputs.length; i++) {
            tfProperties(inputs[i]);
        }

        for (int i = 0; i < inputs.length; i++) {
            inputs[i].addMouseListener(this);
        }

        inputs[0].setText("Nome");
        inputs[1].setText("Apelido");
        inputs[2].setText("BI");
        inputs[3].setText("Telefone 1");
        inputs[4].setText("Telefone 2");
        /*

        model = new UtilDateModel();
        datePanel = new JDatePanel(model);
        datePicker = new JDatePicker(model);
        datePicker.setPreferredSize(new Dimension(205,43));
        datePicker.setMaximumSize(new Dimension(450,43));
        datePicker.setBackground(Color.white);
        datePicker.setOpaque(false);
         */

        genderPanel = new JPanel();
        genderPanel.setPreferredSize(new Dimension(205, 43));
        genderPanel.setMaximumSize(new Dimension(450, 43));
        genderPanel.setOpaque(false);
        genderPanel.setLayout(new GridLayout(2, 1));

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
        classe.addItem("classe");
        classe.setFont(s);
        classe.setBackground(Color.white);
        classe.setPreferredSize(new Dimension(205, 43));
        classe.setMaximumSize(new Dimension(450, 43));
        classe.setFocusable(false);

        for (int i = 0; i < 3; i++) {
            inputsPanel[i].add(inputs[i]);
        }

        //inputsPanel[3].add(datePicker);
        for (int i = 3; i < inputs.length; i++) {
            inputsPanel[i + 1].add(inputs[i]);
        }
        //inner.add(Box.createRigidArea(new Dimension(0,5)));

        for (int i = 0; i < 2; i++) {
            inner.add(inputsPanel[i]);
            inner.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        inner.add(genderPanel);
        inner.add(Box.createRigidArea(new Dimension(0, 5)));

        inner.add(inputsPanel[2]);
        inner.add(Box.createRigidArea(new Dimension(0, 5)));

        inner.add(estCivil);
        inner.add(Box.createRigidArea(new Dimension(0, 5)));

        for (int i = 3; i < inputsPanel.length - 2; i++) {
            inner.add(inputsPanel[i]);
            inner.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        inner.add(classe);

        alDataPanel.add(inner);
    }

    private void addEnc() {
        inner1.removeAll();
        inner1.revalidate();
        inner1.repaint();

        inputs1 = new JTextField[7];
        inputsPanel1 = new JPanel[7];
        st2 = false;

        inner1.setBounds(0, 0, 420, 402);

        for (int i = 0; i < inputsPanel1.length; i++) {
            inputsPanel1[i] = new JPanel();
            inputsPanel1[i].setBackground(Color.white);
            inputsPanel1[i].setPreferredSize(new Dimension(205, 43));
            inputsPanel1[i].setMaximumSize(new Dimension(450, 43));
            inputsPanel1[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
            inputsPanel1[i].setLayout(new GridLayout(1, 1));
        }

        for (int i = 0; i < inputs1.length; i++) {
            inputs1[i] = new JTextField();
        }

        for (int i = 0; i < inputs1.length; i++) {
            tfProperties(inputs1[i]);
        }

        for (int i = 0; i < inputs1.length; i++) {
            inputs1[i].addMouseListener(this);
        }

        inputs1[0].setText("ID");
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
        genderPanel1.setLayout(new GridLayout(2, 1));

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
        estCivil1.setMaximumSize(new Dimension(450, 43));
        estCivil1.setFocusable(false);

        for (int i = 0; i < inputs1.length; i++) {
            inputsPanel1[i].add(inputs1[i]);
        }

        inner1.add(Box.createRigidArea(new Dimension(0, 15)));

        for (int i = 1; i < 4; i++) {
            inner1.add(inputsPanel1[i]);
            inner1.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        inner1.add(genderPanel1);
        inner1.add(Box.createRigidArea(new Dimension(0, 5)));

        inner1.add(inputsPanel1[4]);
        inner1.add(Box.createRigidArea(new Dimension(0, 5)));

        inner1.add(estCivil1);
        inner1.add(Box.createRigidArea(new Dimension(0, 5)));

        for (int i = 5; i < inputsPanel1.length; i++) {
            inner1.add(inputsPanel1[i]);
            inner1.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        addEncarregado.setBounds(10, 402, 400, 43);
        addEncarregado.setText("Voltar");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftButton[0]) {
            matricularPage();
        }

        if (e.getSource() == leftButton[1]) {
            renovarPageHome();
        }

        if (e.getSource() == leftButton[2]) {
            editAlunoPageHome();
        }

        if (e.getSource() == btSearch) {
            editAlunoPage();
        }

        if (e.getSource() == addEncarregado) {
            if (addEncarregado.getText().equalsIgnoreCase("Novo Encarregado")) {
                addEnc();
            } else {
                if (addEncarregado.getText().equalsIgnoreCase("Voltar")) {
                    inner1.removeAll();
                    inner1.revalidate();
                    inner1.repaint();

                    inner1.setBounds(0, 0, 420, 140);

                    inputs1 = new JTextField[7];
                    inputsPanel1 = new JPanel[7];

                    for (int i = 0; i < inputsPanel1.length; i++) {
                        inputsPanel1[i] = new JPanel();
                        inputsPanel1[i].setBackground(Color.white);
                        inputsPanel1[i].setPreferredSize(new Dimension(205, 43));
                        inputsPanel1[i].setMaximumSize(new Dimension(450, 43));
                        inputsPanel1[i].setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148), 1, true));
                        inputsPanel1[i].setLayout(new GridLayout(1, 1));
                    }

                    for (int i = 0; i < inputs1.length; i++) {
                        inputs1[i] = new JTextField();
                    }

                    for (int i = 0; i < inputs1.length; i++) {
                        tfProperties(inputs1[i]);
                    }

                    for (int i = 0; i < inputs1.length; i++) {
                        inputs1[i].addMouseListener(this);
                    }

                    inputs1[0].setText("ID");
                    inputs1[1].setText("Grau de Parentesco");

                    for (int i = 0; i < inputs1.length; i++) {
                        inputsPanel1[i].add(inputs1[i]);
                    }

                    inner1.add(Box.createRigidArea(new Dimension(0, 15)));

                    for (int i = 0; i < 2; i++) {
                        inner1.add(inputsPanel1[i]);
                        inner1.add(Box.createRigidArea(new Dimension(0, 5)));
                    }

                    addEncarregado.setBounds(10, 140, 400, 43);
                    addEncarregado.setText("Novo Encarregado");
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

        if (e.getSource() == inputs1[0]) {
            if (inputs1[0].getText().equals("ID")) {
                tfChanges(inputs1[0]);
            }
        }

        if (e.getSource() == inputs1[1]) {
            if (inputs1[1].getText().equals("Grau de Parentesco")) {
                tfChanges(inputs1[1]);
            }
        }

        if (e.getSource() == inputs1[2]) {
            if (inputs1[2].getText().equals("Nome")) {
                tfChanges(inputs1[2]);
            }
        }

        if (e.getSource() == inputs1[3]) {
            if (inputs1[3].getText().equals("Apelido")) {
                tfChanges(inputs1[3]);
            }
        }

        if (e.getSource() == inputs1[4]) {
            if (inputs1[4].getText().equals("BI")) {
                tfChanges(inputs1[4]);
            }
        }

        if (e.getSource() == inputs1[5]) {
            if (inputs1[5].getText().equals("Telefone 1")) {
                tfChanges(inputs1[5]);
            }
        }

        if (e.getSource() == inputs1[6]) {
            if (inputs1[6].getText().equals("Telefone 2")) {
                tfChanges(inputs1[6]);
            }
        }

        // -----------------------------------------------------------------------
        if (e.getSource() == inputs[0]) {
            if (inputs[0].getText().equals("Numero de Estudante") && st == false) {
                tfChanges(inputs[0]);
            }
            if (inputs[0].getText().equals("Nome") && st == true) {
                tfChanges(inputs[0]);
            }
        }

        if (e.getSource() == inputs[1]) {
            if (inputs[1].getText().equals("Nome") && st == false) {
                tfChanges(inputs[1]);
            }
            if (inputs[1].getText().equals("Apelido") && st == true) {
                tfChanges(inputs[1]);
            }
        }

        if (e.getSource() == inputs[2]) {
            if (inputs[2].getText().equals("Apelido") && st == false) {
                tfChanges(inputs[2]);
            }
            if (inputs[2].getText().equals("BI") && st == true) {
                tfChanges(inputs[2]);
            }
        }

        if (e.getSource() == inputs[3]) {
            if (inputs[3].getText().equals("BI") && st == false) {
                tfChanges(inputs[3]);
            }
            if (inputs[3].getText().equals("Telefone 1") && st == true) {
                tfChanges(inputs[3]);
            }
        }

        if (e.getSource() == inputs[4]) {
            if (inputs[4].getText().equals("Telefone 1") && st == false) {
                tfChanges(inputs[4]);
            }
            if (inputs[4].getText().equals("Telefone 2") && st == true) {
                tfChanges(inputs[4]);
            }
        }

        if (e.getSource() == inputs[5]) {
            if (inputs[5].getText().equals("Telefone 2") && st == false) {
                tfChanges(inputs[5]);
            }
        }

        if (e.getSource() == inputs[6]) {
            if (inputs[6].getText().equals("Nome do Encarregado") && st == false) {
                tfChanges(inputs[6]);
            }
        }
    }

    public void mouseExited(MouseEvent e) {

        if (e.getSource() == inputs1[0]) {
            if (inputs1[0].getText().equals("ID") || inputs1[0].getText().equals("")) {
                inputs1[0].setText("ID");
            }
        }

        if (e.getSource() == inputs1[1]) {
            if (inputs1[1].getText().equals("Grau de Parentesco") || inputs1[1].getText().equals("")) {
                inputs1[1].setText("Grau de Parentesco");
            }
        }

        if (e.getSource() == inputs1[2]) {
            if (inputs1[2].getText().equals("Nome") || inputs1[2].getText().equals("")) {
                inputs1[2].setText("Nome");
            }
        }

        if (e.getSource() == inputs1[3]) {
            if (inputs1[3].getText().equals("Apelido") || inputs1[3].getText().equals("")) {
                inputs1[3].setText("Apelido");
            }
        }

        if (e.getSource() == inputs1[4]) {
            if (inputs1[4].getText().equals("BI") || inputs1[4].getText().equals("")) {
                inputs1[4].setText("BI");
            }
        }

        if (e.getSource() == inputs1[5]) {
            if (inputs1[5].getText().equals("Telefone 1") || inputs1[5].getText().equals("")) {
                inputs1[5].setText("Telefone 1");
            }
        }

        if (e.getSource() == inputs1[6]) {
            if (inputs1[6].getText().equals("Telefone 2") || inputs1[6].getText().equals("")) {
                inputs1[6].setText("Telefone 2");
            }
        }

        // -----------------------------------------------------------------------
        if (e.getSource() == inputs[0]) {
            if (inputs[0].getText().equals("Numero de Estudante") || inputs[0].getText().equals("") && st == false) {
                inputs[0].setText("Numero de Estudante");
            }
            if (inputs[0].getText().equals("Nome") || inputs[0].getText().equals("") && st == true) {
                inputs[0].setText("Nome");
            }
        }

        if (e.getSource() == inputs[1]) {
            if (inputs[1].getText().equals("Nome") || inputs[1].getText().equals("") && st == false) {
                inputs[1].setText("Nome");
            }
            if (inputs[1].getText().equals("Apelido") || inputs[1].getText().equals("") && st == true) {
                inputs[1].setText("Apelido");
            }
        }

        if (e.getSource() == inputs[2]) {
            if (inputs[2].getText().equals("Apelido") || inputs[2].getText().equals("") && st == false) {
                inputs[2].setText("Apelido");
            }
            if (inputs[2].getText().equals("BI") || inputs[2].getText().equals("") && st == true) {
                inputs[2].setText("BI");
            }
        }

        if (e.getSource() == inputs[3]) {
            if (inputs[3].getText().equals("BI") || inputs[3].getText().equals("") && st == false) {
                inputs[3].setText("BI");
            }
            if (inputs[3].getText().equals("Telefone 1") || inputs[3].getText().equals("") && st == true) {
                inputs[3].setText("Telefone 1");
            }
        }

        if (e.getSource() == inputs[4]) {
            if (inputs[4].getText().equals("Telefone 1") || inputs[4].getText().equals("") && st == false) {
                inputs[4].setText("Telefone 1");
            }
            if (inputs[4].getText().equals("Telefone 2") || inputs[4].getText().equals("") && st == true) {
                inputs[4].setText("Telefone 2");
            }
        }

        if (e.getSource() == inputs[5]) {
            if (inputs[6].getText().equals("Telefone 2") || inputs[6].getText().equals("") && st == false) {
                inputs[6].setText("Telefone 2");
            }
        }

        if (e.getSource() == inputs[6]) {
            if (inputs[6].getText().equals("Nome do Encarregado") || inputs[6].getText().equals("") && st == false) {
                inputs[6].setText("Nome do Encarregado");
            }
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
        button.setPreferredSize(new Dimension(200, 50));
        button.setMaximumSize(new Dimension(200, 50));
        //button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        button.setFont(f2);
        button.setForeground(Color.white);
        button.setBackground(new Color(62, 62, 62));
        button.setFocusable(false);
    }
}
