/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Asus PC
 */
public class Atividade implements Serializable{

    private int id;
    private String nome;
    private int esforcoEstimado;
    private Projeto projeto;
    private String sequenciamento;
    private long inicio;
    private long fim;
    private int duracao;
    private String descricao;
    private int progresso;
    private char status;
    private int idPacote;
    private List<AtividadeProfissional> atividadeProfissionais;

    public String getSequenciamento() {
        return sequenciamento;
    }

    public void setSequenciamento(String sequenciamento) {
        this.sequenciamento = sequenciamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getFim() {
        return fim;
    }

    public void setFim(long fim) {
        this.fim = fim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public char getStatus() {
        return status;
    }

    public String getStatus(Boolean formatar) {
        String status;

        switch(this.status) {
            case 'A':
                status = "STATUS_ACTIVE";
                break;

            case 'F':
                status = "STATUS_FAILED";
                break;

            case 'S':
                status = "STATUS_SUSPENDED";
                break;

            case 'D':
                status = "STATUS_DONE";
                break;

            case 'U':
            default:
                status = "STATUS_UNDEFINED";
                break;
        }

        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setStatus(String status) {

        switch(status) {
            case "STATUS_ACTIVE":
                this.status = 'A';
                break;

            case "STATUS_FAILED":
                this.status = 'F';
                break;

            case "STATUS_SUSPENDED":
                this.status = 'S';
                break;

            case "STATUS_DONE":
                this.status = 'D';
                break;

            case "STATUS_UNDEFINED":
            default:
                this.status = 'U';
                break;
        }

    }

    public int getEsforcoEstimado() {
        return esforcoEstimado;
    }

    public void setEsforcoEstimado(int esforcoEstimado) {
        this.esforcoEstimado = esforcoEstimado;
    }

    public List<AtividadeProfissional> getAtividadeProfissionais() {
        return atividadeProfissionais;
    }

    public void setAtividadeProfissionais(List<AtividadeProfissional> atividadeProfissionais) {
        this.atividadeProfissionais = atividadeProfissionais;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Atividade() {
        this.projeto = new Projeto();
        this.atividadeProfissionais = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public int getIdPacote() {
        return idPacote;
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

    public void loadJSON(JSONObject atividadeJSON) {

        if ( atividadeJSON.has("id") ) {
            setId(atividadeJSON.getInt("id"));
        }

        if ( atividadeJSON.has("name") ) {
            setNome(atividadeJSON.getString("name"));
        }

        if ( atividadeJSON.has("start") ) {
            setInicio(atividadeJSON.getLong("start"));
        }

        if ( atividadeJSON.has("end") ) {
            setFim(atividadeJSON.getLong("end"));
        }

        if ( atividadeJSON.has("duration") ) {
            setDuracao(atividadeJSON.getInt("duration"));
        }

        if ( atividadeJSON.has("description") ) {
            setDescricao(atividadeJSON.getString("description"));
        }

        if ( atividadeJSON.has("progress") ) {
            setProgresso(atividadeJSON.getInt("progress"));
        }

        if ( atividadeJSON.has("status") ) {
            setStatus(atividadeJSON.getString("status"));
        }

    }

}
