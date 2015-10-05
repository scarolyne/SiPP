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
public class ProjetoFatorComplexidade implements Serializable{
    
    private int id;
    private FatorComplexidade fator;
    private Projeto projeto;
    private int classificacao;

    public ProjetoFatorComplexidade() {
        projeto = new Projeto();
        fator = new FatorComplexidade();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FatorComplexidade getFator() {
        return fator;
    }

    public void setFator(FatorComplexidade fator) {
        this.fator = fator;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
    
    
    
    
}
