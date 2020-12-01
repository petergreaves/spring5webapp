package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Publisher p = new Publisher("ABC Books","11 Hamilton Rd","the crescent","newtown", "LC8 9PL");
        publisherRepository.save(p);

        Author eric = new Author("Eric", "Idle");
        Book funnyGuy = new Book("A funny guy", "23423423");
        eric.getBooks().add(funnyGuy);
        funnyGuy.getAuthors().add(eric);
        funnyGuy.setPublisher(p);
        authorRepository.save(eric);
        bookRepository.save(funnyGuy);

        Author jrt = new Author("JR", "Tolkien");
        Book lotr = new Book("Lord of the Rings", "2342342342");
        jrt.getBooks().add(lotr);
        lotr.getAuthors().add(jrt);
        lotr.setPublisher(p);
        authorRepository.save(jrt);
        bookRepository.save(lotr);

        p.getBooks().add(lotr);
        p.getBooks().add(funnyGuy);



        System.out.println("Starting bootstrap");
        System.out.println("Number of books : " +bookRepository.count());;
        System.out.println("Number of authors : " +authorRepository.count());
        System.out.println("Number of publishers : " +publisherRepository.count());;
        System.out.println("Books for publisher : " + p.getBooks().size());



    }
}
