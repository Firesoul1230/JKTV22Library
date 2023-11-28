/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.History;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class HistoryFacade extends AbstractFacade<History>{
    private EntityManager em;

    public HistoryFacade() {
        super(History.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
        this.em = emf.createEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
