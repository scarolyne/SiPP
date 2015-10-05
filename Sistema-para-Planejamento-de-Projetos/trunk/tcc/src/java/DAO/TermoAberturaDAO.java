/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.Aprovacao;
import bean.EntregaProjeto;
import bean.Projeto;
import bean.TermoAbertura;
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
public class TermoAberturaDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtEditar;
    private PreparedStatement stmtSalvarAprovadores;
    private PreparedStatement stmtSalvarEntregas;
    private PreparedStatement stmtVisualizar;
    private PreparedStatement stmtVisualizarAprovador;
    private PreparedStatement stmtVisualizarEntrega;
    private PreparedStatement stmtDeletaAprovador;
    private PreparedStatement stmtEditarEntrega;

    public TermoAberturaDAO() {
        prepareSalvar();
        prepareVisualizar();
        prepareEditar();
    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement("INSERT INTO termo_abertura ("
                    + "introducao,"
                    + "reponsabilidade,"
                    + "necessidade_basica,"
                    + "descricao_produto,"
                    + "orcamento_inicial,"
                    + "necessidade_suporte,"
                    + "controle_informacao,"
                    + "projeto_id"
                    + ") VALUES ("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "? )", Statement.RETURN_GENERATED_KEYS);

            this.stmtSalvarAprovadores = super.conn.prepareStatement("INSERT INTO aprovacao ("
                    + "nome,"
                    + "termo_abertura_id"
                    + ") VALUES ("
                    + "?,"
                    + "?)", Statement.RETURN_GENERATED_KEYS);

            this.stmtSalvarEntregas = super.conn.prepareStatement("INSERT INTO entregas_projeto("
                    + "data,"
                    + "descricao,"
                    + "tipo,"
                    + "projeto_id"
                    + ") VALUES("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "? )", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(TermoAberturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareEditar() {
        try {
            this.stmtEditar = super.conn.prepareStatement("UPDATE termo_abertura "
                    + "SET introducao=?,reponsabilidade=?, necessidade_basica=?, descricao_produto=?, "
                    + "orcamento_inicial=?, necessidade_suporte=?, controle_informacao=? "
                    + "WHERE id=? ");

            this.stmtDeletaAprovador = super.conn.prepareStatement("DELETE"
                    + " FROM aprovacao"
                    + " WHERE termo_abertura_id = ?");

            this.stmtEditarEntrega = super.conn.prepareStatement("UPDATE entregas_projeto"
                    + " SET data=?, descricao=?, tipo=? WHERE id=? ");
        } catch (SQLException ex) {
            Logger.getLogger(TermoAberturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareVisualizar() {
        try {
            this.stmtVisualizar = super.conn.prepareStatement("SELECT "
                    + "id,introducao, reponsabilidade, necessidade_basica, descricao_produto,"
                    + "orcamento_inicial, necessidade_suporte, controle_informacao, projeto_id "
                    + "FROM termo_abertura "
                    + "WHERE projeto_id = ?");

            this.stmtVisualizarAprovador = super.conn.prepareStatement("SELECT "
                    + "id, nome, termo_abertura_id"
                    + " FROM aprovacao"
                    + " WHERE termo_abertura_id = ?");

            this.stmtVisualizarEntrega = super.conn.prepareStatement("SELECT "
                    + "id, data, descricao, tipo, projeto_id "
                    + "FROM entregas_projeto "
                    + "WHERE projeto_id = ? ORDER BY data");
        } catch (SQLException ex) {
            Logger.getLogger(TermoAberturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void salvar(TermoAbertura termo) throws ErrorException {

        try {
            this.stmtSalvar.setString(1, termo.getIntroducao());
            this.stmtSalvar.setString(2, termo.getResponsabilidadeGP());
            this.stmtSalvar.setString(3, termo.getNecessidadeBasica());
            this.stmtSalvar.setString(4, termo.getDescricaoProduto());
            this.stmtSalvar.setString(5, termo.getOrcamentoInicial());
            this.stmtSalvar.setString(6, termo.getNecessidadeSuporte());
            this.stmtSalvar.setString(7, termo.getControleInformacao());
            this.stmtSalvar.setInt(8, termo.getProjeto().getId());
            int id = this.stmtSalvar.executeUpdate();

            termo.setId(id);
        } catch (SQLException ex) {
            throw new ErrorException();
        }

        for (Aprovacao aprov : termo.getAprovadores()) {
            try {
                this.stmtSalvarAprovadores.setString(1, aprov.getNome());
                this.stmtSalvarAprovadores.setInt(2, termo.getId());
                this.stmtSalvarAprovadores.executeUpdate();
                System.out.println(stmtSalvarAprovadores);
            } catch (SQLException ex) {
                throw new ErrorException();
            }
        }

        for (EntregaProjeto entrega : termo.getEntregas()) {
            salvarEntrega(entrega);
        }

    }

    public void salvarEntrega(EntregaProjeto entrega) throws ErrorException {
        try {
            this.stmtSalvarEntregas.setDate(1, new java.sql.Date(entrega.getData().getTime()));
            this.stmtSalvarEntregas.setString(2, entrega.getDescricao());
            this.stmtSalvarEntregas.setInt(3, entrega.getTipo());
            this.stmtSalvarEntregas.setInt(4, entrega.getProjeto().getId());
            this.stmtSalvarEntregas.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public void editarEntrega(EntregaProjeto entrega) throws ErrorException {
        try {
            this.stmtEditarEntrega.setDate(1, new java.sql.Date(entrega.getData().getTime()));
            this.stmtEditarEntrega.setString(2, entrega.getDescricao());
            this.stmtEditarEntrega.setInt(3, entrega.getTipo());
            this.stmtEditarEntrega.setInt(4, entrega.getId());
            this.stmtEditarEntrega.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public void editar(TermoAbertura termo) throws ErrorException {
        try {

            this.stmtEditar.setString(1, termo.getIntroducao());
            this.stmtEditar.setString(2, termo.getResponsabilidadeGP());
            this.stmtEditar.setString(3, termo.getNecessidadeBasica());
            this.stmtEditar.setString(4, termo.getDescricaoProduto());
            this.stmtEditar.setString(5, termo.getOrcamentoInicial());
            this.stmtEditar.setString(6, termo.getNecessidadeSuporte());
            this.stmtEditar.setString(7, termo.getControleInformacao());
            this.stmtEditar.setInt(8, termo.getId());
            this.stmtEditar.executeUpdate();

            this.stmtDeletaAprovador.setInt(1, termo.getId());
            this.stmtDeletaAprovador.executeUpdate();

            for (Aprovacao aprov : termo.getAprovadores()) {
                this.stmtSalvarAprovadores.setString(1, aprov.getNome());
                this.stmtSalvarAprovadores.setInt(2, termo.getId());
                this.stmtSalvarAprovadores.executeUpdate();
            }

            for (EntregaProjeto entrega : termo.getEntregas()) {
                if (entrega.getId() == 0) {
                    salvarEntrega(entrega);
                } else {
                    editarEntrega(entrega);
                }
            }
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public TermoAbertura visualizar(Projeto projeto) throws ErrorException {
        ResultSet rs;
        TermoAbertura termo = new TermoAbertura();
        List<Aprovacao> aprovadores = new ArrayList<>();
        List<EntregaProjeto> entregas = new ArrayList<>();

        try {
            this.stmtVisualizar.setInt(1, projeto.getId());
            rs = this.stmtVisualizar.executeQuery();

            while (rs.next()) {
                termo.setId(rs.getInt(1));
                termo.setIntroducao(rs.getString(2));
                termo.setResponsabilidadeGP(rs.getString(3));
                termo.setNecessidadeBasica(rs.getString(4));
                termo.setDescricaoProduto(rs.getString(5));
                termo.setOrcamentoInicial(rs.getString(6));
                termo.setNecessidadeSuporte(rs.getString(7));
                termo.setControleInformacao(rs.getString(8));

            }

            if (termo.getId() != 0) {
                aprovadores = aprovadores(termo.getId());
                entregas = entregasProjeto(projeto.getId());
                termo.setAprovadores(aprovadores);
                termo.setEntregas(entregas);
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao vizualizar Termo de abertura no banco de dados. Origem= " + e.getMessage());
        }

        return termo;
    }

    public List<Aprovacao> aprovadores(int id) throws ErrorException {
        ResultSet rs;
        Aprovacao aprov;
        List<Aprovacao> aprovadores = new ArrayList<>();

        try {
            this.stmtVisualizarAprovador.setInt(1, id);
            rs = this.stmtVisualizarAprovador.executeQuery();

            while (rs.next()) {
                aprov = new Aprovacao();
                aprov.setId(rs.getInt(1));
                aprov.setNome(rs.getString(2));
                aprovadores.add(aprov);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao vizualizar Aprovadores no banco de dados. Origem= " + e.getMessage());
        }

        return aprovadores;

    }

    public List<EntregaProjeto> entregasProjeto(int id) throws ErrorException {
        ResultSet rs;

        List<EntregaProjeto> entregas = new ArrayList<>();
        EntregaProjeto entrega;
        try {
            this.stmtVisualizarEntrega.setInt(1, id);
            rs = this.stmtVisualizarEntrega.executeQuery();

            while (rs.next()) {
                entrega = new EntregaProjeto();
                entrega.setId(rs.getInt(1));
                entrega.setData(rs.getDate(2));
                entrega.setDescricao(rs.getString(3));
                entrega.setTipo(rs.getInt(4));
                //entrega.getProjeto().setId(rs.getInt(5));
                entregas.add(entrega);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao vizualizar Entregas do Projeto no banco de dados. Origem= " + e.getMessage());
        }

        return entregas;

    }

}
