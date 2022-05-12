package edu.javacourse.register.business;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.dao.MarriageDao;
import edu.javacourse.register.dao.PersonDao;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.Person;
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
//        MarriageCertificate marriageCertificate = marriageDao.findMarriageCertificate(request);

        personDao.findPersons();

        /*
        Following code doesn't work because these are same entities, and you need to detach it from entityManager(DB).
        Person male = new PersonMale();
        personDao.addPerson(male);
        personDao.addPerson(male);
         */
        personDao.addPerson(getPerson());
        personDao.addPerson(getPerson());
        personDao.addPerson(getPerson());

        // TODO convert marriageCertificate to MarriageResponse

        return new MarriageResponse();
    }

    private Person getPerson() {
        Person male = new PersonMale();
        male.setFirstName("1");
        male.setLastName("2");
        male.setPatronymic("3");
        male.setDateOfBirth(LocalDate.of(1991, 3, 12));
        return male;
    }
}
