/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class DatabaseManager {
    EntityManager em;

    public DatabaseManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
        em = emf.createEntityManager();
    }
    
    public void saveBook(Book book) {
        /**
         * 1. Получаем список авторов из книги
         * 2. если у автора id = null, сохраняем
         * 3. иначе делаем обновление
         * 4. если ид книги = null, сохраняем книгу
         * 5. иначе делаем обновление
         */
        em.getTransaction().begin();
            for (int i = 0; i < book.getAuthors().size(); i++) {
                if(book.getAuthors().get(i).getId() == null) {
                    em.persist(book.getAuthors().get(i));
                }else{
                    em.merge(book.getAuthors().get(i));
                }
            }
            if(book.getId() == null) {
                em.persist(book);
            }else{
                em.merge(book);
            }
        em.getTransaction().commit();
    }
    
}
