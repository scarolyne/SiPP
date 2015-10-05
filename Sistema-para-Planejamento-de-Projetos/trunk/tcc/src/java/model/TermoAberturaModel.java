/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.TermoAberturaDAO;
import Exception.ErrorException;
import bean.Aprovacao;
import bean.EntregaProjeto;
import bean.Projeto;
import bean.TermoAbertura;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus PC
 */
public class TermoAberturaModel extends Model {

    Projeto projeto;
    TermoAbertura termo;
    HttpSession session;

    public void salvar(HttpServletRequest request) throws ErrorException {
        projeto = new Projeto();
        session = request.getSession();
        String idSessao = (String) session.getAttribute("idProjeto");
        projeto.setId((Integer.parseInt(idSessao)));
        String[] aprovadoresArray = request.getParameterValues("aprovador[]");
        List<Aprovacao> aprovadoresList = new ArrayList<>();
        for (String aprov : aprovadoresArray) {
            if (!aprov.isEmpty()) {
                Aprovacao aprovador = new Aprovacao();
                aprovador.setNome(aprov);
                aprovadoresList.add(aprovador);
            }
        }
        String[] dataArray = request.getParameterValues("data[]");
        String[] entregaArray = request.getParameterValues("entrega[]");
        String[] id_entregaArray = request.getParameterValues("id_entrega[]");
        List<EntregaProjeto> entregasList = new ArrayList<>();

        Date date = null;
        for (int i = 0; i < dataArray.length; i++) {
            if (!dataArray[i].isEmpty()) {

                try {
                    String data = dataArray[i];
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    date = df.parse(data);

                } catch (Exception e) {
                }
                int id_entrega;
                if (request.getParameter("id_entrega[]") == null || request.getParameter("id_entrega[]").equals("")) {
                    id_entrega = 0;
                } else {
                    id_entrega = Integer.parseInt(id_entregaArray[i]);
                }

                EntregaProjeto entregaProj = new EntregaProjeto(id_entrega, entregaArray[i], date, 1, projeto);
                entregasList.add(entregaProj);
            }
        }
        int id;
        if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
            id = 0;
        } else {
            id = Integer.parseInt(request.getParameter("id"));
        }

        termo = new TermoAbertura(id, request.getParameter("introducao"), request.getParameter("responsabilidade"), request.getParameter("necessidade_basica"), request.getParameter("descricao_produto"), request.getParameter("orcamento_inicial"), request.getParameter("necessidade_suporte"), request.getParameter("controle_informacao"), aprovadoresList, entregasList, projeto);
        TermoAberturaDAO dao = new TermoAberturaDAO();
        if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
            dao.salvar(termo);
        } else {
            dao.editar(termo);
        }

    }

    public TermoAbertura visualizar(HttpServletRequest request) throws ErrorException {
        TermoAberturaDAO dao = new TermoAberturaDAO();
        session = request.getSession();
        int id = 0;
        if (session.getAttribute("idProjeto") != null && !session.getAttribute("idProjeto").equals("")) {
            String idsessao = (String) session.getAttribute("idProjeto");
            id = Integer.parseInt(idsessao);
        }
        projeto = new Projeto();
        projeto.setId(id);
        termo = dao.visualizar(projeto);
        return termo;
    }
}
