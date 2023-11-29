/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author pupil
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {

    private static final EntityManagerSingleton INSTANCE = new EntityManagerSingleton();
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    private EntityManagerSingleton() {
        // Имя persistence unit из вашего persistence.xml
        entityManagerFactory = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManagerSingleton getInstance() {
        return INSTANCE;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
