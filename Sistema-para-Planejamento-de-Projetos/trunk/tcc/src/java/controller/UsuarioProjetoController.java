package controller;

import Exception.ErrorException;
import model.ProjetoModel;
import model.UsuarioProjetoModel;

/**
 *
 * @author Carol
 */
public class UsuarioProjetoController extends Controller {

    private UsuarioProjetoModel model;
    private ProjetoModel modelProj;

    @Override
    public void index() {
        super.home();
    }

    public void atualizar() {
        try {
            this.model = new UsuarioProjetoModel();
            this.modelProj = new ProjetoModel();
            this.model.atualizar(request);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.index();
    }
    
    
    public void editar() {
        try {
            String id = "" + (String) request.getParameter("lastProj");
            int projetoId = Integer.parseInt(id);
            model = new UsuarioProjetoModel();
            model.salvar(request, projetoId);
        } catch (ErrorException ex) {
            request.setAttribute("mensagemErro", ex.getMessage());
        }

        this.home();
    }

    public void excluir() {
        try {
            this.model = new UsuarioProjetoModel();
            this.modelProj = new ProjetoModel();

            this.model.excluir(request);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.index();
    }
}
