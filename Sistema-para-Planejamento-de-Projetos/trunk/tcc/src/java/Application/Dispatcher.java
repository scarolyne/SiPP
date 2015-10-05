package Application;

import bean.Usuario;
import controller.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AccessUtilities;

/**
 *
 * @author ricobonfim
 */
public class Dispatcher {
    private final HashMap ControllerMap;

    public Dispatcher() {
        this.ControllerMap = new HashMap();

        ControllerMap.put("termoAbertura", new TermoAberturaController());
        ControllerMap.put("DefinicaoEscopo", new DefinicaoEscopoController());
        ControllerMap.put("CasoDeUso", new CasoDeUsoController());
        ControllerMap.put("cargo", new CargoController());
        ControllerMap.put("Profissional", new ProfissionalController());
        ControllerMap.put("usuario", new UsuarioController());
        ControllerMap.put("usuarioProjeto", new UsuarioProjetoController());
        ControllerMap.put("riscos", new PlanoRiscosController());
        ControllerMap.put("comunicacao", new PlanoComunicacaoController());
        ControllerMap.put("PlanoDeCusto", new PlanoCustoController());
        ControllerMap.put("fator", new FatorComplexidadeController());
        ControllerMap.put("atividade", new AtividadeController());
        ControllerMap.put("pontoUC", new ProjetoFatorComplexidadeController());
        ControllerMap.put("projeto", new ProjetoController());
        ControllerMap.put("pdf", new GeradorDePDFController());
        ControllerMap.put("Gantt", new GanttController());
    }

    public void dispatch(HttpServletRequest request, HttpServletResponse response) {

        try {
            AccessUtilities usuarioAcesso = new AccessUtilities(request);
            String[] parametros = request.getParameter("key").split("/");

            String action = "";
            if ( parametros.length > 0 ) {
                action = parametros[0];
            }

            Controller controller = new UsuarioController();
            if ( this.ControllerMap.containsKey(action) ) {
                controller = (Controller) this.ControllerMap.get(action);
            }

            String method = "index";
            if ( parametros.length > 1 ) {
                method = parametros[1];
            }

            if (!usuarioAcesso.hasAccessTo(controller, method)) {
                controller = new UsuarioController();

                method = "login";
                if (usuarioAcesso.userIsAuthenticated()) {
                    method = "index";
                }
            }

            Method MethodReflection;
            MethodReflection = controller.getClass().getMethod(method);

            for (int i = 2; i < parametros.length; i+=2) {
                String chave = parametros[i];
                request.setAttribute(chave, parametros[i+1]);
            }

            controller.request = request;
            controller.response = response;

            MethodReflection.invoke(controller);

        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | IllegalAccessException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}