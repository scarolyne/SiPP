package utils;

import bean.Usuario;
import controller.Controller;
import controller.ProjetoController;
import controller.UsuarioController;
import controller.UsuarioProjetoController;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccessUtilities {

    HttpServletRequest request;
    HttpSession session;

    public AccessUtilities(HttpServletRequest request) {
        this.request = request;
        this.session = request.getSession();
    }

    public boolean userIsAuthenticated() {
        return this.session.getAttribute("usuario") != null;
    }

    private boolean isProjectSelected() {
        String idProjeto = "" + (String) this.session.getAttribute("idProjeto");
        return !"null".equals(idProjeto);
    }

    public boolean hasAccessTo(Controller controller, String method) {
        if ( !this.userIsAuthenticated() ) {
            return this.isFreePages(controller, method);
        } else if (!this.isProjectSelected()) {
            return this.isMyProjectPages(controller, method);
        }
        return true;
    }

    private boolean isFreePages(Controller controller, String method) {
        List<String> freeMethods = new ArrayList();

        if (UsuarioController.class.isInstance(controller)) {
            freeMethods.add("logar");
            freeMethods.add("cadastrar");
            freeMethods.add("salvar");
            return freeMethods.contains(method);
        }

        return false;
    }

    private boolean isMyProjectPages(Controller controller, String method) {
        List<String> availableMethods = new ArrayList();

        if (UsuarioProjetoController.class.isInstance(controller)) {
            availableMethods.add("editar");
            availableMethods.add("excluir");
            availableMethods.add("atualizar");
            return availableMethods.contains(method);
        } else if (ProjetoController.class.isInstance(controller)) {
            availableMethods.add("indexProjeto");
            availableMethods.add("salvar");
            availableMethods.add("excluir");
            return availableMethods.contains(method);
        } else if (UsuarioController.class.isInstance(controller)) {
            availableMethods.add("editarEquipe");
            availableMethods.add("verificarEmail");
            availableMethods.add("cadastrar");
            availableMethods.add("salvar");
            availableMethods.add("logout");
            availableMethods.add("index");
            return availableMethods.contains(method);
        }

        return false;
    }

}
