/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import dao.Article;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ArticleService;
import services.DomaineService;

/**
 *
 * @author epulapp
 */
@WebServlet(name = "svrlUtilisateur", urlPatterns = {"/svrlUtilisateur"})
public class NetArticlesServlet extends HttpServlet {

    private String erreur;
    
    @EJB
    ArticleService articleService;
    
    @EJB
    DomaineService domaineService;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String demande;
        String pageReponse = "/index.jsp";
        erreur = "";
        try {
            demande = getDemande(request);
            if (demande.equalsIgnoreCase("accueil.do")) {
                pageReponse = acceuil(request);
            }
            else if (demande.equalsIgnoreCase("rechercher.do")) {
                pageReponse = rechercher(request);
            }
            else if (demande.equalsIgnoreCase("deconnexion.do")) {
               pageReponse = deconnexion(request);
            }
            else if (demande.equalsIgnoreCase("connexion.do")) {
               pageReponse = connexion(request);
            }
            else if (demande.equalsIgnoreCase("moncompte.do")) {
               pageReponse = moncompte(request);
            }
            else if (demande.equalsIgnoreCase("monpanier.do")) {
               pageReponse = monpanier(request);
            }
            else if (demande.equalsIgnoreCase("mesarticles.do")) {
               pageReponse = mesarticles(request);
            }
            else if (demande.equalsIgnoreCase("detailarticle.do")) {
               pageReponse = detailarticle(request);
            }
        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            request.setAttribute("erreur", erreur);
            RequestDispatcher dsp = request.getRequestDispatcher(pageReponse);
            dsp.forward(request, response);
        }
    }
    
     /**
     * Extrait le texte de la demande de l'URL
     *
     * @param request
     * @return String texte de la demande
     */
    private String getDemande(HttpServletRequest request) {
        String demande = "";
        demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        return demande;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String acceuil(HttpServletRequest request) throws Exception {
        String pageReponse;
        try {
            request.setAttribute("article", articleService.rechercherDernierArticle());
            pageReponse = "/index.jsp";
            return (pageReponse);
        } catch (Exception e) {
            throw e;
        }
    }

    private String rechercher(HttpServletRequest request) throws Exception{
       String pageReponse;
        try {
            List<Article> lstArticles = new ArrayList<Article>();
            String selectedValue = request.getParameter("codedomaine");
            if (selectedValue != null && !selectedValue.isEmpty() && !selectedValue.equals("0")) {
                int idDomaine = Integer.valueOf(selectedValue);
                lstArticles = articleService.rechercherParDomaine(idDomaine);
            }
            request.setAttribute("domaines", domaineService.rechercherTout());
            
            request.setAttribute("lstArticles", lstArticles);
            pageReponse = "/rechercher.jsp";
            return (pageReponse);
        } catch (Exception e) {
            throw e;
        }
    }

    private String deconnexion(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String connexion(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String moncompte(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String monpanier(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String mesarticles(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String detailarticle(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
