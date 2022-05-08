package edu.javacourse.register.business;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.dao.MarriageDao;
import edu.javacourse.register.dao.PersonDao;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.dto.MarriageRequest;
import edu.javacourse.register.dto.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarriageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);
//    @Autowired
    private MarriageDao marriageDao;
//    @Autowired
    private PersonDao personDao;

//    @Autowired
    public MarriageManager(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Autowired
    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("MarriageManager findMarriageCertificate called");
        MarriageCertificate marriageCertificate = marriageDao.findMarriageCertificate(request);
        // TODO convert marriageCertificate to MarriageResponse
        return new MarriageResponse();
    }
}
