package View.Create;

/**
 *
 * @author Basilio
 */

import java.awt.*;
import javax.swing.*;

public class InputEncarregado extends JComponent{
    
    private JLabel txtLab[] = new JLabel[8];
    private JLabel Lab[] = new JLabel[5];
    private String btl[] = {"Voltar","Limpar","Adicionar"};
    private String msg1[] = {"Masculino","Femenino"};
    private String msg2[] = {"Casado","Divorciado","Solteiro","Viuvo"};
    private String msg[] = {"Data de Nascimento","Distrito","Bairro","Quarteirao","Casa"};
    private String texto[] = {"Nome","Apelido","Numero de BI","Sexo","Estado Civil","Telefone 1","Telefone 2","Email"};
    private JPanel pane1,pane2,panePrincipal,paneButton,paneLocal;
    private JPanel pane[] = new JPanel[8];
    private JPanel pan[] = new JPanel[5];
    private JTextField txtInPut[] = new JTextField[6];
    private JTextField txtInput[] = new JTextField[5];
    private JButton btlClick[] = new JButton[3];
    private JComboBox combo[] = new JComboBox[3];
    private Container cont;
    
    int i;
    
    public InputEncarregado(){
        cont = new Container();
        
        panePrincipal = new JPanel();
        paneLocal = new JPanel();
        paneButton= new JPanel();
        pane1 = new JPanel();
        pane2 = new JPanel();
        
        for(i=0;i<pane.length;i++){
            pane[i] = new JPanel();
            pane[i].setLayout(new GridLayout(2,1,5,5));
        }
        
        for(i=0;i<pan.length;i++){
            pan[i] = new JPanel();
            pan[i].setLayout(new GridLayout(2,1,5,5));
        }
        
        paneButton.setLayout(new GridLayout(1,2,20,5));
        paneLocal.setLayout(new GridLayout(2,2,10,10));
        panePrincipal.setLayout(null);
        pane1.setLayout(null);
        pane2.setLayout(null);
        
        panePrincipal.setBorder(BorderFactory.createTitledBorder("Adicionar Encarregado"));
        paneButton.setBorder(BorderFactory.createTitledBorder("Operacoes"));
        pane1.setBorder(BorderFactory.createTitledBorder("Contacto"));
        paneLocal.setBorder(BorderFactory.createTitledBorder("Morada"));
        pane2.setBorder(BorderFactory.createTitledBorder(" "));
        
        for(i=0;i<Lab.length;i++){
            Lab[i] = new JLabel(msg[i]);
            Lab[i].setFont(new Font("Tahoma", Font.BOLD,15));
        }
        
        for(i=0;i<txtInput.length;i++)
            txtInput[i] = new JTextField(15);
        
        for(i = 0;i< txtInPut.length;i++){
            txtLab[i] = new JLabel(texto[i]);
            txtLab[i].setFont(new Font("Tahoma", Font.BOLD,15));
        }
        
        for(i=0;i<txtInPut.length;i++)
            txtInPut[i] = new JTextField();
        
        combo[0] = new JComboBox(msg1);
        combo[1] = new JComboBox(msg2);
        
        for(i=0;i<btlClick.length;i++)
            btlClick[i] = new JButton(btl[i]);
        
        for(i=0; i<3;i++){
            pane[i].add(txtLab[i]);
            pane[i].add(txtInPut[i]);
        }
        
        for(i=3; i<5;i++){
            pane[i].add(txtLab[i]);
            pane[i].add(combo[(i-3)]);
        }
        
        for(i=0; i<pan.length; i++){
            pan[i].add(Lab[i]);
            Lab[i].setFont(new Font("Tahoma", Font.BOLD,15));
            pan[i].add(txtInput[(i)]);
        }
        
        pane[5].add(txtLab[5]);
        pane[5].add(txtInPut[(3)]);
        /*pane[6].add(txtLab[6]);
        pane[6].add(txtInPut[(4)]);
        pane[7].add(txtLab[7]);
        pane[7].add(txtInPut[(5)]);
        */
        
        pane2.setBounds(10, 50, 1000, 700);
        pane1.setBounds(570, 20, 415, 250);
        pane[0].setBounds(10, 30, 300, 70);
        pane[1].setBounds(375, 30, 150, 70);
        pane[2].setBounds(10, 120, 210, 70);
        pane[3].setBounds(375, 120, 140, 70);
        pane[4].setBounds(10, 210, 280, 70);
        pane[5].setBounds(10, 15, 350, 70);
        pane[6].setBounds(10, 50, 300, 70);
        pane[7].setBounds(10, 90, 300, 70);
        pan[0].setBounds(10, 330, 170, 70);
        btlClick[0].setBounds(10, 620, 150, 50);
        paneButton.setBounds(710, 600, 275, 70);
        paneLocal.setBounds(570, 300, 415, 210);
        
        pane2.add(btlClick[0]);
        
        for(i=1;i<btlClick.length;i++)
            paneButton.add(btlClick[i]);
        
        for(i=0; i<5; i++)
            pane2.add(pane[i]);
        
        for(i=1; i<pan.length; i++)
            paneLocal.add(pan[i]);
        
        //for(i=5; i<pane.length; i++)
        pane1.add(pane[5]);
        pane1.add(pane[6]);
        pane1.add(pane[7]);
        
        pane2.add(pan[0]);
        pane2.add(paneLocal);
        pane2.add(paneButton);
        pane2.add(pane1);
        panePrincipal.add(pane2);
        
        cont = panePrincipal;
        add(cont);
        show();
        
    }
}
