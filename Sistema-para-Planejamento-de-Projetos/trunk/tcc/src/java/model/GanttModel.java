package model;

import DAO.AtividadeDAO;
import DAO.AtividadeProfissionalDAO;
import DAO.AtividadeSequenciaDAO;
import DAO.DAO;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Atividade;
import bean.AtividadeProfissional;
import bean.AtividadeSequencia;
import bean.Cargo;
import bean.Profissional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public class GanttModel extends Model {

    List<Atividade> atividades;
    private HttpServletRequest request;

    public GanttModel() {
        this.atividades = new ArrayList();
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public JSONObject gerarProjetoJson() throws FilterCreationException, ErrorException {
        JSONObject jsonResponse = new JSONObject();

        jsonResponse.append("canWrite", true);
        jsonResponse.append("canWriteOnParent", true);
        jsonResponse.append("cannotCloseTaskIfIssueOpen", true);
        //jsonResponse.append("minEditableDate", true);
        //jsonResponse.append("maxEditableDate", true);
        //jsonResponse.append("selectedRow", true);
        //jsonResponse.append("splitterPosition", true);
        //jsonResponse.append("zoom", true);

        carregarAtividadesProjeto(jsonResponse);
        carregarProfissionaisProjeto(jsonResponse);
        carregarCargosProjeto(jsonResponse);

        return jsonResponse;
    }

    public void carregarAtividadesProjeto(JSONObject jsonResponse) throws FilterCreationException, ErrorException {
        List<Atividade> atividades;

        atividades = buscarPacotes();
        if (!atividades.isEmpty()) {
            for (Atividade atividade : atividades) {
                carregarAtividade(jsonResponse, atividade, 1);
            }
        } else {
            jsonResponse.append("tasks", new JSONObject());
        }

    }

    public List<Atividade> buscarPacotes() throws FilterCreationException, ErrorException {
        AtividadeModel atividadeModel = new AtividadeModel();
        List<Atividade> atividades;

        request.setAttribute("pacotes", true);
        atividades = atividadeModel.buscar(request);
        request.removeAttribute("pacotes");

        return atividades;
    }

    private void carregarAtividade(JSONObject jsonResponse, Atividade atividade, int level) throws FilterCreationException, ErrorException {
        AtividadeModel atividadeModel = new AtividadeModel();
        JSONObject atividadeJson = new JSONObject();
        String[] idAnteriores;
        String sequenciamento = "";

        atividadeJson.put("id", atividade.getId());
        atividadeJson.put("name", atividade.getNome());
        atividadeJson.put("description", atividade.getDescricao());
        atividadeJson.put("code", "");
        atividadeJson.put("level", level);
        atividadeJson.put("status", atividade.getStatus(Boolean.TRUE));
        atividadeJson.put("canWrite", true);
        atividadeJson.put("start", atividade.getInicio());
        atividadeJson.put("duration", atividade.getDuracao());
        atividadeJson.put("progress", atividade.getProgresso());
        atividadeJson.put("end", atividade.getFim());
        atividadeJson.put("startIsMilestone", false);
        atividadeJson.put("endIsMilestone", false);
        atividadeJson.put("collapsed", false);

        if ( !atividade.getSequenciamento().isEmpty() ) {
            idAnteriores = atividade.getSequenciamento().split(",");
            for (int i = 0; i < idAnteriores.length; i++) {
                for (int j = 0; j < this.atividades.size(); j++) {
                    if ( Integer.parseInt(idAnteriores[i]) == atividades.get(j).getId() ) {
                        sequenciamento += j+1;
                        if ( i+1 < idAnteriores.length ) {
                            sequenciamento += ", ";
                        }
                    }
                }
            }
        }

        atividadeJson.put("depends", sequenciamento);

        JSONArray profissionais = new JSONArray();
        for (AtividadeProfissional atividadeProfissional : atividade.getAtividadeProfissionais()) {
            JSONObject profissional = new JSONObject();

            profissional.put("effort", atividadeProfissional.getEsforco());
            profissional.put("id", "teste_" + atividade.getId() + "_" + atividadeProfissional.getProfissional().getId());
            profissional.put("resourceId", atividadeProfissional.getProfissional().getId());
            profissional.put("roleId", atividadeProfissional.getProfissional().getCargo().getId());

            profissionais.put(profissional);
        }
        atividadeJson.put("assigs", profissionais);
        atividadeJson.put("hasChild", false);

        jsonResponse.append("tasks", atividadeJson);

        this.atividades.add(atividade);

        request.setAttribute("id_pacote", String.valueOf(atividade.getId()));

        for (Atividade dependencia : atividadeModel.buscar(request)) {
            carregarAtividade(jsonResponse, dependencia, level+1);
        }

        request.removeAttribute("id_pacote");

    }

    public void carregarProfissionaisProjeto(JSONObject jsonResponse) throws FilterCreationException, ErrorException {
        ProfissionalModel profissionalModel = new ProfissionalModel();
        List<Profissional> profissionais;

        profissionais = profissionalModel.buscar(request);

        if (!profissionais.isEmpty()) {
            for (Profissional profissional : profissionais) {
                JSONObject profissionalJson = new JSONObject();

                profissionalJson.put("id", profissional.getId());
                profissionalJson.put("name", profissional.getNome());

                jsonResponse.append("resources", profissionalJson);
            }
        } else {
            jsonResponse.append("resources", new JSONObject());
        }


    }

    public void carregarCargosProjeto(JSONObject jsonResponse) throws FilterCreationException, ErrorException {
        CargoModel cargoModel = new CargoModel();
        List<Cargo> cargos;

        cargos = cargoModel.buscar(request);

        if (!cargos.isEmpty()) {
            for (Cargo cargo : cargos) {
                JSONObject cargoJson = new JSONObject();

                cargoJson.put("id", cargo.getId());
                cargoJson.put("name", cargo.getNome());

                jsonResponse.append("roles", cargoJson);
            }
        } else {
            jsonResponse.append("roles", new JSONObject());
        }

    }

    public void atualizarProjetoJson() throws FilterCreationException, ErrorException {
        JSONObject projetoJson;
        JSONArray atividadesJson;
        JSONArray atividadesDeletarJson;

        projetoJson = new JSONObject(request.getParameter("projeto_json"));
        atividadesJson = projetoJson.getJSONArray("tasks");
        atividadesDeletarJson = projetoJson.getJSONArray("deletedTaskIds");

        try {
            DAO.begin();
            for (int i = 0; i < atividadesJson.length(); i++) {
                this.atividades.add(salvarAtividade(atividadesJson.getJSONObject(i)));
            }
            for (int i = 0; i < this.atividades.size(); i++) {
                salvarAtividadeSequenciamento(this.atividades.get(i), atividadesJson.getJSONObject(i));
            }
            for (int i = 0; i < atividadesDeletarJson.length(); i++) {
                deletarAtividade(atividadesDeletarJson.getInt(i));
            }
            this.atividades = new ArrayList();
            DAO.commit();
        } catch (ErrorException ex) {
            DAO.rollback();
            throw ex;
        }
    }

    private void deletarAtividade(int id) throws ErrorException {
        AtividadeModel atividadeModel = new AtividadeModel();
        atividadeModel.excluir(id);
    }

    private Atividade salvarAtividade(JSONObject atividadeJson) throws FilterCreationException, ErrorException {
        Atividade atividade;

        try {
            String id = String.valueOf(atividadeJson.get("id"));

            if (Integer.parseInt(id) > 0) {
                atividade = editarAtividade(atividadeJson);
            } else {
                atividade = novaAtividade(atividadeJson);
            }
        } catch (NumberFormatException e) {
            atividade = novaAtividade(atividadeJson);
        } catch (FilterCreationException e) {
            throw e;
        }

        return atividade;
    }

    private Atividade editarAtividade(JSONObject atividadeJson) throws FilterCreationException, ErrorException {
        AtividadeModel atividadeModel = new AtividadeModel();
        Atividade atividade;
        AtividadeDAO dao = new AtividadeDAO();

        atividade = atividadeModel.buscarPorId(atividadeJson.getInt("id"));
        atividade.loadJSON(atividadeJson);

        dao.atualizar(atividade);

        excluirProfissionaisAtividade(atividade.getId());
        salvarProfissionaisAtividade(atividade, atividadeJson.getJSONArray("assigs"));

        return atividade;
    }

    private Atividade novaAtividade(JSONObject atividadeJson) throws ErrorException {
        Atividade atividade = new Atividade();
        AtividadeDAO dao = new AtividadeDAO();

        atividadeJson.remove("id");

        atividade.loadJSON(atividadeJson);

        atividade = dao.salvar(atividade);

        salvarProfissionaisAtividade(atividade, atividadeJson.getJSONArray("assigs"));

        return atividade;
    }

    private void salvarAtividadeSequenciamento(Atividade atividade, JSONObject atividadeJson) throws ErrorException {
        AtividadeSequenciaDAO dao = new AtividadeSequenciaDAO();
        AtividadeSequencia atividadeSequencia = new AtividadeSequencia();
        String anteriores;

        anteriores = atividadeJson.getString("depends");

        excluirAtividadeSequenciamento(atividade.getId());

        if (anteriores.isEmpty()) {
            return;
        }

        Set idAnteriores = new HashSet(Arrays.asList(anteriores.replaceAll("[^0-9,]", "").split(",")));

        atividadeSequencia.setAtividade(atividade);

        for (Object id : idAnteriores) {
            atividadeSequencia.setAtividadeAnterior(this.atividades.get(Integer.parseInt(String.valueOf(id))-1));
            dao.salvar(atividadeSequencia);
        }

    }

    private void excluirAtividadeSequenciamento(int id) throws ErrorException {
        AtividadeSequenciaDAO dao = new AtividadeSequenciaDAO();
        dao.excluirPorAtividade(id);
    }

    private void salvarProfissionaisAtividade(Atividade atividade, JSONArray profissionaisJson) throws ErrorException {
        AtividadeProfissional atividadeProfissional = new AtividadeProfissional();
        atividadeProfissional.setAtividade(atividade);

        for (int i = 0; i < profissionaisJson.length(); i++) {
            atividadeProfissional.loadJSON(profissionaisJson.getJSONObject(i));
            salvarAtividadeProfissional(atividadeProfissional);
        }
    }

    private void salvarAtividadeProfissional(AtividadeProfissional atividadeProfissional) throws ErrorException {
        AtividadeProfissionalDAO dao = new AtividadeProfissionalDAO();
        dao.salvar(atividadeProfissional);
    }

    private void excluirProfissionaisAtividade(int atividade) throws ErrorException {
        AtividadeProfissionalDAO dao = new AtividadeProfissionalDAO();
        dao.excluirPorAtividade(atividade);
    }
}
