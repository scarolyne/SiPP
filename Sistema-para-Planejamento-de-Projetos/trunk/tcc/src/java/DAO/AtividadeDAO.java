package DAO;

import Exception.ErrorException;
import bean.Atividade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtividadeDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtAtualizar;
    private PreparedStatement stmtEditar;
    private PreparedStatement stmtExcluir;

    public AtividadeDAO() {
        prepareSalvar();
        prepareAtualizar();
        prepareEditar();
        prepareExcluir();
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement(""
                    + "INSERT INTO atividade ("
                    + " nome,"
                    + " projeto_id,"
                    + " inicio,"
                    + " fim,"
                    + " descricao,"
                    + " progresso,"
                    + " status,"
                    + " duracao, "
                    + " id_pacote"
                    + ") VALUES ("
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(AtividadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Atividade salvar(Atividade atividade) throws ErrorException {
        ResultSet rs;

        try {
            this.stmtSalvar.setString(1, atividade.getNome());
            this.stmtSalvar.setInt(2, atividade.getProjeto().getId());
            //this.stmtSalvar.setInt(2, 1);
            this.stmtSalvar.setLong(3, atividade.getInicio());
            this.stmtSalvar.setLong(4, atividade.getFim());
            this.stmtSalvar.setString(5, atividade.getDescricao());
            this.stmtSalvar.setInt(6, atividade.getProgresso());
            this.stmtSalvar.setString(7, String.valueOf(atividade.getStatus()));
            this.stmtSalvar.setInt(8, atividade.getDuracao());
            if (atividade.getIdPacote() != 0) {
                this.stmtSalvar.setInt(9, atividade.getIdPacote());
            } else {
                this.stmtSalvar.setNull(9, Types.NULL);
            }

            this.stmtSalvar.executeUpdate();

            rs = this.stmtSalvar.getGeneratedKeys();
            if (rs.next()) {
                atividade.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return atividade;
    }

    public void atualizar(Atividade atividade) throws ErrorException {
        try {
            this.stmtAtualizar.setString(1, atividade.getNome());
            this.stmtAtualizar.setLong(2, atividade.getInicio());
            this.stmtAtualizar.setLong(3, atividade.getFim());
            this.stmtAtualizar.setString(4, atividade.getDescricao());
            this.stmtAtualizar.setInt(5, atividade.getProgresso());
            this.stmtAtualizar.setString(6, String.valueOf(atividade.getStatus()));
            this.stmtAtualizar.setInt(7, atividade.getDuracao());
            this.stmtAtualizar.setInt(8, atividade.getId());
            this.stmtAtualizar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    private void prepareEditar() {
        try {
            this.stmtEditar = super.conn.prepareStatement(""
                    + "UPDATE atividade"
                    + "   SET nome = ? "
                    + " WHERE id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(Atividade atividade) throws ErrorException {
        try {
            this.stmtEditar.setString(1, atividade.getNome());
            this.stmtEditar.setInt(2, atividade.getId());
            this.stmtEditar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    private void prepareAtualizar() {
        try {
            this.stmtAtualizar = super.conn.prepareStatement(""
                    + "UPDATE atividade SET "
                    + " nome = ?,"
                    + " inicio = ?,"
                    + " fim = ?,"
                    + " descricao = ?,"
                    + " progresso = ?,"
                    + " status = ?, "
                    + " duracao = ? "
                    + "WHERE "
                    + " id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Atividade> buscar(String where) throws ErrorException {
        try {
            ResultSet rs;
            Atividade atividade;

            List<Atividade> atividades = new ArrayList();

            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT"
                    + "  atividade.id, "
                    + "  atividade.nome,"
                    + "  atividade.projeto_id,"
                    + "  SUM(esforco) AS esforco_estimado,"
                    + "  atividade.inicio,"
                    + "  atividade.fim,"
                    + "  atividade.descricao,"
                    + "  atividade.progresso,"
                    + "  atividade.status,"
                    + "  atividade.duracao,"
                    + "  atividade.id_pacote,"
                    + "  COALESCE( GROUP_CONCAT(DISTINCT atividade_anterior), '' ) AS dependencias "
                    + "FROM"
                    + "  atividade"
                    + "  LEFT JOIN atividade_has_profissional ON atividade_has_profissional.atividade_id = atividade.id"
                    + "  LEFT JOIN atividade_sequencia ON atividade_sequencia.atividade = atividade.id "
                    + "WHERE"
                    + "  atividade.data_exclusao IS NULL "
                    + where + " "
                    + " GROUP BY id "
                    + " ORDER BY id";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                atividade = new Atividade();
                atividade.setId(rs.getInt(1));
                atividade.setNome(rs.getString(2));
                atividade.getProjeto().setId(rs.getInt(3));
                atividade.setEsforcoEstimado(rs.getInt(4));
                atividade.setInicio(rs.getLong(5));
                atividade.setFim(rs.getLong(6));
                atividade.setDescricao(rs.getString(7));
                atividade.setProgresso(rs.getInt(8));

                if (!"null".equals("" + rs.getString(9))) {
                    atividade.setStatus(rs.getString(9).charAt(0));
                }

                atividade.setDuracao(rs.getInt(10));
                atividade.setIdPacote(rs.getInt(11));
                atividade.setSequenciamento(rs.getString(12));

                atividades.add(atividade);
            }

            return atividades;
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public List<Atividade> buscarPacotes(String where) throws ErrorException {
        ResultSet rs;
        Atividade atividade;
        List<Atividade> atividades = new ArrayList();

        try {
            Statement stmt = super.conn.createStatement();

        String sql = "select a.id, "
                + "          a.nome, "
                + "          a.id_pacote, "
                + "          a.projeto_id "
                + "     from atividade a "
                + "left join atividade a1 on a1.id = a.id_pacote and a1.data_exclusao is null "
                + "    where a.data_exclusao is null "
                +      where
                + " order by a.id_pacote, a.id";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                atividade = new Atividade();
                atividade.setId(rs.getInt(1));
                atividade.setNome(rs.getString(2));
                atividade.setIdPacote(rs.getInt(3));
                atividade.getProjeto().setId(rs.getInt(4));

                atividades.add(atividade);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return atividades;
    }

    public Atividade buscarId(int id) throws ErrorException {
        Atividade atividade = new Atividade();
        ResultSet rs;

        try {
            Statement stmt = super.conn.createStatement();



            String sql = "select id"
                    + "  from atividade"
                    + " where id = " + id;

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                atividade.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return atividade;
    }

    public void excluir(int id) throws ErrorException {
        try {
            this.stmtExcluir.setInt(1, id);
            this.stmtExcluir.setInt(2, id);
            this.stmtExcluir.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    private void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement(""
                    + "UPDATE atividade SET "
                    + " data_exclusao = NOW()"
                    + "WHERE "
                    + "id_pacote = ? or id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
