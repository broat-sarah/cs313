/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sarahbroat
 */
public class LibraryTester {
    
    public static void main(String[] args) {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AuthorJPA"); 
        EntityManager em = emf.createEntityManager();
        Query authorQuery = em.createQuery("SELECT a FROM author a");
        List<Author> authors = authorQuery.getResultList(); 

        for (Author author : authors) {
               System.out.println("Author: " + author.getName() + " has books: " + author.getBook().getTitle());
                em.close();
        }
    }
}
