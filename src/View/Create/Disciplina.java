
package View.Create;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Gabriel
 */
public class Disciplina {
    
    JFrame janela_Disc = new JFrame("Disciplina");
    Container ctDisc = janela_Disc.getContentPane();
    
    
    public Disciplina(){
        
        
        janela_Disc.setSize(1000, 650);
        janela_Disc.setLocationRelativeTo(null);
        janela_Disc.setResizable(false);
        janela_Disc.setLayout(new FlowLayout(FlowLayout.CENTER));
        ctDisc.setLayout(null);
        
        
        label();
        
        text();
        
        botoes();
        
        
        janela_Disc.setVisible(true);
        janela_Disc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
    }
    
    public void label(){
        
        JSeparator separador = new JSeparator();
        separador.setBounds(0,60,1000,10);
        
        JLabel title = new JLabel("DADOS DAS DISCIPLINAS");
        title.setBounds(30,-10,300,100);
        title.setFont(new Font("Tahoma", Font.BOLD,20));
        
        JLabel idClasse = new JLabel("ID Disciplina");
        idClasse.setBounds(30, 100, 100, 20);
        JLabel nomeClasse = new JLabel("Nome");
        nomeClasse.setBounds(30, 150, 100, 20);
        
        ctDisc.add(separador);
        ctDisc.add(title);
        ctDisc.add(idClasse);
        ctDisc.add(nomeClasse);
        
        janela_Disc.setSize(1000, 650);
        janela_Disc.setLocationRelativeTo(null);
        janela_Disc.setResizable(false);
        janela_Disc.setLayout(new FlowLayout(FlowLayout.CENTER));
        ctDisc.setLayout(null);
    }
    
    
    public void text(){
        
        JTextField idDisciplinaText = new JTextField(25);
        idDisciplinaText.setBounds(400, 100, 300, 20);
        
        JTextField nomeDisciplinaText = new JTextField(25);
        nomeDisciplinaText.setBounds(400, 150, 300, 20);
        
        ctDisc.add(idDisciplinaText);
        ctDisc.add(nomeDisciplinaText);
        
    }
    
    public void botoes(){
        
        JButton editarButton = new JButton("Editar dados");
        editarButton.setBounds(480, 200, 150, 20);
        editarButton.setFocusable(false);
        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(480, 250, 150, 20);
        adicionarButton.setFocusable(false);
        
        ctDisc.add(editarButton);
        ctDisc.add(adicionarButton);
    }
}
