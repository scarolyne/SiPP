/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Camyla
 */
public class PlanoRiscos {

    private int idPlano;
    private String condicaoRisco;
    private String classificacaoRisco;
    private String probabilidadeRisco;
    private String impactoRisco;
    private Projeto projeto;

    public PlanoRiscos() {
          this.projeto = new Projeto();
    }

 
    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getCondicaoRisco() {
        return condicaoRisco;
    }

    public void setCondicaoRisco(String condicaoRisco) {
        this.condicaoRisco = condicaoRisco;
    }

    public String getClassificacaoRisco() {
        return classificacaoRisco;
    }

    public void setClassificacaoRisco(String classificacaoRisco) {
        this.classificacaoRisco = classificacaoRisco;
    }

    public String getProbabilidadeRisco() {
        return probabilidadeRisco;
    }

    public void setProbabilidadeRisco(String probabilidadeRisco) {
        this.probabilidadeRisco = probabilidadeRisco;
    }

    public String getImpactoRisco() {
        return impactoRisco;
    }

    public void setImpactoRisco(String impactoRisco) {
        this.impactoRisco = impactoRisco;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
