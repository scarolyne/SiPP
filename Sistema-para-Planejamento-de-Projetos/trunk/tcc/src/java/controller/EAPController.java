package controller;

/**
 *
 * @author ricobonfim
 */
public class EAPController extends Controller {

    public EAPController() {
        this.menu = "home";
    }

    @Override
    public void index() {
        super.include("eap/diagrama.jsp");
    }
    

}