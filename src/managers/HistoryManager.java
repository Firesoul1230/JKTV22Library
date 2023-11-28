/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import facades.HistoryFacade;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;


/**
 *
 * @author Melnikov
 */
public class HistoryManager{
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;
    private final HistoryFacade historyFacade;
    
    public HistoryManager(Scanner scanner,BookManager bookManager, ReaderManager readerManager) {
        this.scanner = scanner;
        this.readerManager = readerManager;
        this.bookManager = bookManager;
        this.historyFacade = new HistoryFacade();
    }
    public void giveOutBook(){
        History history = new History();
        List<Reader> readers = readerManager.readers();
        List<Book> books = bookManager.books();
        /*
         *  1. вывести спиок читателей
         *  2. попросить прользователя выбрать номер читателя из списка
         *  3. добавить выбранного читателя из массива readers в history
         *  4. сделать 1-3 пункт для книги
         *  5. добавить в history дату выдачи книги (текущую дату)
         */
        List<Integer> listId = readerManager.printListReaders();
        int selectedReaderNumber =  InputFromKeyboard.inputNumberFromRange(listId);//scanner.nextInt(); scanner.nextLine();
        
        history.setReader(readerManager.findById(selectedReaderNumber));
        listId = bookManager.printListBooks();
        int selectedBookNumber = InputFromKeyboard.inputNumberFromRange(listId);//scanner.nextInt(); scanner.nextLine();
        history.setBook(bookManager.findById(selectedBookNumber));
        history.setDateOnHand(new GregorianCalendar().getTime());
        historyFacade.create(history);
        System.out.printf("%s выдана читателю: %s %s%n",
                history.getBook().getTitle(),
                history.getReader().getFirstname(),
                history.getReader().getLastname()
        );
    }

    public void returnBook() {
        List<History> histories = historyFacade.findAll();
        printListGiveOutBooks();
        System.out.print("Select book for return: ");
        int historyNumber = scanner.nextInt(); scanner.nextLine();
        histories.get(historyNumber-1).setDateBack(new GregorianCalendar().getTime());
        System.out.printf("Book \"%s\" returned%n", 
                histories.get(historyNumber-1).getBook().getTitle()
        );
        historyFacade.edit(histories.get(historyNumber-1));
    }
    public void printListGiveOutBooks() {
       List<History> histories = historyFacade.findAll();
       System.out.println("------- List books of hands --------"); 
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i).getDateBack() == null){
                System.out.printf("%d. \"%s\" to read %s %s. %s%n",
                        histories.get(i).getId(),
                        histories.get(i).getBook().getTitle(),
                        histories.get(i).getReader().getFirstname(),
                        histories.get(i).getReader().getLastname(),
                        histories.get(i).getReader().getPhone()
                );
            }
            
        }
    }
    
}
