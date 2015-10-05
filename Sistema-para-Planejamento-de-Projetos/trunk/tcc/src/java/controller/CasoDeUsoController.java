/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.AlertException;
import Exception.ErrorException;
import bean.CasoUso;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.CasoDeUsoModel;
import model.ProjetoModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Camyla
 */
public class CasoDeUsoController extends Controller {

    CasoDeUsoModel model;
    ProjetoModel modelProjeto;
    HttpSession session;

    public CasoDeUsoController() {
        this.model = new CasoDeUsoModel();
    }

    @Override
    public void index() {
        HttpSession session = request.getSession();
        session.invalidate();

        cadastrar();
    }

    public void cadastrar() {
        try {
            List<CasoUso> listaUC = model.buscar(request);

            if (listaUC != null || !listaUC.isEmpty()) {
                modelProjeto = new ProjetoModel();
                String nomeArquivo = modelProjeto.buscar(request).get(0).getImagem();
                model.setarSessaoUC(request, listaUC);

                request.setAttribute("casos", listaUC);
                request.setAttribute("nomeArquivo", nomeArquivo);
            }
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.include("pontos_uc/cadastrarUC.jsp");
    }

    public void salvar() {
        try {

            if (request.getParameter("acao").equals("alterar")) {
                model.editar(request);
            } else {
                model.salvar(request);
            }
            super.setSuccessMessage("Casos de uso cadastrados com sucesso.");
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        super.redirect("pontoUC/calculoUC");

    }

    public void ajaxBuscaUCsessao() {
        List<CasoUso> listaUC;

        try {
            listaUC = model.buscar(request);
            if (listaUC != null || !listaUC.isEmpty()) {
                model.setarSessaoUC(request, listaUC);
                JSONArray jsonArray = model.setarUCAjax(request, listaUC);

                response.getWriter().println(jsonArray);
            }
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(CasoDeUsoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir() {
        try {
            this.model.excluir(request);
            List<CasoUso> listaUC = model.buscar(request);

            if (listaUC != null || !listaUC.isEmpty()) {
                model.setarSessaoUC(request, listaUC);
                request.setAttribute("casos", listaUC);
                super.include("pontos_uc/cadastrarUC.jsp");
            }

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

    }

    public void excluirDaSessao() {
        try {
            JSONArray jsonArray = this.model.excluirSessaoAjax(request);
            response.getWriter().println(jsonArray);
        } catch (IOException ex) {
            Logger.getLogger(CasoDeUsoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvarImagem() {
        boolean sucesso = false;

        try {
            this.model.salvarImagem(request);

            sucesso = true;

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

        if (sucesso) {
            this.cadastrar();
        } else {
            this.upload();
        }


    }

    public void adicionaUcAjax() {
        try {
            String dados = request.getParameter("dadosUC");

            JSONObject json = new JSONObject(dados);
            JSONArray jsonArray = new JSONArray();
            CasoUso caso;
            List<CasoUso> UcLista;

            HttpSession session = request.getSession();
            if (session.getAttribute("UC") == null) {
                UcLista = new ArrayList<>();
            } else {
                UcLista = (List) session.getAttribute("UC");
            }
            caso = new CasoUso();
            String nome = json.getString("nomeTipo");
            String tipo = json.getString("escolha");
            String complexidade = json.getString("complexidade");
            caso.setId(0);
            caso.setNome(nome);
            caso.setTipo(tipo);
            caso.setValor(complexidade);

            UcLista.add(caso);
            session.setAttribute("UC", UcLista);

            for (int i = 0; i < UcLista.size(); i++) {
                caso = UcLista.get(i);
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("id", caso.getId());
                jsonResponse.put("tipo", caso.getTipo());
                jsonResponse.put("nome", caso.getNome());
                jsonResponse.put("complexidade", caso.getValor());
                jsonArray.put(jsonResponse);

            }
            response.getWriter().println(jsonArray);
        } catch (IOException ex) {
            Logger.getLogger(CasoDeUsoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void upload() {
        super.include("definicaoEscopo/upload.jsp");
    }
}
