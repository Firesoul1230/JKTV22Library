/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Melnikov
 */
public class SaveManager {
    
    private final String BOOKS_FILENAME = "books";
    private final String READERS_FILENAME = "readers";
    private final String HISTORIES_FILENAME = "histories";
    
    public void saveBooks(List<Book> books){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(BOOKS_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"books\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O books");
        }
    }
    public List<Book> loadBooks(){
        List<Book> books = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(BOOKS_FILENAME);
            ois = new ObjectInputStream(fis);
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException ex) {
           System.out.println("File \"books\" does not exist"); 
        } catch (IOException ex) {
           System.out.println("Error I/O books");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Book not found");
        }
        return books;
    }

    public List<Reader> loadReaders() {
        List<Reader> readers = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(READERS_FILENAME);
            ois = new ObjectInputStream(fis);
            readers = (List<Reader>) ois.readObject();
        } catch (FileNotFoundException ex) {
           System.out.println("File \"readers\" does not exist"); 
        } catch (IOException ex) {
           System.out.println("Error I/O readers");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Reader not found");
        }
        return readers;
    }

    public void saveReaders(List<Reader> readers) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(READERS_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"readers\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O readers");
        }
    }

    public List<History> loadHistories() {
        List<History> histories = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(HISTORIES_FILENAME);
            ois = new ObjectInputStream(fis);
            histories = (List<History>) ois.readObject();
        } catch (FileNotFoundException ex) {
           System.out.println("File \"histories\" does not exist"); 
        } catch (IOException ex) {
           System.out.println("Error I/O histories");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class historie not found");
        }
        return histories;
    }

    public void saveHistories(List<History> histories) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(HISTORIES_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"histories\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O histories");
        }
    }
}
