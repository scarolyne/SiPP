/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.FatorComplexidade;
import bean.Projeto;
import bean.ProjetoFatorComplexidade;
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
public class ProjetoFatorComplexidadeDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtCountUC;
    private PreparedStatement stmtBuscar;
    private PreparedStatement stmtEditar;

    public ProjetoFatorComplexidadeDAO() {
        prepareSalvar();
        prepareCount();
        prepareBuscar();
        prepareEditar();
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement("INSERT INTO projeto_has_fator_complexidade"
                    + "(projeto_id, fator_complexidade_id, classificacao) "
                    + "VALUES "
                    + "(?, ?, ?)");

        } catch (Exception e) {
        }
    }

    private void prepareEditar() {
        try {
            this.stmtEditar = super.conn.prepareStatement("UPDATE projeto_has_fator_complexidade SET "
                    + "classificacao = ? "
                    + "WHERE "
                    + "projeto_id = ? AND "
                    + "fator_complexidade_id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoFatorComplexidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareCount() {
        try {
            this.stmtCountUC = super.conn.prepareStatement("SELECT COUNT(*) "
                    + "as count "
                    + "FROM caso_de_uso "
                    + "WHERE valor = ? "
                    + "AND projeto_id = ? "
                    + "AND tipo = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoFatorComplexidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareBuscar() {
        try {
            this.stmtBuscar = super.conn.prepareStatement("SELECT"
                    + " id, projeto_id, fator_complexidade_id, classificacao "
                    + "FROM projeto_has_fator_complexidade "
                    + "LEFT JOIN fator_complexidade ON  "
                    + "WHERE projeto_id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoFatorComplexidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(ProjetoFatorComplexidade fator) throws ErrorException {
        try {
            this.stmtSalvar.setInt(1, fator.getProjeto().getId());
            this.stmtSalvar.setInt(2, fator.getFator().getId());
            this.stmtSalvar.setInt(3, fator.getClassificacao());
            this.stmtSalvar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public void editar(ProjetoFatorComplexidade fator) throws ErrorException {
        try {
            this.stmtEditar.setInt(1, fator.getClassificacao());
            this.stmtEditar.setInt(2, fator.getProjeto().getId());
            this.stmtEditar.setInt(3, fator.getFator().getId());
            this.stmtEditar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public int contarUCporComplexidade(String complexidade, int id, String valor) throws ErrorException {
        int count = 0;

        try {
            ResultSet rs;
            this.stmtCountUC.setString(1, complexidade);
            this.stmtCountUC.setInt(2, id);
            this.stmtCountUC.setString(3, valor);
            rs = this.stmtCountUC.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return count;
    }

    public List<ProjetoFatorComplexidade> buscar(String where) throws ErrorException {
        List<ProjetoFatorComplexidade> lista = new ArrayList<>();
        ProjetoFatorComplexidade projetoFC;
        ResultSet rs;

        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT "
                    + "id, "
                    + "projeto_id, "
                    + "fator_complexidade_id, "
                    + "classificacao "
                    + "FROM projeto_has_fator_complexidade "
                    + "WHERE "
                    + "1 = 1 "
                    + where;


            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                projetoFC = new ProjetoFatorComplexidade();

                projetoFC.setId(rs.getInt(1));
                projetoFC.getProjeto().setId(rs.getInt(2));
                projetoFC.getFator().setId(rs.getInt(3));
                projetoFC.setClassificacao(rs.getInt(4));

                lista.add(projetoFC);

            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return lista;
    }

    public List<ProjetoFatorComplexidade> buscarFT(Projeto projeto) throws ErrorException {
        List<ProjetoFatorComplexidade> lista = new ArrayList<>();

        try {
            ResultSet rs;
            ProjetoFatorComplexidade projetoFC;
            FatorComplexidade FC;

            this.stmtBuscar.setInt(1, projeto.getId());
            rs = this.stmtBuscar.executeQuery();

            while (rs.next()) {
                projetoFC = new ProjetoFatorComplexidade();
                FC = new FatorComplexidade();
                projeto = new Projeto();
                projetoFC.setId(rs.getInt(1));
                projeto.setId(rs.getInt(2));
                FC.setId(rs.getInt(3));
                projetoFC.setClassificacao(rs.getInt(4));
                projetoFC.setProjeto(projeto);
                projetoFC.setFator(FC);

                lista.add(projetoFC);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return lista;

    }
}
