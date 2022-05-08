package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.dto.MarriageRequest;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/*
 *   Created by Kovalyov Anton 08.05.2022
 */

public class MarriageDaoTest {

    @Test
    public void findMarriageCertificate() {
        MarriageDao marriageDao = new MarriageDao();
        
        MarriageRequest marriageRequest = new MarriageRequest();
        marriageRequest.setHusbandFirstName("Олег");
        marriageRequest.setHusbandSurname("Васильев");
        marriageRequest.setHusbandPatronymic("Петрович");
        marriageRequest.setHusbandDateOfBirth(LocalDate.of(1997, 10, 16));
        marriageRequest.setWifeFirstName("Елена");
        marriageRequest.setWifeSurname("Васильева");
        marriageRequest.setWifePatronymic("Сергеевна");
        marriageRequest.setWifeDateOfBirth(LocalDate.of(1998, 3, 24));

        MarriageCertificate marriageCertificate = marriageDao.findMarriageCertificate(marriageRequest);
        System.out.println(marriageCertificate.toString());
    }
}