package edu.javacourse.register.dao;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.domain.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findPersons() {
        Query query = entityManager.createNamedQuery("Person.findPersons");
        return query.getResultList();
    }

    public Long addPerson(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        return person.getPersonId();
    }
}