/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Gabriel
 */
public class Classe {
    
    JFrame janela_Disc = new JFrame("Classe");// criacao de JFrame classe
    Container ctDisc = janela_Disc.getContentPane();
    
    
    public Classe(){
        
        
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
        
        JLabel title = new JLabel("DADOS DAS CLASSES");
        title.setBounds(30,-10,300,100);
        title.setFont(new Font("Tahoma", Font.BOLD,20));
        
        JLabel idClasse = new JLabel("ID Classe");
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
        
        JTextField idClasseText = new JTextField(25);
        idClasseText.setBounds(400, 100, 300, 20);
        
        JTextField nomeClasseText = new JTextField(25);
        nomeClasseText.setBounds(400, 150, 300, 20);
        
        ctDisc.add(idClasseText);
        ctDisc.add(nomeClasseText);
        
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
