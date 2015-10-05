package bean;

import java.io.Serializable;


public class AtividadeSequencia implements Serializable {

    private Atividade atividade;
    private Atividade atividadeAnterior;

    public AtividadeSequencia() {
        this.atividade = new Atividade();
        this.atividadeAnterior = new Atividade();
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Atividade getAtividadeAnterior() {
        return atividadeAnterior;
    }

    public void setAtividadeAnterior(Atividade atividadeAnterior) {
        this.atividadeAnterior = atividadeAnterior;
    }

}
