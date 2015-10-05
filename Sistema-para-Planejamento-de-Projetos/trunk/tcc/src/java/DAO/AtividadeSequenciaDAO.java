package DAO;

import Exception.ErrorException;
import bean.AtividadeSequencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carol
 */
public class AtividadeSequenciaDAO extends DAO {

    private PreparedStatement stmtSalvar;

    public AtividadeSequenciaDAO() {
        prepareSalvar();
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement(""
                    + "INSERT INTO atividade_sequencia ( "
                    + " atividade,"
                    + " atividade_anterior "
                    + ") VALUES ("
                    + " ?, ?)", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(AtividadeSequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(AtividadeSequencia atividade) throws ErrorException {
        try {
            this.stmtSalvar.setInt(1, atividade.getAtividade().getId());
            this.stmtSalvar.setInt(2, atividade.getAtividadeAnterior().getId());
            this.stmtSalvar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public void excluirPorAtividade(int atividade) throws ErrorException {
        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "DELETE FROM"
                    + " atividade_sequencia "
                    + "WHERE "
                    + " atividade = " + atividade;

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }
}
