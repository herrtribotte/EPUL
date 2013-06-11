/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.HibernateException;

/**
 *
 * @author micha_000
 */
public abstract class AbstractService<T> {

    @PersistenceContext(unitName = "NetArticlesJ2EE-ejbPU")
    private EntityManager em;
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    private Class<T> entityClass;

    public AbstractService(Class<T> entityClass) throws Exception  {
        this.entityClass = entityClass;
    }

    public T rechercherParId(Object id) throws Exception  {
        return em.find(entityClass, id);
    }

    public List<T> rechercherTout() throws Exception  {
        Query query = em.createQuery("from " + entityClass.getName());
        return query.getResultList();
    }
    
    public void creer(T entity) throws Exception  {
        em.persist(entity);
    }

    public T modifier(T entity) throws Exception  {
        return em.merge(entity);
    }

    public void supprimer(T entity) throws Exception  {
        em.remove(em.merge(entity));
    }

    public int compter() throws Exception {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }
}
