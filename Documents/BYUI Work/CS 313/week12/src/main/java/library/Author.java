/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author sarahbroat
 */
@Entity
public class Author {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @ManyToOne 
       private Book book;

    public int getId() { 
           return id;
    }

    public void setId(int id) { 
           this.id = id;
    }

    public String getName() { 
           return name;
    }

    public void setName(String name) {
           this.name = name;
    }
    
    public Book getBook() { 
              return book;
       }

       public void setBook(Book book) { 
              this.book = book;
       }
}
