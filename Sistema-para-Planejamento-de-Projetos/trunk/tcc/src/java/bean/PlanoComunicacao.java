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
public class PlanoComunicacao implements Serializable{
    
    private int id;
    private String interessado;
    private String foco;
    private String informacao;
    private String metodo;
    private String quando;
    
    private Projeto projeto;

    public PlanoComunicacao(int id, String interessado, String foco, String informacao, String metodo, String quando, Projeto projeto) {
        this.id = id;
        this.interessado = interessado;
        this.foco = foco;
        this.informacao = informacao;
        this.metodo = metodo;
        this.quando = quando;
        this.projeto = projeto;
    }



    public PlanoComunicacao() {
    }
    
    
    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoco() {
        return foco;
    }

    public void setFoco(String foco) {
        this.foco = foco;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getQuando() {
        return quando;
    }

    public void setQuando(String quando) {
        this.quando = quando;
    }

    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {
        this.interessado = interessado;
    }


    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
    
    
    
}
