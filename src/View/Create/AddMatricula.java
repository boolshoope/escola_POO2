package View.Create;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class AddMatricula extends JComponent implements ActionListener {
    
    
    private JPanel masterPanel;
    private JPanel headerPanel;
    private JPanel leftPanel;
    private JLabel headerLabel, usr, img;
    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    
    private JButton leftButton[], btSearch;
    private JPanel btPanel, searchPanel;
    private JTextField search;
    
    private JPanel rightPanel;
    
    private JButton renovarSearch;
    
    private String path = System.getProperty("user.dir") + "/src/View/img/";
    
    private JPanel central;
    
    public AddMatricula() {
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
        btPanel.setLayout(new GridLayout(1,leftButton.length));
        //btPanel.setBounds(0, 150, 200, 200);
        
        
        leftButton[0] = new JButton("MATRICULAR");
        leftButton[1] = new JButton("RENOVAR");
        leftButton[2] = new JButton("EDITAR ALUNO");
       
        for(int i=0; i<leftButton.length; i++)
            leftButton[i].addActionListener(this);
        
        for(int i=0; i<leftButton.length; i++)
            btProperties(leftButton[i]);
        
        // add botoes ao painel
        for(int i=0; i<leftButton.length; i++)
            btPanel.add(leftButton[i]);
        
        // righ panel
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setLayout(null);
        
        central = new JPanel();
        central.setBackground(Color.white);
        central.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        central.setLayout(new BorderLayout());
        
        central.add(BorderLayout.CENTER, rightPanel);
        
        showForm(new AddAluno());
        
        masterPanel.add(BorderLayout.NORTH, btPanel);
        masterPanel.add(BorderLayout.CENTER, central);
        
        //cont.add(masterPanel);
        //setVisible(true);
        
        setSize(1100, 620);
        setLayout(new BorderLayout());
        add(masterPanel);
        show();
    }
    
    private void showForm(Component com) {
        BorderLayout layout = (BorderLayout) central.getLayout();
        if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
            central.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        }

        central.add(com, BorderLayout.CENTER);
        central.repaint();
        central.revalidate();
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
        renovarSearch.setIcon(new ImageIcon(path+"iconsSearch.png"));
        
        // add search ao painel
        searchPanel.add(search);
        searchPanel.add(renovarSearch);
        
        rightPanel.add(searchPanel);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftButton[0])
            showForm(new AddAluno());
        
        if(e.getSource() == leftButton[1])
            renovarPageHome();
        
        if(e.getSource() == leftButton[2])
            showForm(new editAluno());
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