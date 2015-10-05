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
public class FatorComplexidade implements Serializable{
    
    private int id;
    private String nome;
    private float peso;
    private String tipo;

    public FatorComplexidade() {
    }

    public FatorComplexidade(int id, String nome, float peso, String tipo) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }


  
    
}
