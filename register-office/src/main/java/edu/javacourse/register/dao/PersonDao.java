package edu.javacourse.register.dao;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonDao {
    private EntityManager entityManager;

    public PersonDao() {
        entityManager = Persistence
                .createEntityManagerFactory("persistence")
                .createEntityManager();
    }

    public List<Person> findPersons() {
        return entityManager.createQuery("SELECT p FROM Person p").getResultList();
    }
}