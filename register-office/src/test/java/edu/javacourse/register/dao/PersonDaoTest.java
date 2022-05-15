package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import org.junit.Test;

import java.util.List;

/*
 *   Created by Kovalyov Anton 04.05.2022
 */

public class PersonDaoTest {

    @Test
    public void findPersons() {
/*        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();

        persons.forEach(person -> {
            System.out.println("Name: " + person.getFirstName());
            System.out.println("Class for sex: " + person.getClass().getName());
            System.out.println("Number of passports: " + person.getPassports().size());
            System.out.println("Birth certificate: " + person.getBirthCertificate());
            if (person instanceof PersonMale p) {
                System.out.println("Number of birth certificates: " + p.getBirthCertificates().size());
                System.out.println("Number of marriage certificates: " + p.getMarriageCertificates().size());
            } else {
                System.out.println("Number of birth certificates: " + ((PersonFemale)person).getBirthCertificates().size());
                System.out.println("Number of marriage certificates: " + ((PersonFemale)person).getMarriageCertificates().size());
            }
            System.out.println();
            System.out.println();
        });*/
    }
}