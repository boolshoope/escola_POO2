/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Visualizar;

import Controller.AlunoController;
import Controller.AnoAcController;
import Model.ValueObject.AnoAcademico;
import View.Create.Relatorio;
import View.MainMenu;
import View.SubMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    JLabel lblDisc, l = new JLabel("");
    JLabel lblDados[] = new JLabel[5];
    JTextField[] txtDados = new JTextField[4];
    JButton btnAdd, btnSearch;
    JComboBox cboAnoAc;
    JTable tab;
    int ilblY = 90;
    AlunoController ctrlAluno = new AlunoController();
    AnoAcController anoAc = new AnoAcController();
    Relatorio rel = new Relatorio();

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

        for (int i = 0; i < lblDados.length; i++) {
            switch (i) {
                case 0:
                    lblDados[i] = new JLabel("Número de Estudante");
                    lblDados[i].setBounds(30, ilblY + 0 * (i + 1), 200, 20);
                    lblDados[i].setFont(f1);

                    txtDados[i] = new JTextField();
                    txtDados[i].setBounds(30, ilblY + 30 * (i + 1), 180, 30);
                    txtDados[i].setFont(f2);
                    txtDados[i].addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            char c = e.getKeyChar();
                            if (((c < '0') || (c > '9'))) {
                                e.consume();
                            }
                        }
                    });
                    add(txtDados[i]);
                    add(lblDados[i]);
                    break;
                case 1:
                    lblDados[i] = new JLabel("Nome de Estudante");
                    lblDados[i].setBounds(30, ilblY + 88 * i, 200, 20);
                    lblDados[i].setFont(f1);

                    txtDados[i] = new JTextField();
                    txtDados[i].setBounds(30, ilblY + 60 * (i + 1), 300, 30);
                    txtDados[i].setFont(f2);
                    txtDados[i].setEditable(false);
                    add(txtDados[i]);
                    add(lblDados[i]);
                    break;
                case 2:
                    lblDados[i] = new JLabel("Data de Nascimento");
                    lblDados[i].setBounds(30, ilblY + 83 * i, 200, 20);
                    lblDados[i].setFont(f1);

                    txtDados[i] = new JTextField();
                    txtDados[i].setBounds(30, ilblY + 65 * (i + 1), 180, 30);
                    txtDados[i].setFont(f2);
                    txtDados[i].setEditable(false);
                    add(txtDados[i]);
                    add(lblDados[i]);
                    break;
                case 3:
                    lblDados[i] = new JLabel("Sexo");
                    lblDados[i].setBounds(250, ilblY + 83 * 2, 200, 20);
                    lblDados[i].setFont(f1);

                    txtDados[i] = new JTextField();
                    txtDados[i].setBounds(250, ilblY + 65 * (2 + 1), 180, 30);
                    txtDados[i].setFont(f2);
                    txtDados[i].setEditable(false);
                    add(txtDados[i]);
                    add(lblDados[i]);
                    break;
                case 4:
                    lblDados[i] = new JLabel("Ano Academico");
                    lblDados[i].setBounds(500, 100, 200, 20);
                    lblDados[i].setFont(f1);
                    add(lblDados[i]);
                    break;
            }
        }

        btnAdd = new JButton("Gerar Certificado");
        btnAdd.setBounds(900, 530, 200, 40);
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

        cboAnoAc = new JComboBox();
        cboAnoAc.setBounds(500, 125, 180, 30);
        cboAnoAc.setFont(f2);
        cboAnoAc.addActionListener(this);
        add(cboAnoAc);

        //tabela
        String col[] = {"Disciplina", "Media"};
        Object[][] data = {
            {"", ""}
        };

        tab = new JTable(data, col);
        tab.setFont(f2);
        tab.setRowHeight(22);
        TableColumnModel columnModel = tab.getColumnModel();
        tab.setColumnModel(columnModel);

        JScrollPane sp = new JScrollPane(tab);
        sp.setBounds(500, 180, 605, 330);
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
        if (e.getSource() == btnSearch) {
            btnSearch_Click();
        }
        if (e.getSource() == btnAdd) {
            rel.GerarCertificado();
        }
        if (e.getSource() == cboAnoAc && canListenCbo) {
            int ano = Integer.parseInt(cboAnoAc.getSelectedItem().toString());
            rel.VisualizarMediasNotaGlobal(Integer.parseInt(txtDados[0].getText()),
                    anoAc.searchItemAnoAcRelatorio(ano));
            tab.setModel(rel.tableModel);
        }
    }

    boolean canListenCbo = false;
    public void btnSearch_Click() {
        String[] dados = ctrlAluno.searchItemCertificado(Integer.parseInt(txtDados[0].getText()));
        if (dados != null) {
            JOptionPane.showMessageDialog(null, "Registo Encontrado.");

            canListenCbo = false;
            cboAnoAc.removeAllItems();
            List<String> lst = ctrlAluno.getAnoAcFrequentado(Integer.parseInt(txtDados[0].getText()));
            for (int i = 0; i < lst.size(); i++) {
                cboAnoAc.addItem(lst.get(i));
            }
            canListenCbo = true;
            cboAnoAc.setSelectedIndex(0);
            
            txtDados[1].setText(dados[0]);
            txtDados[2].setText(dados[1]);
            txtDados[3].setText(dados[2]);
        } else {
            JOptionPane.showMessageDialog(null, "Registo Nao Encontrado.");
        }
    }

}
