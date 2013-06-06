/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author micha_000
 */
public abstract class AbstractService<T> {

    @PersistenceContext(unitName = "NetArticlesJ2EE-ejbPU")
    private EntityManager em;
    
    private Class<T> entityClass;

    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T rechercherParId(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> rechercherTout() {
        Query query = em.createQuery("from " + entityClass.getName());
        return query.getResultList();
    }
    
    public void creer(T entity) {
        em.persist(entity);
    }

    public T modifier(T entity) {
        return em.merge(entity);
    }

    public void supprimer(T entity) {
        em.remove(em.merge(entity));
    }

    public int compter() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }
}
