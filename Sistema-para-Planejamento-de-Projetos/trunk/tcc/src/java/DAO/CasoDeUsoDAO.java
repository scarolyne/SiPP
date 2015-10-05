/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.CasoUso;
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
 * @author Camyla
 */
public class CasoDeUsoDAO extends DAO {

    private PreparedStatement stmtSalvar;
    private PreparedStatement stmtSalvarImagem;
    private PreparedStatement stmtExcluir;
    private PreparedStatement stmtBusca;

    public CasoDeUsoDAO() {
        prepareSalvar();
        prepareSalvarImagem();
        prepareExcluir();

    }

    private void prepareSalvar() {
        try {
            this.stmtSalvar = super.conn.prepareStatement("INSERT INTO "
                    + "caso_de_uso"
                    + "( nome, valor, tipo, projeto_id) "
                    + "VALUES "
                    + "(?,?,?,?)");
        } catch (SQLException ex) {
            Logger.getLogger(CasoDeUsoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareExcluir() {
        try {
            this.stmtExcluir = super.conn.prepareStatement("UPDATE caso_de_uso "
                    + "SET "
                    + "data_exclusao = now() "
                    + "WHERE "
                    + "id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(CasoDeUsoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void busca() {

        try {
            this.stmtBusca = super.conn.prepareStatement("SELECT IMAGEM FROM PROJETO WHERE ID =?");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void prepareSalvarImagem() {
        try {
            this.stmtSalvarImagem = super.conn.prepareStatement("UPDATE PROJETO SET IMAGEM = ? WHERE ID = ?");
        } catch (SQLException ex) {
            Logger.getLogger(CasoDeUsoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(CasoUso uc) throws ErrorException {

        try {
            this.stmtSalvar.setString(1, uc.getNome());
            this.stmtSalvar.setString(2, uc.getValor());
            this.stmtSalvar.setString(3, uc.getTipo());
            this.stmtSalvar.setInt(4, uc.getProjeto().getId());
            this.stmtSalvar.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public void salvarImagem(String nomeArquivo, int idProjeto) throws ErrorException {
        try {
            this.stmtSalvarImagem.setString(1, nomeArquivo);
            this.stmtSalvarImagem.setInt(2, idProjeto);

            this.stmtSalvarImagem.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }

    }

    public void excluir(CasoUso uc) throws ErrorException {

        try {
            this.stmtExcluir.setInt(1, uc.getId());
            this.stmtExcluir.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public List<CasoUso> buscar(String where) throws ErrorException {
        ResultSet rs;
        List<CasoUso> listaUC = new ArrayList<>();
        CasoUso casouso;

        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT "
                    + "id, "
                    + "tipo, "
                    + "nome, "
                    + "valor, "
                    + "projeto_id "
                    + "FROM caso_de_uso "
                    + "WHERE "
                    + "data_exclusao IS NULL "
                    + where;

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                casouso = new CasoUso();
                casouso.setId(rs.getInt(1));
                casouso.setTipo(rs.getString(2));
                casouso.setNome(rs.getString(3));
                casouso.setValor(rs.getString(4));
                listaUC.add(casouso);
            }
        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return listaUC;
    }

    public int contarUCporComplexidade(String where) throws ErrorException {
        ResultSet rs;
        int count = 0;
        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT COUNT(*) "
                    + "as count "
                    + "FROM caso_de_uso "
                    + "WHERE 1=1 "
                    + where;

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return count;
    }

//    public String buscaImagem(int idProjeto) {
//        String imagem = null;
//
//        try {
//            this.stmtBusca.setInt(1, idProjeto);
//            ResultSet rs = this.stmtBusca.executeQuery();
//
//            while (rs.next()) {
//                imagem = rs.getString(1);
//
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return imagem;
//
//    }
}
