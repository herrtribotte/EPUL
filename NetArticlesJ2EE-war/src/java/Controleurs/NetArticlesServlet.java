/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import dao.Article;
import dao.Client;
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
import javax.servlet.http.HttpSession;
import services.*;

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
    
    @EJB
    ClientService clientService;
    
    @EJB
    CategorieService categorieService;
    
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
            if (demande.equalsIgnoreCase("rechercher.do")) {
                pageReponse = rechercher(request);
            }
            else if (demande.equalsIgnoreCase("deconnexion.do")) {
               pageReponse = deconnexion(request);
            }
            else if (demande.equalsIgnoreCase("connexion.do")) {
               pageReponse = connexion(request);
            }
            else if (demande.equalsIgnoreCase("seconnecter.do")) {
               pageReponse = seconnecter(request);
            }
            else if (demande.equalsIgnoreCase("moncompte.do")) {
               pageReponse = moncompte(request);
            }
            else if (demande.equalsIgnoreCase("creercompte.do")) {
               pageReponse = creercompte(request);
            }
            else if (demande.equalsIgnoreCase("enregistrerclient.do")) {
               pageReponse = enregistrerClient(request);
            }
            else if (demande.equalsIgnoreCase("monpanier.do")) {
               pageReponse = monpanier(request);
            }
            else if (demande.equalsIgnoreCase("mesarticles.do")) {
               pageReponse = mesarticles(request);
            }
            else if (demande.equalsIgnoreCase("detailarticle.do")) {
               pageReponse = detailarticle(request);
            } else {
                pageReponse = acceuil(request);
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
                request.setAttribute("codeDomaine", selectedValue);
            }
            request.setAttribute("domaines", domaineService.rechercherTout());
            
            request.setAttribute("lstArticles", lstArticles);
            pageReponse = "/rechercher.jsp";
            return (pageReponse);
        } catch (Exception e) {
            throw e;
        }
    }

    private String deconnexion(HttpServletRequest request) throws Exception{
        String pageReponse;
        try {
            HttpSession uneSession = request.getSession();
            if (uneSession != null) {
                uneSession.removeAttribute("idClient");
                uneSession.invalidate();
            }
            pageReponse = "/connexion.do";
            return (pageReponse);
        } catch (Exception e) {
            throw e;
        }
    }

    private String connexion(HttpServletRequest request) throws Exception{
        String pageReponse;
        try {
            HttpSession uneSession = request.getSession();
            if (uneSession != null && uneSession.getAttribute("idClient") != null) {
                pageReponse = "/index.jsp";
            } else {
                pageReponse = "/connexion.jsp";
            }
            return pageReponse;
        } catch (Exception e) {
            throw e;
        }
    }

    private String moncompte(HttpServletRequest request) throws Exception{
        String pageReponse;
        try {
            HttpSession uneSession = request.getSession();
            
            if (uneSession != null && uneSession.getAttribute("idClient") != null) {
                Integer idClient = (Integer) uneSession.getAttribute("idClient");
                Client unClient = clientService.rechercherParId(idClient);
                request.setAttribute("client", unClient);
                pageReponse = "/compteUtilisateur.jsp";
            } else {
                pageReponse = "/connexion.jsp";
            }
            return pageReponse;
        } catch (Exception e) {
            throw e;
        }
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

    private String seconnecter(HttpServletRequest request) throws Exception{
        String pageReponse;
        try {
            String login = request.getParameter("txtLogin");
            String pw = request.getParameter("txtPwd");
            if (login != null && !login.isEmpty() && pw != null && !pw.isEmpty()) {
                HttpSession uneSession = request.getSession(true);
                Client unClient;
                try {
                    unClient = clientService.rechercherClientParLoginPw(login, pw);
                    uneSession.setAttribute("idClient", unClient.getIdClient());
                } catch (Exception e) {
                    request.setAttribute("txtLogin", login);
                    erreur = "Login et mot de passe incorrect";
                    return "/connexion.jsp";
                }
                pageReponse = "index.jsp";
            } else {
                request.setAttribute("txtLogin", login);
                erreur = "Vous devez saisir le login et mot de passe";
                pageReponse = "/connexion.jsp";
            }
            return (pageReponse);
        } catch (Exception e) {
            throw e;
        }
    }

    private String enregistrerClient(HttpServletRequest request) throws Exception{
        String pageReponse;
        try {
            String nom = request.getParameter("txtIdentiteClient");
            String adresse = request.getParameter("txtAdresseClient");
            String login = request.getParameter("txtLoginClient");
            String pw = request.getParameter("txtPwdClient");
            String credits = request.getParameter("txtCredits");
            String sIdCategorie = request.getParameter("lstCategories");
            if (nom == null || "".equals(nom)) {
                erreur = "Le nom est obligatoire";
            } else if (adresse == null || "".equals(adresse)) {
                erreur = "L'adresse est obligatoire";
            } else if (login == null || "".equals(login)) {
                erreur = "Le login est obligatoire";
            } else if (pw == null || "".equals(pw)) {
                erreur = "Le mot de passe est obligatoire";
            } else if (credits == null || "".equals(credits)) {
                erreur = "Le credit est obligatoire";
            } else if (sIdCategorie == null || "".equals(sIdCategorie) || "0".equals(sIdCategorie)) {
                erreur = "La catégorie est obligatoire";
            } else {
                HttpSession uneSession = request.getSession();
                Integer idCategorie = new Integer(sIdCategorie);
                Integer credit = new Integer(credits);
                if (uneSession != null && uneSession.getAttribute("idClient") != null) {
                    Integer idClient = (Integer) request.getAttribute("idClient");
                    clientService.modifierClient(idClient, idCategorie, nom, adresse, credit, login, pw);
                } else {
                    clientService.ajouterClient(idCategorie, nom, adresse, credit, login, pw);
                }
                return "index.jsp";
            }
            request.setAttribute("txtIdentiteClient", nom);
            request.setAttribute("txtAdresseClient", adresse);
            request.setAttribute("txtLoginClient", login);
            request.setAttribute("txtPwdClient", pw);
            request.setAttribute("txtCredits", credits);
            request.setAttribute("lstCategories", categorieService.rechercherTout());
            pageReponse = "compteUtilisateur.jsp";
            return (pageReponse);
        } catch (Exception e) {
            throw e;
        }
    }

    private String creercompte(HttpServletRequest request) throws Exception {
        String pageReponse;
        try {
            HttpSession uneSession = request.getSession();
            
            if (uneSession != null && uneSession.getAttribute("idClient") != null) {
                Integer idClient = (Integer) uneSession.getAttribute("idClient");
                Client unClient = clientService.rechercherParId(idClient);
                request.setAttribute("client", unClient);
                pageReponse = "/compteUtilisateur.jsp";
            } else {
                pageReponse = "/compteUtilisateur.jsp";
            }
            request.setAttribute("lstCategories", categorieService.rechercherTout());
            return pageReponse;
        } catch (Exception e) {
            throw e;
        }
    }

}
