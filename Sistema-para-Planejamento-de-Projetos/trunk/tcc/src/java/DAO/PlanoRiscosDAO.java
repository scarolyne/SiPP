/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.PlanoRiscos;
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
 * @author Camyla
 */
public class PlanoRiscosDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtEditar;
    private PreparedStatement stmtPesquisar;
    private PreparedStatement stmtExcluir;

    public PlanoRiscosDAO() {
        prepareSalvar();
        prepareEditar();
        prepareExcluir();

    }

    public void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement("INSERT INTO plano_risco(condicao, classificacao, probabilidade, impacto, projeto_id, data_exclusao) "
                    + "VALUES (?,?,?,?,?, null)", Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException ex) {
            Logger.getLogger(PlanoRiscosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(PlanoRiscos plano) throws ErrorException {
        try {
            this.stmtSalvar.setString(1, plano.getCondicaoRisco());
            this.stmtSalvar.setString(2, plano.getClassificacaoRisco());
            this.stmtSalvar.setString(3, plano.getProbabilidadeRisco());
            this.stmtSalvar.setString(4, plano.getImpactoRisco());
            this.stmtSalvar.setInt(5, plano.getProjeto().getId());

            this.stmtSalvar.executeUpdate();

        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public void prepareEditar() {
        try {
            this.stmtEditar = super.conn.prepareStatement("UPDATE plano_risco SET condicao= ?,classificacao= ?,probabilidade= ?,impacto =? WHERE id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(PlanoRiscosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(PlanoRiscos plano) throws ErrorException {
        try {
            this.stmtEditar.setString(1, plano.getCondicaoRisco());
            this.stmtEditar.setString(2, plano.getClassificacaoRisco());
            this.stmtEditar.setString(3, plano.getProbabilidadeRisco());
            this.stmtEditar.setString(4, plano.getImpactoRisco());
            this.stmtEditar.setInt(5, plano.getProjeto().getId());

            this.stmtEditar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public List<PlanoRiscos> buscaRiscos(String where) throws ErrorException {
        List<PlanoRiscos> listaRiscos = new ArrayList<PlanoRiscos>();
        ResultSet rs;

        try {
            Statement stmtBusca = super.conn.createStatement();

            String sql = " SELECT id, "
                    + "condicao, "
                    + "classificacao, "
                    + "probabilidade, "
                    + "impacto, "
                    + "projeto_id "
                    + "FROM plano_risco "
                    + " WHERE "
                    + " data_exclusao IS NULL "
                    + where;


            rs = stmtBusca.executeQuery(sql);

            while (rs.next()) {
                PlanoRiscos plano = new PlanoRiscos();
                plano.setIdPlano(rs.getInt("id"));
                plano.setCondicaoRisco(rs.getString("condicao"));
                plano.setImpactoRisco(rs.getString("impacto"));
                plano.setProbabilidadeRisco(rs.getString("probabilidade"));
                plano.setClassificacaoRisco(rs.getString("classificacao"));
                plano.getProjeto().setId(rs.getInt("projeto_id"));

                listaRiscos.add(plano);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return listaRiscos;
    }

    public void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement("UPDATE plano_risco set data_exclusao = now() WHERE id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(PlanoRiscosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int id) throws ErrorException {
        try {
            this.stmtExcluir.setInt(1, id);
            this.stmtExcluir.executeUpdate();

        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }
}
