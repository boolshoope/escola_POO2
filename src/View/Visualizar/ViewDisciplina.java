/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Visualizar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author isacl
 */
public class ViewDisciplina extends JComponent {

    JPanel panMenu, panList, panMain;
    JLabel lblDisc, lblIdProd, lblOp, l = new JLabel("");
    JTextField txtNome;
    JButton btnAdd, btnUpd, btnDel, btnSearch;
    JTable tabAluno;
    int ilblY = 90;

    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    private Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);

    public ViewDisciplina() {
        panMain = new JPanel();
        panMain.setBackground(Color.white);
        panMain.setBounds(0, 0, 1800, 1000);

        panMenu = new JPanel();
        panMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
        panMenu.setBounds(15, 63, 315, 493);
        panMenu.setBackground(Color.white);

        panList = new JPanel();
        panList.setBorder(BorderFactory.createTitledBorder("Lista"));
        
        panList.setBounds(344, 62, 739, 494);
        panList.setBackground(Color.white);
        panList.setForeground(Color.black);

        lblDisc = new JLabel("Disciplina");
        lblDisc.setBounds(500, 20, 200, 30);
        lblDisc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

        lblIdProd = new JLabel("Nome da Disciplina");
        lblIdProd.setBounds(30, ilblY, 200, 20);
        lblIdProd.setFont(f1);
        add(lblIdProd);

        lblOp = new JLabel("Operacoes");
        lblOp.setBounds(30, ilblY + 80, 200, 20);
        lblOp.setFont(f1);
        add(lblOp);

        txtNome = new JTextField();
        txtNome.setBounds(30, ilblY + 30, 180, 27);
        add(txtNome);

        btnAdd = new JButton("Adicionar Disciplina");
        btnAdd.setBounds(50, ilblY + 114, 250, 40);
        btnAdd.setFont(f1);
        setButtonColors(btnAdd);
        add(btnAdd);

        btnUpd = new JButton("Actualizar Disciplina");
        btnUpd.setBounds(50, ilblY + 165, 250, 40);
        btnUpd.setFont(f1);
        setButtonColors(btnUpd);
        add(btnUpd);

        btnDel = new JButton("Remover Disciplina");
        btnDel.setBounds(50, ilblY + 216, 250, 40);
        btnDel.setFont(f1);
        setButtonColors(btnDel);
        add(btnDel);

        btnSearch = new JButton("Procurar");
        btnSearch.setBounds(220, ilblY + 29, 98, 27);
        btnSearch.setFont(f1);
        setButtonColors(btnSearch);
        add(btnSearch);

        String[][] data = {
            {"Kundan Kumar Jha", "4031", "CSE"},
            {"Anand Jha", "6014", "IT"}
        };
        String[] columnNames = {"Name", "Nota", "Comentario"};

        tabAluno = new JTable(data, columnNames);
        tabAluno.setFont(f2);

        JScrollPane sp = new JScrollPane(tabAluno);
        sp.setBounds(365, 90, 705, 450);
        add(sp);

        add(panList);
        add(panMenu);
        add(lblDisc);
        add(l);

        add(panMain);
        setSize(1100, 600);
        show();
    }

    private void setButtonColors(JButton btn) {
        btn.setBackground(new Color(62, 62, 62));
        btn.setForeground(Color.white);
    }
}
