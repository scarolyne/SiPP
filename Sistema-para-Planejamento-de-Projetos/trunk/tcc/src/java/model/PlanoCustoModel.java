package model;

import DAO.AtividadeProfissionalDAO;
import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Atividade;
import bean.AtividadeProfissional;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class PlanoCustoModel extends Model {

    public PlanoCustoModel() { }

    public List<Atividade> buscar(HttpServletRequest request) throws FilterCreationException, ErrorException {
        List<Atividade> atividades;
        AtividadeModel atividadeModel = new AtividadeModel();

        request.setAttribute("pacotes", true);
        atividades = atividadeModel.buscar(request);
        request.removeAttribute("pacotes");

        atividades = buscarDependentes(request, atividades);

        return atividades;
    }

    private List<Atividade> buscarDependentes(HttpServletRequest request, List<Atividade> atividades) throws FilterCreationException, ErrorException {
        AtividadeModel atividadeModel = new AtividadeModel();
        List<Atividade> novaLista = new ArrayList();
        List<Atividade> dependentes;

        for (Atividade atividade : atividades) {
            request.setAttribute("id_pacote", String.valueOf(atividade.getId()));
            dependentes = atividadeModel.buscar(request);

            for (Atividade dependente : dependentes) {
                atividade.setEsforcoEstimado(atividade.getEsforcoEstimado() + dependente.getEsforcoEstimado());
            }

            novaLista.add(atividade);
            novaLista.addAll(dependentes);
        }

        return novaLista;
    }

    public void excluir(HttpServletRequest request) throws AlertException, ErrorException {
        String profissional = "" + (String) request.getAttribute("profissional");
        if ("null".equals(profissional)) {
            throw new AlertException("Profissional invalido");
        }

        String atividade = "" + (String) request.getAttribute("atividade");
        if ("null".equals(atividade)) {
            throw new AlertException("Atividade invalida");
        }

        AtividadeProfissionalModel atividadeProfissionalModel = new AtividadeProfissionalModel();
        atividadeProfissionalModel.excluir(Integer.parseInt(profissional), Integer.parseInt(atividade));
    }

    public void salvar(HttpServletRequest request) throws ErrorException {

        AtividadeProfissional atividadeProfissional = new AtividadeProfissional();
        AtividadeProfissionalDAO atividadeProfissionalDAO = new AtividadeProfissionalDAO();

        atividadeProfissional.getProfissional().setId(Integer.parseInt("" + (String) request.getAttribute("profissional")));
        atividadeProfissional.getAtividade().setId(Integer.parseInt("" + (String) request.getAttribute("atividade")));
        atividadeProfissional.setEsforco(Long.parseLong("" + (String) request.getAttribute("quantidadeHoras"))*60*60*1000);
        atividadeProfissionalDAO.salvar(atividadeProfissional);

    }
}
