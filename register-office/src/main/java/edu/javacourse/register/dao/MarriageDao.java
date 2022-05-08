package edu.javacourse.register.dao;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.dto.MarriageRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class MarriageDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);
    private EntityManager entityManager;
    private String test;

    public MarriageDao() {
        entityManager = Persistence
                .createEntityManagerFactory("persistence")
                .createEntityManager();
    }

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("MarriageDao findMarriageCertificate called: {}", test);

/*        Query query = entityManager.createNamedQuery("MarriageCertificate.findMarriageCertificate");
        query.setParameter("husbandName", request.getHusbandFirstName());
        query.setParameter("husbandSurName", request.getHusbandSurname());
        query.setParameter("husbandPatronymic", request.getHusbandPatronymic());
        query.setParameter("husbandDateOfBirth", request.getHusbandDateOfBirth());
        query.setParameter("wifeName", request.getWifeFirstName());
        query.setParameter("wifeSurName", request.getWifeSurname());
        query.setParameter("wifePatronymic", request.getWifePatronymic());
        query.setParameter("wifeDateOfBirth", request.getWifeDateOfBirth());
        query.setParameter("marriageCertificateNumber", request.getMarriageCertificateNumber());
        query.setParameter("marriageCertificateDate", request.getMarriageCertificateDate());

        List<MarriageCertificate> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return new MarriageCertificate();
        } else {
            return resultList.get(0);
        }*/
        return null;
    }
}
