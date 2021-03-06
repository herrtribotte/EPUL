/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Domaine;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author Michael
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DomaineService extends AbstractService<Domaine>{
    
    public DomaineService() {
        super(Domaine.class);
    }
}
