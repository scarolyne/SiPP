/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.FatorComplexidade;
import bean.ProjetoFatorComplexidade;
import java.util.ArrayList;
import java.util.List;
import model.FatorComplexidadeModel;
import model.ProjetoFatorComplexidadeModel;

/**
 *
 * @author Asus PC
 */
public class FatorComplexidadeController extends Controller {

    FatorComplexidadeModel model;

    @Override
    public void index() {
        buscarFatoresTecnico();
    }

    public void buscarFatoresTecnico() {
        model = new FatorComplexidadeModel();
        ProjetoFatorComplexidadeModel modelProjFC = new ProjetoFatorComplexidadeModel();
        try {
            List<FatorComplexidade> fatores;
            List<ProjetoFatorComplexidade> projetosClassificacao = new ArrayList();
            ProjetoFatorComplexidade projetoFC;

            fatores = model.buscarFatorTecnico();

            for (FatorComplexidade fator : fatores) {
                projetoFC = modelProjFC.buscarPorId(request, fator.getId());
                if (projetoFC != null) {
                    projetosClassificacao.add(projetoFC);
                }
            }

            if (!projetosClassificacao.isEmpty()) {
                fatores = new ArrayList();
            }

            request.setAttribute("projetoFatoresComplexidade", projetosClassificacao);
            request.setAttribute("fatores", fatores);


        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("pontos_uc/cadastrarFatorTecnico.jsp");
    }

    public void buscarFatoresAmbiental() {
         ProjetoFatorComplexidadeModel modelProjFC = new ProjetoFatorComplexidadeModel();
        model = new FatorComplexidadeModel();
        try {
            List<FatorComplexidade> fatores = new ArrayList<>();
            fatores = model.buscarFatorAmbiental();
            ProjetoFatorComplexidade projetoFC;
            List<ProjetoFatorComplexidade> projetosClassificacao = new ArrayList();

            for (FatorComplexidade fator : fatores) {
                projetoFC = modelProjFC.buscarPorId(request, fator.getId());
                if (projetoFC != null) {
                    projetosClassificacao.add(projetoFC);
                }
            }

            if (!projetosClassificacao.isEmpty()) {
                fatores = new ArrayList();
            }

            request.setAttribute("projetoFatoresComplexidade", projetosClassificacao);
            request.setAttribute("fatores", fatores);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("pontos_uc/cadastrarFatorAmbiental.jsp");
    }

}
