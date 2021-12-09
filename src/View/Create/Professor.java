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
public class Professor {
    
    JFrame janela_Prof = new JFrame("Professor");
    JPanel pnLabel = new JPanel();
    Container ct = janela_Prof.getContentPane();
    
    public Professor() {
        
        janela_Prof.setSize(1000, 650);
        janela_Prof.setLocationRelativeTo(null);
        janela_Prof.setResizable(false);
        janela_Prof.setLayout(new FlowLayout(FlowLayout.CENTER));
        ct.setLayout(null);
        
        label();
        
        textfield();
        
        botoes();
        
        janela_Prof.setVisible(true);
        janela_Prof.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    public void label() {
        
        JSeparator separador = new JSeparator();
        separador.setBounds(0,60,1000,10);
        
        JLabel title = new JLabel("DADOS DO PROFESSOR");
        title.setBounds(30,-10,250,100);
        title.setFont(new Font("Tahoma", Font.BOLD,20));
        
        
        JLabel id = new JLabel("ID Professor");
        id.setBounds(30, 100, 100, 20);
        
        JLabel nome = new JLabel("Nome");
        nome.setBounds(30,150,100,20);
        
        JLabel apelido = new JLabel("Apelido");
        apelido.setBounds(30,200,100,20);
        
        JLabel sexo = new JLabel("Sexo");
        sexo.setBounds(30,250,100,20);
        
        JLabel estado_civil = new JLabel("Estado Civil");
        estado_civil.setBounds(30,300,100,20);
        
        JLabel telefone1 = new JLabel("Telefone (1)");
        telefone1.setBounds(30,350,100,20);
        
        JLabel telefone2 = new JLabel("Telefone (2)");
        telefone2.setBounds(30,400,100,20);
        
        JLabel grau_academico = new JLabel("Grau Academico");
        grau_academico.setBounds(30,450,100,20);
        
        ct.add(title);
        ct.add(separador);
        ct.add(id);
        ct.add(nome);
        ct.add(apelido);
        ct.add(sexo);
        ct.add(estado_civil);
        ct.add(telefone1);
        ct.add(telefone2);
        ct.add(grau_academico);
        
        
        
        
    }
    
    public void textfield() {
        
        
        JTextField idText = new JTextField(25);
        idText.setBounds(400, 100, 300, 20);
        
        JTextField nomeText = new JTextField(25);
        nomeText.setBounds(400, 150, 300, 20);
        JTextField apelidoText = new JTextField(25);
        apelidoText.setBounds(400, 200, 300, 20);
        JTextField sexoText = new JTextField(25);
        sexoText.setBounds(400, 250, 300, 20);
        JTextField estadocivilText = new JTextField(25);
        estadocivilText.setBounds(400, 300, 300, 20);
        JTextField telefone1Text = new JTextField(25);
        telefone1Text.setBounds(400, 350, 300, 20);
        JTextField telefone2Text = new JTextField(25);
        telefone2Text.setBounds(400, 400, 300, 20);
        JTextField grauText = new JTextField(25);
        grauText.setBounds(400, 450, 300, 20);

        
        ct.add(idText);
        ct.add(nomeText);
        ct.add(apelidoText);
        ct.add(sexoText);
        ct.add(estadocivilText);
        ct.add(telefone1Text);
        ct.add(telefone2Text);
        ct.add(grauText);

        
        
    }
    
    public void botoes(){
        
        JButton editarButton = new JButton("Editar dados");
        editarButton.setBounds(480, 500, 150, 20);
        editarButton.setFocusable(false);
        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(480, 550, 150, 20);
        adicionarButton.setFocusable(false);
        
        ct.add(editarButton);
        ct.add(adicionarButton);
        
    }
    
}
