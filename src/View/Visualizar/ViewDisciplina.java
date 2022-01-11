/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Visualizar;

import Controller.DisciplinaController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author isacl
 */
public class ViewDisciplina extends JComponent implements ActionListener {

    JPanel panMenu, panList, panMain;
    JLabel lblDisc, lblIdProd, lblOp, l = new JLabel("");
    JTextField txtNome;
    JButton btnAdd, btnUpd, btnDel, btnSearch, btnVoltar;
    JTable tabAluno;
    int ilblY = 90;

    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    private Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);

    public ViewDisciplina() {
        panMain = new JPanel();
        panMain.setBackground(Color.white);
        panMain.setBounds(0, 0, 1800, 1000);

        TitledBorder tb = BorderFactory.createTitledBorder("Menu");
        tb.setTitleFont(f2);

        panMenu = new JPanel();
        panMenu.setBorder(tb);
        panMenu.setBounds(15, 63, 330, 523);
        panMenu.setBackground(Color.white);

        tb = BorderFactory.createTitledBorder("Lista");
        tb.setTitleFont(f2);

        panList = new JPanel();
        panList.setBorder(tb);

        panList.setBounds(359, 62, 760, 524);
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
        txtNome.setBounds(30, ilblY + 30, 180, 30);
        txtNome.setFont(f2);
        add(txtNome);

        btnVoltar = new JButton("");
        btnVoltar.setBounds(1060, 12, 45, 45);
        DefinirBackImagem();
        btnVoltar.setBackground(Color.white);
        btnVoltar.setBorderPainted(false);
        add(btnVoltar);

        btnAdd = new JButton("Adicionar Disciplina");
        btnAdd.setBounds(50, ilblY + 114, 260, 40);
        btnAdd.setFont(f1);
        setButtonColors(btnAdd);
        add(btnAdd);

        btnUpd = new JButton("Actualizar Disciplina");
        btnUpd.setBounds(50, ilblY + 165, 260, 40);
        btnUpd.setFont(f1);
        setButtonColors(btnUpd);
        add(btnUpd);

        btnDel = new JButton("Remover Disciplina");
        btnDel.setBounds(50, ilblY + 216, 260, 40);
        btnDel.setFont(f1);
        setButtonColors(btnDel);
        add(btnDel);

        btnSearch = new JButton("Procurar");
        btnSearch.setBounds(220, ilblY + 29, 110, 30);
        btnSearch.setFont(f1);
        setButtonColors(btnSearch);
        add(btnSearch);

        //tabela
        DisciplinaController disc = new DisciplinaController();
        tabAluno = new JTable(disc.listItems());
        tabAluno.setFont(f2);
        tabAluno.setRowHeight(22);
        TableColumnModel columnModel = tabAluno.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(50);
        tabAluno.setColumnModel(columnModel);

        JScrollPane sp = new JScrollPane(tabAluno);
        sp.setBounds(380, 90, 725, 480);
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
        btn.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            
        }
    }

    private void DefinirBackImagem() {
        BufferedImage imgb = null;
        try {
            //C:\Users\isacl\Documents\NetBeansProjects\escola_POO2\src\View\img\back_to_24px.png
            imgb = ImageIO.read(new File(System.getProperty("user.dir") + "/src/View/img/back_to_24px.png"));
        } catch (IOException e) {
        }
        Image dimg = imgb.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnVoltar.setIcon(new ImageIcon(dimg));
    }

}
