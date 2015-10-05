/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import DAO.DAO;
import Exception.AlertException;
import Exception.ErrorException;
import Exception.FilterCreationException;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProjetoModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author Camyla
 */
public class GeradorDePDF extends DAO {

    HttpSession session;

    public void GeraPDF(HttpServletRequest request, HttpServletResponse response) throws AlertException, ErrorException {
        try {
            session = request.getSession();
            int idProjeto = Integer.parseInt(""+ (String) session.getAttribute("idProjeto"));
            ProjetoModel modelProj = new ProjetoModel();
            String caminho = request.getServletContext().getRealPath("") + "\\casos_de_uso\\" + modelProj.buscar(request).get(0).getImagem();


            String jasper = (request.getContextPath() + "/view/relatorio/teste.jasper");
            String host = "http://" + request.getServerName() + ":"
                    + request.getServerPort();
            URL jasperUrl = new URL(host + jasper);

            HashedMap params = new HashedMap();

            BufferedImage image = ImageIO.read(new FileInputStream(caminho));

            // tem que ser maiusculo o parametro, porque la no xml do ireport eh maiusculo tambem
            params.put("IMAGEM", image );
            params.put("idProjeto", idProjeto);

            byte[] bytes = JasperRunManager.runReportToPdf(
                    jasperUrl.openStream(), params, super.conn);
            if (bytes != null) {
                response.setContentType("application/pdf");
                OutputStream ops = null;
                ops = response.getOutputStream();
                ops.write(bytes);
            }
        } catch (FilterCreationException ex) {
            throw new AlertException(ex.getMessage());
        } catch (Exception ex) {
            throw new ErrorException();
        }

    }

    public void GeraPDFPlanos(HttpServletRequest request, HttpServletResponse response) throws ErrorException {
        try {

            String jasper = (request.getContextPath() + "/view/relatorio/planos.jasper");
            String host = "http://" + request.getServerName() + ":"
                    + request.getServerPort();
            URL jasperUrl = new URL(host + jasper);

            HashedMap params = new HashedMap();
            byte[] bytes = JasperRunManager.runReportToPdf(
                    jasperUrl.openStream(), params, super.conn);
            if (bytes != null) {
                response.setContentType("application/pdf");
                OutputStream ops = null;
                ops = response.getOutputStream();
                ops.write(bytes);
            }
        } catch (Exception e) {
            throw new ErrorException();
        }
    }

}
