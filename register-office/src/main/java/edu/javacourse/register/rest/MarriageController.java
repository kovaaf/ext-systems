package edu.javacourse.register.rest;
/*
 *   Created by Kovalyov Anton 08.05.2022
 */

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.dto.MarriageRequest;
import edu.javacourse.register.dto.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageController.class);
    private MarriageManager marriageManager;

    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest marriageRequest) {
        LOGGER.info("MarriageController findMarriageCertificate() called");
        return marriageManager.findMarriageCertificate(marriageRequest);
    }
}