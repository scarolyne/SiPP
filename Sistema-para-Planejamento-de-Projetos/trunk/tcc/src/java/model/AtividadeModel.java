/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AtividadeDAO;
import DAO.AtividadeProfissionalDAO;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Atividade;
import bean.Projeto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utils.Filtro;

/**
 *
 * @author Asus PC
 */
public class AtividadeModel extends Model {

    private AtividadeDAO dao;
    private AtividadeProfissionalDAO atividadeProfissionalDAO;
    private Atividade atividade;
    private Projeto projeto;
    private HttpSession session;


    public AtividadeModel() {
        dao = new AtividadeDAO();
        atividadeProfissionalDAO = new AtividadeProfissionalDAO();
    }

    public void salvar(HttpServletRequest request) throws ErrorException {

        Atividade idAtividade;
        Atividade idPacote;
        this.session = request.getSession();
        int count = 0;
        String[] pacoteUpdate = request.getParameterValues("ativiUpdate[]");
        String[] delAtividade = request.getParameterValues("delAtivId[]");

        if (delAtividade != null && !delAtividade.equals("null")) {
            for (String delAtividade1 : delAtividade) {
                int id = Integer.parseInt(delAtividade1);
                dao.excluir(id);
            }
        }

        if (pacoteUpdate != null && !pacoteUpdate.equals("null")) {
            for (String pacoteUpdate1 : pacoteUpdate) {
                String updateAtivi = "" + request.getParameter("atividade_" + pacoteUpdate1);
                if (!updateAtivi.equals("") && !updateAtivi.isEmpty() && !updateAtivi.equals("null")) {
                    atividade = new Atividade();
                    atividade.setId(Integer.parseInt(pacoteUpdate1));
                    atividade.setNome(updateAtivi);
                    dao.editar(atividade);
                }
            }
        }

        if (!request.getParameter("count_pacotes").equals("") || request.getParameter("count_pacotes") != null) {
            count = Integer.parseInt(request.getParameter("count_pacotes"));
        }

        for (int i = 0; i < count; i++) {
            String pacote = "" + (String) request.getParameter("pacote_" + i);

            if (!pacote.equals("") && !pacote.isEmpty() && !pacote.equals("null")) {
                String idproj = "" + session.getAttribute("idProjeto");
                projeto = new Projeto();
                projeto.setId(Integer.parseInt(idproj));

                if (pacoteUpdate != null && !pacoteUpdate.equals("null") && Arrays.asList(pacoteUpdate).contains(Integer.toString(i))) {
                    atividade = new Atividade();
                    atividade.setId(i);
                    atividade.setNome(pacote);
                    dao.editar(atividade);
                    idPacote = atividade;
                }
                else {
                    atividade = new Atividade();
                    atividade.setNome(pacote);
                    atividade.setProjeto(projeto);
                    atividade.setInicio(System.currentTimeMillis());
                    atividade.setFim(System.currentTimeMillis());
                    atividade.setDescricao("");
                    atividade.setProgresso(0);
                    atividade.setStatus("STATUS_UNDEFINED");
                    atividade.setDuracao(1);
                    atividade.setIdPacote(0);

                    idPacote = dao.salvar(atividade);
                }

                String[] atividadeArray = request.getParameterValues("pacote_" + i + "_atividade[]");
                if (atividadeArray != null) {
                    for (int j = 0; j < atividadeArray.length; j++) {

                        atividade = new Atividade();
                        atividade.setNome(atividadeArray[j]);
                        atividade.setProjeto(projeto);
                        atividade.setInicio(System.currentTimeMillis());
                        atividade.setFim(System.currentTimeMillis());
                        atividade.setDescricao("");
                        atividade.setProgresso(0);
                        atividade.setStatus("STATUS_UNDEFINED");
                        atividade.setDuracao(1);
                        atividade.setIdPacote(idPacote.getId());

                        idAtividade = dao.salvar(atividade);
                    }
                }
            }
        }
    }


    public Atividade buscarPorId(int id) throws ErrorException, FilterCreationException {
        Filtro filtro = new Filtro();

        filtro.setCampo("id");
        filtro.setValor(String.valueOf(id));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");

        String where = dao.criarFiltro(filtro);
        return dao.buscar(where).get(0);
    }

    public List<Atividade> buscarPacotes(HttpServletRequest request) throws FilterCreationException, ErrorException {
        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        this.session = request.getSession();
        String idproj = "" + session.getAttribute("idProjeto");
        projeto = new Projeto();
        projeto.setId(Integer.parseInt(idproj));
        dao = new AtividadeDAO();

        filtro = new Filtro();
        filtro.setCampo("a.projeto_id");
        filtro.setValor(Integer.toString(projeto.getId()));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("a.id_pacote");
        filtro.setValor("");
        filtro.setOperador("AND");
        filtro.setTipo("NULL");
        filtros.add(filtro);

        return dao.buscarPacotes(dao.criarFiltro(filtros));
    }

    public List<Atividade> buscarDependencia(HttpServletRequest request) throws FilterCreationException, ErrorException {
        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;
        this.session = request.getSession();
        String idproj = "" + session.getAttribute("idProjeto");
        projeto = new Projeto();
        projeto.setId(Integer.parseInt(idproj));
        dao = new AtividadeDAO();

        filtro = new Filtro();
        filtro.setCampo("a.projeto_id");
        filtro.setValor(Integer.toString(projeto.getId()));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("a.id_pacote");
        filtro.setValor("");
        filtro.setOperador("AND");
        filtro.setTipo("NOTNULL");
        filtros.add(filtro);

        return dao.buscarPacotes(dao.criarFiltro(filtros));
    }

    public List<Atividade> buscar(HttpServletRequest request) throws FilterCreationException, ErrorException {
        List<Atividade> atividades;
        List<Filtro> filtros = new ArrayList();
        Filtro filtro;

        filtro = new Filtro();
        filtro.setCampo("projeto_id");
        filtro.setValor("" + (String) request.getSession().getAttribute("idProjeto"));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        filtros.add(filtro);

        Object buscarPacotes = request.getAttribute("pacotes");
        if ( buscarPacotes != null ) {
            filtro = new Filtro();
            filtro.setCampo("atividade.id_pacote");
            filtro.setValor("");
            filtro.setOperador("AND");
            filtro.setTipo("NULL");

            filtros.add(filtro);
        }

        String idPacote = "" + (String) request.getAttribute("id_pacote");
        if (!"null".equals(idPacote) && !idPacote.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("atividade.id_pacote");
            filtro.setValor(idPacote);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");

            filtros.add(filtro);
        }

        atividades = dao.buscar(dao.criarFiltro(filtros));

        for (Atividade atividade : atividades) {
            filtro = new Filtro();
            filtro.setCampo("atividade_id");
            filtro.setValor(String.valueOf(atividade.getId()));
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");
            atividade.setAtividadeProfissionais(atividadeProfissionalDAO.buscar(dao.criarFiltro(filtro)));
        }

        return atividades;
    }

    public void excluir(int id) throws ErrorException {
        dao.excluir(id);
    }
}
