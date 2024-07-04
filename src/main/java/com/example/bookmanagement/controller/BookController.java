package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.service.BookService;
import com.example.bookmanagement.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserSession userSession;

    @GetMapping("/home")
    public String home(Model model) {
        if (userSession.getUsername() == null) {
            return "redirect:/login";
        }
        // 打印
        System.out.println("userSession.getUsername() = " + userSession.getUsername());
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("username", userSession.getUsername());
        return "home";
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/books")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam String isbn) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
