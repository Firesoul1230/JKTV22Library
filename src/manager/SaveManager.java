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
/**
 *
 * @author pupil
 */
public class SaveManager {
    public void saveBooks(Book[] books) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("books");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            fos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"books\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O books");
        }
    }
    public Book[] loadBooks(){
        Book[] books = new Book[0];
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("books");
            ois = new ObjectInputStream(fis);
            books = (Book[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"books\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O books");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Book not found");
        }
        return books;
    }
    
    public void saveReaders(Reader[] readers) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("readers");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            fos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"readers\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O readers");
        }
    }
    
    public Reader[] loadReaders(){
        Reader[] readers = new Reader[0];
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("readers");
            ois = new ObjectInputStream(fis);
            readers = (Reader[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"readers\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O readers");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Reader not found");
        }
        return readers;
    }
    
    public void saveHistories(History[] histories) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("histories");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            fos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"histories\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O histories");
        }
    }
    
    public History[] loadHistories(){
        History[] histories = new History[0];
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("histories");
            ois = new ObjectInputStream(fis);
            histories = (History[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"histories\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O histories");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class History not found");
        }
        return histories;
    }
}
