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
        
        em.getTransaction().begin(); 

        Book newBook = new Book();
        newBook.setTitle("Stardust");
        newBook.setAuthor_id(3);

        em.persist(newBook);

        em.getTransaction().commit();
        
        
        em.getTransaction().begin(); 

        Author newAuthor = new Author();
        newAuthor.setName("Neil Gaiman");

        em.persist(newAuthor);

        em.getTransaction().commit();

        Query query = em.createQuery("SELECT b FROM Book b");
        List<Book> books = query.getResultList(); 

        for (Book book : books) {
               System.out.println("Book: " + book.getTitle());

               for (Author author : book.getAuthors()) { 
                      System.out.println("\tAuthor: " + author.getName());
               }
        }
    }
}