/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Melnikov
 */
public class History implements Serializable{
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

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.dateOnHand);
        hash = 59 * hash + Objects.hashCode(this.dateBack);
        hash = 59 * hash + Objects.hashCode(this.book);
        hash = 59 * hash + Objects.hashCode(this.reader);
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
        if (!Objects.equals(this.dateOnHand, other.dateOnHand)) {
            return false;
        }
        if (!Objects.equals(this.dateBack, other.dateBack)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        return Objects.equals(this.reader, other.reader);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("History{");
        sb.append("dateOnHand=").append(dateOnHand);
        sb.append(", dateBack=").append(dateBack);
        sb.append(", book=").append(book);
        sb.append(", reader=").append(reader);
        sb.append('}');
        return sb.toString();
    }
    
}
