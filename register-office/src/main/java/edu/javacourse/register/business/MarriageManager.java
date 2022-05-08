package edu.javacourse.register.business;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.dao.MarriageDao;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.dto.MarriageRequest;
import edu.javacourse.register.dto.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);
    private MarriageDao marriageDao;

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        MarriageCertificate marriageCertificate = marriageDao.findMarriageCertificate(request);

        return new MarriageResponse();
    }
}
