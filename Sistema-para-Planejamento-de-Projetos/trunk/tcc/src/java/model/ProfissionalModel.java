package model;

import DAO.ProfissionalDAO;
import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Profissional;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import utils.Filtro;

public class ProfissionalModel extends Model {

    ProfissionalDAO dao;

    public ProfissionalModel() {
        dao = new ProfissionalDAO();
    }

    public Profissional buscarPorId(int id) throws ErrorException, FilterCreationException {
        Filtro filtro = new Filtro();
        List<Profissional> profissionais;

        filtro.setCampo("profissional.id");
        filtro.setValor(String.valueOf(id));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");

        String where = dao.criarFiltro(filtro);

        profissionais = dao.buscar(where);

        if ( profissionais.size() == 0 ) {
            throw new ErrorException("Profissional não encontrado.");
        }

        return profissionais.get(0);
    }

    public List<Profissional> buscar(HttpServletRequest request) throws FilterCreationException, ErrorException {
        List<Profissional> profissionais;
        List<Filtro> filtros = new ArrayList();
        Filtro filtro;
        CargoModel cargoModel = new CargoModel();

        String nome = "" + (String) request.getParameter("nome");
        if (!"null".equals(nome) && !nome.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("profissional.nome");
            filtro.setValor(nome);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");

            filtros.add(filtro);
        }

        String cargo = "" + (String) request.getParameter("cargo");
        if (!"null".equals(cargo) && !cargo.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("profissional.cargo_id");
            filtro.setValor(cargo);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");

            filtros.add(filtro);
        }

        filtro = new Filtro();
        filtro.setCampo("profissional.projeto_id");
        filtro.setValor("" + (String) request.getSession().getAttribute("idProjeto"));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");

        filtros.add(filtro);

        profissionais = dao.buscar(dao.criarFiltro(filtros));

        for (Profissional profissional : profissionais) {
            int idCargo = profissional.getCargo().getId();
            profissional.setCargo(cargoModel.buscarPorId(idCargo));
        }

        return profissionais;
    }

    public Profissional salvar(HttpServletRequest request) throws ErrorException {
        Profissional profissional = new Profissional();

        profissional.setNome(request.getParameter("nome"));
        profissional.getCargo().setId(Integer.parseInt("" + (String) request.getParameter("cargo")));

        profissional.getProjeto().setId(Integer.parseInt("" + (String) request.getSession().getAttribute("idProjeto")));

        String idProfissional = "" + (String) request.getParameter("profissional");

        if (!"null".equals(idProfissional) && !idProfissional.isEmpty()) {
            profissional.setId(Integer.parseInt(idProfissional));
            dao.atualizar(profissional);
        } else {
            profissional = dao.salvar(profissional);
        }

        return profissional;
    }

    public void excluir(int id) throws ErrorException, AlertException {
        List<Filtro> filtros = new ArrayList();
        Filtro filtro;

        filtro = new Filtro();
        filtro.setCampo("atividade.data_exclusao");
        filtro.setValor("");
        filtro.setOperador("AND");
        filtro.setTipo("NULL");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("atividade_has_profissional.profissional_id");
        filtro.setValor(String.valueOf(id));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        filtros.add(filtro);

        if ( !dao.buscar(dao.criarFiltro(filtros)).isEmpty() ) {
            throw new AlertException("Existem atividades ativas utilizando este profissional.");
        }

        dao.excluir(id);
    }
}
