/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jktv22library;

import entity.Author;
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
    private Book[] books = new Book[0];
    private Reader[] readers = new Reader[0];
    private History[] histories = new History [0];

    void run() {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Select task: ");
            System.out.println("0. Exit");
            System.out.println("1. Add new Book");
            System.out.println("2. Add new Reader");
            System.out.println("3. Give out a book to read");
            System.out.print("Set task: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    BookManager bookManager = new BookManager(scanner);
                    addBookToArray(bookManager.addBook());
                    break;
                case 2:
                    ReaderManager readerManager = new ReaderManager(scanner);
                    addReaderToArray(readerManager.addReader());
                    break;
                case 3:
                    HistoryManager historyManager = new HistoryManager(scanner);
                    addHistoryToArray(historyManager.giveOutBook(books, readers));
                    break;
                default:
                    System.out.println("Select number from list!");
            }
            System.out.println("---------------------------");
        }while(repeat);
    }

    private void addBookToArray(Book book) {
        this.books = Arrays.copyOf(books, books.length + 1);
        this.books[books.length - 1] = book;
    }

    private void addReaderToArray(Reader reader) {
        this.readers = Arrays.copyOf(readers, readers.length + 1);
        this.readers[readers.length - 1] = reader;
    }

    private void addHistoryToArray(History history) {
        this.histories = Arrays.copyOf(histories, histories.length + 1);
        this.histories[histories.length - 1] = history;
    }
    
}
