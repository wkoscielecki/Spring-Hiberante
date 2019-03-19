package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @ModelAttribute("hobbieItems")
    public List<String> hobbies() {
        String[] arr = {"sport", "netflix"};
        return Arrays.asList(arr);
    }

    @ModelAttribute("skills")
    public List<String> programmingSkills() {
        return Arrays.asList(
                "Udaje że umie jave",
                "Klepanie kodu",
                "Lepsze klepanie kodu"
        );
    }

    @ModelAttribute("countries")
    public List<String> countryList() {
        return Arrays.asList(
                "Polska",
                "Japonia",
                "Ukraina"
        );
    }

    @PostMapping("/form")
    public String form(@ModelAttribute Student student){
        return "student/details";
    }


}
