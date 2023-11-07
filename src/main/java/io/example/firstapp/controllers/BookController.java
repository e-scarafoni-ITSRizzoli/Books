package io.example.firstapp.controllers;

import io.example.firstapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book/")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        System.out.println("sono in getBooks");
        model.addAttribute("books", bookService.findAll());
        return "Book/books";
    }

    @RequestMapping("/firstBook")
    public String getFirstBook(Model model) {
        System.out.println("sono in firstbook");
        model.addAttribute("firstBook", bookService.getFirstBook());
        return "Book/firstBook";
    }

    @RequestMapping(path="/bookById/{idBook}")
    public ModelAndView getBookById(@PathVariable(value = "idBook") Long idBook) {
        System.out.println("Sono in getBookById: " + idBook );
        ModelAndView modelAndView = new ModelAndView("Book/bookById");

        modelAndView.addObject("book", bookService.getBookById(idBook));

        return modelAndView;
    }
}


