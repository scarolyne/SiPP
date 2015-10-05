package DAO;

import Exception.ErrorException;
import Exception.FilterCreationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Filtro;

/**
 *
 * @author ricobonfim
 */
public class DAO {

    protected static Connection conn = null;

    public DAO() {
        Properties prop = new Properties();
        try {
            if (this.conn == null || this.conn.isClosed()) {
                String url = "jdbc:mysql://localhost/tcc";
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                prop.put("user", "root");
                prop.put("password", "");
                prop.put("autoReconnect", "true");

                conn = DriverManager.getConnection(url, prop);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String criarFiltro(Filtro filtro) throws FilterCreationException {
        String where = "";

        switch (filtro.getOperador()) {
            case "":
            case "AND":
            case "OR":
                where += filtro.getOperador() + " ";
                break;

            default:
                throw new FilterCreationException();
        }

        if (filtro.getIniciaAgrupamento()) {
            where += " (";
        }

        where += filtro.getCampo() + " ";

        switch (filtro.getTipo()) {
            case "EQUAL":
                where += "= " + filtro.getValor() + " ";
                break;

            case "NOT_EQUAL":
                where += "!= " + filtro.getValor() + " ";
                break;

            case "GREATER":
                where += "> " + filtro.getValor() + " ";
                break;

            case "GREATER_EQUAL":
                where += ">= " + filtro.getValor() + " ";
                break;

            case "LOWER":
                where += "< " + filtro.getValor() + " ";
                break;

            case "LOWER_EQUAL":
                where += "<= " + filtro.getValor() + " ";
                break;

            case "LIKELEFT":
                where += "LIKE '%" + filtro.getValor() + "' ";
                break;

            case "LIKERIGHT":
                where += "LIKE '" + filtro.getValor() + "%' ";
                break;

            case "LIKEALL":
                where += "LIKE '%" + filtro.getValor() + "%' ";
                break;
            case "LIKE":
                where += "LIKE '" + filtro.getValor() + "' ";
                break;
            case "NOTLIKE":
                where += "NOT LIKE '" + filtro.getValor() + "' ";
                break;
            case "NOTNULL":
                where += "IS NOT NULL ";
                break;

            case "NULL":
                where += "IS NULL ";
                break;

            case "IN":
                where += "IN (" + filtro.getValor() + ") ";
                break;

            case "NOTIN":
                where += "NOT IN (" + filtro.getValor() + ") ";
                break;

            case "EQUALMD5":
                where += "= MD5('" + filtro.getValor() + "') ";
                break;

            default:
                throw new FilterCreationException();
        }

        if (filtro.getFinalizaAgrupamento()) {
            where += " )";
        }

        return where;
    }

    public String criarFiltro(List<Filtro> parametros) throws FilterCreationException {

        String where = "";

        for (int i = 0; i < parametros.size(); i++) {
            where += this.criarFiltro(parametros.get(i));
        }

        return where;
    }

    public int getLastInsertedId(PreparedStatement stmt) throws ErrorException {
        int id = 0;
        try {
            ResultSet rs = stmt.getGeneratedKeys();

            if ( !rs.next() ) {
                throw new ErrorException();
            }

            id = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    public static void begin() throws ErrorException {
        try {
            DAO.conn.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public static void commit() throws ErrorException {
        try {
            DAO.conn.commit();
            DAO.conn.setAutoCommit(true);
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }

    public static void rollback() throws ErrorException {
        try {
            DAO.conn.rollback();
            DAO.conn.setAutoCommit(true);
        } catch (SQLException ex) {
            throw new ErrorException();
        }
    }
}
