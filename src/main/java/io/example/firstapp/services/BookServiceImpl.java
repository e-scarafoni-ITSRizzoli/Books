package io.example.firstapp.services;

import io.example.firstapp.domain.Book;
import io.example.firstapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getFirstBook() {
        if(bookRepository.count() != 0) {
            //return bookRepository.findById(1L).get();
            return bookRepository.findAll().iterator().next();
        }

        else {
            return new Book();
        }
    }

    @Override
    public Book getBookById(Long Id) {
        for (Book b:
                bookRepository.findAll()) {
            if(b.getId() == Id) {
                return b;
            }
        }

        return new Book();
    }
}
