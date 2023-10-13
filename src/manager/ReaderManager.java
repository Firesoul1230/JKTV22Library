/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Author;
import entity.Book;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ReaderManager {
    private Scanner scanner;

    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Reader addReader() {
        Reader reader = new Reader();
                    System.out.print("Enter First Name: ");
                    reader.setFirstname(scanner.nextLine());
                    System.out.print("Enter Last Name: ");
                    reader.setLastname(scanner.nextLine());
                    System.out.print("Enter Phone: ");
                    reader.setPhone(scanner.nextLine());
                    
                    
                    System.out.println("Added reader: ");
                    System.out.println(reader.toString());
                    return reader;
    }
    
}
