/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Visualizar;
import View.Update.UpdateTurma;
import Controller.TurmaController;
import View.Create.AddTurma;
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
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author isacl
 */
public class ViewTurma extends JComponent implements ActionListener{
    JPanel panMenu, panList, panMain;
    JLabel lblDisc, lblIdProd, lblOp, l = new JLabel("");
    JTextField txtNome;
    JButton btnAdd, btnUpd, btnDel, btnSearch, btnVoltar;
    JTable tab;
    int ilblY = 90;
    TurmaController turma ;

    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    private Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);

    public ViewTurma() {
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

        lblDisc = new JLabel("Turma");
        lblDisc.setBounds(500, 20, 200, 30);
        lblDisc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

        lblIdProd = new JLabel("Nome da Turma");
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

        btnAdd = new JButton("Adicionar Turma");
        btnAdd.setBounds(50, ilblY + 114, 260, 40);
        btnAdd.setFont(f1);
        btnAdd.addActionListener(this);
        setButtonColors(btnAdd);
        add(btnAdd);

        btnUpd = new JButton("Actualizar Turma");
        btnUpd.setBounds(50, ilblY + 165, 260, 40);
        btnUpd.setFont(f1);
        btnUpd.addActionListener(this);
        setButtonColors(btnUpd);
        add(btnUpd);

        btnDel = new JButton("Remover Turma");
        btnDel.setBounds(50, ilblY + 216, 260, 40);
        btnDel.setFont(f1);
        btnDel.addActionListener(this);
        setButtonColors(btnDel);
        add(btnDel);

        btnSearch = new JButton("Procurar");
        btnSearch.setBounds(220, ilblY + 29, 110, 30);
        btnSearch.setFont(f1);
        btnSearch.addActionListener(this);
        setButtonColors(btnSearch);
        add(btnSearch);

        //tabela
        turma = new TurmaController();
        tab = new JTable(turma.listItems());
        tab.setFont(f2);
        tab.setRowHeight(22);
        TableColumnModel columnModel = tab.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(50);
        tab.setColumnModel(columnModel);

        JScrollPane sp = new JScrollPane(tab);
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
            showForm(new SubMenu());
        }
        if (e.getSource() == btnSearch) {
            btnSearch_Click();
        }
        if (e.getSource() == btnAdd) {
            showForm(new AddTurma());
        }
        if (e.getSource() == btnUpd) {
            btnUpd_Click();
        }
        if (e.getSource() == btnDel) {
            btnDel_Click();
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

    public void btnDel_Click() {
        int getSelectedRow = tab.getSelectedRow();
        //Check if their is a row selected
        if (getSelectedRow != -1) {
            int reply = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o registo?", "Confirmacao.", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                turma.deleteItem(getSelectedRow);
                JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item na lista.");
        }
    }

    public void btnSearch_Click() {
        int aux = turma.searchItem(txtNome.getText());
        if (aux != -1) {
            tab.setRowSelectionInterval(aux, aux);
            JOptionPane.showMessageDialog(null, "Registo Encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Registo Nao Encontrado.");
        }
    }

    public void btnUpd_Click() {
        int getSelectedRow = tab.getSelectedRow();
        int id;
        String nome;
        int max;
        if (getSelectedRow != -1) {
            id = turma.getIdSelectedItem(getSelectedRow);
            nome = turma.getNomeSelectedItem(getSelectedRow);
            max = turma.getMaxSelectedItem(getSelectedRow);
            //Chamar a classe update com o parametro
            showForm(new UpdateTurma(id,nome,max));

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item na lista.");
        }
    }
}
