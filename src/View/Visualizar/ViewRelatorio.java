/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Visualizar;

import Controller.AnoAcController;
import View.MainMenu;
import View.SubMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author isacl
 */
public class ViewRelatorio extends JComponent implements ActionListener {

    JPanel panMenu, panList, panMain;
    JLabel lblDisc, lblIdProd, lblOp, l = new JLabel("");
    JTextField txtNome;
    JButton btnAdd, btnSearch, btnVoltar;
    JTable tab;
    int ilblY = 90;
    AnoAcController anoAc;

    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    private Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);

    public ViewRelatorio() {
        panMain = new JPanel();
        panMain.setBackground(Color.white);
        panMain.setBounds(0, 0, 1800, 1000);

        TitledBorder tb = BorderFactory.createTitledBorder("Menu");
        tb.setTitleFont(f2);

        panMenu = new JPanel();
        panMenu.setBorder(tb);
        panMenu.setBounds(15, 63, 450, 523);
        panMenu.setBackground(Color.white);

        tb = BorderFactory.createTitledBorder("Lista");
        tb.setTitleFont(f2);

        panList = new JPanel();
        panList.setBorder(tb);

        panList.setBounds(479, 62, 640, 524);
        panList.setBackground(Color.white);
        panList.setForeground(Color.black);

        lblDisc = new JLabel("Gerar Certificado");
        lblDisc.setBounds(450, 20, 300, 30);
        lblDisc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

        lblIdProd = new JLabel("Número de Estudante");
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
        btnVoltar.addActionListener(this);
        add(btnVoltar);

        btnAdd = new JButton("Adicionar Ano Academico");
        btnAdd.setBounds(50, ilblY + 114, 260, 40);
        btnAdd.setFont(f1);
        btnAdd.addActionListener(this);
        setButtonColors(btnAdd);
        add(btnAdd);

        btnSearch = new JButton("Procurar");
        btnSearch.setBounds(220, ilblY + 29, 110, 30);
        btnSearch.setFont(f1);
        btnSearch.addActionListener(this);
        setButtonColors(btnSearch);
        add(btnSearch);

        //tabela
        anoAc = new AnoAcController();
        tab = new JTable(anoAc.listItems());
        tab.setFont(f2);
        tab.setRowHeight(22);
        TableColumnModel columnModel = tab.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(50);
        tab.setColumnModel(columnModel);

        JScrollPane sp = new JScrollPane(tab);
        sp.setBounds(500, 90, 605, 480);
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
            showForm(new SubMenu());
        }
        if (e.getSource() == btnSearch) {
            btnSearch_Click();
        }
        if (e.getSource() == btnAdd) {
            showForm(new AddAnoAcademico());
        }
    }

    private void DefinirBackImagem() {
        BufferedImage imgb = null;
        try {
            imgb = ImageIO.read(new File(System.getProperty("user.dir") + "/src/View/img/back_to_24px.png"));
        } catch (IOException e) {
        }
        Image dimg = imgb.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnVoltar.setIcon(new ImageIcon(dimg));
    }

    private void showForm(Component com) {
        BorderLayout layout = (BorderLayout) MainMenu.main.getLayout();
        if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
            MainMenu.main.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        }

        MainMenu.main.add(com, BorderLayout.CENTER);
        MainMenu.main.repaint();
        MainMenu.main.revalidate();
    }

    public void btnSearch_Click() {
        int aux = anoAc.searchItem(Integer.parseInt(txtNome.getText()));
        if (aux != -1) {
            tab.setRowSelectionInterval(aux, aux);
            JOptionPane.showMessageDialog(null, "Registo Encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Registo Nao Encontrado.");
        }
    }

}
