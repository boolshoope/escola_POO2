package View.Create;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Basilio
 */

public class AddTurma extends JComponent {
    
    private JPanel paneMenu,paneDados,paneVisual,panePrincipal;
    private JPanel panePesquisa,paneOperacao;
    private String texto[] = {"Ano","Turma","Classe","1 Trimestre","2 Trimestre","3 Trimestre"};
    private JLabel txtLab[] = new JLabel[3];
    private JTextField txtInPut[]=new JTextField[3];
    private JButton btlClick[] = new JButton[4];
    private JTable tabDados;
    
    int i;
    
    public AddTurma(){
        
        panePrincipal = new JPanel();
        paneMenu = new JPanel();
        paneVisual = new JPanel();
        panePesquisa = new JPanel();
        paneOperacao = new JPanel();
        
        panePrincipal.setLayout(new FlowLayout(FlowLayout.LEFT));
        paneMenu.setLayout(new GridLayout(2,1,10,190));
        panePesquisa.setLayout(new GridLayout(4,2,10,15));
        paneOperacao.setLayout(new GridLayout(2,1,10,20));
        
        paneMenu.setBorder(BorderFactory.createTitledBorder("menu"));
        paneVisual.setBorder(BorderFactory.createTitledBorder("Visualizar"));
        panePrincipal.setBorder(BorderFactory.createTitledBorder("Turma"));
        panePesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisa"));
        paneOperacao.setBorder(BorderFactory.createTitledBorder("Operacoes"));
        
        txtLab[0] = new JLabel("Ano");
        txtLab[1] = new JLabel("Turma");
        txtLab[2] = new JLabel("Classe");
        
        txtInPut[0] = new JTextField(15);
        txtInPut[1] = new JTextField(15);
        txtInPut[2] = new JTextField(15);
        
        btlClick[0] = new JButton("Pesquisar");
        btlClick[1] = new JButton("Remover");
        btlClick[2] = new JButton("Actualizar");
        
        for(i=0;i<3;i++){
            panePesquisa.add(txtLab[i]);
            panePesquisa.add(txtInPut[i]);
        }
        panePesquisa.add(btlClick[0]);
        
        for(i=1;i<3;i++)
            paneOperacao.add(btlClick[i]);
        
        paneMenu.add(panePesquisa);
        paneMenu.add(paneOperacao);
        
        Object dado[][] = {{"2010","1b1","12 ","Activa ","Activa","Activa"},};
        
        tabDados = new JTable(dado,texto);
        tabDados.setPreferredScrollableViewportSize(new Dimension (550,500));
        tabDados.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(tabDados);
        paneVisual.add(sp);
        
        panePrincipal.add(paneMenu);
        panePrincipal.add(paneVisual);
        add(panePrincipal);
        
        show();
    }
    
    public static void main(String[] args) {
        AddTurma t = new AddTurma();
    }
}
