package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Model;

/**
 *
 * @author ricobonfim
 */
public abstract class Controller {

    public HttpServletRequest request;
    public HttpServletResponse response;

    public String menu;

    abstract public void index();

    public void include(String caminho) {
        this.request.setAttribute("menu", this.menu);

        try {
            RequestDispatcher rd;
            rd = request.getServletContext().getRequestDispatcher("/view/" + caminho);
            rd.include(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redirect(String site) {
        try {
            response.sendRedirect("/tcc/Bootstrap/" + site);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void home() {
        this.redirect("usuario");
    }

    public void setSuccessMessage(String mensagem) {
        this.setMessage("mensagemSucesso", mensagem);
    }

    public void setAlertMessage(String mensagem) {
        this.setMessage("mensagemAlerta", mensagem);
    }

    public void setErrorMessage(String mensagem) {
        this.setMessage("mensagemErro", mensagem);
    }

    private void setMessage(String nomeVariavel, String mensagem) {
        request.getSession().setAttribute(nomeVariavel, mensagem);
    }

}
