package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.servlet.http.HttpServletRequest;
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
    public String form(@ModelAttribute Book book, HttpServletRequest request) {
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
    public String editBook(@ModelAttribute Book book, @PathVariable Long id, HttpServletRequest request) {
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


    ///////// stare

//    @GetMapping("/testadd")
//    @ResponseBody
//    public void testAdd() {
//
//        Author author = new Author();
//        author.setFirstName("Evan");
//        author.setLastName("Currie");
//        authorDao.save(author);
//
//        Book book = new Book();
//        book.getAuthors().add(author);
//        book.setTitle("Odysey One");
//        book.setRating(6);
//        bookDao.save(book);
//    }


//    @GetMapping("/{bookId}")
//    @ResponseBody
//    public String getBookById(@PathVariable Long bookId) {
//        return bookDao.findById(bookId).toString();
//    }
//
//
//    @GetMapping("/update/{bookId}")
//    @ResponseBody
//    public void updateBook(@PathVariable Long bookId) {
//        Book bookToUpdate = bookDao.findById(bookId);
//        bookToUpdate.setTitle("Inny tytuł");
//        bookDao.save(bookToUpdate);
//    }
//
//    @GetMapping("/delete/{bookId}")
//    @ResponseBody
//    public void deleteBook(@PathVariable Long bookId) {
//        Book bookToDelete = bookDao.findById(bookId);
//        bookDao.delete(bookToDelete);
//    }


}
