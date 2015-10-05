package controller;

import Exception.AlertException;
import Exception.ErrorException;
import model.ProjetoFatorComplexidadeModel;

public class ProjetoFatorComplexidadeController extends Controller {

    ProjetoFatorComplexidadeModel model;

    @Override
    public void index() {
        super.include("indexProjeto.jsp");
    }

    public void salvar() {
        try {
            model = new ProjetoFatorComplexidadeModel();

            model.salvar(request);
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.index();
    }

    public void calculoUC() {
        try {
            model = new ProjetoFatorComplexidadeModel();

            float pontoUC = model.calculoUCAjustados(request);

            if (pontoUC == 0) {
                request.setAttribute("mensagem", 1);
            } else {
                request.setAttribute("pontoUC", pontoUC);
            }

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("pontos_uc/index.jsp");

    }
}
