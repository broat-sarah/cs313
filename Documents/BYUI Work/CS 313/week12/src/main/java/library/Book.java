/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
