package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.validator.PropositionBookValidatorGroup;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    PublisherDao publisherDao;


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }


    @PostMapping("/form")
    public String form(@Validated({PropositionBookValidatorGroup.class, Default.class}) Book book, BindingResult bookErrors, HttpServletRequest request) {
        if (bookErrors.hasErrors()) {
            return "book/form";
        }
        bookDao.save(book);
        return "redirect:" + request.getContextPath() + "/book/list";

    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }


    @RequestMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "book/form";
    }


    @PostMapping("/edit/{id}")
    public String editBook(@Validated({PropositionBookValidatorGroup.class, Default.class}) Book book, BindingResult bookErrors, @PathVariable Long id, HttpServletRequest request) {
        if (bookErrors.hasErrors()) {
            return "book/form";
        }
        if (book.isProposition()){
            book.setProposition(false);
        }
        bookDao.save(book);
        return "redirect:" + request.getContextPath() + "/book/list";


    }


    @RequestMapping("/delete/{id}")
    public String deleteBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "book/delete";
    }


    @RequestMapping("/delete/true/{id}")
    public String deleteBook(@ModelAttribute Book book, @PathVariable Long id, HttpServletRequest request) {
        bookDao.delete(book);
        return "redirect:" + request.getContextPath() + "/book/list";
    }


    @ModelAttribute("publishers")
    public List<Publisher> publisherList() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authorList() {
        return authorDao.findAll();
    }

}
