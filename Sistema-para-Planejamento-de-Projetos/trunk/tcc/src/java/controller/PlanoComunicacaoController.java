    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.PlanoComunicacao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PlanoComunicacaoModel;

/**
 *
 * @author Asus PC
 */
public class PlanoComunicacaoController extends Controller {

    private PlanoComunicacaoModel model;
    private PlanoComunicacao plano;

    public PlanoComunicacaoController() {
        model = new PlanoComunicacaoModel();
    }

    @Override
    public void index() {
        super.include("planoComunicacao/pesquisar.jsp");
    }

    public void cadastrar() {
        super.include("planoComunicacao/cadastrar.jsp");

    }

    public void buscar() {
        try {
            List<PlanoComunicacao> planos = model.buscarPlanoComunicacao(request);
            if(planos.isEmpty()){
                throw new AlertException("Nenhum plano de comunicação foi encontrado.");
            }
            
            String interessado = "" + (String) request.getParameter("interessado");
            if (!"null".equals(interessado) && !interessado.isEmpty()) {
                request.setAttribute("interessado", interessado);
            }
            
             String metodo = "" + (String) request.getParameter("metodo");
            if (!"null".equals(metodo) && !metodo.isEmpty()) {
                request.setAttribute("metodo", metodo);
            }
            
             String quando = "" + (String) request.getParameter("quando");
            if (!"null".equals(quando) && !quando.isEmpty()) {
                request.setAttribute("quando", quando);
            }
            
            request.setAttribute("planos", planos);
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }
        this.index();
    }

    public void salvar() {
        try {
            model.salvar(request);
            super.setSuccessMessage("Plano de Comunicação inserido com sucesso");
            
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.index();
    }

    public void editar() {
        try {
            plano = model.buscarPlanoComunicacaoPorId(request);
            request.setAttribute("plano", plano);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (FilterCreationException ex) {
            Logger.getLogger(PlanoComunicacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cadastrar();
    }

    public void excluir() {
        try {
            model.excluir(request);
            super.setSuccessMessage("Plano de Comunicação excluido com sucesso");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.index();
    }
}
