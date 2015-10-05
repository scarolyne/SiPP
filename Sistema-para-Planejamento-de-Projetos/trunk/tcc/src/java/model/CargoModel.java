package model;

import DAO.CargoDAO;
import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.Cargo;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utils.Filtro;

public class CargoModel extends Model {

    CargoDAO dao;

    public CargoModel() {
        this.dao = new CargoDAO();
    }

    public Cargo salvar(HttpServletRequest request) throws ErrorException {
        HttpSession session = request.getSession();
        Cargo cargo = new Cargo();

        cargo.setNome(request.getParameter("cargo"));

        cargo.getProjeto().setId(Integer.parseInt("" + (String) session.getAttribute("idProjeto")));
        cargo.setValorHora(Double.parseDouble(request.getParameter("preco").replaceAll("\\.", "").replaceAll(",", ".")));

        String idCargo = "" + (String) request.getParameter("id");
        if (!"null".equals(idCargo) && !idCargo.isEmpty()) {
            cargo.setId(Integer.parseInt(idCargo));
            dao.editar(cargo);
        } else {
            cargo = dao.salvar(cargo);
        }

        return cargo;
    }

    public Cargo buscarPorId(int id) throws FilterCreationException, ErrorException {
        Filtro filtro = new Filtro();

        filtro.setCampo("cargo.id");
        filtro.setValor(String.valueOf(id));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");

        String where = dao.criarFiltro(filtro);
        return dao.buscar(where).get(0);
    }

    public List<Cargo> buscar(HttpServletRequest request) throws FilterCreationException, ErrorException {
        HttpSession session = request.getSession();
        List<Filtro> filtros = new ArrayList();
        Filtro filtro;

        filtro = new Filtro();
        filtro.setCampo("cargo.projeto_id");
        filtro.setValor("" + (String) session.getAttribute("idProjeto"));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        filtros.add(filtro);

        String cargo = "" + (String) request.getParameter("cargo");
        if (!"null".equals(cargo) && !cargo.isEmpty()) {
            filtro = new Filtro();
            filtro.setCampo("cargo.nome");
            filtro.setValor(cargo);
            filtro.setOperador("AND");
            filtro.setTipo("LIKEALL");

            filtros.add(filtro);
        }

        String preco = "" + (String) request.getParameter("preco");
        if (!"null".equals(preco) && !preco.isEmpty()) {
            preco = preco.replaceAll("\\.", "").replaceAll(",", ".");
            filtro = new Filtro();
            filtro.setCampo("cargo.preco_hora");
            filtro.setValor(preco);
            filtro.setOperador("AND");
            filtro.setTipo("EQUAL");

            filtros.add(filtro);
        }

        return dao.buscar(dao.criarFiltro(filtros));
    }

    public Cargo buscaPorId(int id) throws FilterCreationException, ErrorException {

        Filtro filtro = new Filtro();
        String where;

        filtro.setCampo("cargo.id");
        filtro.setValor(String.valueOf(id));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        where = dao.criarFiltro(filtro);

        return dao.buscar(where).get(0);

    }

    public void excluir(int id) throws ErrorException, AlertException {
        List<Filtro> filtros = new ArrayList();
        Filtro filtro;

        filtro = new Filtro();
        filtro.setCampo("profissional.data_exclusao");
        filtro.setValor("");
        filtro.setOperador("AND");
        filtro.setTipo("NULL");
        filtros.add(filtro);

        filtro = new Filtro();
        filtro.setCampo("profissional.cargo_id");
        filtro.setValor(String.valueOf(id));
        filtro.setOperador("AND");
        filtro.setTipo("EQUAL");
        filtros.add(filtro);

        if ( !dao.buscar(dao.criarFiltro(filtros)).isEmpty() ) {
            throw new AlertException("Existem profissionais ativos utilizando este cargo.");
        }

        dao.excluir(id);
    }

}
