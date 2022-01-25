/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Gui
 */
public class Janela extends JFrame{
    
    private JPanel painelVis, painelDados, painelPrincipal;
    private JPanel painelVal, painelOp; 
    
    private JButton aluno, classe, turma, disciplina;
    private JTextField painelN, painelS;
    
    //As tabelas abaixo serao adicionadas no painel de visualizacao num evento
    private JTable tabelaAluno, tabelaDisciplina, tabelaTurma, tabelaClasse; 
    
    
    
    
    public Janela(){
        //Ajustando a janela
        setTitle("Acesso");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 100, 900, 550);
        setLayout(null);
        setResizable(false);
        setContentPane(painelPrincipal = new JPanel(null));
        
        
        
        //Personalizando os paineis
        painelPrincipal.add(painelVis = new JPanel());
        painelVis.setBounds(5, 5, 450, 500);
        painelVis.setBorder(BorderFactory.createTitledBorder("Visualização"));
    
     
        painelPrincipal.add(painelDados = new JPanel(null));
        painelDados.setBounds(455, 5, 435, 500);
        painelDados.setBorder(BorderFactory.createTitledBorder("Inserção de Dados"));
       
        
        painelDados.add(painelVal = new JPanel(null));
        painelVal.setBounds(20, 20, 400, 230);
        painelVal.setBorder(BorderFactory.createTitledBorder(""));
        
        painelDados.add(painelOp = new JPanel(null));
        painelOp.setBounds(painelVal.getX(), painelVal.getHeight() + painelVal.getY() + 10, 400, 230);
        painelOp.setBorder(BorderFactory.createTitledBorder("Visualizar"));
        
        //Adicionando componentes nos paineis
        painelVal.add(painelN = new JTextField());
        painelN.setBounds(10, 10, 380, 50);
        painelN.setBorder(BorderFactory.createTitledBorder("Nome: "));
       
        
        
        painelVal.add(painelS = new JTextField(null));
        painelS.setBounds(10, 80, 380, 50);
        painelS.setBorder(BorderFactory.createTitledBorder("Numero do Aluno: "));
        
        painelOp.add(aluno = new JButton("Aluno"));
        aluno.setBounds(100, 20, 200, 30);
        aluno.setBorder(BorderFactory.createTitledBorder(""));
        
        
        painelOp.add(classe = new JButton("Classe"));
        classe.setBounds(100, 70, 200, 30);
        classe.setBorder(BorderFactory.createTitledBorder(""));
        
        painelOp.add(turma = new JButton("Turma"));
        turma.setBounds(100, 120, 200, 30);
        turma.setBorder(BorderFactory.createTitledBorder(""));
        
        painelOp.add(disciplina = new JButton("Disciplina"));
        disciplina.setBounds(100, 170, 200, 30);
        disciplina.setBorder(BorderFactory.createTitledBorder(""));
        //trabalhando em Visualizar
      
        setVisible(true);
    }
}