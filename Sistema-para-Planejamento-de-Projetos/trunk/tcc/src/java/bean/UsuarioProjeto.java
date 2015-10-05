/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

/**
 *
 * @author Asus PC
 */
public class UsuarioProjeto {
    
    private Usuario usuario;
    private Projeto projeto;
    private String cargo;

    public UsuarioProjeto(Usuario usuario, Projeto projeto) {
        this.usuario = usuario;
        this.projeto = projeto;
    }

    public UsuarioProjeto() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
