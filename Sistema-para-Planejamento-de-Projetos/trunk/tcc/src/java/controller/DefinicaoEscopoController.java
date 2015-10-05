/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.ErrorException;
import bean.DefinicaoEscopo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DefinicaoEscopoModel;


/**
 *
 * @author Camyla
 */
public class DefinicaoEscopoController extends Controller {

    @Override
    public void index() {
        try {
            //pegar id da sessão
            DefinicaoEscopoModel model = new DefinicaoEscopoModel();
            DefinicaoEscopo escopo = null;
            escopo = model.visualizar(request);

            if (escopo != null) {
                request.setAttribute("escopo", escopo);
            }
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        super.include("definicaoEscopo/cadastrar.jsp");
    }

    public void salvar() {
        try {
            DefinicaoEscopoModel model = new DefinicaoEscopoModel();
            model.salvar(request);

            super.setSuccessMessage("Definição de Escopo atualizada com sucesso!");
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        super.redirect("DefinicaoEscopo");
    }

    public void cadastrar() {
        try {
            DefinicaoEscopoModel model = new DefinicaoEscopoModel();
            request.setAttribute("escopo", model.visualizar(request));

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }

        super.include("definicaoEscopo/cadastrar.jsp");

    }

    public void buscar() {
        this.index();
    }

}