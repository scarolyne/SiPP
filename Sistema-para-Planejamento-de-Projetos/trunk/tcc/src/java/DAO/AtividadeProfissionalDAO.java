package DAO;

import Exception.ErrorException;
import bean.AtividadeProfissional;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.Profissional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtividadeProfissionalDAO extends DAO {

    private PreparedStatement stmtExcluir;
    private PreparedStatement stmtSalvar;

    public AtividadeProfissionalDAO() {
        this.prepareExcluir();
        this.prepareSalvar();
    }

    private void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement(""
                    + "DELETE FROM"
                    + " atividade_has_profissional "
                    + "WHERE "
                    + " profissional_id = ?"
                    + " AND atividade_id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement(""
                    + "INSERT INTO atividade_has_profissional ( "
                    + " atividade_id,"
                    + " profissional_id,"
                    + " esforco "
                    + ") VALUES ("
                    + " ?,"
                    + " ?,"
                    + " ?)");
        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<AtividadeProfissional> buscar(String where) throws ErrorException {
        ResultSet rs;
        List<AtividadeProfissional> atividadeProfissionais = new ArrayList();

        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT"
                    + " id, "
                    + " cargo_id,"
                    + " nome, "
                    + " projeto_id,"
                    + " esforco "
                    + "FROM"
                    + " profissional "
                    + " LEFT JOIN atividade_has_profissional ON profissional_id = id "
                    + "WHERE"
                    + " data_exclusao IS NULL "
                    + where + " "
                    + "ORDER BY "
                    + " nome";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                AtividadeProfissional atividadeProfissional = new AtividadeProfissional();

                atividadeProfissional.getProfissional().setId(rs.getInt(1));
                atividadeProfissional.getProfissional().getCargo().setId(rs.getInt(2));
                atividadeProfissional.getProfissional().setNome(rs.getString(3));
                atividadeProfissional.getProfissional().getProjeto().setId(rs.getInt(4));
                atividadeProfissional.setEsforco(rs.getLong(5));

                atividadeProfissionais.add(atividadeProfissional);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return atividadeProfissionais;
    }

    public void excluir(int profissional, int atividade) throws ErrorException {
        try {
            this.stmtExcluir.setInt(1, profissional);
            this.stmtExcluir.setInt(2, atividade);
            this.stmtExcluir.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public void excluirPorAtividade(int atividade) throws ErrorException {
        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "DELETE FROM"
                    + " atividade_has_profissional "
                    + "WHERE "
                    + " atividade_id = " + atividade;

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public void salvar(AtividadeProfissional atividadeProfissional) throws ErrorException {
        try {
            this.stmtSalvar.setInt(1, atividadeProfissional.getAtividade().getId());
            this.stmtSalvar.setInt(2, atividadeProfissional.getProfissional().getId());
            this.stmtSalvar.setLong(3, atividadeProfissional.getEsforco());
            this.stmtSalvar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }
}
