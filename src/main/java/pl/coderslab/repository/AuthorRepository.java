package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
