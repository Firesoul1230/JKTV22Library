/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Reader;
import facades.ReaderFacade;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ReaderManager {
    private final Scanner scanner;
    private final ReaderFacade readerFacade;

    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
        this.readerFacade = new ReaderFacade();
    }

    public Reader createReader() {
        Reader reader = new Reader();
                    System.out.print("Enter First Name: ");
                    reader.setFirstname(scanner.nextLine());
                    System.out.print("Enter Last Name: ");
                    reader.setLastname(scanner.nextLine());
                    System.out.print("Enter Phone: ");
                    reader.setPhone(scanner.nextLine());
                    
                    
                    System.out.println("Added reader: ");
                    System.out.println(reader.toString());
                    readerFacade.createReader(reader);
    }
    
    public void printListReaders (Reader[] readers) {
            System.out.println("------ List readers ------");
            for (int i = 0; i < readers.length; i++) {
                System.out.printf("%d. %s %s. %s%n" , i+1,
                        readers[i].getFirstname(),
                        readers[i].getLastname(),
                        readers[i].getPhone()
                );
            }
    }
    
}
