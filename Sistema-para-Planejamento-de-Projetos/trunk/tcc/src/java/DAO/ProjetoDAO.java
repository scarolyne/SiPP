/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.Projeto;
import bean.Usuario;
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
public class ProjetoDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtExcluir;

    public ProjetoDAO() {
        prepareSalvar();
        prepareExcluir();
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar =
                    super.conn.prepareStatement(
                    "INSERT INTO projeto(titulo, "
                    + "        gerente_projeto) "
                    + "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Projeto salvar(Projeto projeto) throws ErrorException {
        try {
            this.stmtSalvar.setString(1, projeto.getTitulo());
            this.stmtSalvar.setInt(2, projeto.getGerente().getId());
           
            // int id = this.stmtSalvar.executeUpdate();
            this.stmtSalvar.executeUpdate();
            
            ResultSet rs = stmtSalvar.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            
            projeto.setId(id);
        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return projeto;
    }

    private void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement("UPDATE projeto "
                    + "     SET data_exclusao = now() "
                    + "   WHERE id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Projeto> buscarProjeto(String where) throws ErrorException {
        ResultSet rs;
        Projeto projeto;
        List<Projeto> projetos = new ArrayList<>();

        try {
            Statement stmt = super.conn.createStatement();

            String sql = "select id, "
                    + "          titulo, "
                    + "          gerente_projeto,"
                    + "          imagem"
                    + "     from projeto "
                    + "    where 1 = 1 "
                    + where;


            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                projeto = new Projeto();
                projeto.setId(rs.getInt(1));
                projeto.setTitulo(rs.getString(2));
                Usuario user = new Usuario();
                user.setId(rs.getInt(3));
                projeto.setImagem(rs.getString(4));
                projeto.setGerente(user);

                projetos.add(projeto);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return projetos;
    }

    public List<Projeto> buscarPendencias(String where) throws ErrorException {
        ResultSet rs;
        Projeto projeto;
        List<Projeto> projetos = new ArrayList<>();

        try {
            Statement stmt = super.conn.createStatement();

            String sql = "select p.id, "
                    + "          p.titulo, "
                    + "          p.gerente_projeto, "
                    + "          u.nome, "
                    + "          u.sobrenome "
                    + "     from projeto p "
                    + "     join usuario_has_projeto up on up.projeto_id = p.id "
                    + "     join usuario u on u.id = p.gerente_projeto "
                    + "    where 1 = 1 "
                    +      where;

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                projeto = new Projeto();
                projeto.setId(rs.getInt(1));
                projeto.setTitulo(rs.getString(2));
                Usuario user = new Usuario();
                user.setId(rs.getInt(3));
                user.setNome(rs.getString(4));
                user.setSobrenome(rs.getString(5));
                projeto.setGerente(user);
                projetos.add(projeto);
            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return projetos;
    }

}
