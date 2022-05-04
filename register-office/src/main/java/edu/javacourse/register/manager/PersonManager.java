package edu.javacourse.register.manager;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import edu.javacourse.register.domain.Person;

import java.util.List;

public class PersonManager {
    public static void main(String[] args) {
        sessionExample();
        jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager(); // Близок к Session по функционалу

        em.getTransaction().begin();
        Person p = new Person();
        p.setFirstName("Алексей");
        p.setLastName("Фёдоров");
        em.persist(p);
        System.out.println("Persisted " + p.getPersonId());
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        List<Person> personList = em.createQuery("FROM Person", Person.class).getResultList();
        personList.forEach(System.out::println);

        em.close();
    }

    private static void sessionExample() {
        SessionFactory sf = buildSessionFactory();

        System.out.println();
        System.out.println();
        System.out.println();

        Session session = sf.openSession();
        session.getTransaction().begin();
        Person p = new Person();
        p.setFirstName("Василий");
        p.setLastName("Сидоров");
//        Deprecated
//        Long id = (Long) session.save(p);
        session.persist(p);
        Long identifier = (Long) session.getIdentifier(p);
        System.out.println("Persisted " + identifier);
        session.getTransaction().commit();
        session.close();

        Session session1 = sf.openSession();
        Person person = session1.get(Person.class, identifier);
        System.out.println(person);
        session1.close();

        Session session2 = sf.openSession();
        List<Person> personList = session2.createQuery("FROM Person", Person.class).list();
        personList.forEach(System.out::println);
        session2.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
