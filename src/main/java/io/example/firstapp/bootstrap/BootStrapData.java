package io.example.firstapp.bootstrap;

import io.example.firstapp.domain.Author;
import io.example.firstapp.domain.Book;
import io.example.firstapp.domain.Publisher;
import io.example.firstapp.repositories.AuthorRepository;
import io.example.firstapp.repositories.BookRepository;
import io.example.firstapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap - Start");

        Publisher p1 = new Publisher();
        p1.setPublisherName("Editore1");
        p1.setCity("Milano");
        p1.setAddress("Via Crespi 1");
        p1.setState("20100");
        p1.setState("Italia");
        Publisher p1Saved = publisherRepository.save(p1);

        Book b1 = new Book();
        b1.setTitle("Titolo di b1");
        b1.setIsbn("Isbn di b1");
        b1.setPublisher(p1Saved);

        Book b1Saved = bookRepository.save(b1);

        Book b2 = new Book();
        b2.setTitle("Sistemi operativi");
        b2.setIsbn("ISBN2");
        b2.setPublisher(p1Saved);

        Book b2Saved = bookRepository.save(b2);

        Author a1 = new Author();
        a1.setFirstName("Mario");
        a1.setLastName("Rossi");
        Author a1Saved = authorRepository.save(a1);

        Author a2 = new Author();
        a2.setFirstName("Chiara");
        a2.setLastName("Bianchi");
        Author a2Saved = authorRepository.save(a2);

        System.out.println("Bootstrap - End");
    }
}
