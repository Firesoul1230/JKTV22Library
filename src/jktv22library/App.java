/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jktv22library;

import manager.HistoryManager;
import manager.ReaderManager;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;
import java.util.Scanner;
import manager.BookManager;
import manager.DatabaseManager;
import manager.SaveManager;
import tools.KeyboardInput;

/**
 *
 * @author Melnikov
 */
class App {
    //private Book[] books;
    
    private final List<Reader> readers;
    private List<History> histories;
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;
    private final HistoryManager historyManager;
    private final SaveManager saveManager;
    private final DatabaseManager databaseManager;

    public App() {
        this.saveManager = new SaveManager();
        this.databaseManager = new DatabaseManager();
        this.readers = saveManager.loadReaders();
        this.histories = saveManager.loadHistories();
        this.scanner = new Scanner(System.in);
        this.readerManager = new ReaderManager(scanner);
        this.bookManager = new BookManager(scanner);
        this.historyManager = new HistoryManager(scanner,bookManager, readerManager);
    }
    
    void run() {
        boolean repeat = true;
        do{
            System.out.println("Select task: ");
            System.out.println("0. Exit");
            System.out.println("1. Add new Book");
            System.out.println("2. Add new Reader");
            System.out.println("3. Give out a book to read");
            System.out.println("4. Print list readers");
            System.out.println("5. Print list books");
            System.out.println("6. Print list give out books");
            System.out.println("7. Return book");
            System.out.println("8. Rating of books by readability");
            System.out.print("Set task: ");
            int task = KeyboardInput.inputNumber(0, 8);
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    databaseManager.saveBook(bookManager.addBook());
                    break;
//                case 2:
//                    this.readers.add(readerManager.addReader());
//                    saveManager.saveReaders(readers);
//                    break;
//                case 3:
//                    History history = historyManager.giveOutBook(books, readers);
//                    if(history != null){
//                        this.histories.add(history);
//                        saveManager.saveHistories(this.histories);
//                    }
//                    break;
//                case 4:
//                    readerManager.printListReaders(readers);
//                    break;
//                case 5:
//                    bookManager.printListBooks(books);
//                    break;
//                case 6:
//                    bookManager.printListGiveOutBooks(histories);
//                    break;
//                case 7:
//                    List<History> histories = historyManager.returnBook(this.histories);
//                    if(histories != null){
//                        this.histories = histories;
//                        saveManager.saveHistories(this.histories);
//                    }
//                    break;
//                case 8:
//                    historyManager.RatingOfBooksByReadability(this.histories);
//                    break;
                default:
                    System.out.println("Select number from list!");
            }
            System.out.println("\n-----------------------------------------------------");
        }while(repeat);
    }
}
