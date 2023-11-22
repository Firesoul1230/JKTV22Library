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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import tools.KeyboardInput;


/**
 *
 * @author Melnikov
 */
public class HistoryManager{
    private Scanner scanner;
    private ReaderManager readerManager;
    private BookManager bookManager;
    
    public HistoryManager(Scanner scanner,BookManager bookManager, ReaderManager readerManager) {
        this.scanner = scanner;
        this.readerManager = readerManager;
        this.bookManager = bookManager;
    }
    /**
     * Алгоритм выдачи книги читателю.
     *  1. вывести спиок читателей
     *  2. попросить прользователя выбрать номер читателя из списка
     *  3. добавить выбранного читателя из массива readers в history
     *  4. сделать 1-3 пункт для книги
     *  5. создавать history, только если book.getCount() > 0, иначе возвращать null
     *  6. добавить в history дату выдачи книги (текущую дату)
     */
    public History giveOutBook(List<Book> books, List<Reader> readers){
        History history = new History();
        readerManager.printListReaders(readers);
        int selectedReaderNumber = KeyboardInput.inputNumber(1, null);
        history.setReader(readers.get(selectedReaderNumber-1));
        bookManager.printListBooks(books);
        int selectedBookNumber = KeyboardInput.inputNumber(1, null);
        if(books.get(selectedBookNumber-1).getCount() > 0){
            history.setBook(books.get(selectedBookNumber-1));
            books.get(selectedBookNumber-1).setCount(books.get(selectedBookNumber-1).getCount()-1);
            history.setDateOnHand(new GregorianCalendar().getTime());
            return history;
        }else{
            System.out.println("All books are read");
            return null;
        }
    }
    /**
     * Возврат книги
     * Выводим список читаемых книг
     * Выбираем возвращаемую книгу
     * Если book.getCount() меньше book.getQuantity() вернет истину
     *  выполняем увелечение count книги на 1 и возвращаем массив histories
     * иначе возвращаем null
     */
    public List<History> returnBook(List<History> histories) {
        bookManager.printListGiveOutBooks(histories);
        System.out.print("Select book for return: ");
        int historyNumber = KeyboardInput.inputNumber(1, null);
        if(histories.get(historyNumber-1).getBook().getCount() 
                < histories.get(historyNumber-1).getBook().getQuantity()){
            histories.get(historyNumber-1).getBook().setCount(
                    histories.get(historyNumber-1).getBook().getCount()+1
            );
            histories.get(historyNumber-1).setDateBack(new GregorianCalendar().getTime());
            System.out.printf("Book \"%s\" returned%n", 
                    histories.get(historyNumber-1).getBook().getTitle()
            );
            return histories;
        }else{
            return null;
        }
    }
    /**
     * Алгоритм метода 
     * 1. Создадим mapBooks
     * 2. Проходим по всем элементам histories
     *    если в mapBooks нет ключа с книгой из истории
     *      добавляем ключ и устанавливаем значение 1
     *    иначе
     *      по ключу обновляем значение увеличивая его на 1
     * 3. отсортировать mapBooks по значениям
     * 4. Вывести ключ и значение сортированного sortedMapBooks
     *  
     */
    public void RatingOfBooksByReadability(List<History> histories) {
        Map<Book,Integer> mapBooks = new HashMap<>();
        for (int i = 0; i < histories.size(); i++) {
            if(!mapBooks.containsKey(histories.get(i).getBook())){
                mapBooks.put(histories.get(i).getBook(), 1);
            }else{
                mapBooks.put(histories.get(i).getBook(), mapBooks.get(histories.get(i).getBook())+1);
            }
        }
        //sort ???
        Map<Book, Integer> sortedMapBooks = mapBooks.entrySet()
            .stream()
            .sorted(Map.Entry.<Book, Integer>comparingByValue().reversed())
            .collect(Collectors.toMap(
                Map.Entry::getKey, 
                Map.Entry::getValue, 
                (oldValue, newValue) -> oldValue, 
                LinkedHashMap::new)
            );
        int n = 1;
        for (Map.Entry<Book, Integer> entry : sortedMapBooks.entrySet()) {
            System.out.printf("%d. %s: %d%n",
                    n,
                    entry.getKey().getTitle(),
                    entry.getValue()
            );
            n++;
        }
        
    }

    public void printMostReadingReader(List<History> histories) {
        System.out.println("Implementation expected");
    }
    
}
