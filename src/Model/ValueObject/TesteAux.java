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
public class TesteAux {
    private int nrEstudante;
    private String nome;
    private float nota;
    private String comentario;

    public TesteAux(int nrEstudante, String nome, float nota, String comentario) {
        this.nrEstudante = nrEstudante;
        this.nome = nome;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNrEstudante() {
        return nrEstudante;
    }

    public void setNrEstudante(int nrEstudante) {
        this.nrEstudante = nrEstudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    
}
