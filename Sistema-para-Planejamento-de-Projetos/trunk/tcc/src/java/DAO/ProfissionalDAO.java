package DAO;

import Exception.ErrorException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Profissional;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfissionalDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtAtualizar;
    private PreparedStatement stmtExcluir;

    public ProfissionalDAO() {
        this.prepareSalvar();
        this.prepareAtualizar();
        this.prepareExcluir();
    }

    public List<Profissional> buscar(String where) throws ErrorException {
        ResultSet rs;
        List<Profissional> profissionais = new ArrayList();

        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT DISTINCT"
                    + " profissional.id, "
                    + " profissional.cargo_id,"
                    + " profissional.nome, "
                    + " profissional.projeto_id "
                    + "FROM"
                    + " profissional"
                    + " LEFT JOIN atividade_has_profissional ON atividade_has_profissional.profissional_id = profissional.id"
                    + " LEFT JOIN atividade ON atividade_has_profissional.atividade_id = atividade.id "
                    + "WHERE"
                    + " profissional.data_exclusao IS NULL "
                    + where + " "
                    + "ORDER BY "
                    + " profissional.nome";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Profissional profissional = new Profissional();

                profissional.setId(rs.getInt(1));
                profissional.getCargo().setId(rs.getInt(2));
                profissional.setNome(rs.getString(3));
                profissional.getProjeto().setId(rs.getInt(4));

                profissionais.add(profissional);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return profissionais;
    }

    public Profissional salvar(Profissional profissional) throws ErrorException {
        try {
            boolean gravou;

            this.stmtSalvar.setString(1, profissional.getNome());
            this.stmtSalvar.setInt(2, profissional.getCargo().getId());
            this.stmtSalvar.setInt(3, profissional.getProjeto().getId());
            gravou = this.stmtSalvar.executeUpdate() == 1;

            if (!gravou) {
                throw new ErrorException();
            }

            profissional.setId(super.getLastInsertedId(stmtSalvar));

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return profissional;
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement(""
                    + "INSERT INTO profissional ("
                    + "nome,"
                    + "cargo_id,"
                    + "projeto_id"
                    + ") VALUES ("
                    + "?,"
                    + "?,"
                    + "?"
                    + ")", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(Profissional profissional) throws ErrorException {
        try {
            this.stmtAtualizar.setString(1, profissional.getNome());
            this.stmtAtualizar.setInt(2, profissional.getCargo().getId());
            this.stmtAtualizar.setInt(3, profissional.getProjeto().getId());
            this.stmtAtualizar.setInt(4, profissional.getId());
            this.stmtAtualizar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    private void prepareAtualizar() {
        try {
            this.stmtAtualizar = super.conn.prepareStatement(""
                    + "UPDATE profissional SET "
                    + " nome = ?,"
                    + " cargo_id = ?,"
                    + " projeto_id = ? "
                    + "WHERE "
                    + " id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    private void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement(""
                    + "UPDATE profissional SET "
                    + " data_exclusao = NOW()"
                    + "WHERE "
                    + " id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
