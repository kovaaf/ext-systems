package edu.javacourse.student.service;

import edu.javacourse.student.domain.Faculty;
import edu.javacourse.student.domain.University;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Kovalyov Anton 16.05.2022
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class UniversityServiceTest {
    @Autowired
    private UniversityService service;
    @Test
    public void findUniversities() {
        List<University> list = service.findUniversities();
        System.out.println("Ok universities!");
        list.forEach(u -> System.out.println(
                u.getUniversityId() + ": " + u.getUniversityName() + ": " + u.getFaculties().size()));
    }
    @Test
    public void findFaculties() {
        List<Faculty> list = service.findFaculties();
        System.out.println("Ok faculties!");
        list.forEach(f -> System.out.println(f.getUniversity().getUniversityName()));
    }
}