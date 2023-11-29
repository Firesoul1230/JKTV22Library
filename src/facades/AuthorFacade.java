/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Author;
import javax.persistence.EntityManager;
import tools.EntityManagerSingleton;

/**
 *
 * @author Melnikov
 */
public class AuthorFacade extends AbstractFacade<Author>{
    private EntityManager em;

    public AuthorFacade() {
        super(Author.class);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
//        this.em = emf.createEntityManager();
        EntityManagerSingleton entityManagerSingleton = EntityManagerSingleton.getInstance();
        this.em = entityManagerSingleton.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
}
