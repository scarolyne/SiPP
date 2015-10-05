/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.AlertException;
import Exception.ErrorException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ProjetoModel;
import utils.GeradorDePDF;

/**
 *
 * @author Camyla
 */
public class GeradorDePDFController extends Controller {

    @Override
    public void index() {
        geraPdf();
    }
    ProjetoModel modelProj;

    public void geraPdf() {
        try {
            GeradorDePDF gerar = new GeradorDePDF();
            gerar.GeraPDF(request, response);

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        }

    }

    public void geraPdfPlanos() {
        try {
            GeradorDePDF gerar = new GeradorDePDF();
            gerar.GeraPDFPlanos(request, response);
            
        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        }
    }
}
