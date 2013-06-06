/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Article;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ArticleService extends AbstractService<Article>{

    @PersistenceContext(unitName = "NetArticlesJ2EE-ejbPU")
    private EntityManager em;
    
    
    public ArticleService() {
        super(Article.class);
    }
    
    public Article rechercherDernierArticle() {
        Query query = em.createQuery("SELECT a FROM Article a WHERE a.dateArticle = (SELECT MAX(a1.dateArticle) FROM Article a1)");
        return (Article) query.getResultList().get(0);
    }

    public List<Article> rechercherParDomaine(int idDomaine) {
        Query query = em.createQuery("SELECT a FROM Article a WHERE a.domaine.idDomaine = :idDomaine");
        query.setParameter("idDomaine", idDomaine);
        return (List<Article>) query.getResultList();
    }
}
