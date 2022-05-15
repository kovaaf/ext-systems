package edu.javacourse.register.rest;
/*
 *   Created by Kovalyov Anton 08.05.2022
 */

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service("controller")
@Path("/mc")
public class MarriageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageController.class);
    @Autowired
    @Qualifier("marriageService")
    private MarriageManager marriageManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MarriageResponse findMarriageCertificate(/*MarriageRequest marriageRequest*/) {
        LOGGER.info("MarriageController findMarriageCertificate() called");
//        return marriageManager.findMarriageCertificate(marriageRequest);
        return marriageManager.findMarriageCertificate(null);
    }
}
