package View.Create;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Basilio
 */

public class AddTurma extends JComponent implements ActionListener {
    private String texto[] = {"Ano","Turma","Classe","Turno","Total alunos"};
    private JButton btlClick[] = new JButton[3];
    private JTextField txtInPut[] =new JTextField[4];
    private JLabel txtLab[]= new JLabel[5];
    private JPanel panePrincipal, pane1,pane2,paneButton;
    private JPanel pane[] = new JPanel[5];
    private JComboBox combo[] = new JComboBox[2];
    private String msg1[] = {"Manha","Tarde","Noite"},msg3[] = {"Voltar","Limpar","Adicionar"};
    private String msg2[] = {"8 Classe","9 Classe","10 Classe","11 Classe","8 Classe"};
    private JTable tabela;
    private Container cont;
    int i,confirm;
    
    public AddTurma(){
        panePrincipal = new JPanel();
        pane1 = new JPanel();
        pane2 = new JPanel();
        paneButton = new JPanel();
        
        for(i=0;i<pane.length;i++){
            pane[i] = new JPanel();
            pane[i].setLayout(new GridLayout(2,1,0,0));
        }
        
        cont = new Container();
        
        panePrincipal.setLayout(null);
        paneButton.setLayout(null);
        pane1.setLayout(null);
        pane2.setLayout(null);
                
        panePrincipal.setBorder(BorderFactory.createTitledBorder("Adicionar Turma"));
        paneButton.setBorder(BorderFactory.createTitledBorder("Operacoes"));
        pane1.setBorder(BorderFactory.createTitledBorder("Dados"));
        pane2.setBorder(BorderFactory.createTitledBorder("Visualzar"));
        
        for(i=0;i<txtLab.length;i++){
            txtLab[i] = new JLabel(texto[i]);
            txtLab[i].setFont(new Font("Tahoma", Font.BOLD,15));
        }
        
        for(i=0;i<txtInPut.length;i++)
            txtInPut[i] = new JTextField(15);
        
        for(i = 0;i<btlClick.length;i++)
            btlClick[i] = new JButton(msg3[i]);
        
        combo[0] = new JComboBox(msg2);
        combo[1] = new JComboBox(msg1);
        
        for(i=0;i<2;i++){
            pane[i].add(txtLab[i]);
            pane[i].add(txtInPut[i]);
        }
        
        for(i=0; i< combo.length ;i++){
            pane[(i+2)].add(txtLab[(i+2)]);
            pane[(i+2)].add(combo[i]);
        }
        
        pane[4].add(txtLab[4]);
        pane[4].add(txtInPut[2]);
        
        Object dado[][] = {{"2010","1b1","12 Classe","Diurno "," 40 "},};
        
        tabela = new JTable(dado,texto);
        tabela.setPreferredScrollableViewportSize(new Dimension (410,250));
        tabela.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(tabela);
        
        sp.setBounds(10,30,410,250);
        
        pane1.setBounds(20, 30, 410, 400);
        pane2.setBounds(440, 30, 440, 400);
        paneButton.setBounds(20, 440, 860, 90);
        
        pane[0].setBounds(30,30,100,60);
        pane[1].setBounds(220,30,100,60);
        pane[2].setBounds(30,130,120,60);
        pane[3].setBounds(220,130,120,60);
        pane[4].setBounds(30,230,100,60);
        btlClick[0].setBounds(10, 30, 100, 40);
        btlClick[1].setBounds(300, 30, 100, 40);
        btlClick[2].setBounds(715, 30, 100, 40);
        
        for(i=0;i<pane.length;i++)
            pane1.add(pane[i]);
        
        for(i=0;i<btlClick.length;i++)
            paneButton.add(btlClick[i]);
        
        pane2.add(sp);
        
        panePrincipal.add(pane1);
        panePrincipal.add(pane2);
        panePrincipal.add(paneButton);
        
        cont = panePrincipal;
        add(cont);
        
        show();
    }
    
    public static void main(String[] args) {
        AddTurma t = new AddTurma();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btlClick[1]){
            for(i=0;i<txtInPut.length;i++)
                txtInPut[i].setText(" ");
        }
        //if(e.getSource() == btlClick[2])
            //confirm = JOptionPane.showMessageDialog(null,"Deseja salvar os dados","Confirmacao",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}
