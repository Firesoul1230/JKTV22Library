/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
import facades.BookFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;

/**
 *
 * @author Melnikov
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
        // если авторы есть, то вызвоть вырать
        // иначе создать авторов
        authorManager.printListAuthors();
        do{
            System.out.print("Если авторов в списке нет, нажми 0, если есть, нажми 1: ");
            int isAuthors = InputFromKeyboard.inputNumberFromRange(0, 1);
            if(isAuthors == 0){
                authorManager.createAuthor();
                authorManager.printListAuthors();
            }else{
                break;
            }
        }while(true);
        System.out.println("Сколько авторов у книги: ");
        int countAuthors = InputFromKeyboard.inputNumberFromRange(1, 5);
        List<Author> authorsBook = new ArrayList<>();
        for (int i = 0; i < countAuthors; i++) {
            System.out.printf("Выберите автора %d: ",i+1);
            int idAuthor = InputFromKeyboard.inputNumberFromRange(1, null);
            authorsBook.add(authorManager.find(idAuthor));
        }
        book.setAuthors(authorsBook);
        
        bookFacade.create(book);
        System.out.println("Added book: ");
        System.out.println(book.toString());
    }

    public List<Integer> printListBooks() {
        List<Book> books = bookFacade.findAll();
        List<Integer> arrayBookId = new ArrayList<>();
        System.out.println("------- List books --------");
        for (int i = 0; i < books.size(); i++) {
            StringBuilder sbAuthorsBook = new StringBuilder();
            for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                Author author = books.get(i).getAuthors().get(j);
                sbAuthorsBook.append(author.getFirstname());
                sbAuthorsBook.append(" ");
                sbAuthorsBook.append(author.getLastname());
                sbAuthorsBook.append(". ");
            }
            System.out.printf("%d. %s. %d. %s%n",
                    books.get(i).getId(),
                    books.get(i).getTitle(),
                    books.get(i).getPublishedYear(),
                    sbAuthorsBook.toString()
            );
            arrayBookId.add(books.get(i).getId().intValue());
        }
        return arrayBookId;
    }

    
    
    public List<Book> books(){
        return bookFacade.findAll();
    }

    public Book findById(int id) {
        return bookFacade.find((long)id);
    }
}
