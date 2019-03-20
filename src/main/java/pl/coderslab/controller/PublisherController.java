package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;


    @RequestMapping("/form")
    public String form(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/form";
    }


    @PostMapping("/form")
    public String form(@Valid Publisher publisher, BindingResult publisherErrors, HttpServletRequest request) {

        if (publisherErrors.hasErrors()) {
            return "publisher/form";
        }
        publisherDao.save(publisher);
        return "redirect:" + request.getContextPath() + "/publisher/list";
    }


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        return "publisher/list";
    }

    @RequestMapping("/edit/{id}")
    public String editPublisher(Model model, @PathVariable Long id) {
        model.addAttribute(publisherDao.findById(id));
        return "publisher/form";
    }


    @PostMapping("/edit/{id}")
    public String editPublisher(@Valid Publisher publisher, BindingResult publisherError, @PathVariable Long id, HttpServletRequest request) {
        if (publisherError.hasErrors()) {

            return "publisher/form";
        }
        publisherDao.save(publisher);
        return "redirect:" + request.getContextPath() + "/publisher/list";
    }


    @RequestMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id, HttpServletRequest request) {
        publisherDao.delete(publisherDao.findById(id));
        return "redirect:" + request.getContextPath() + "/publisher/list";
    }


}
