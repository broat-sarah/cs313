/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 *
 * @author sarahbroat
 */
@Entity
public class Book {
    
    @Id 
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
       private String title;
       private int author_id;

       
       @OneToMany(mappedBy = "book")
            private List<Author> authors;

            public List<Author> getAuthors() {
                   return authors;
            }

            public void setAuthors(List<Author> authors) {
                   this.authors = authors;
            }
    
       public int getId() {
           return id;
       }

       public void setId(int id) {
          this.id = id;
       }

       public String getTitle() {
           return title;
       }

       public void setTitle(String title) {
           this.title = title;
       }
       
        public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}