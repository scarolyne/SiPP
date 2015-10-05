package controller;

import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GanttModel;
import org.json.JSONObject;

public class GanttController extends Controller {

    private GanttModel model;

    public GanttController() {
        this.model = new GanttModel();
    }

    @Override
    public void index() {
        JSONObject projetoJSON;
        boolean erro = false;

        try {
            model.setRequest(request);

            if (model.buscarPacotes().isEmpty()) {
                throw new AlertException("Cadastre atividades no EAP antes de acessar o Gantt.");
            }

        } catch (ErrorException ex) {
            erro = true;
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            erro = true;
            super.setAlertMessage(ex.getMessage());
        }

        if (erro) {
            super.redirect("projeto/indexProjeto/id/" + request.getSession().getAttribute("idProjeto"));
        } else {
            super.include("gantt/index.jsp");
        }
    }

    public void carregarProjetoAjax() {
        JSONObject projetoJSON;
        try {
            model.setRequest(request);
            projetoJSON = model.gerarProjetoJson();

            response.getWriter().println(projetoJSON);
            response.getWriter().close();

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(GanttController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvarProjetoAjax() {
        JSONObject projetoJSON;

        try {
            model.setRequest(request);

            model.atualizarProjetoJson();

            projetoJSON = model.gerarProjetoJson();

            response.getWriter().println(projetoJSON);
            response.getWriter().close();

        } catch (ErrorException ex) {
            super.setErrorMessage(ex.getMessage());
        } catch (AlertException ex) {
            super.setAlertMessage(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(GanttController.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
}
