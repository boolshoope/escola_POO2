/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.Visualizar.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author isacl
 */
public class SubMenu extends JComponent implements ActionListener {

    JButton[] btn = new JButton[5];
    JPanel pan;

    public SubMenu() {

        btn[0] = new JButton("Turma");
        btn[1] = new JButton("Ano Ac");
        btn[2] = new JButton("disc");
        btn[3] = new JButton("classe");
        btn[4] = new JButton("encarregado");

        pan = new JPanel(new GridLayout(2, 3, 50, 50));
        pan.setBorder(BorderFactory.createEmptyBorder(150, 20, 20, 20));

        for (int i = 0; i < btn.length; i++) {
            btn[i].setPreferredSize(new Dimension(150, 150));
            btn[i].addActionListener(this);
            btn[i].setBackground(Color.white);
            switch (i) {
                case 0:
                    DefinirBackImagem(btn[0], "btnTurma");
                    break;
                case 1:
                    DefinirBackImagem(btn[1], "btnAnoAc");
                    break;
                case 2:
                    DefinirBackImagem(btn[2], "btnDisc");
                    break;
                case 3:
                    DefinirBackImagem(btn[3], "btnClasse");
                    break;
                case 4:
                    DefinirBackImagem(btn[4], "btnEncEd");
                    break;
            }
            pan.add(btn[i]);
        }

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(pan);

        setSize(1100, 600);
        show();
    }

    private void DefinirBackImagem(JButton btn, String imgS) {
        BufferedImage imgb = null;
        try {
            imgb = ImageIO.read(new File(System.getProperty("user.dir") + "/src/View/img/" + imgS + ".jpg"));
        } catch (IOException e) {
        }
        Image dimg = imgb.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(dimg));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        btn[0] = new JButton("Turma");
        btn[1] = new JButton("Ano Ac");
        btn[2] = new JButton("disc");
        btn[3] = new JButton("classe");
        btn[4] = new JButton("encarregado");
         */
        if (e.getSource() == btn[0]) {

        } else if (e.getSource() == btn[1]) {

        } else if (e.getSource() == btn[2]) {
            showForm(new ViewDisciplina());
        } else if (e.getSource() == btn[3]) {

        } else if (e.getSource() == btn[4]) {

        }
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
}
