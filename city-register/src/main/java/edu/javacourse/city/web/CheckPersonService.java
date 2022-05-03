package edu.javacourse.city.web;
/*
 *   Created by Kovalyov Anton 26.04.2022
 */

import edu.javacourse.city.dao.PersonCheckDao;
import edu.javacourse.city.dao.PullConnectionBuilder;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

@Path("/check")
@Singleton
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);
    private PersonCheckDao dao;

    @PostConstruct
    public void init() {
        logger.info("SERVICE IS CREATED!");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PullConnectionBuilder());
    }

    @PreDestroy
    public void destroy() {
        logger.info("FINISH");
    }

    @GET
    @Path("/response")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson() {
        return new PersonResponse();
    }

    @POST
    @Path("/request")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson2(PersonRequest personRequest) throws PersonCheckException {
        logger.info(personRequest.toString());
        return dao.checkPerson(personRequest);
    }
}
