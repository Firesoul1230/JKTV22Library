/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class ReaderFacade {
    private EntityManager em;

    public ReaderFacade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
        this.em = emf.createEntityManager();
    }
    public void create(Reader reader){
       em.getTransaction().begin();
          em.persist(reader);
       em.getTransaction().commit();
    }
    public Reader find(Long id){
        return em.find(Reader.class, id);
    }
    public List<Reader> findAll(){
        return em.createQuery("SELECT reader FROM Reader reader").getResultList();
    }
    public void edit(Reader reader){
        em.getTransaction().begin();
          em.merge(reader);
       em.getTransaction().commit();
    }
}
