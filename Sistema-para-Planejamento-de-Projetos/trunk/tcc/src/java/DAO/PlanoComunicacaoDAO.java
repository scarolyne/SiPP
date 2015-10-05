/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.PlanoComunicacao;
import bean.Projeto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus PC
 */
public class PlanoComunicacaoDAO extends DAO {

    private PreparedStatement stmtBuscar;
    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtEditar;
    private PreparedStatement stmtExcluir;

    public PlanoComunicacaoDAO() {
        prepareSalvar();
        prepareEditar();
        prepareExcluir();
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement("INSERT INTO "
                    + "plano_comunicacao ("
                    + "foco, metodo, quando, interessado, informacao, projeto_id "
                    + ") VALUES ("
                    + " ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(PlanoComunicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void prepareEditar() {
        try {
            this.stmtEditar = super.conn.prepareStatement("UPDATE plano_comunicacao"
                    + " SET foco=?, metodo=?, quando=?, interessado=?, informacao=? "
                    + " WHERE id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(PlanoComunicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement("UPDATE plano_comunicacao SET"
                    + " data_exclusao = now()  "
                    + "WHERE id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(PlanoComunicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<PlanoComunicacao> buscaPlanoComunicacao(String where) throws ErrorException {
        List<PlanoComunicacao> listaComunicacao = new ArrayList<PlanoComunicacao>();

        try {
            ResultSet rs;
            Statement stmBusca = super.conn.createStatement();

            String sql = " SELECT id, "
                    + "interessado, "
                    + "foco, "
                    + "informacao, "
                    + "metodo, "
                    + "quando, "
                    + "projeto_id "
                    + "FROM plano_comunicacao "
                    + " WHERE "
                    + " DATA_EXCLUSAO IS NULL "
                    + where;

            rs = stmBusca.executeQuery(sql);
            PlanoComunicacao plano;
            Projeto projeto;

            while (rs.next()) {
                plano = new PlanoComunicacao();
                projeto = new Projeto();
                plano.setId(rs.getInt(1));
                plano.setInteressado(rs.getString(2));
                plano.setFoco(rs.getString(3));
                plano.setInformacao(rs.getString(4));
                plano.setMetodo(rs.getString(5));
                plano.setQuando(rs.getString(6));
                projeto.setId(rs.getInt(7));
                plano.setProjeto(projeto);
                listaComunicacao.add(plano);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return listaComunicacao;
    }

    public void salvar(PlanoComunicacao plano) throws ErrorException {
        try {

            this.stmtSalvar.setString(1, plano.getFoco());
            this.stmtSalvar.setString(2, plano.getMetodo());
            this.stmtSalvar.setString(3, plano.getQuando());
            this.stmtSalvar.setString(4, plano.getInteressado());
            this.stmtSalvar.setString(5, plano.getInformacao());
            this.stmtSalvar.setInt(6, plano.getProjeto().getId());
            this.stmtSalvar.executeUpdate();

        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public void editar(PlanoComunicacao plano) throws ErrorException {
        try {
            this.stmtEditar.setString(1, plano.getFoco());
            this.stmtEditar.setString(2, plano.getMetodo());
            this.stmtEditar.setString(3, plano.getQuando());
            this.stmtEditar.setString(4, plano.getInteressado());
            this.stmtEditar.setString(5, plano.getInformacao());
            this.stmtEditar.setInt(6, plano.getId());
            this.stmtEditar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public void excluir(PlanoComunicacao plano) throws ErrorException {
        try {
            this.stmtExcluir.setInt(1, plano.getId());
            this.stmtExcluir.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }
}
