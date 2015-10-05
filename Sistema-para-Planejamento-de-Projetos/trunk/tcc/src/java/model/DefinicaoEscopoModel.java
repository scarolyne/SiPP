/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DAO;
import DAO.DefinicaoEscopoDAO;
import DAO.TermoAberturaDAO;
import Exception.ErrorException;
import bean.DefinicaoEscopo;
import bean.EntregaProjeto;
import bean.Projeto;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Camyla
 */
public class DefinicaoEscopoModel {

    DefinicaoEscopo escopo;
    HttpSession session;

    public void salvar(HttpServletRequest request) throws ErrorException {
        try {
            DefinicaoEscopoDAO dao = new DefinicaoEscopoDAO();
            TermoAberturaDAO termoAberturaDAO = new TermoAberturaDAO();
            DefinicaoEscopo definicao = new DefinicaoEscopo();
            List<EntregaProjeto> entregasList = new ArrayList<>();
            Projeto projeto = new Projeto();
            String[] entregas;
            String[] idEntregas;
            String[] datas;

            projeto.setId(Integer.parseInt("" + request.getSession().getAttribute("idProjeto")));

            definicao.setDescricaoEscopo(request.getParameter("descricao"));
            definicao.setCriteriosAceitacao(request.getParameter("criterios"));
            definicao.setExclusoesProjeto(request.getParameter("exclusoes"));
            definicao.setRestricoesProjeto(request.getParameter("restricoes"));
            definicao.setPremissasProjeto(request.getParameter("premissas"));
            definicao.setProjeto(projeto);

            datas = request.getParameterValues("data[]");
            entregas = request.getParameterValues("entrega[]");
            idEntregas = request.getParameterValues("id_entrega[]");

            for (int i = 0; i < datas.length; i++) {
                if (datas[i].isEmpty()) {
                    continue;
                }
                int idEntrega;
                Date date;
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                date = df.parse(datas[i]);

                idEntrega = 0;
                if (idEntregas != null && i < idEntregas.length) {
                    idEntrega = Integer.parseInt(idEntregas[i]);
                }

                EntregaProjeto entregaProj = new EntregaProjeto(idEntrega, entregas[i], date, 1, projeto);
                entregasList.add(entregaProj);
            }

            DAO.begin();
            dao.salvar(definicao);

            for (EntregaProjeto entrega : entregasList) {
                if ( entrega.getId() > 0 ) {
                    termoAberturaDAO.editarEntrega(entrega);
                } else {
                    termoAberturaDAO.salvarEntrega(entrega);
                }
            }

            DAO.commit();

        } catch (ParseException ex) {
            DAO.rollback();
            Logger.getLogger(DefinicaoEscopoModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void criarDefinicao(int id) throws ErrorException {
        DefinicaoEscopoDAO dao = new DefinicaoEscopoDAO();
        dao.inserir(id);

    }

    public DefinicaoEscopo visualizar(HttpServletRequest request) throws ErrorException {
        DefinicaoEscopoDAO dao = new DefinicaoEscopoDAO();

        Projeto projeto = new Projeto();
        projeto.setId(Integer.parseInt("" + (String) request.getSession().getAttribute("idProjeto")));

        escopo = dao.visualizar(projeto);
        if (escopo != null) {
            TermoAberturaDAO termoDao = new TermoAberturaDAO();
            List<EntregaProjeto> entregas = termoDao.entregasProjeto(projeto.getId());
            if (entregas != null) {
                escopo.setEntregas(entregas);
            }
        }
        return escopo;
    }
}
