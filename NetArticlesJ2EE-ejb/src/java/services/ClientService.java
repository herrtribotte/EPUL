/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Categorie;
import dao.Client;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

/**
 *
 * @author Michael
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClientService extends AbstractService<Client>{

    @PersistenceContext(unitName = "NetArticlesJ2EE-ejbPU")
    private EntityManager em;
    
    @EJB
    private CategorieService categorieService;
    
    public ClientService() {
        super(Client.class);
    }
    
   /**
     * Mise à jour d'un client
     * @param idClient
     * @param idCategorie
     * @param identiteClient
     * @param adrClient
     * @param creditClient
     * @param loginClien
     * @param pwdClient
     * @throws Exception 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modifierClient(Integer idClient, Integer idCategorie, String identiteClient, String adrClient, Integer creditsClient, String loginClient, String pwdClient)throws Exception {

        try {
            Client unClient = rechercherParId(idClient);
            if (idCategorie != null || idCategorie != 0) {
                Categorie uneCategorie = categorieService.rechercherParId(idCategorie);
                unClient.setCategorie(uneCategorie);
            }
            unClient.setIdentiteClient(identiteClient);
            unClient.setAdresseClient(adrClient);
            unClient.setCredits(creditsClient);
            if (!loginClient.isEmpty() && !pwdClient.isEmpty()) {
                unClient.setLoginClient(loginClient);
                unClient.setPwdClient(pwdClient);
            }
            super.modifier(unClient);
        } catch (Exception e) {
            throw e;
        }
    }    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void ajouterClient(Integer idCategorie, String identiteClient, String adrClient, Integer creditsClient, String loginClient, String pwdClient)throws Exception {

        try {
            Client unClient = new Client();
             if (idCategorie != null || idCategorie != 0) {
                Categorie uneCategorie = categorieService.rechercherParId(idCategorie);
                unClient.setCategorie(uneCategorie);
            }
            unClient.setIdentiteClient(identiteClient);
            unClient.setAdresseClient(adrClient);
            unClient.setCredits(creditsClient);
            if (!loginClient.isEmpty() && !pwdClient.isEmpty()) {
                unClient.setLoginClient(loginClient);
                unClient.setPwdClient(pwdClient);
            }
            super.creer(unClient);
        } catch (Exception e) {
            throw e;
        }
    }  
    
    /**
     * Supprimer une occurrence de client sur la clé primaire
     * @param idClient
     * @return
     * @throws Exception 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void supprimerClient(Integer idClient) throws Exception {

        try {
           Client unClient = rechercherParId(idClient);
           super.supprimer(unClient);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Client rechercherClientParLoginPw(String login, String pwd) throws Exception {
        try {
            Query query = em.createNamedQuery("Client.findByLoginPwdClient");
            query.setParameter("loginClient", login);
            query.setParameter("pwdClient", pwd);
            return (Client)query.getSingleResult();

        } catch (Exception e) {
            throw e;
        }
    }
            
    
}
