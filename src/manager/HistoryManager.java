/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Book;
import entity.History;
import entity.Reader;
import facades.HistoryFacade;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class HistoryManager{
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;
    private final HistoryManager historyFacade;

    public HistoryManager(Scanner scanner, BookManager bookManager, ReaderManager readerManager) {
        this.scanner = scanner;
        this.readerManager = readerManager;
        this.bookManager = bookManager;
        this.historyFacade = new HistoryFacade();
    }

    public History giveOutBook() {
        History history = new History();
        List<Reader> readers = readerManager.readers();
        List<Book> books = bookManager.books();
        /*
         * 1. Вывести список читателей
         * 2. Попросить пользователя выбрать номер читателя из списка
         * 3. Добавить выбранного читателя из массива readers в history
         * 4. Сделать 1-3 пункт для книги
         * 5. Добавить в history дату выдачи книги (текущую дату)
         */
        readerManager.printListReaders();
        int selectedReaderNumber = scanner.nextInt(); scanner.nextLine();
        history.setReader(readers.get(selectedReaderNumber-1));
        BookManager bookManager = new BookManager (scanner);
        bookManager.printListBooks();
        int selectedBooksNumber = scanner.nextInt(); scanner.nextLine();
        history.setBook(books.get(selectedBooksNumber-1));
        history.setDateOnHand(new GregorianCalendar().getTime());
        historyFacade.create(history);
        System.out.printf("%s given to reader: %s %s%n",
                history.getBook().getTitle(),
                history.getReader().getFirstname(),
                history.getReader().getLastname(),
            );
        return history;
    }
    
    public void returnBook (History[] histories) {
        List<History> histories = historyFacade.findAll();
        printListGiveOutBooks();
        System.out.print("Select book for return: ");
        int historyNumber = scanner.nextInt(); scanner.nextLine();
        histories[historyNumber-1].setDateBack(new GregorianCalendar().getTime());
        System.out.printf("Book \"%s\" returned",
                histories[historyNumber-1].getBook().getTitle()
        );
    }
}
