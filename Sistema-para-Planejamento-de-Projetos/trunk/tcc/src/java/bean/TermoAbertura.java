/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Asus PC
 */
public class TermoAbertura implements Serializable{
    
    private int id;
    private String introducao;
    private String responsabilidadeGP;
    private String necessidadeBasica;
    private String descricaoProduto;
    private String orcamentoInicial;
    private String necessidadeSuporte;
    private String controleInformacao;
    private List<Aprovacao> aprovadores;
    private List<EntregaProjeto> entregas;
    private Projeto projeto;

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public TermoAbertura(int id, String introducao, String responsabilidadeGP, String necessidadeBasica, String descricaoProduto, String orcamentoInicial, String necessidadeSuporte, String controleInformacao, List<Aprovacao> aprovadores, List<EntregaProjeto> entregas, Projeto projeto) {
        this.id = id;
        this.introducao = introducao;
        this.responsabilidadeGP = responsabilidadeGP;
        this.necessidadeBasica = necessidadeBasica;
        this.descricaoProduto = descricaoProduto;
        this.orcamentoInicial = orcamentoInicial;
        this.necessidadeSuporte = necessidadeSuporte;
        this.controleInformacao = controleInformacao;
        this.aprovadores = aprovadores;
        this.entregas = entregas;
        this.projeto = projeto;
    }


    public TermoAbertura() {
    }

    public List<Aprovacao> getAprovadores() {
        return aprovadores;
    }

    public void setAprovadores(List<Aprovacao> aprovadores) {
        this.aprovadores = aprovadores;
    }

    public List<EntregaProjeto> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<EntregaProjeto> entregas) {
        this.entregas = entregas;
    }
  
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntroducao() {
        return introducao;
    }

    public void setIntroducao(String introducao) {
        this.introducao = introducao;
    }

    public String getResponsabilidadeGP() {
        return responsabilidadeGP;
    }

    public void setResponsabilidadeGP(String responsabilidadeGP) {
        this.responsabilidadeGP = responsabilidadeGP;
    }

    public String getNecessidadeBasica() {
        return necessidadeBasica;
    }

    public void setNecessidadeBasica(String necessidadeBasica) {
        this.necessidadeBasica = necessidadeBasica;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getOrcamentoInicial() {
        return orcamentoInicial;
    }

    public void setOrcamentoInicial(String orcamentoInicial) {
        this.orcamentoInicial = orcamentoInicial;
    }

    public String getNecessidadeSuporte() {
        return necessidadeSuporte;
    }

    public void setNecessidadeSuporte(String necessidadeSuporte) {
        this.necessidadeSuporte = necessidadeSuporte;
    }

    public String getControleInformacao() {
        return controleInformacao;
    }

    public void setControleInformacao(String controleInformacao) {
        this.controleInformacao = controleInformacao;
    }
    
    
    
}
