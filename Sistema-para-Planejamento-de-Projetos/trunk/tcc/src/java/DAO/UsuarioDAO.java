package DAO;

import Exception.ErrorException;
import bean.Usuario;
import bean.UsuarioProjeto;
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
 * @author ricobonfim
 */
public class UsuarioDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtEditar;
    private PreparedStatement stmtTrocarSenha;

    public UsuarioDAO() {
        prepareSalvar();
        prepareEditar();
    }

    public Usuario salvar(Usuario usuario) throws ErrorException {
        try {
            this.stmtSalvar.setString(1, usuario.getNome());
            this.stmtSalvar.setString(2, usuario.getSobrenome());
            this.stmtSalvar.setString(3, usuario.getEmail());
            this.stmtSalvar.setString(4, usuario.getSenha());
            int id = this.stmtSalvar.executeUpdate();

            usuario.setId(id);

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return usuario;
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement("INSERT INTO usuario ("
                    + "nome,"
                    + "sobrenome,"
                    + "email,"
                    + "senha"
                    + ") VALUES ("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "MD5(?)"
                    + ")", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(Usuario usuario) throws ErrorException {
        try {
            this.stmtEditar.setString(1, usuario.getNome());
            this.stmtEditar.setString(2, usuario.getSobrenome());
            this.stmtEditar.setString(3, usuario.getEmail());
            this.stmtEditar.setInt(4, usuario.getId());

            if (!usuario.getSenha().isEmpty()) {
                this.stmtTrocarSenha.setString(1, usuario.getSenha());
                this.stmtTrocarSenha.setInt(2, usuario.getId());
                this.stmtTrocarSenha.executeUpdate();
            }

            this.stmtEditar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    private void prepareEditar() {
        try {
            this.stmtEditar = super.conn.prepareStatement("UPDATE usuario SET "
                    + "nome = ?, "
                    + "sobrenome = ?, "
                    + "email = ? "
                    + "WHERE id = ?", Statement.RETURN_GENERATED_KEYS);

            this.stmtTrocarSenha = super.conn.prepareStatement("UPDATE usuario SET "
                    + "senha = MD5(?) "
                    + "WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> buscar(String where) throws ErrorException {
        ResultSet rs;
        List<Usuario> usuarios = new ArrayList();

        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT"
                    + " usuario.id,"
                    + " usuario.nome,"
                    + " usuario.sobrenome,"
                    + " usuario.email,"
                    + " usuario.senha "
                    + "FROM"
                    + " usuario"
                    + " LEFT JOIN usuario_has_projeto ON usuario_has_projeto.usuario_id = usuario.id"
                    + " LEFT JOIN projeto ON usuario_has_projeto.projeto_id = projeto.id "
                    + "WHERE"
                    + " usuario.data_exclusao IS NULL "
                    + where + " "
                    + "ORDER BY "
                    + " usuario.nome";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt(1));
                usuario.setNome(rs.getString(2));
                usuario.setSobrenome(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                usuario.setSenha(rs.getString(5));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return usuarios;
    }
}
