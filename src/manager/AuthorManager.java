/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Author;
import facades.AuthorFacade;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class AuthorManager {
    private final Scanner scanner;
    private final AuthorFacade authorFacade;
    
    public AuthorManager(Scanner scanner) {
        this.scanner = scanner;
        this.authorFacade = new AuthorFacade();
    }

    public void printListAuthors() {
        System.out.println("------ List of Authors ------");
        List<Author> authors = authorFacade.findAll();
        for (int i = 0; i < authors.size(); i++) {
            System.out.printf("%d. %s %s%n",
                    authors.get(i).getId(),
                    authors.get(i).getFirstname(),
                    authors.get(i).getLastname()
            );
            
        }
    }

    public Author find(int id) {
        return authorFacade.find((long)id);
    }

    public void createAuthor() {
        Author author = new Author();
        System.out.println("------ Creating an author ------");
        System.out.println("Author's Name: ");
        author.setFirstname(scanner.nextLine());
        System.out.println("Author's LastName: ");
        author.setLastname(scanner.nextLine());
        authorFacade.createAuthor(author);
    }
    
}
