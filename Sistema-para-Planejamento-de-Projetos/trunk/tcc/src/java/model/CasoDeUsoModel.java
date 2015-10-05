package model;

import DAO.CasoDeUsoDAO;
import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.CasoUso;
import bean.Projeto;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.Filtro;

public class CasoDeUsoModel {

    CasoDeUsoDAO dao;
    CasoUso uc;
    HttpSession session;
    Projeto projeto;

    public CasoDeUsoModel() {
        dao = new CasoDeUsoDAO();
    }

    public void salvar(HttpServletRequest request) throws ErrorException {

        projeto = new Projeto();
        projeto.setId(Integer.parseInt("" + (String) session.getAttribute("idProjeto")));
        List<CasoUso> listaUc = new ArrayList<>();
        session = request.getSession();

        listaUc = (List<CasoUso>) session.getAttribute("UC");

        for (CasoUso casoUso : listaUc) {
            uc = new CasoUso();
            uc.setNome(casoUso.getNome());
            uc.setTipo(casoUso.getTipo());
            uc.setValor(casoUso.getValor());
            uc.setProjeto(projeto);
            dao.salvar(uc);

        }

    }

    public void setarSessaoUC(HttpServletRequest request, List<CasoUso> listaUC) {
        session = request.getSession();
        session.setAttribute("UC", listaUC);
    }

    public JSONArray excluirSessaoAjax(HttpServletRequest request) {
        session = request.getSession();
        List<CasoUso> listaUC = (List<CasoUso>) session.getAttribute("UC");
        uc = new CasoUso();
        JSONArray jsonArray = new JSONArray();

        String dados = request.getParameter("dadosUC");

        JSONObject json = new JSONObject(dados);
        int id = json.getInt("id");
        uc.setId(id);
        for (CasoUso casoUso : listaUC) {
            if (casoUso.getId() == uc.getId()) {
                listaUC.remove(casoUso);
                break;
            }
        }

        session.setAttribute("UC", listaUC);

        for (int i = 0; i < listaUC.size(); i++) {
            uc = listaUC.get(i);
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("id", uc.getId());
            jsonResponse.put("tipo", uc.getTipo());
            jsonResponse.put("nome", uc.getNome());
            jsonResponse.put("complexidade", uc.getValor());
            jsonArray.put(jsonResponse);

        }
        return jsonArray;
    }

    public JSONArray setarUCAjax(HttpServletRequest request, List<CasoUso> listaUC) {
        JSONArray jsonArray = new JSONArray();
        CasoUso caso;
        for (int i = 0; i < listaUC.size(); i++) {
            caso = listaUC.get(i);
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("id", caso.getId());
            jsonResponse.put("tipo", caso.getTipo());
            jsonResponse.put("nome", caso.getNome());
            jsonResponse.put("complexidade", caso.getValor());
            jsonArray.put(jsonResponse);

        }

        return jsonArray;
    }

    public String salvarArquivoServidor(HttpServletRequest request) throws ErrorException {
        String nomeArquivo = null;

        try {
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> fileItemsList = servletFileUpload.parseRequest(request);

            for (FileItem fileItem : fileItemsList) {

                if (fileItem.getSize() > 0) {
                    Date d = new Date();
                    String caminhoArquivoServidor;

                    nomeArquivo = d.getTime() + "_" + fileItem.getName();
                    caminhoArquivoServidor= request.getServletContext().getRealPath("") + "\\casos_de_uso\\" + nomeArquivo;

                    File saveTo = new File(caminhoArquivoServidor);
                    fileItem.write(saveTo);
                }
            }

        } catch (Exception e) {
            throw new ErrorException();
        }

        return nomeArquivo;
    }

    public void salvarImagem(HttpServletRequest request) throws ErrorException, AlertException {
        CasoDeUsoDAO dao = new CasoDeUsoDAO();

        if (ServletFileUpload.isMultipartContent(request)) {
            String nomeArquivo = salvarArquivoServidor(request);
            dao.salvarImagem(nomeArquivo, Integer.parseInt("" + (String) request.getSession().getAttribute("idProjeto")));

        } else {
            throw new AlertException("Imagem invalida.");
        }

    }

    public List<CasoUso> buscar(HttpServletRequest request) throws FilterCreationException, ErrorException {
        session = request.getSession();

        Filtro filtro = new Filtro();
        filtro.setCampo("projeto_id");
        filtro.setValor((String) session.getAttribute("idProjeto"));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        String where = dao.criarFiltro(filtro);

        return dao.buscar(where);

    }

    public int countUCporComplexidade(HttpServletRequest request, String complexidade, String tipo) throws FilterCreationException, ErrorException {
        session = request.getSession();
        int count = 0;
        dao = new CasoDeUsoDAO();
        Filtro filtro = new Filtro();
        ArrayList<Filtro> filtros = new ArrayList();

        filtro.setCampo("projeto_id");
        filtro.setValor((String) session.getAttribute("idProjeto"));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("valor");
        filtro.setValor(complexidade);
        filtro.setOperador("AND");
        filtro.setTipo("LIKEALL");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("tipo");
        filtro.setValor(tipo);
        filtro.setOperador("AND");
        filtro.setTipo("LIKEALL");
        filtros.add(filtro);

        String where = dao.criarFiltro(filtros);
        count = dao.contarUCporComplexidade(where);
        return count;
    }

    public void excluir(HttpServletRequest request) throws ErrorException {
        session = request.getSession();
        List<CasoUso> listaUC = (List<CasoUso>) session.getAttribute("UC");
        uc = new CasoUso();
        int id = 0;

        if (request.getAttribute("id") != null || !request.getAttribute("id").equals("")) {
            id = Integer.parseInt((String) request.getAttribute("id"));
        }

        uc.setId(id);
        for (CasoUso casoUso : listaUC) {
            if (casoUso.getId() == uc.getId()) {
                listaUC.remove(casoUso);
                session.setAttribute("UC", listaUC);
                break;
            }
        }

        dao.excluir(uc);

    }

    public void editar(HttpServletRequest request) throws FilterCreationException, ErrorException {
        List<CasoUso> listaUC = buscar(request);
        session = request.getSession();
        List<CasoUso> sessaoUC = (List<CasoUso>) session.getAttribute("UC");
        boolean excluir;
        projeto = new Projeto();
        projeto.setId(Integer.parseInt("" + (String) session.getAttribute("idProjeto")));

        for (CasoUso casoUso : sessaoUC) {
            casoUso.setProjeto(projeto);
            if (!casoUso.getTipo().isEmpty() && !casoUso.getValor().isEmpty()) {
                if (casoUso.getId() == 0) {
                    dao.salvar(casoUso);
                }
            }
        }

        for (CasoUso casoUso : listaUC) {
            excluir = true;
            for (CasoUso casoUsoSession : sessaoUC) {
                if (casoUso.getId() == casoUsoSession.getId()) {
                    excluir = false;
                    break;
                }
            }
            if (excluir) {
                dao.excluir(casoUso);
            }

        }
    }
}
