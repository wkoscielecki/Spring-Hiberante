package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.validator.PeselValidatorGroup;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.groups.Default;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    @RequestMapping("/form")
    public String form(Model model) {
        model.addAttribute("author", new Author());
        return "author/form";
    }

    @PostMapping("/form")
    public String form(@Valid Author author,BindingResult errors,@Validated({
            PeselValidatorGroup.class, Default.class}) Author authorPesel, BindingResult errPesel,Model model, HttpServletRequest request) {

        if (author.getPesel().length() ==0 ){
            author.setPesel(null);
        }else if (errPesel.hasErrors()){
            model.addAttribute("author",authorPesel);
            return "author/form";
        }

        if (errors.hasErrors()){
            return "author/form";
        }

        authorDao.save(author);
        return "redirect:" + request.getContextPath() + "/author/list";
    }


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "author/list";
    }


    @RequestMapping("/edit/{id}")
    public String editAuthor(Model model, @PathVariable Long id) {
        model.addAttribute(authorDao.findById(id));
        return "author/form";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@Valid Author author, BindingResult errors, @PathVariable Long id, HttpServletRequest request) {
        if (errors.hasErrors()) {
            return "author/form";
        }
        authorDao.save(author);
        return "redirect:" + request.getContextPath() + "/author/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id, HttpServletRequest request) {
        authorDao.delete(authorDao.findById(id));
        return "redirect:" + request.getContextPath() + "/author/list";
    }


}
