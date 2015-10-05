/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.FatorComplexidadeDAO;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.FatorComplexidade;
import java.util.List;
import utils.Filtro;

/**
 *
 * @author Asus PC
 */
public class FatorComplexidadeModel extends Model {

    FatorComplexidadeDAO dao;
    FatorComplexidade fator;

    public List<FatorComplexidade> buscarFatorTecnico() throws FilterCreationException, ErrorException {
        List<FatorComplexidade> listaFatores = buscarFatoresporTipo("T");
        return listaFatores;

    }

    public List<FatorComplexidade> buscarFatorAmbiental() throws FilterCreationException, ErrorException {
        List<FatorComplexidade> listaFatores = buscarFatoresporTipo("A");
        return listaFatores;

    }

    private List<FatorComplexidade> buscarFatoresporTipo(String tipo) throws FilterCreationException, ErrorException {
        dao = new FatorComplexidadeDAO();
        Filtro filtro = new Filtro();

        filtro.setCampo("tipo");
        filtro.setValor(tipo);
        filtro.setOperador("AND");
        filtro.setTipo("LIKE");

        String where = dao.criarFiltro(filtro);

        List<FatorComplexidade> listaFatores = dao.buscar(where);

        return listaFatores;
    }

     public FatorComplexidade buscarFatoresporId(int idFC) throws FilterCreationException, ErrorException {
        dao = new FatorComplexidadeDAO();
        Filtro filtro = new Filtro();

        filtro.setCampo("id");
        filtro.setValor(String.valueOf(idFC));
        filtro.setOperador("AND");
        filtro.setTipo("LIKE");

        String where = dao.criarFiltro(filtro);

       FatorComplexidade fator = dao.buscar(where).get(0);

        return fator;
    }

}
