package edu.javacourse.register.business;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.dao.MarriageDao;
import edu.javacourse.register.dao.PersonDao;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);
    @Autowired
    private MarriageDao marriageDao;
    @Autowired
    private PersonDao personDao;

    @Transactional
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("MarriageManager findMarriageCertificate called");

        /*
        Following code doesn't work because these are same entities, and you need to detach it from entityManager(DB).
        Person male = new PersonMale();
        personDao.addPerson(male);
        personDao.addPerson(male);
         */
        personDao.addPerson(getPerson(1));
        personDao.addPerson(getPerson(2));

        MarriageCertificate mc = getMarriageCertificate();
        marriageDao.saveAndFlush(mc);
        List<MarriageCertificate> all = marriageDao.findAll();
        all.forEach(System.out::println);
        System.out.println(marriageDao.findById(1L));

        return new MarriageResponse();
    }

    private MarriageCertificate getMarriageCertificate() {
        MarriageCertificate mc = new MarriageCertificate();
        mc.setIssueDate(LocalDate.now());
        mc.setNumber("123456");
        mc.setActive(true);

        List<Person> persons = personDao.findPersons();
        for(Person p : persons) {
            if (p instanceof PersonMale male) {
                mc.setHusband(male);
            } else {
                mc.setWife((PersonFemale) p);
            }
        }
        return mc;
    }

    private Person getPerson(int sex) {
        Person male = sex == 1 ? new PersonMale() : new PersonFemale();
        male.setFirstName("1_" + sex);
        male.setLastName("2_" + sex);
        male.setPatronymic("3_" + sex);
        male.setDateOfBirth(LocalDate.of(1991, 3, 12));
        return male;
    }
}
