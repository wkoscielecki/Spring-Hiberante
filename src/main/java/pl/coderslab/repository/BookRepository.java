package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Book;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Long> {


    List<Book> findAllByCategoryId(Long id);

}
