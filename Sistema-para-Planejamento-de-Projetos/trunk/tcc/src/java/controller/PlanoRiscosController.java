/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.AlertException;
import Exception.ErrorException;
import bean.PlanoRiscos;
import java.util.List;
import model.PlanoRiscosModel;

/**
 *
 * @author Camyla
 */
public class PlanoRiscosController extends Controller {

    public void cadastrar() {
        super.include("planoRiscos/cadastrar.jsp");
    }

    @Override
    public void index() {
        super.include("planoRiscos/pesquisar.jsp");
    }

    public void salvar() {

        try {
            PlanoRiscosModel model = new PlanoRiscosModel();
            model.salvar(request);

            super.setSuccessMessage("Risco salvo com sucesso.");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.index();

    }

    public void buscar() {
        try {
            PlanoRiscosModel model = new PlanoRiscosModel();

            List<PlanoRiscos> plano = model.buscar(request);

            String condicao;
            String probabilidade;
            String classificacao;
            String impacto;

            condicao = "" + (String) request.getParameter("condicao");

            if (!"null".equals(condicao) && !condicao.isEmpty()) {
                request.setAttribute("condicao", condicao);
            }
            probabilidade = "" + (String) request.getParameter("probabilidade");

            if (!"null".equals(probabilidade) && !probabilidade.isEmpty()) {
                request.setAttribute("probabilidade", probabilidade);
            }

            classificacao = "" + (String) request.getParameter("classificacao");

            if (!"null".equals(classificacao) && !classificacao.isEmpty()) {
                request.setAttribute("classificacao", classificacao);
            }
            impacto = "" + (String) request.getParameter("impacto");

            if (!"null".equals(impacto) && !impacto.isEmpty()) {
                request.setAttribute("impacto", impacto);
            }

            if (plano.isEmpty()) {
                throw new AlertException("Nenhum resultado encontrado.");
            } else {
                request.setAttribute("registros", plano);
            }

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("planoRiscos/pesquisar.jsp");
    }

    public void editar() {
        PlanoRiscosModel model = new PlanoRiscosModel();
        PlanoRiscos plano = new PlanoRiscos();

        try {
            String id = "" + (String) request.getAttribute("id");
            if ("null".equals(id)) {
                throw new AlertException("Plano de riscos invalido.");
            }

            plano = model.buscaPorId(Integer.parseInt(id));

            request.setAttribute("plano", plano);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("planoRiscos/cadastrar.jsp");
    }

    public void excluir() {
        PlanoRiscosModel model = new PlanoRiscosModel();

        try {
            String id = "" + (String) request.getAttribute("id");
            if ("null".equals(id)) {
                throw new AlertException("Plano de riscos invalido.");
            }

            model.excluir(Integer.parseInt(id));

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        this.index();
    }
}
