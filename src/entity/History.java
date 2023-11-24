/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Melnikov
 */
@Entity
public class History implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal
    private Date dateOnHand;
    private Date dateBack;
    private Book book;
    private Reader reader;

    public History() {
    }

    public History(Date dateOnHand, Date dateBack, Book book, Reader reader) {
        this.dateOnHand = dateOnHand;
        this.dateBack = dateBack;
        this.book = book;
        this.reader = reader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOnHand() {
        return dateOnHand;
    }

    public void setDateOnHand(Date dateOnHand) {
        this.dateOnHand = dateOnHand;
    }

    public Date getDateBack() {
        return dateBack;
    }

    public void setDateBack(Date dateBack) {
        this.dateBack = dateBack;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.dateOnHand);
        hash = 29 * hash + Objects.hashCode(this.dateBack);
        hash = 29 * hash + Objects.hashCode(this.book);
        hash = 29 * hash + Objects.hashCode(this.reader);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final History other = (History) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateOnHand, other.dateOnHand)) {
            return false;
        }
        if (!Objects.equals(this.dateBack, other.dateBack)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "History{" 
                + "id=" 
                + id 
                + ", dateOnHand=" 
                + dateOnHand 
                + ", dateBack=" 
                + dateBack 
                + ", book=" 
                + book 
                + ", reader=" 
                + reader 
                + '}';
    }

    
    
}
