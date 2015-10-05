/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Asus PC
 */
public class EntregaProjeto implements Serializable{
    
    private int id;
    private String descricao;
    private Date data;
    private int tipo;
    private Projeto projeto;

    public EntregaProjeto(int id, String descricao, Date data, int tipo, Projeto projeto) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.projeto = projeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EntregaProjeto() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
    
    
    
}
