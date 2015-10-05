package controller;

import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Cargo;
import bean.Profissional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CargoModel;
import model.ProfissionalModel;

public class ProfissionalController extends Controller {

    private ProfissionalModel model;

    public ProfissionalController() {
        this.model = new ProfissionalModel();
    }

    @Override
    public void index() {
        boolean redirecionarCargo = false;

        try {
            List<Cargo> cargos;
            CargoModel cargoModel = new CargoModel();

            cargos = cargoModel.buscar(request);

            if (cargos.isEmpty()) {
                redirecionarCargo = true;
                throw new AlertException("Para acessar o cadastro de profissionais é necessário cadastrar funções.");
            }

            request.setAttribute("cargos", cargos);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        if ( redirecionarCargo ) {
            super.redirect("cargo/cadastrar");
        } else {
            super.include("profissional/pesquisa.jsp");
        }

    }

    public void pesquisar() {
        try {

            Profissional profissional = new Profissional();
            List<Profissional> profissionais;

            profissionais = model.buscar(request);

            request.setAttribute("profissionais", profissionais);

            String nome = "" + (String) request.getParameter("nome");
            if (!"null".equals(nome) && !nome.isEmpty()) {
                profissional.setNome(nome);
            }

            String cargo = "" + (String) request.getParameter("cargo");
            if (!"null".equals(cargo) && !cargo.isEmpty()) {
                profissional.getCargo().setId(Integer.parseInt(cargo));
            }

            request.setAttribute("profissional", profissional);

            if (profissionais.isEmpty()) {
                throw new AlertException("Nenhum profissional foi encontrado.");
            }

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        this.index();
    }

    public void cadastrar() {
        CargoModel cargoModel = new CargoModel();
        try {
            request.setAttribute("cargos", cargoModel.buscar(request));

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("profissional/cadastro.jsp");

    }

    public void salvar() {
        Profissional profissional = new Profissional();

        try {
            profissional = this.model.salvar(request);

            super.setSuccessMessage("Profissional salvo com sucesso.");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        if (profissional.getId() > 0) {
            super.redirect("Profissional/editar/id/" + profissional.getId());
        }

        super.redirect("Profissional");
    }

    public void editar() {
        Profissional profissional = new Profissional();

        try {
            String id = "" + (String) request.getAttribute("id");
            if ("null".equals(id)) {
                throw new AlertException("Profissional invalido.");
            }

            profissional = this.model.buscarPorId(Integer.parseInt(id));
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        request.setAttribute("profissional", profissional);

        this.cadastrar();
    }

    public void excluir() {

        try {
            String id = "" + (String) request.getAttribute("id");
            if ("null".equals(id)) {
                throw new AlertException("Profissional invalido.");
            }

            this.model.excluir(Integer.parseInt(id));

            super.setSuccessMessage("Profissional excluido com sucesso.");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        this.redirect("Profissional");
    }
}
