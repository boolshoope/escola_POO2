/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ValueObject;

/**
 *
 * @author isacl
 */
public class AlunoTeste {

    private int nrEstudante;
    private int idTeste;
    private float nota;
    private String comentario;

    public AlunoTeste(int nrEstudante, int idTeste, float nota, String comentario) {
        this.nrEstudante = nrEstudante;
        this.idTeste = idTeste;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNrEstudante() {
        return nrEstudante;
    }

    public void setNrEstudante(int nrEstudante) {
        this.nrEstudante = nrEstudante;
    }

    public int getIdTeste() {
        return idTeste;
    }

    public void setIdTeste(int idTeste) {
        this.idTeste = idTeste;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "AlunoTeste{" + "nrEstudante=" + nrEstudante + ", idTeste=" + idTeste + ", nota=" + nota + ", comentario=" + comentario + '}';
    }

}
