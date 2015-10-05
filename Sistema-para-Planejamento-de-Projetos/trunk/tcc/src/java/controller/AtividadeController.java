/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Atividade;
import java.util.ArrayList;
import java.util.List;
import model.AtividadeModel;

/**
 *
 * @author Asus PC
 */
public class AtividadeController extends Controller {

    private AtividadeModel model;
    private Atividade atividade;
    private List<Atividade> pacotes;
    private List<Atividade> atividades;

    @Override
    public void index() {
        try {
            pacotes = new ArrayList<>();
            atividades = new ArrayList<>();
            model = new AtividadeModel();

            pacotes = model.buscarPacotes(request);
            atividades = model.buscarDependencia(request);

            request.setAttribute("pacotes", pacotes);
            request.setAttribute("atividades", atividades);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("eap/diagrama.jsp");
    }

    public void salvar() {
        try {
            model = new AtividadeModel();
            model.salvar(request);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.index();
    }

    public void carregar() {
        this.index();
    }
}
