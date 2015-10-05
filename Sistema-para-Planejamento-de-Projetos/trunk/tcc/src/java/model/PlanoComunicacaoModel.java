/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.PlanoComunicacaoDAO;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.PlanoComunicacao;
import bean.Projeto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utils.Filtro;

/**
 *
 * @author Asus PC
 */
public class PlanoComunicacaoModel {

    private PlanoComunicacao plano;
    private HttpSession session;
    private Projeto projeto;

    public void salvar(HttpServletRequest request) throws ErrorException{

         int id;
         if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
                id = 0;
             }else{
                id = Integer.parseInt(request.getParameter("id"));
            }

         session = request.getSession();
         int idProjeto = Integer.parseInt(""+(String) session.getAttribute("idProjeto"));

         projeto = new Projeto();
         projeto.setId(idProjeto);
         plano = new PlanoComunicacao(id, request.getParameter("interessado"), request.getParameter("foco"), request.getParameter("informacao"), request.getParameter("metodo"), request.getParameter("quando"), projeto);

        PlanoComunicacaoDAO dao = new PlanoComunicacaoDAO();
        if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
            dao.salvar(plano);
        }else{
            dao.editar(plano);
        }

    }


        public PlanoComunicacao buscarPlanoComunicacaoPorId (HttpServletRequest request) throws ErrorException, FilterCreationException{
        List<PlanoComunicacao> planos = new ArrayList<>();
        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        PlanoComunicacaoDAO dao = new PlanoComunicacaoDAO();

        session = request.getSession();
        String id = "" +(String) request.getAttribute("id") ;

            filtro = new Filtro();
            filtro.setCampo("id");
            filtro.setValor(id);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            filtros.add(filtro);
        

        return dao.buscaPlanoComunicacao(dao.criarFiltro(filtro)).get(0);
    }
    
    
    public List<PlanoComunicacao> buscarPlanoComunicacao (HttpServletRequest request) throws ErrorException, FilterCreationException{
        List<PlanoComunicacao> planos = new ArrayList<>();
        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        PlanoComunicacaoDAO dao = new PlanoComunicacaoDAO();
        String interessado = "" + (String) request.getParameter("interessado");
        if (!"null".equals(interessado) && !interessado.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("interessado");
            filtro.setValor(interessado);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");
            filtros.add(filtro);
        }

        String metodo = "" + (String) request.getParameter("metodo");
        if (!"null".equals(metodo) && !metodo.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("metodo");
            filtro.setValor(metodo);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");
            filtros.add(filtro);
        }

        String quando = "" + (String) request.getParameter("quando");
        if (!"null".equals(quando) && !quando.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("quando");
            filtro.setValor(quando);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");
            filtros.add(filtro);
        }
        session = request.getSession();
        String id = "" +(String) session.getAttribute("idProjeto");

        if (!"null".equals(id) && !id.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("projeto_id");
            filtro.setValor(id);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            filtros.add(filtro);
        }

        return dao.buscaPlanoComunicacao(dao.criarFiltro(filtros));
    }


    public void excluir(HttpServletRequest request) throws ErrorException{
        PlanoComunicacaoDAO dao = new PlanoComunicacaoDAO();
        plano = new PlanoComunicacao();
        int id=0;
        if (request.getAttribute("id") != null || !request.getAttribute("id").equals("")) {
            id = Integer.parseInt((String)request.getAttribute("id"));
        }
        plano.setId(id);
        dao.excluir(plano);

    }
}
