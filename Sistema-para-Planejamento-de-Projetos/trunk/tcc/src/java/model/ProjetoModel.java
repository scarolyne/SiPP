/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DefinicaoEscopoDAO;
import DAO.ProjetoDAO;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Projeto;
import bean.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utils.Filtro;

/**
 *
 * @author Carol
 */
public class ProjetoModel extends Model {

    Projeto projeto;
    Usuario usuario;
    ProjetoDAO dao;
    HttpSession session;

    public int salvar(HttpServletRequest request) throws ErrorException {

        projeto = new Projeto();
        usuario = new Usuario();
        dao = new ProjetoDAO();

        String titulo = request.getParameter("titulo");
        int gerente = Integer.parseInt(request.getParameter("gerente"));

        usuario.setId(gerente);
        projeto.setGerente(usuario);
        projeto.setTitulo(titulo);

        projeto = dao.salvar(projeto);

        DefinicaoEscopoDAO def = new DefinicaoEscopoDAO();

       // def.inserir(projeto.getId());

        return projeto.getId();
    }

    public void excluir(int id) throws ErrorException {
        dao = new ProjetoDAO();
        dao.excluir(id);
    }

    public List<Projeto> buscar(HttpServletRequest request) throws ErrorException, FilterCreationException {
        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        session = request.getSession();
        dao = new ProjetoDAO();

        String gerente = session.getAttribute("idUsuario").toString();

        if (!gerente.equals("null") && !gerente.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("gerente_projeto");
            filtro.setValor(gerente);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            filtros.add(filtro);
        }
        String projeto = "" + (String) session.getAttribute("idProjeto");

        if (!"null".equals(projeto) && !projeto.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("projeto.id");
            filtro.setValor(projeto);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            filtros.add(filtro);
        }

        filtro = new Filtro();
        filtro.setCampo("data_exclusao");
        filtro.setValor("");
        filtro.setOperador("AND");
        filtro.setTipo("NULL");
        filtros.add(filtro);

        return dao.buscarProjeto(dao.criarFiltro(filtros));
    }

    public List<Projeto> buscarPendencias(HttpServletRequest request) throws ErrorException, FilterCreationException {

        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        session = request.getSession();
        dao = new ProjetoDAO();

        String gerente = session.getAttribute("idUsuario").toString();

        if (!gerente.equals("null") && !gerente.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("up.usuario_id");
            filtro.setValor(gerente);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            filtros.add(filtro);
        }

        filtro = new Filtro();
        filtro.setCampo("p.data_exclusao");
        filtro.setValor("");
        filtro.setOperador("AND");
        filtro.setTipo("NULL");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("up.aprovacao");
        filtro.setValor("");
        filtro.setOperador("AND");
        filtro.setTipo("NULL");
        filtros.add(filtro);

        return dao.buscarPendencias(dao.criarFiltro(filtros));
    }

    public List<Projeto> buscarEquipe(HttpServletRequest request) throws ErrorException, FilterCreationException {

        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        session = request.getSession();
        dao = new ProjetoDAO();

        String gerente = session.getAttribute("idUsuario").toString();

        if (!gerente.equals("null") && !gerente.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("up.usuario_id");
            filtro.setValor(gerente);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            filtros.add(filtro);
        }

        filtro = new Filtro();
        filtro.setCampo("p.data_exclusao");
        filtro.setValor("");
        filtro.setOperador("AND");
        filtro.setTipo("NULL");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("coalesce(up.aprovacao, 'N')");
        filtro.setValor("S");
        filtro.setOperador("AND");
        filtro.setTipo("LIKEALL");
        filtros.add(filtro);

        return dao.buscarPendencias(dao.criarFiltro(filtros));
    }
}
