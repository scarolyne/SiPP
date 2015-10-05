package controller;

import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Projeto;
import bean.Usuario;
import bean.UsuarioProjeto;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.ProjetoModel;
import model.UsuarioModel;
import model.UsuarioProjetoModel;

/**
 *
 * @author Asus PC
 */
public class UsuarioController extends Controller {

    private UsuarioModel model;
    private ProjetoModel modelProj;
    private UsuarioProjetoModel modelUP;
    private Usuario user;
    private List<Projeto> projeto;
    private List<Projeto> pendencias;
    private List<Projeto> projEquipe;
    private List<UsuarioProjeto> equipe;
    HttpSession session;

    public UsuarioController() {
        this.model = new UsuarioModel();
        this.modelProj = new ProjetoModel();
        this.modelUP = new UsuarioProjetoModel();
    }

    @Override
    public void index() {
        try {
            session = request.getSession();
            session.removeAttribute("idProjeto");
            this.projeto = this.modelProj.buscar(request);
            this.pendencias = this.modelProj.buscarPendencias(request);
            this.projEquipe = this.modelProj.buscarEquipe(request);

            request.setAttribute("projetos", this.projeto);
            request.setAttribute("projetoEquipe", this.projEquipe);
            request.setAttribute("pendProjetos", this.pendencias);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.menu = "Meus Projetos";

        super.include("usuario/iniciar.jsp");
    }

    public void cadastrar() {

        try {
            this.user = new Usuario();
            session = request.getSession();

            if (session.getAttribute("nomeUsuario") != null && !session.getAttribute("nomeUsuario").equals("")) {

                int idUser = (int) session.getAttribute("idUsuario");
                this.user = this.model.buscarPorId(idUser);

                request.setAttribute("user", this.user);
            }
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }
        super.menu = "Minha Conta";

        super.include("usuario/cadastrar.jsp");
    }

    public void salvar() {
        boolean sucesso = false;
        try {

            this.model.salvar(request);

            sucesso = true;

            super.setSuccessMessage("Usuário salvo com sucesso!");

            request.setAttribute("nomeUsuario", request.getParameter("nomeUsuario"));

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }
        if (sucesso) {
            this.logar();
        } else {
            super.redirect("usuario/cadastrar");
        }

    }

    public void login() {
        super.menu = "Login";

        super.include("usuario/login.jsp");
    }

    public void logar() {
        try {
            List<Usuario> usuarios;
            usuarios = this.model.buscar(request);

            if (usuarios.isEmpty()) {
                request.setAttribute("mensagemErro", "Email ou senha incorretos. Por favor, tente novamente!");
                request.setAttribute("email", request.getParameter("email"));
                this.login();
            } else {
                request.setAttribute("mensagem", "Seja Bem vindo!");
                iniciarSessao();
                this.index();
            }
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }
    }

    private void iniciarSessao() throws ErrorException, FilterCreationException {
        Usuario usuario;
        session = request.getSession(true);

        // TODO ( remover linha abaixo ou setar sessao menor posteriormente )
        session.setMaxInactiveInterval(60*60);

        usuario = this.model.buscar(request).get(0);

        /*
         * Nao criar novos atributos de uma entidade.. adicione a entidade no lugar
         */
        session.setAttribute("nomeUsuario", usuario.getNome());
        session.setAttribute("idUsuario", usuario.getId());

        session.setAttribute("usuario", usuario);

    }

    public void logout() {
        session = request.getSession();
        session.invalidate();
        this.login();
    }

    public void editarEquipe() {
        try {
            equipe = null;

            String idProjeto = "" + request.getAttribute("id");
            request.setAttribute("idProjeto", idProjeto);

            equipe = this.modelUP.buscarEquipe(request);
            request.setAttribute("equipe", equipe);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("usuario/editarEquipe.jsp");
    }

    public void verificarEmail() {
        try {
            String email = request.getAttribute("email").toString();
            Usuario usuario = this.model.buscarPorEmail(email);
            if (usuario != null){
                request.setAttribute("idUsuarioEquipe", usuario.getId());
            } else {
                request.setAttribute("idUsuarioEquipe", 0);
            }

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("usuario/editarEquipe.jsp");
    }

    public void carregarDados() {
        this.index();
    }
}
