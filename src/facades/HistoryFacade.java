/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.History;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class HistoryFacade {
    private EntityManager em;

    public HistoryFacade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
        this.em = emf.createEntityManager();
    }
    public void create(History history){
       em.getTransaction().begin();
          em.persist(history);
       em.getTransaction().commit();
    }
    public History find(Long id){
        return em.find(History.class, id);
    }
    public List<History> findAll(){
        return em.createQuery("SELECT history FROM History history").getResultList();
    }
    public void edit(History history){
        em.getTransaction().begin();
          em.merge(history);
       em.getTransaction().commit();
    }
    
    
}
