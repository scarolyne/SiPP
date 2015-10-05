/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AtividadeProfissionalDAO;
import Exception.ErrorException;

/**
 *
 * @author Asus PC
 */
public class AtividadeProfissionalModel extends Model {

    AtividadeProfissionalDAO dao;

    public AtividadeProfissionalModel() {
        this.dao = new AtividadeProfissionalDAO();
    }

    public void excluir(int profissional, int atividade) throws ErrorException {
        dao.excluir(profissional, atividade);
    }

}
