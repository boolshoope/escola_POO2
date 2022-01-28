/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Visualizar;

/**
 *
 * @author Basilio
 */
import Controller.EncarregadoController;
import View.MainMenu;
import View.SubMenu;
import View.Create.AddEncarregado;
import View.Update.UpdateEncarregado;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

public class ViewEncarregado extends JComponent implements ActionListener {
    JPanel panMenu, panList, panMain;
    JLabel lblDisc, lblIdProd, lblOp, l = new JLabel("");
    JTextField txtNome;
    JButton btnAdd, btnUpd, btnDel, btnSearch, btnVoltar;
    JTable tab;
    EncarregadoController encarregado = new EncarregadoController(); 
    private String texto[] = {"Id","Nome","Apelido","Numero de BI","Sexo","Estado Civil","Telefone 1","Telefone 2"};
    int ilblY = 90,aux;
    //ClasseController classe;,"Telefone 1","Telefone 2","Email"

    private Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    private Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
    
    public ViewEncarregado(){
        panMain = new JPanel();
        panMain.setBackground(Color.white);
        panMain.setBounds(0, 0, 1800, 1000);

        TitledBorder tb = BorderFactory.createTitledBorder("Menu");
        tb.setTitleFont(f2);

        panMenu = new JPanel();
        panMenu.setBorder(tb);
        panMenu.setBounds(15, 63, 320, 523);
        panMenu.setBackground(Color.white);

        tb = BorderFactory.createTitledBorder("Lista");
        tb.setTitleFont(f2);

        panList = new JPanel();
        panList.setBorder(tb);

        panList.setBounds(349, 62, 700, 524);
        panList.setBackground(Color.white);
        panList.setForeground(Color.black);

        lblDisc = new JLabel("Encarregado");
        lblDisc.setBounds(500, 20, 200, 30);
        lblDisc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

        lblIdProd = new JLabel("Id do Encarregado");
        lblIdProd.setBounds(30, ilblY, 200, 20);
        lblIdProd.setFont(f1);
        add(lblIdProd);

        lblOp = new JLabel("Operacoes");
        lblOp.setBounds(30, ilblY + 80, 200, 20);
        lblOp.setFont(f1);
        add(lblOp);

        txtNome = new JTextField("");
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

        btnAdd = new JButton("Adicionar");
        btnAdd.setBounds(50, ilblY + 114, 240, 40);
        btnAdd.setFont(f1);
        btnAdd.addActionListener(this);
        setButtonColors(btnAdd);
        add(btnAdd);

        btnUpd = new JButton("Actualizar");
        btnUpd.setBounds(50, ilblY + 165, 240, 40);
        btnUpd.setFont(f1);
        btnUpd.addActionListener(this);
        setButtonColors(btnUpd);
        add(btnUpd);

        btnDel = new JButton("Remover");
        btnDel.setBounds(50, ilblY + 216, 240, 40);
        btnDel.setFont(f1);
        btnDel.addActionListener(this);
        setButtonColors(btnDel);
        add(btnDel);

        btnSearch = new JButton("Procurar");
        btnSearch.setBounds(220, ilblY + 29, 100, 30);
        btnSearch.setFont(f1);
        btnSearch.addActionListener(this);
        setButtonColors(btnSearch);
        add(btnSearch);

        
        tab = new JTable(encarregado.listItems());
        
        tab.setFont(f2);
        tab.setRowHeight(15);
        TableColumnModel columnModel = tab.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(50);
        
        tab.setColumnModel(columnModel);

        JScrollPane sp = new JScrollPane(tab);
        sp.setBounds(365, 90, 675, 480);
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
            showForm(new  AddEncarregado());
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
                encarregado.deleteItem(getSelectedRow);
                
                JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item na lista.");
        }
    }

  public void btnSearch_Click() {
       int aux;
        aux = encarregado.searchItem(Integer.parseInt(txtNome.getText()));
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
        String nome,apelido,t1,t2,bi,estad;
        String grau;
        if (getSelectedRow != -1) {
            id = encarregado.getIdSelectedItem(getSelectedRow);
            nome = encarregado.getNomeSelectedItem(getSelectedRow);
            apelido = encarregado.getApelidoSelectedItem(getSelectedRow);
            bi = encarregado.getBiSelectedItem(getSelectedRow);
            t1 = encarregado.getTel1SelectedItem(getSelectedRow);
            t2 = encarregado.getTel2SelectedItem(getSelectedRow);
            grau = encarregado.getGrauSelectedItem(getSelectedRow);
            estad = encarregado.getEstadoSelectedItem(getSelectedRow);
            
            showForm(new UpdateEncarregado(id,nome,apelido,bi,grau,estad,t1,t2));
            //showForm(new updateClasse(id-1));
           
            //Chamar a classe update com o parametro

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item na lista.");
        }
    }
}
