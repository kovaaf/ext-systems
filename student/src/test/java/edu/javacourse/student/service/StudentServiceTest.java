package edu.javacourse.student.service;

import edu.javacourse.student.rest.StudentController;
import edu.javacourse.student.view.LocalDateAdapter;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Kovalyov Anton 15.05.2022
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class StudentServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTest.class);

    @Autowired
    private StudentController controller;

    @Test
    public void getStudentInfoTest() {
        StudentRequest request = new StudentRequest();

        request.setLastName("last");
        request.setFirstName("first");
        request.setMiddleName("middle");
        request.setDateOfBirth(LocalDate.of(1993, 11, 30));
        request.setPassportNumber("number");
        request.setPassportSeria("seria");
        request.setPassportDate(LocalDate.of(2022, 5, 15));

        List<StudentResponse> info = controller.getStudentInfo(request);
        Assert.assertTrue(info.size() > 0);
    }
}