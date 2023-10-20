/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Author;
import entity.Book;
import entity.History;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class BookManager {
private final Scanner scanner;

    public BookManager(Scanner scanner) {
        this.scanner = scanner;
    }
    public Book addBook() {
        
                    Book book = new Book();
                    System.out.print("Enter title: ");
                    book.setTitle(scanner.nextLine());
                    System.out.print("Enter published year: ");
                    book.setPublishedYear(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("How many authors: ");
                    int countAuthors = scanner.nextInt(); scanner.nextLine();
                    for (int i = 0; i < countAuthors; i++) {
                        System.out.println(i+1+" author:");
                        System.out.print("Author firstname: ");
                        String authorFirstname = scanner.nextLine();
                        System.out.print("Author lastname: ");
                        String authorLastname = scanner.nextLine();
                        book.addAuthor(new Author(authorFirstname, authorLastname));
                    }
                    System.out.println("Added book: ");
                    System.out.println(book.toString());
                    return book;
    }
    
    public void printListBooks (Book[] books) {
            System.out.println("------ List books ------");
            for (int i = 0; i < books.length; i++) {
                
                StringBuilder sbAuthorsBook = new StringBuilder();
                for (int j = 0; j < books[i].getAuthors().length; j++) {
                    Author author = books[j].getAuthors()[j];
                    sbAuthorsBook.append(author.getFirstname());
                    sbAuthorsBook.append(" ");
                    sbAuthorsBook.append(author.getLastname()+". ");
                }
                
                System.out.printf("%d. %s. %d. %s%n" , i+1,
                        books[i].getTitle(),
                        books[i].getPublishedYear(),
                        sbAuthorsBook.toString());
            }
    }

    public void printListGivenOutBooks(History[] histories) {
        System.out.println("------ List books of hands ------");
        for (int i = 0; i < histories.length; i++) {
            if(histories[i].getDateBack() == null) {
                System.out.printf("%d. \"%s\" to read %s %s. %s%n",
                        i+1,
                        histories[i].getBook().getTitle(),
                        histories[i].getReader().getFirstname(),
                        histories[i].getReader().getLastname(),
                        histories[i].getReader().getPhone()
                );
            }
        }
        
        
    }
}
