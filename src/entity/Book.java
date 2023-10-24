package entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Melnikov
 */
public class Book implements Serializable{
    private String title;
    private int publishedYear;
    private Author[] authors = new Author[0];

    public Book() {
    }

    public Book(String title, int publishedYear, Author[] authors) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.authors = authors;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        this.authors = Arrays.copyOf(authors, authors.length+1);
        this.authors[authors.length-1] = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.title);
        hash = 19 * hash + this.publishedYear;
        hash = 19 * hash + Arrays.deepHashCode(this.authors);
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
        final Book other = (Book) obj;
        if (this.publishedYear != other.publishedYear) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Arrays.deepEquals(this.authors, other.authors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book{");
        sb.append("title=").append(title);
        sb.append(", publishedYear=").append(publishedYear);
        sb.append(", authors=").append(Arrays.toString(authors));
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
