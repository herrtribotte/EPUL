/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import dao.Achete;
import dao.AchetePK;
import dao.Article;
import dao.Client;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;
import org.hibernate.HibernateException;

/**
 *
 * @author Michael
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AcheteService extends AbstractService<Achete> {
    
    public AcheteService() {
        super(Achete.class);
    } 
    
    @EJB
    ClientService clientService;
    
    @EJB
    ArticleService articleService;
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void ajouterAchat(Integer idClient, Integer idArticle, Date uneDate)throws Exception {

        try {
            Achete unAchat = new Achete();
            Client unClient = clientService.rechercherParId(idClient);
            unAchat.setClient(unClient);
            Article unArticle = articleService.rechercherParId(idArticle);
            unAchat.setArticle(unArticle);
            unAchat.setDateAchat(uneDate);
            unAchat.setAchetePK(new AchetePK(idClient, idArticle));
            super.creer(unAchat);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Article> rechercherParClient(Integer idClient) {
        Query query = getEntityManager().createNamedQuery("Achete.findByIdClient");
        query.setParameter("idClient", idClient);
        return (List<Article>) query.getResultList();
    }
}
