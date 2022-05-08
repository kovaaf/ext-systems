package edu.javacourse.register.dao;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class PersonDao {
    private EntityManager entityManager;

    public PersonDao() {
        entityManager = Persistence
                .createEntityManagerFactory("persistence")
                .createEntityManager();
    }

    public List<Person> findPersons() {
        Query query = entityManager.createNamedQuery("Person.findPersons");
        query.setParameter("personId", 2L);
        return query.getResultList();
    }
}