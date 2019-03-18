package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Person entity) {
        if (entity.getId() == null) {
            add(entity);
        } else {
            update(entity);
        }
    }


    public List<Person> readAll() {
        Query query = entityManager.createQuery("SELECT person FROM Person person");
        List<Person> peoples = query.getResultList();
        return peoples;
    }


    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }


    public void delete(Person entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    private void add(Person entity) {
        entityManager.persist(entity);
    }

    private void update(Person entity) {
        entityManager.merge(entity);
    }


}
