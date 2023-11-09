/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Author;
import entity.Book;
import entity.History;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import tools.KeyboardInput;

/**
 *
 * @author Melnikov
 */
public class BookManager {
    private Scanner scanner;

    public BookManager(Scanner scanner) {
        this.scanner = scanner;
    }
    public Book addBook() {
        Book book = new Book();
        System.out.print("Enter title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter published year: ");
        book.setPublishedYear(KeyboardInput.inputNumber(1, 2050));
        
        System.out.println("How many authors: ");
        int countAuthors = KeyboardInput.inputNumber(1, 10);
        for (int i = 0; i < countAuthors; i++) {
            System.out.println(i+1+" author:");
            System.out.print("Author firstname: ");
            String authorFirstname = scanner.nextLine();
            System.out.print("Author lastname: ");
            String authorLastname = scanner.nextLine();
            book.addAuthor(new Author(authorFirstname, authorLastname));
        }
        System.out.print("Enter quantity copy: ");
        book.setQuantity(KeyboardInput.inputNumber(1, 10));
        book.setCount(book.getQuantity());
        System.out.println("Added book: ");
        System.out.println(book.toString());
        return book;
    }

    public void printListBooks(List<Book> books) {
        System.out.println("------- List books --------");
        for (int i = 0; i < books.size(); i++) {
            StringBuilder sbAuthorsBook = new StringBuilder();
            for (int j = 0; j < books.get(i).getAuthors().length; j++) {
                Author author = books.get(i).getAuthors()[j];
                sbAuthorsBook.append(author.getFirstname());
                sbAuthorsBook.append(" ");
                sbAuthorsBook.append(author.getLastname()+". ");
            }
            
            System.out.printf("%d. %s. %d. %s Count: %d%n",
                    i+1,
                    books.get(i).getTitle(),
                    books.get(i).getPublishedYear(),
                    sbAuthorsBook.toString(),
                    books.get(i).getCount()
            );
            
        }
    }

    public void printListGiveOutBooks(List<History> histories) {
       System.out.println("------- List books of hands --------"); 
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i).getDateBack() == null){
                System.out.printf("%d. \"%s\" to read %s %s. %s%n",
                        i+1,
                        histories.get(i).getBook().getTitle(),
                        histories.get(i).getReader().getFirstname(),
                        histories.get(i).getReader().getLastname(),
                        histories.get(i).getReader().getPhone()
                );
            }
            
        }
    }
    
    
}
