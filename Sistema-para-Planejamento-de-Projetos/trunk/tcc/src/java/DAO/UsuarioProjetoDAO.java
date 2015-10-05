/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.Projeto;
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
 * @author Carol
 */
public class UsuarioProjetoDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtAtualizar;
    private PreparedStatement stmtExcluir;

    public UsuarioProjetoDAO() {
        prepareSalvar();
        prepareAtualizar();
        prepareExcluir();
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar =
                super.conn.prepareStatement(
                    "INSERT INTO usuario_has_projeto("
                            + "     usuario_id, "
                            + "     projeto_id) "
                            + " VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(String equipe, int projeto) throws ErrorException {
        try {
            this.stmtSalvar.setInt(1, Integer.parseInt(equipe));
            this.stmtSalvar.setInt(2, projeto);
            this.stmtSalvar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    private void prepareAtualizar() {
        try {
            this.stmtAtualizar =
                super.conn.prepareStatement(
                    "update usuario_has_projeto set aprovacao = ?"
                  + " where usuario_id = ? and projeto_id = ?", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(String usuario_id, String projeto_id, String flag) throws ErrorException {
        try {
            this.stmtAtualizar.setString(1, flag);
            this.stmtAtualizar.setInt(2, Integer.parseInt(usuario_id));
            this.stmtAtualizar.setInt(3, Integer.parseInt(projeto_id));
            this.stmtAtualizar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    private void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement("DELETE FROM usuario_has_projeto WHERE usuario_id = ? and projeto_id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int id, int idProjeto) throws ErrorException{
        try {
            this.stmtExcluir.setInt(1, id);
            this.stmtExcluir.setInt(2, idProjeto);
            this.stmtExcluir.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }
    
    public List<UsuarioProjeto> buscarEquipe(String where) throws ErrorException {
        ResultSet rs;
        Projeto projeto;
        Usuario usuario;
        UsuarioProjeto usuarioProjeto;
        List<UsuarioProjeto> projetos = new ArrayList<>();

        try {
            Statement stmt = super.conn.createStatement();

            String sql = "select p.id, "
                    + "          p.titulo, "
                    + "          u.id, "
                    + "          u.email, "
                    + "          case coalesce(up.aprovacao, 'N')"
                    + "             when 'S' then 'Aprovado'"
                    + "             when 'N' then 'Aguardando Aprovação'"
                    + "          end as aprovacao "
                    + "     from projeto p "
                    + "     join usuario_has_projeto up on up.projeto_id = p.id "
                    + "     join usuario u on u.id = up.usuario_id "
                    + "    where 1 = 1 "
                    +      where
                    + " order by coalesce(up.aprovacao, 'N') desc, "
                    + "          u.email";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                projeto = new Projeto();
                projeto.setId(rs.getInt(1));
                projeto.setTitulo(rs.getString(2));
                
                usuario = new Usuario();
                usuario.setId(rs.getInt(3));
                usuario.setEmail(rs.getString(4));

                usuarioProjeto = new UsuarioProjeto();
                usuarioProjeto.setUsuario(usuario);
                usuarioProjeto.setProjeto(projeto);
                usuarioProjeto.setCargo(rs.getString(5));
                
                projetos.add(usuarioProjeto);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }
        return projetos;
    }
}
