package controller;

import Exception.ErrorException;
import bean.TermoAbertura;

import model.TermoAberturaModel;

/**
 *
 * @author Asus PC
 */
public class TermoAberturaController extends Controller {

    private TermoAberturaModel model;

    public TermoAberturaController() {
        this.model = new TermoAberturaModel();

    }

    @Override
    public void index() {
        super.include("termoAbertura/pesquisa.jsp");
    }

    public void cadastrar() {
        try {
            TermoAbertura termo;
            termo = model.visualizar(request);

            if (termo != null) {
                request.setAttribute("termo", termo);
            }

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        super.include("termoAbertura/cadastrar.jsp");

    }

    public void visualizar() {
        try {
            TermoAbertura termo;

            termo = model.visualizar(request);
            if (termo == null) {
                super.include("termoAbertura/cadastrar.jsp");
            } else {
                request.setAttribute("termo", termo);
                super.include("termoAbertura/visualizar.jsp");
            }

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

    }

    public void salvar() {
        try {
            model.salvar(request);
            request.setAttribute("mensagem", "Pedido Alterado com sucesso!");

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        super.redirect("termoAbertura/cadastrar");
    }

    public void editar() {
        super.include("termoAbertura/");
    }
}
