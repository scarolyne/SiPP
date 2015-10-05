/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.PlanoRiscosDAO;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.PlanoRiscos;
import bean.Projeto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utils.Filtro;

/**
 *
 * @author Camyla
 */
public class PlanoRiscosModel {

    HttpSession session;

    public void salvar(HttpServletRequest request) throws ErrorException {
        PlanoRiscos plano = new PlanoRiscos();
        PlanoRiscosDAO DAO = new PlanoRiscosDAO();
        Projeto projeto = new Projeto();
        session = request.getSession();
        projeto.setId(Integer.parseInt(""+ (String) session.getAttribute("idProjeto")));
        plano.setProjeto(projeto);
        if (request.getParameter("valida").equals("inserir")) {

            plano.setClassificacaoRisco(request.getParameter("classificacao"));
            plano.setCondicaoRisco(request.getParameter("condicao"));
            plano.setImpactoRisco(request.getParameter("impacto"));
            plano.setProbabilidadeRisco(request.getParameter("probabilidade"));

            DAO.salvar(plano);
        } else if (request.getParameter("valida").equals("editar")) {
            plano.setClassificacaoRisco(request.getParameter("classificacao"));
            plano.setCondicaoRisco(request.getParameter("condicao"));
            plano.setImpactoRisco(request.getParameter("impacto"));
            plano.setProbabilidadeRisco(request.getParameter("probabilidade"));

            DAO.editar(plano);
        }

    }

    public List<PlanoRiscos> buscar(HttpServletRequest request) throws ErrorException, FilterCreationException {

        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        String condicao = "" + (String) request.getParameter("condicao");
        PlanoRiscosDAO dao = new PlanoRiscosDAO();
        session= request.getSession();

        if (!"null".equals(condicao) && !condicao.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("condicao");
            filtro.setValor(condicao);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");
            filtros.add(filtro);
        }
        String classificacao = "" + (String) request.getParameter("classificacao");
        if (!"null".equals(classificacao) && !classificacao.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("classificacao");
            filtro.setValor(classificacao);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");
            filtros.add(filtro);
        }
        String probabilidade = "" + (String) request.getParameter("probabilidade");
        if (!"null".equals(probabilidade) && !probabilidade.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("probabilidade");
            filtro.setValor(probabilidade);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");
            filtros.add(filtro);
        }
        String impacto = "" + (String) request.getParameter("impacto");
        if (!"null".equals(impacto) && !impacto.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("impacto");
            filtro.setValor(impacto);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");
            filtros.add(filtro);
        }
        String id = "" + (String) session.getAttribute("idProjeto");
        if (!"null".equals(id) && !id.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("projeto_id");
            filtro.setValor(id);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            filtros.add(filtro);
        }
        return dao.buscaRiscos(dao.criarFiltro(filtros));
    }

    public PlanoRiscos buscaPorId(int id) throws FilterCreationException, ErrorException {

        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro = new Filtro();
        String where = null;


        PlanoRiscosDAO dao = new PlanoRiscosDAO();
        filtro.setCampo("id");
        filtro.setValor(String.valueOf(id));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        where = dao.criarFiltro(filtro);
        return dao.buscaRiscos(where).get(0);
    }

    public void excluir(int id) throws ErrorException{
      PlanoRiscosDAO dao = new PlanoRiscosDAO();
      dao.excluir(id);

    }
}
