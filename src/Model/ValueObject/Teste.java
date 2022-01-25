/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ValueObject;

import java.sql.Date;

/**
 *
 * @author isacl
 */
public class Teste {

    private int idTeste;
    private String tipo;
    private Date dataRealizacao;
    private float peso;
    private int idAnoAcademico;
    private int idDisciplina;

    public Teste(int idTeste, String tipo, Date dataRealizacao, float peso, int idAnoAcademico, int idDisciplina) {
        this.idTeste = idTeste;
        this.tipo = tipo;
        this.dataRealizacao = dataRealizacao;
        this.peso = peso;
        this.idAnoAcademico = idAnoAcademico;
        this.idDisciplina = idDisciplina;
    }

    public int getIdTeste() {
        return idTeste;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public float getPeso() {
        return peso;
    }

    public int getIdAnoAcademico() {
        return idAnoAcademico;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public String toString(String est, String disc, String anoAcademico) {
        String format = "%-20s %-20s %-20s %-20s %-20s %-20s %-20s";
        return String.format(format, idTeste, est, disc, tipo, dataRealizacao, peso, anoAcademico);
    }
}
