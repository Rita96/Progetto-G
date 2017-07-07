/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BusinessModel.BusinessModelUtente;
import Casa.AnnuncioCasa;
import Casa.CameraDisponibile;
import Casa.ElettroDomestico;
import Exceptions.NessunAnnuncioException;
import HtmlCreators.AnnuncioRisultanteCreator;
import ProfiloUtente.DatiUtente;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sistema.Sistema;

/**
 *
 * @author Margherita
 */
public class RisultatoAnnuncioServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idProprietario = Integer.parseInt(req.getParameter("id"));
            Sistema sys = new Sistema();
            AnnuncioCasa annuncio = sys.getAnnuncioProprietario(idProprietario);
            String formannuncio = HtmlReader.htmlReader("formAnnuncio.html");
            resp.getWriter().println(AnnuncioRisultanteCreator.creaPagina(formannuncio, annuncio, req, resp));
            resp.setStatus(200);
        } catch (SQLException ex) {
            Logger.getLogger(RisultatoCoinquiServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NessunAnnuncioException ex) {
            Logger.getLogger(RisultatoAnnuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
}
