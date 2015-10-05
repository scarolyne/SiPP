package controller;

import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Atividade;
import bean.Profissional;
import java.util.List;
import model.PlanoCustoModel;
import model.ProfissionalModel;

public class PlanoCustoController extends Controller {

    private PlanoCustoModel model;

    public PlanoCustoController() {
        this.model = new PlanoCustoModel();
    }

    @Override
    public void index() {
        this.cadastrar();
    }

    public void cadastrar() {

        try {
            ProfissionalModel profissionalModel = new ProfissionalModel();
            List<Atividade> atividades;
            List<Profissional> profissionais;

            atividades = model.buscar(request);
            profissionais = profissionalModel.buscar(request);

            if (atividades.isEmpty()) {
                throw new AlertException("Para acessar o Plano de custo é necessário cadastrar atividades.");
            }
            if (profissionais.isEmpty()) {
                throw new AlertException("Para acessar o Plano de custo é necessário cadastrar profissionais.");
            }

            request.setAttribute("atividades", atividades);
            request.setAttribute("profissionais", profissionais);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("plano_custo/index.jsp");
    }

    public void removerAtividadeProfissional() {

        try {
            model.excluir(request);

            super.setSuccessMessage("Profissional removido com sucesso.");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.redirect("PlanoDeCusto");
    }

    public void salvar() {
        try {
            model.salvar(request);

            super.setSuccessMessage("Profissional adicionado com sucesso.");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        super.redirect("PlanoDeCusto");
    }
}
