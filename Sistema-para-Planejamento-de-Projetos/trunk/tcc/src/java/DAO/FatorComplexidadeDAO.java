/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.ErrorException;
import bean.FatorComplexidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus PC
 */
public class FatorComplexidadeDAO extends DAO {

    public List<FatorComplexidade> buscar(String where) throws ErrorException {
        ResultSet rs;
        FatorComplexidade fator;

        List<FatorComplexidade> fatores = new ArrayList();

        try {
            Statement stmt = super.conn.createStatement();

            String sql = ""
                    + "SELECT "
                    + "id, "
                    + "nome, "
                    + "valor, "
                    + "tipo "
                    + "FROM fator_complexidade "
                    + "WHERE"
                    + " data_exclusao IS NULL "
                    + where + " ";

            rs = stmt.executeQuery(sql);

           while (rs.next()) {
                fator = new FatorComplexidade();
                fator.setId(rs.getInt(1));
                fator.setNome(rs.getString(2));
                fator.setPeso(rs.getFloat(3));
                fator.setTipo(rs.getString(4));
                fatores.add(fator);

            }

        } catch (SQLException ex) {
            throw new ErrorException();
        }

        return fatores;
    }

}
