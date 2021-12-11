/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.Create.Encarregado;
import View.Create.Matricula;
//import View.Create
import View.Create.*;
import java.awt.*;
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
public class MainMenu extends JFrame implements ActionListener {

    JPanel panWButtons, panNButtons, main;
    JButton[] lstButtons = new JButton[9];
    JLabel lblWLine, lblLogo, lblNSistGestEsc, lblUsername;

    int wSize = 220;
    String path = "";
    Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 20);

    public MainMenu() {
        //panels
        main = new JPanel(new BorderLayout());
        panWButtons = new JPanel();
        panWButtons.setBackground(new Color(62, 62, 62));
        panWButtons.setLayout(new BoxLayout(panWButtons, BoxLayout.Y_AXIS));
        panNButtons = new JPanel();
        panNButtons.setBackground(new Color(62, 62, 62));
        panNButtons.setLayout(new BorderLayout());

        //labels
        lblWLine = new JLabel();
        lblWLine.setMaximumSize(new Dimension(wSize, 10));
        lblWLine.setBackground(Color.WHITE);
        lblWLine.setOpaque(true);

        path = System.getProperty("user.dir") + "/src/View/img/logo.jpg";
        lblLogo = new JLabel();
        DefinirIimagem(lblLogo, "logo", wSize, 90);

        lblNSistGestEsc = new JLabel("Sistema de Gestao Escolar");
        lblNSistGestEsc.setFont(f2);
        lblNSistGestEsc.setForeground(Color.WHITE);
        lblNSistGestEsc.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        lblUsername = new JLabel("username");
        lblUsername.setFont(f2);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        //buttons
        for (int i = 0; i < lstButtons.length; i++) {
            /*
            Aluno
            teste
            matricula
            professor
            enc. ed
            Classe
            disciplina
            Turma
            ano academico
             */
            switch (i) {
                case 0:
                    lstButtons[i] = new JButton("Aluno");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
                case 1:
                    lstButtons[i] = new JButton("Teste");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
                case 2:
                    lstButtons[i] = new JButton("Matricula");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
                case 3:
                    lstButtons[i] = new JButton("Professor");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
                case 4:
                    lstButtons[i] = new JButton("Encarregado de Educacao");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
                case 5:
                    lstButtons[i] = new JButton("Classe");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
                case 6:
                    lstButtons[i] = new JButton("Disciplina");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
                case 7:
                    lstButtons[i] = new JButton("Turma");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
                case 8:
                    lstButtons[i] = new JButton("Ano Academico");
                    SetWButtons(lstButtons[i], "Add File_32px");
                    break;
            }
            lstButtons[i].addActionListener(this);
        }

        for (int i = 0; i < lstButtons.length; i++) {
            panWButtons.add(lstButtons[i]);
        }

        //add elements to panel
        panWButtons.add(lblWLine);
        for (int i = 0; i < lstButtons.length; i++) {
            panWButtons.add(lstButtons[i]);
        }
        main.add(panWButtons, BorderLayout.WEST);

        panNButtons.add(lblLogo, BorderLayout.WEST);
        panNButtons.add(lblNSistGestEsc, BorderLayout.CENTER);
        panNButtons.add(lblUsername, BorderLayout.EAST);

        main.add(panNButtons, BorderLayout.NORTH);

        add(main);
        setSize(1366, 760);
        show();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void SetWButtons(JButton btn, String file) {
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        path = System.getProperty("user.dir") + "/src/View/img/" + file + ".png";

        btn.setPreferredSize(new Dimension(wSize, 50));
        btn.setMaximumSize(new Dimension(wSize, 50));
        btn.setIcon(new ImageIcon(path));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBackground(new Color(62, 62, 62));
        btn.setForeground(Color.WHITE);
        btn.setFont(f1);
        btn.setFocusable(false);
    }

    private void DefinirIimagem(JLabel lbl, String imagem, int w, int h) {
        BufferedImage imgb = null;
        try {
            imgb = ImageIO.read(new File(System.getProperty("user.dir") + "/src/View/img/" + imagem + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = imgb.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(dimg));
    }

    private void showForm(Component com) {
        BorderLayout layout = (BorderLayout) main.getLayout();
        if (layout.getLayoutComponent(BorderLayout.CENTER) != null) 
            main.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        
        main.add(com, BorderLayout.CENTER);
        main.repaint();
        main.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lstButtons[0]) {
            showForm(new Teste2());
        }
        
        if(e.getSource() == lstButtons[2]) {
            new Matricula();
        }
        if (e.getSource() == lstButtons[4]) {
            showForm(new Encarregado());
        }
    }
}
