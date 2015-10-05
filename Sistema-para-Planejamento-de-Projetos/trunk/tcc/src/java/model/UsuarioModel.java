package model;

import DAO.UsuarioDAO;
import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import utils.Filtro;

/**
 *
 * @author Asus PC
 */
public class UsuarioModel extends Model {

    private UsuarioDAO dao;

    public UsuarioModel() {
        this.dao = new UsuarioDAO();
    }

    public void salvar(HttpServletRequest request) throws ErrorException, AlertException {
        int id = Integer.parseInt(request.getParameter("id_user"));
        Usuario usuarioGravar;
        Usuario usuarioEncontrado;

        usuarioEncontrado = this.buscarPorEmail(request.getParameter("email"));
        if (usuarioEncontrado != null && usuarioEncontrado.getId() != id) {
            throw new AlertException("Email já cadastrado! Tente novamente!");
        }

        usuarioGravar = new Usuario(id, request.getParameter("nome"), request.getParameter("sobrenome"), request.getParameter("email"), request.getParameter("senha"));

        if (id == 0) {
            dao.salvar(usuarioGravar);
        } else {
            usuarioGravar.setSenha("");
            if (!request.getParameter("senhaAtual").isEmpty()) {

                if (this.buscarPorSenha(request.getParameter("senhaAtual")) != null) {
                    usuarioGravar.setSenha(String.valueOf(request.getParameter("senha")));
                } else {
                    throw new AlertException("A senha atual está incorreta!");
                }
            }
            dao.editar(usuarioGravar);
        }
    }

    public Usuario buscarPorId(int id) throws ErrorException, FilterCreationException {
        Filtro filtro = new Filtro();

        filtro.setCampo("usuario.id");
        filtro.setValor(String.valueOf(id));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");

        String where = dao.criarFiltro(filtro);
        return dao.buscar(where).get(0);
    }

    public List<Usuario> buscar(HttpServletRequest request) throws ErrorException, FilterCreationException {
        Filtro filtro;
        List<Filtro> filtros = new ArrayList();

        String email = "" + (String) request.getParameter("email");
        if (!"null".equals(email) && !email.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("usuario.email");
            filtro.setValor(email);
            filtro.setOperador("AND");
            filtro.setTipo("LIKE");

            filtros.add(filtro);
        }

        String senha = "" + (String) request.getParameter("senha");
        if (!"null".equals(senha) && !senha.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("usuario.senha");
            filtro.setValor(senha);
            filtro.setOperador("AND");
            filtro.setTipo("EQUALMD5");

            filtros.add(filtro);
        }

        return dao.buscar(dao.criarFiltro(filtros));
    }

    public Usuario buscarPorSenha(String senha) throws ErrorException, FilterCreationException {
        Filtro filtro;
        Usuario usuario = null;
        List<Usuario> listUsuario;
        filtro = new Filtro();
        filtro.setCampo("usuario.senha");
        filtro.setValor(senha);
        filtro.setOperador("AND");
        filtro.setTipo("EQUALMD5");

        listUsuario = dao.buscar(dao.criarFiltro(filtro));
        if (!listUsuario.isEmpty()) {
            usuario = listUsuario.get(0);
        }

        return usuario;
    }

    public Usuario buscarPorEmail(String email) throws ErrorException, FilterCreationException {
        Filtro filtro;
        Usuario usuario = null;
        List<Usuario> usuarios;

        filtro = new Filtro();
        filtro.setCampo("usuario.email");
        filtro.setValor(email);
        filtro.setOperador("AND");
        filtro.setTipo("LIKE");

        usuarios = dao.buscar(dao.criarFiltro(filtro));
        if (!usuarios.isEmpty()) {
            usuario = usuarios.get(0);
        }

        return usuario;
    }
}
