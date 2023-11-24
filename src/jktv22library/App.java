/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jktv22library;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.Scanner;
import manager.BookManager;
import manager.HistoryManager;
import manager.ReaderManager;

/**
 *
 * @author Melnikov
 */
class App {
    private Scanner scanner;
    private ReaderManager readerManager;
    private BookManager bookManager;
    private HistoryManager historyManager;
    
    public App() {
        this.scanner = new Scanner(System.in);
        this.readerManager = new ReaderManager(scanner);
        this.bookManager = new BookManager(scanner);
        this.historyManager = new HistoryManager(scanner, bookManager, readerManager);
    }

    void run() {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Select task: ");
            System.out.println("0. Exit");
            System.out.println("1. Add new Book");
            System.out.println("2. Add new Reader");
            System.out.println("3. Give out a book to read");
            System.out.println("4. Print list readers");
            System.out.println("5. Print list books");
            System.out.println("6. Print list given out books");
            System.out.println("7. Return book");
            System.out.print("Set task: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    bookManager.createBook();
                    break;
                case 2:
                    readerManager.createReader();
                    break;
                case 3:
                    addHistoryToArray(historyManager.giveOutBook(books, readers));
                    break;
                case 4:
                    readerManager.printListReaders();
                    break;
                case 5:
                    bookManager.printListBooks();
                    break;
                case 6:
                    bookManager.printListGivenOutBooks(histories);
                    break;
                case 7:
                    historyManager.returnBook(histories);
                    break;
                default:
                    System.out.println("Select number from list!");
            }
            System.out.println("---------------------------");
        }while(repeat);
    }
}
