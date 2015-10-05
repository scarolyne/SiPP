package model;

import DAO.ProjetoDAO;
import DAO.UsuarioProjetoDAO;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Projeto;
import bean.Usuario;
import bean.UsuarioProjeto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utils.Filtro;

/**
 *
 * @author Carol
 */
public class UsuarioProjetoModel extends Model {

    UsuarioProjeto usuarioProjeto;
    UsuarioProjetoDAO dao;
    HttpSession session;

    public void salvar(HttpServletRequest request, int projetoId) throws ErrorException {
        String[] equipeArray = request.getParameterValues("usuario[]");
        dao = new UsuarioProjetoDAO();
        for (String equipe : equipeArray) {
            if (!equipe.equals("") && !equipe.isEmpty()) {
                dao.salvar(equipe, projetoId);
            }
        }
    }

    public void excluir(HttpServletRequest request) throws ErrorException {
        String id = "" + request.getAttribute("id");
        String idProjeto = "" + request.getAttribute("idProjeto");
        dao = new UsuarioProjetoDAO();
        dao.excluir(Integer.parseInt(id), Integer.parseInt(idProjeto));
    }

    public void atualizar(HttpServletRequest request) throws ErrorException {
        String aprov = "" + request.getParameter("aprovarProj");
        String recus = "" + request.getParameter("recusarProj");
        String gerente = "" + request.getParameter("gerente");

        dao = new UsuarioProjetoDAO();

        if (!aprov.equals("") && !aprov.isEmpty()) {
            dao.atualizar(gerente, aprov, "S");
        }
        else if (!recus.equals("") && !recus.isEmpty()) {
            dao.atualizar(gerente, recus, "N");
        }
    }
    
    public List<UsuarioProjeto> buscarEquipe(HttpServletRequest request) throws ErrorException, FilterCreationException {
        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        String projeto = request.getAttribute("id").toString();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        dao = new UsuarioProjetoDAO();

        if (!projeto.equals("null") && !projeto.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("up.projeto_id");
            filtro.setValor(projeto);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            filtros.add(filtro);
        }

        filtro = new Filtro();
        filtro.setCampo("COALESCE(up.aprovacao, 'S')");
        filtro.setValor("N");
        filtro.setOperador("AND");
        filtro.setTipo("NOTLIKE");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("u.id");
        filtro.setValor(String.valueOf(usuario.getId()));
        filtro.setOperador("AND");
        filtro.setTipo("NOT_EQUAL");
        filtros.add(filtro);

        return dao.buscarEquipe(dao.criarFiltro(filtros));
    }
}
