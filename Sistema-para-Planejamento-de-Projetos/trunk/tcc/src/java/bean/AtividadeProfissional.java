package bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import org.json.JSONObject;

public class AtividadeProfissional implements Serializable {

    private Profissional profissional;
    private Atividade atividade;
    private long esforco;

    public AtividadeProfissional() {
        this.profissional = new Profissional();
        this.atividade = new Atividade();
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public long getEsforco() {
        return esforco;
    }

    public void setEsforco(long esforco) {
        this.esforco = esforco;
    }

    public int getQuantidadeHoras() {
        return (int) (esforco/1000/60/60);
    }

    public void loadJSON(JSONObject profissionalJSON) {

        getProfissional().setId(profissionalJSON.getInt("resourceId"));

        if (profissionalJSON.has("effort")) {
            setEsforco(profissionalJSON.getInt("effort"));
        }

    }
}
