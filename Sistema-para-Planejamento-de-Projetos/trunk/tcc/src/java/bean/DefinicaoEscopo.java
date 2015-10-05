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
 * @author Camyla
 */
public class DefinicaoEscopo implements Serializable {

    private int idEscopo;
    private String descricaoEscopo;
    private String criteriosAceitacao;
    private String exclusoesProjeto;
    private String restricoesProjeto;
    private String premissasProjeto;
    private List<EntregaProjeto> entregas;
    private Projeto projeto;

    public DefinicaoEscopo(String descricaoEscopo, String entregasProjeto, String exclusoesProjeto, String premissasProjeto, String casoDeUso, EntregaProjeto entregas) {
        this.descricaoEscopo = descricaoEscopo;
        this.exclusoesProjeto = exclusoesProjeto;
        this.premissasProjeto = premissasProjeto;
        //this.entregas = entregas;
    }

    public DefinicaoEscopo() {
    }

    public String getDescricaoEscopo() {
        return descricaoEscopo;
    }

    public void setDescricaoEscopo(String descricaoEscopo) {
        this.descricaoEscopo = descricaoEscopo;
    }

    public String getExclusoesProjeto() {
        return exclusoesProjeto;
    }

    public void setExclusoesProjeto(String exclusoesProjeto) {
        this.exclusoesProjeto = exclusoesProjeto;
    }

    public String getPremissasProjeto() {
        return premissasProjeto;
    }

    public void setPremissasProjeto(String premissasProjeto) {
        this.premissasProjeto = premissasProjeto;
    }

    public String getRestricoesProjeto() {
        return restricoesProjeto;
    }

    public void setRestricoesProjeto(String restricoesProjeto) {
        this.restricoesProjeto = restricoesProjeto;
    }

    public String getCriteriosAceitacao() {
        return criteriosAceitacao;
    }

    public void setCriteriosAceitacao(String criteriosAceitacao) {
        this.criteriosAceitacao = criteriosAceitacao;
    }

    public int getIdEscopo() {
        return idEscopo;
    }

    public void setIdEscopo(int idEscopo) {
        this.idEscopo = idEscopo;
    }

    public List<EntregaProjeto> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<EntregaProjeto> entregas) {
        this.entregas = entregas;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
