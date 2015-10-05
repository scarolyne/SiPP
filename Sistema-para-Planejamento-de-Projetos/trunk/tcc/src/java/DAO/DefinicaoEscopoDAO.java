/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.DefinicaoEscopo;
import bean.EntregaProjeto;
import bean.Projeto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camyla
 */
public class DefinicaoEscopoDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtVisualizar;
    private PreparedStatement stmtInserir;

    public DefinicaoEscopoDAO() {
        prepareSalvar();
        prepareEditar();
        prepareInserir();
    }

    private void prepareInserir() {
        try {
            this.stmtInserir = super.conn.prepareStatement("INSERT INTO definicao_escopo( projeto_id) VALUES (?)");
        } catch (SQLException ex) {
            Logger.getLogger(DefinicaoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement("Update DEFINICAO_ESCOPO set DESCRICAO_ESCOPO = ?, CRITERIOS_ACEITACAO = ?,"
                    + "                EXCLUSAO = ?, RESTRICAO = ?, PREMISSA = ? where PROJETO_ID = ?");

        } catch (SQLException ex) {
            Logger.getLogger(DefinicaoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void prepareEditar() {
        try {
            this.stmtVisualizar = super.conn.prepareStatement("SELECT id,descricao_escopo, "
                    + "criterios_aceitacao, exclusao, "
                    + "restricao, premissa "
                    + "FROM definicao_escopo "
                    + "WHERE projeto_id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(DefinicaoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(int id) throws ErrorException {
        try {
            this.stmtInserir.setInt(1, id);
            this.stmtInserir.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public void salvar(DefinicaoEscopo def) throws ErrorException {
        try {
            this.stmtSalvar.setString(1, def.getDescricaoEscopo());
            this.stmtSalvar.setString(2, def.getCriteriosAceitacao());

            this.stmtSalvar.setString(3, def.getExclusoesProjeto());
            this.stmtSalvar.setString(4, def.getRestricoesProjeto());
            this.stmtSalvar.setString(5, def.getPremissasProjeto());
            this.stmtSalvar.setInt(6, def.getProjeto().getId());
            this.stmtSalvar.executeUpdate();

        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public DefinicaoEscopo visualizar(Projeto projeto) throws ErrorException {

        ResultSet rs;
        DefinicaoEscopo escopo = null;

        try {
            this.stmtVisualizar.setInt(1, projeto.getId());
            rs = this.stmtVisualizar.executeQuery();

            if (rs.next()) {
                escopo = new DefinicaoEscopo();
                escopo.setIdEscopo(rs.getInt(1));
                escopo.setDescricaoEscopo(rs.getString(2));
                escopo.setCriteriosAceitacao(rs.getString(3));
                escopo.setExclusoesProjeto(rs.getString(4));
                escopo.setRestricoesProjeto(rs.getString(5));
                escopo.setPremissasProjeto(rs.getString(6));
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return escopo;
    }
}
