package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@Controller
@RequestMapping("/test")
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate")
    public String validate(Model model) {
        Book book = new Book();
        book.setTitle("titale");
        book.setRating(3);
        book.setAuthors(Arrays.asList(new Author()));
        book.setPublisher(new Publisher());

//        StringBuilder sb = new StringBuilder();


        Set<ConstraintViolation<Book>> voliations = validator.validate(book);
        model.addAttribute("violations",voliations);
        return "validation/validationBook";
//        if (!voliations.isEmpty()) {
//            for (ConstraintViolation<Book> err : voliations) {
//                sb
//                        .append(err.getPropertyPath())
//                        .append("-")
//                        .append(err.getMessage())
//                        .append("<br>");
//            }

//        }
//        return sb.toString();
    }
}
