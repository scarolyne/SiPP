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
public class Aprovacao implements Serializable{
    
    private int id;
    private String nome;


    public Aprovacao(int id, String nome) {
        this.id = id;
        this.nome = nome;
      
    }

    public Aprovacao() {
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
    
    
    
}
