/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;

/**
 *
 * @author Asus PC
 */
public class Cargo implements Serializable{

    private int id;
    private String nome;
    private Projeto projeto;
    private double valorHora;

    public Cargo() {
        this.projeto = new Projeto();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Cargo(int id, String nome, Projeto projeto) {
        this.id = id;
        this.nome = nome;
        this.projeto = projeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public String getPreco() {
        return String.format("%.2f", valorHora).replaceAll("\\.", ",");
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }


}
