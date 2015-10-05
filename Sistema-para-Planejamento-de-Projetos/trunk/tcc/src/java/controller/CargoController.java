package controller;

import Exception.AlertException;
import Exception.ErrorException;
import bean.Cargo;
import java.util.ArrayList;
import java.util.List;
import model.CargoModel;

public class CargoController extends Controller {

    private CargoModel model;

    public CargoController() {
        this.model = new CargoModel();
    }

    @Override
    public void index() {
        super.include("cargo/pesquisar.jsp");
    }

    public void cadastrar() {
        request.getSession();
        super.include("cargo/cadastrar.jsp");
    }

    public void salvar() {
        Cargo cargo = new Cargo();
        try {
            cargo = model.salvar(request);

            super.setSuccessMessage("Função salva com sucesso.");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        super.redirect("cargo/editar/id/" + cargo.getId());
    }

    public void buscar() {
        try {
            List<Cargo> cargos;

            cargos = model.buscar(request);

            request.setAttribute("cargos", cargos);

            String nome = "" + (String) request.getParameter("cargo");
            if (!"null".equals(nome) && !nome.isEmpty()) {
                request.setAttribute("nome", nome);
            }

            String preco = "" + (String) request.getParameter("preco");
            if (!"null".equals(preco) && !preco.isEmpty()) {
                request.setAttribute("preco", preco);
            }

            if (cargos.isEmpty()) {
                throw new AlertException("Nenhuma função encontrada.");
            }

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        this.index();
    }

    public void editar() {
        try {
            CargoModel model = new CargoModel();
            Cargo cargo = new Cargo();


            String id = "" + (String) request.getAttribute("id");
            System.out.println(id);

            if ("null".equals(id)) {
                throw new AlertException("Cargo invalido.");
            }

            cargo = model.buscaPorId(Integer.parseInt(id));

            request.setAttribute("cargo", cargo);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        this.cadastrar();
    }

    public void excluir() {
        try {
            String id = "" + (String) request.getAttribute("id");

            if ("null".equals(id)) {
                throw new AlertException("Cargo invalido.");
            }

            CargoModel cargo = new CargoModel();

            cargo.excluir(Integer.parseInt(id));

            super.setSuccessMessage("Cargo excluido com sucesso.");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.redirect("cargo");
    }
}
