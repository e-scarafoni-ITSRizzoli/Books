package io.example.firstapp.services;

import io.example.firstapp.domain.Author;
import org.springframework.stereotype.Service;


public interface AuthorService {
    Iterable<Author> findAll();
}
