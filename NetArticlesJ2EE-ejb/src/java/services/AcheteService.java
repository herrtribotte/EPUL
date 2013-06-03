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
import dao.Achete;
import dao.Client;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

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
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void ajouterAchat(Integer idClient, Integer idArticle, Date uneDate)throws Exception {

        try {
            Achete unAchat = new Achete();
            Client unClient = clientService.rechercherParId(idClient);
            reservation.setAdherent(unAdherent);
            Oeuvre uneOeuvre =  oeuvreFacade.Lire_Oeuvre_Id(idOeuvre);
            reservation.setStatut("Attente");
            reservation.setOeuvre(uneOeuvre);
            reservation.setReservationPK(new ReservationPK(uneDate, idOeuvre));
            super.
        } catch (Exception e) {
            throw e;
        }
    }
}
