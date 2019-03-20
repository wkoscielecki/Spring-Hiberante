package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/proposition")
public class PropositionController {


    @Autowired
    BookDao bookDao;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "proposition/form";
    }

    @PostMapping("/form")
    public String form(@Valid Book book, BindingResult propBookErr, HttpServletRequest request) {
        if (propBookErr.hasErrors()) {
            return "proposition/form";
        }
        book.setProposition(true);
        bookDao.save(book);
        return "redirect:" + request.getContextPath() + "/proposition/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAllInPropositonStage());
        return "proposition/list";
    }

    @RequestMapping("/edit/{id}")
    public String editProposition(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "proposition/form";
    }


    @PostMapping("/edit/{id}")
    public String editProposition(@Valid Book book, BindingResult bookErrors, @PathVariable Long id, HttpServletRequest request) {
        if (bookErrors.hasErrors()) {
            return "proposition/form";
        }
        book.setProposition(true);
        bookDao.save(book);
        return "redirect:" + request.getContextPath() + "/proposition/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProposition(Model model, @PathVariable Long id, HttpServletRequest request) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:" + request.getContextPath() + "/proposition/list";

    }

}
