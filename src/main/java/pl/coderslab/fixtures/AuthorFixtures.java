package pl.coderslab.fixtures;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorFixtures {


    @Autowired
    AuthorRepository authorRepository;

    public void createAndInsertIntoDb() {
        List<Author> authors = createAuthors();
        authorRepository.save(authors);
    }


    public List<Author> createAuthors() {

        List<Author> authors = new ArrayList<>();

        Author aut1 = new Author();
        aut1.setFirstName("Gal");
        aut1.setLastName("Anonim");
        aut1.setEmail("bor@gmail.com");
        aut1.setYearOfBirth(LocalDate.parse("2000-10-10"));

        Author aut2 = new Author();
        aut2.setFirstName("Abc");
        aut2.setLastName("Cda");
        aut2.setEmail("cda@gmail.com");
        aut2.setYearOfBirth(LocalDate.parse("1999-10-10"));


        Author aut3 = new Author();
        aut3.setFirstName("Gwd");
        aut3.setLastName("Gwww");
        aut3.setEmail("Gda@gmail.com");
        aut3.setYearOfBirth(LocalDate.parse("1994-10-10"));

        authors.add(aut1);
        authors.add(aut2);
        authors.add(aut3);

        return authors;
    }


}
