/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Author;
import entity.Book;
import entity.History;
import facades.BookFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tools.KeyboardInput;

/**
 *
 * @author pupil
 */
public class BookManager {
private final Scanner scanner;
private final AuthorManager authorManager;
private final BookFacade bookFacade;

    public BookManager(Scanner scanner) {
        this.scanner = scanner;
        this.authorManager = new AuthorManager(scanner);
        this.bookFacade = new BookFacade();
    }
    public void createBook() {
        
                    Book book = new Book();
                    System.out.print("Enter title: ");
                    book.setTitle(scanner.nextLine());
                    System.out.print("Enter published year: ");
                    book.setPublishedYear(scanner.nextInt());
                    scanner.nextLine();
                    //список авторов
                    //если авторы есть, то вызвать выбрать
                    //иначе создать авторов
                    authorManager.printListAuthors();
                    System.out.println("If there are no authors in the list, press 0, if there are, press 1: ");
                    int isAuthors = KeyboardInput.inputNumber(0, 1);
                    if(isAuthors == 0){
                        authorManager.createAuthor();
                    }
                    
                    System.out.println("How many authors in this book: ");
                    int countAuthors = KeyboardInput.inputNumber(1, 5);
                    
                    List<Author> authorsBook = new ArrayList<>();
                    
                    for (int i = 0; i < countAuthors; i++) {
                        System.out.printf("Choose author %d: ",i+1);
                        int idAuthor = KeyboardInput.inputNumber(1, countAuthors);
                        
                        authorsBook.add(authorManager.find(idAuthor));
                            
                        
                    }
                    book.setAuthors(authorsBook);
                    
//                    for (int i = 0; i < countAuthors; i++) {
//                        System.out.println(i+1+" author:");
//                        System.out.print("Author firstname: ");
//                        String authorFirstname = scanner.nextLine();
//                        System.out.print("Author lastname: ");
//                        String authorLastname = scanner.nextLine();
//                        book.addAuthor(new Author(authorFirstname, authorLastname));
//                    }
                    System.out.println("Added book: ");
                    System.out.println(book.toString());
                    bookFacade.createBook(book);
                    
    }
    
    public void printListBooks () {
            List<Book> books = bookFacade.findAll();
            System.out.println("------ List books ------");
            for (int i = 0; i < books.size(); i++) {
                
                StringBuilder sbAuthorsBook = new StringBuilder();
                for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                    Author author = books.get(i).getAuthors().get(j);
                    sbAuthorsBook.append(author.getFirstname());
                    sbAuthorsBook.append(" ");
                    sbAuthorsBook.append(author.getLastname()+". ");
                }
                
                System.out.printf("%d. %s. %d. %s%n" , i+1,
                        books.get(i).getTitle(),
                        books.get(i).getPublishedYear(),
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
