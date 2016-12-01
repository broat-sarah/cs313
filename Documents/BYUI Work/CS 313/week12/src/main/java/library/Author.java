/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sarahbroat
 */
@Entity
public class Author implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Book> books = new ArrayList<Book>();
    
    public List<Book> getBooks() {
        return books;
    }
    
    public void setStudents(List<Book> books) {
        this.books = books;
    }
    
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
    
}