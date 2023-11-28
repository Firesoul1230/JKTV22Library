/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;
import facades.ReaderFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class ReaderManager {
    private final Scanner scanner;
    private final ReaderFacade readerFacade;
    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
        this.readerFacade = new ReaderFacade();
    }

    public void createReader() {
        Reader reader = new Reader();
        System.out.print("Enter firstname: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Enter lastname: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Enter phone: ");
        reader.setPhone(scanner.nextLine());
        System.out.println("Added reader: ");
        System.out.println(reader.toString());
        readerFacade.create(reader);
    }

    public List<Integer> printListReaders() {
        List<Reader> readers = readerFacade.findAll();
        List<Integer> arrayReaderId = new ArrayList<>();
        System.out.println("------ List readers ------");
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%d. %s %s. %s%n",
                    readers.get(i).getId(),
                    readers.get(i).getFirstname(),
                    readers.get(i).getLastname(),
                    readers.get(i).getPhone()
            );
            arrayReaderId.add(readers.get(i).getId().intValue());
        }
        return arrayReaderId;
    }
    
    public List<Reader> readers(){
        return readerFacade.findAll();
    }
    
    public Reader findById(int id){
        return readerFacade.find((long)id);
    }

    
    
}
