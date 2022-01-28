package Controller;

import static View.MainMenu.lstButtons;
import java.awt.event.*;
import java.util.*;
import Model.ValueObject.*;
import Model.DataAccessObject.*;
import View.Create.AddAluno;
import static View.Create.AddAluno.*;
import View.Create.Encarregado;
import View.Update.editAluno;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JOptionPane;

public class MatriculaController implements ActionListener {
    private static  SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-mm-dd");
    public List<Matricula> lstMatricula;
    private MatriculaDAO bd;
            
    public MatriculaController() {
        bd = new MatriculaDAO();
        lstMatricula = bd.getMatricula();
    }
    
    public static void matricular() throws ParseException {
        int idPessoa = getIdPessoa();
        String nome = inputs[0].getText();
        String apelido = inputs[1].getText();
        char sexo;
        if(male.isSelected()) sexo = 'M';
        else sexo = 'F';
        String bi = inputs[2].getText();
        String civil =(String) estCivil.getSelectedItem();
        String tel1 = inputs[4].getText();
        String tel2 = inputs[5].getText();
        
        int nrEstudante = getNrEstudante();
        String dt = inputs[3].getText();
        Date dtNascimento = Date.valueOf(dt);
        AlunoDAO tmp = new AlunoDAO();
        int idEnc;
        
        if(tmp.getPessoa(Integer.parseInt(inputs1[0].getText())) == null)  {
            JOptionPane.showMessageDialog(null, "Encarregado nao encontrado!\nPor favor! Adicione o encarregado...","Adicionar Encarregado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        idEnc = tmp.getPessoa(Integer.parseInt(inputs1[0].getText())).getIdPessoa();
        
        Pessoa pp = new Pessoa(idPessoa,nome,apelido,
                        sexo,bi,civil,tel1,tel2);
        PessoaDAO pdao = new PessoaDAO();
        pdao.inserir(pp);
        
        Aluno al = new Aluno(pp,nrEstudante,dtNascimento,idEnc);
        tmp.inserir(al);
        
        if(addMatr(nrEstudante) ==  -1) {
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Aluno Matriculado com sucesso!!!");
    }
    
    public static void addEnc() {
        int idPessoa = getIdPessoa();
        String nome = Encarregado.inputs1[2].getText();
        String apelido = Encarregado.inputs1[3].getText();
        char sexo;
        if(Encarregado.male1.isSelected()) sexo = 'M';
        else sexo = 'F';
        String bi = Encarregado.inputs1[4].getText();
        String civil =(String) Encarregado.estCivil1.getSelectedItem();
        String tel1 = Encarregado.inputs1[5].getText();
        String tel2 = Encarregado.inputs1[6].getText();
        
        Pessoa p =  new Pessoa(idPessoa,nome,apelido,sexo,
                                bi,civil,tel1,tel2);
        
        PessoaDAO pdao = new PessoaDAO();
        pdao.inserir(p);
        
        String prt = Encarregado.inputs1[1].getText();
        EncarregadoEducacao ee = new EncarregadoEducacao(p,prt);
        
        EncarregadoEducacaoDAO edDAO = new EncarregadoEducacaoDAO();
        edDAO.inserir1(ee);
        
        inputs1[0].setText(""+idPessoa);
    }
    
    public static int addMatr(int nrEstudante) {
        Turma t;
        int idTurma, idAnoAcademico, idClasse, index;
        
        ClasseDAO cldao = new ClasseDAO();
        List<Classe> cl = new ArrayList<>();
        Classe aux;
        
        cl = cldao.getClasse();
        aux = cl.get(classe.getSelectedIndex()-1);
        
        String anoAc =(String) AddAluno.anoAcademico.getSelectedItem();
        idAnoAcademico = Integer.parseInt(anoAc.substring(0,anoAc.indexOf("-")));
        
        idClasse = aux.getIdClasse();
        
        if ((index = classeTurma(idAnoAcademico, idClasse)) == -1) {
            JOptionPane.showMessageDialog(null, "Turmas Cheias!\nPor favor! Adicione nova turma...","Adicionar Turma", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
        
        idTurma = index;
        
        Matricula mat = new Matricula(nrEstudante, idTurma, idAnoAcademico);
        MatriculaDAO mtDAO = new MatriculaDAO();
        mtDAO.inserir(mat);
        return 1;
    }
    
    public static int editAluno() {
        AlunoDAO tmp = new AlunoDAO();
        PessoaDAO pdao = new PessoaDAO();
        EncarregadoEducacaoDAO edao = new EncarregadoEducacaoDAO();
        
        
        List<Aluno> lstA = new ArrayList<>();
        List<Pessoa> lstP = new ArrayList<>();
        List<EncarregadoEducacao> lstE = new ArrayList<>();
        
        Aluno al;
        Pessoa p;
        EncarregadoEducacao e;
        
        int index = -1;
        
        int nrEstudante = Integer.parseInt(editAluno.search.getText());
        
        lstA = tmp.getAluno();
        
        for(int i=0;i<lstA.size();i++) {
            al = lstA.get(i);
            if(nrEstudante == al.getNrEstudante()) {
                index = i;
                break;
            }
        }
        
        if(index == -1) {
            JOptionPane.showMessageDialog(null, "Aluno nao encontrado!\nPor favor! Insira um numero de estudante valido...","Aluno nao encontrado", JOptionPane.WARNING_MESSAGE);
            return index;
        }
        
        al = lstA.get(index);
        lstP = pdao.getPessoa();
        
        index = -1;
        for(int i=0;i<lstP.size();i++) {
            p = lstP.get(i);
            if(al.getIdPessoa() == p.getIdPessoa()) {
                index = i;
                break;
            }
        }
        
        p = lstP.get(index);
        
        lstE = edao.getEncarregadoEducacao();
        
        index = -1;
        for(int i=0; i<lstE.size(); i++) {
            e = lstE.get(i);
            if(al.getIdEncarregadoEducacao() == e.getIdPessoa()) {
                index = i;
                break;
            }
        }
        
        e = lstE.get(index);
        
        editAluno.inputs[0].setText(""+al.getNrEstudante());
        editAluno.inputs[1].setText(p.getpNome());
        editAluno.inputs[2].setText(p.getApelido());
        editAluno.inputs[3].setText(p.getNrBI());
        editAluno.inputs[4].setText(dataFormatada.format(al.getDataNascimento()));
        editAluno.inputs[5].setText(p.getTel1());
        editAluno.inputs[6].setText(p.getTel2());
        editAluno.inputs[7].setText(e.getpNome());
        if(p.getSexo() == 'M') {
            editAluno.male.setSelected(true);
        }else {
            editAluno.female.setSelected(true);
        }
        
        if(p.getEstadoCivil().equals("Solteiro"))
            editAluno.estCivil.setSelectedIndex(1);
        else if(p.getEstadoCivil().equals("Casado"))
            editAluno.estCivil.setSelectedIndex(2);
        else if(p.getEstadoCivil().equals("Divorciado"))
            editAluno.estCivil.setSelectedIndex(3);
        else if(p.getEstadoCivil().equals("Viuvo"))
            editAluno.estCivil.setSelectedIndex(4);
        
        return 1;
    }
    
    public static int classeTurma(int idAno, int idClasse) {
        List<Turma> tur = new ArrayList<>();
        List<Turma> aux = new ArrayList<>();
        List<Matricula> mt = new ArrayList<>();
        
        Turma turma;
        Matricula mat;
        
        int index = -1, countT = 0;
        
        TurmaDAO tr = new TurmaDAO();
        tur = tr.getTurma();
        
        for(int i=0; i<tur.size(); i++) {
            turma = (Turma) tur.get(i);
            if (idClasse == turma.getIdClasse()) {
                aux.add(turma);
            }
        }
        
        MatriculaDAO m = new MatriculaDAO();
        mt = m.getMatricula();
        
        for(int i=0; i<aux.size(); i++) {
            countT = 0;
            turma = (Turma) aux.get(i);
            for(int j=0; j<mt.size(); j++) {
                mat = (Matricula) mt.get(j);
                if (turma.getIdTurma() == mat.getIdTurma() && idAno == mat.getIdAnoAcademico()) {
                    countT++;
                }
                if (countT == turma.getMaxAlunos()) {
                    break;
                }
            }
            index = turma.getIdTurma();
            return index;
        }
        return index;
    }
    
    public static int getNrEstudante() {
        List<Aluno> al = new ArrayList<>();
        AlunoDAO alDAO = new AlunoDAO();
        al = alDAO.getAluno();
        Aluno aux = al.get(al.size()-1);
        return aux.getNrEstudante()+1;
    }
    
    public static int getIdPessoa() {
        List<Pessoa> ps = new ArrayList<>();
        PessoaDAO psDAO = new PessoaDAO();
        ps = psDAO.getPessoa();
        Pessoa aux = ps.get(ps.size()-1);
        return aux.getIdPessoa()+1;
    }
    
    public static void loadClasse() {
        List<Classe> cl = new ArrayList<>();
        Classe aux;
        ClasseDAO clDAO = new ClasseDAO();
        
        cl = clDAO.getClasse();
        
        for(int i=0; i<cl.size(); i++) {
            aux = cl.get(i);
            classe.addItem(aux.getNome());
        }
    }
    
    public static void loadAnoAcademico() {
        List<AnoAcademico> cl = new ArrayList<>();
        AnoAcademico aux;
        AnoAcademicoDAO clDAO = new AnoAcademicoDAO();
        
        cl = clDAO.getAnoAcademico();
        
        for(int i=0; i<cl.size(); i++) {
            aux = cl.get(i);
            anoAcademico.addItem("" + aux.getIdAnoAcademico() + "- "+aux.getAno()+"- "+aux.getTrimestre()+" Trimestre");
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }
}
