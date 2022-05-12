package edu.javacourse.register.dao;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.domain.MarriageCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageDao extends JpaRepository<MarriageCertificate, Long> {

}

/*
public class MarriageDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Value("${sample.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("MarriageDao findMarriageCertificate called: {}", test);

        Query query = entityManager.createNamedQuery("MarriageCertificate.findMarriageCertificate");
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
        }
        return null;
    }
}
 */
