/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Projeto;
import bean.UsuarioProjeto;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.DefinicaoEscopoModel;
import model.ProjetoModel;
import model.UsuarioProjetoModel;

/**
 *
 * @author Carol
 */
public class ProjetoController extends Controller {

    private ProjetoModel model;
    private List<Projeto> projeto;
    private List<Projeto> pendencias;
    private List<Projeto> projEquipe;
    private List<UsuarioProjeto> equipe;
    private UsuarioProjetoModel modelUsuario;
    private DefinicaoEscopoModel modelDefinicao;

    public ProjetoController() {
        this.model = new ProjetoModel();
        this.modelUsuario = new UsuarioProjetoModel();
    }

    @Override
    public void index() {
        HttpSession session = request.getSession();
        session.setAttribute("idProjeto", request.getAttribute("id"));
        super.include("indexProjeto.jsp");
    }

    public void indexProjeto() throws ErrorException, FilterCreationException {
        this.model.buscar(request);
        this.equipe = this.modelUsuario.buscarEquipe(request);
        
        request.setAttribute("equipe", this.equipe);
            
        this.index();
    }

    public void salvar() {
        try {
            int projetoId = this.model.salvar(request);
            modelDefinicao = new DefinicaoEscopoModel();
            modelUsuario = new UsuarioProjetoModel();
            modelUsuario.salvar(request, projetoId);
            modelDefinicao.criarDefinicao(projetoId);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.home();
    }

    public void excluir() {
        try {
            int id = Integer.parseInt(request.getAttribute("id").toString());

            this.model.excluir(id);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        this.home();
    }
}