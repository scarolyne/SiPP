package DAO;

import Exception.ErrorException;
import bean.Cargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtEditar;
    private PreparedStatement stmtExcluir;

    public CargoDAO() {
        prepareSalvar();
        prepareEditar();
        prepareExcluir();
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement("INSERT INTO cargo("
                    + "nome, "
                    + "projeto_id, "
                    + "preco_hora "
                    + ") VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareEditar() {
        try {
            this.stmtEditar = super.conn.prepareStatement("UPDATE cargo "
                    + "SET nome = ?, preco_hora = ? "
                    + "WHERE id = ? and projeto_id = ? ");
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement("UPDATE cargo "
                    + "SET data_exclusao = NOW() "
                    + "WHERE id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cargo salvar(Cargo cargo) throws ErrorException {
        try {
            boolean gravou;

            this.stmtSalvar.setString(1, cargo.getNome());
            this.stmtSalvar.setInt(2, cargo.getProjeto().getId());
            this.stmtSalvar.setDouble(3, cargo.getValorHora());

            gravou = this.stmtSalvar.executeUpdate() == 1;

            if ( gravou ) {
                cargo.setId(super.getLastInsertedId(stmtSalvar));
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return cargo;
    }

    public void editar(Cargo cargo) throws ErrorException {
        try {
            this.stmtEditar.setString(1, cargo.getNome());
            this.stmtEditar.setDouble(2, cargo.getValorHora());
            this.stmtEditar.setInt(3, cargo.getId());
            this.stmtEditar.setInt(4, cargo.getProjeto().getId());
            this.stmtEditar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public List<Cargo> buscar(String where) throws ErrorException {
        ResultSet rs;
        Cargo cargo;
        List<Cargo> cargos = new ArrayList();

        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT DISTINCT"
                    + " cargo.id,"
                    + " cargo.nome,"
                    + " cargo.projeto_id,"
                    + " cargo.preco_hora "
                    + "FROM"
                    + " cargo"
                    + " LEFT JOIN profissional ON profissional.cargo_id = cargo.id "
                    + "WHERE"
                    + " cargo.data_exclusao IS NULL "
                    + where + " "
                    + "ORDER BY"
                    + " cargo.nome";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cargo = new Cargo();
                cargo.setId(rs.getInt(1));
                cargo.setNome(rs.getString(2));
                cargo.getProjeto().setId(rs.getInt(3));
                cargo.setValorHora(rs.getDouble(4));

                cargos.add(cargo);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return cargos;
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
