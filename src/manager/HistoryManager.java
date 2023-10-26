/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.KeyboardInput;

/**
 *
 * @author pupil
 */
public class HistoryManager{
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;

    public HistoryManager(Scanner scanner, BookManager bookManager, ReaderManager readerManager) {
        this.scanner = scanner;
        this.readerManager = readerManager;
        this.bookManager = bookManager;
    }

    public History giveOutBook(Book[] books, Reader[] readers) {
        History history = new History();
        /*
         * 1. Вывести список читателей
         * 2. Попросить пользователя выбрать номер читателя из списка
         * 3. Добавить выбранного читателя из массива readers в history
         * 4. Сделать 1-3 пункт для книги
         * 5. Добавить в history дату выдачи книги (текущую дату)
         */
        /*System.out.println("List readers: ");
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s %s %s%n",i+1,readers[i].getFirstname(),readers[i].getLastname(),readers[i].getPhone());
            
        }*/
        
        readerManager.printListReaders(readers);
        int selectedReaderNumber = KeyboardInput.inputNumber(1, null);
        history.setReader(readers[selectedReaderNumber-1]);
        /*
        System.out.println("List books: ");
        for (int i = 0; i < books.length; i++) {
            System.out.printf("%d. %s. %d. %s%n",i+1,books[i].getTitle(),books[i].getPublishedYear(),Arrays.toString(books[i].getAuthors()));
            
        }*/
        
        bookManager.printListBooks(books);
        int selectedBooksNumber = KeyboardInput.inputNumber(1, null);
        history.setBook(books[selectedBooksNumber-1]);
        
        history.setDateOnHand(new GregorianCalendar().getTime());
        
        return history;
    }
    
    public History[] returnBook (History[] histories) {
        
        bookManager.printListGivenOutBooks(histories);
        System.out.print("Select book for return: ");
        int historyNumber = KeyboardInput.inputNumber(1, null);
        histories[historyNumber-1].setDateBack(new GregorianCalendar().getTime());
        System.out.printf("Book \"%s\" returned",
                histories[historyNumber-1].getBook().getTitle()
        );
        return histories;
    }
}
