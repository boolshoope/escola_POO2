package View.Create;


/**
 *
 * @author Basilio
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.MainMenu;


public class Encarregado extends JComponent implements ActionListener {
    
    private JLabel labDados[] = new JLabel[7];
    private JTextField txtInPuts[] = new JTextField[7],txtPesquisa;
    private JButton btlClick[] = new JButton[4];
    private JPanel paneMenu,paneDados,paneVisual,panePrincipal;
    private JPanel componete = new JPanel();
    private JPanel panePesquisa,paneOperacao;
    private String texto[] = {"Primeiro nome","Apelido","Sexo","Numero de BI","Estado Civil","Telefone 1","Telefone 2"};
    private JTable tabDados;
    
    int i;
    boolean val=false;
    
    public Encarregado(){
        setSize(1000,600);
        
        setLayout(new BorderLayout());
        
        panePrincipal = new JPanel();
        paneMenu = new JPanel();
        paneVisual = new JPanel();
        panePesquisa = new JPanel();
        paneOperacao = new JPanel();
        
        panePrincipal.setLayout(new FlowLayout(FlowLayout.LEFT,2,25));
        panePrincipal.setBorder(BorderFactory.createTitledBorder("Encarregado de Educacao"));
        
        paneMenu.setLayout(new GridLayout(2,1));
        paneMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
        
        paneVisual.setLayout(new BoxLayout(paneVisual, BoxLayout.Y_AXIS));
        paneVisual.setBorder(BorderFactory.createTitledBorder("Visualizar Dados"));
        
        panePesquisa.setLayout(new FlowLayout());
        panePesquisa.setBorder(BorderFactory.createTitledBorder("Numero de BI"));
        
        paneOperacao.setLayout(new GridLayout(3,1,5,5));
        paneOperacao.setBorder(BorderFactory.createTitledBorder("Operações"));
        
        txtPesquisa = new JTextField(15);
        btlClick[0] = new JButton("Procurar");
        panePesquisa.add(BorderLayout.WEST,txtPesquisa);
        panePesquisa.add(BorderLayout.EAST,btlClick[0]);
        
        btlClick[1] = new JButton("Adicionar");
        btlClick[2] = new JButton("Actualizar");
        btlClick[3] = new JButton("Remover");
        
        btlClick[1].addActionListener(this);
        
        for(i=1;i<btlClick.length;i++) {
            paneOperacao.add(btlClick[i]);
        }
        
        paneMenu.add(panePesquisa);
        paneMenu.add(paneOperacao);
        
        visual();
        
        panePrincipal.add(BorderLayout.WEST,paneMenu);
        panePrincipal.add(BorderLayout.EAST,paneVisual);
        add(panePrincipal);
        show();
    }
    public void visual(){
        Object pessoa[][] = {{"Alone","Basilio","Masculino","123123414B","Solteiro","23423354","45645456"},
        {"Alone","Basilio","Masculino","123123414B","Solteiro","23423354","45645456"},
        {"Alone","Basilio","Masculino","123123414B","Solteiro","23423354","45645456"},};
        
        tabDados = new JTable(pessoa,texto);
        tabDados.setPreferredScrollableViewportSize(new Dimension (600,200));
        tabDados.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(tabDados);
        
        paneVisual.add(BorderLayout.CENTER,sp);
    }
    
    public static void main(String[] args) {
        Encarregado j = new Encarregado();
        if(j.val){
            Add a =new Add();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btlClick[1]){
            val =true;
            //showForm(new Add());
            //Add j =new Add();
        }
    }
    
}

class Add extends JComponent {
    
    private JLabel labDados[] = new JLabel[7];
    private String texto[] = {"Primeiro nome","Apelido","Sexo","Numero de BI","Estado Civil","Telefone 1","Telefone 2"};
    private JPanel paneMenu,paneDados,paneVisual,panePrincipal,paneButton;
    private JTextField txtInPuts[] = new JTextField[7],txtPesquisa;
    private JButton buton[] = new JButton[2];
    
    int i;
    
    public Add(){
        
        panePrincipal = new JPanel();
        paneButton= new JPanel();
        
        setSize(600,300);
        panePrincipal.setLayout(new GridLayout(2,2));
        panePrincipal.setBorder(BorderFactory.createTitledBorder("Encarregado de Educacao"));
        
        paneDados = new JPanel();
        
        paneDados.setLayout(new GridLayout(7,2,10,5));
        paneDados.setBorder(BorderFactory.createTitledBorder("Dados Pessoais"));
        
        for(i = 0;i< txtInPuts.length;i++){
            
            labDados[i] = new JLabel(texto[i]);
            txtInPuts[i] = new JTextField(10);
            paneDados.add(labDados[i]);
            paneDados.add(txtInPuts[i]);
        }
        
        panePrincipal.add(paneDados);
        
        buton[0]=new JButton("Voltar");
        buton[1]=new JButton("Guardar");
        
        for(i=0;i<buton.length;i++){
            paneButton.add(buton[i]);
        }
        panePrincipal.add(paneButton);
        add(panePrincipal);
        //add(paneDados);
        show();
    }
}
