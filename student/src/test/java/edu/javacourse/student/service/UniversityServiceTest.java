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
    // There will be LazyInitializationException
/*    @Test
    public void findUniversities() {
        List<University> list = service.findUniversities();
        System.out.println("Ok universities!");
        list.forEach(u -> System.out.println(
                u.getUniversityId() + ": " + u.getUniversityName() + ": " + u.getFaculties().size()));
    }*/

    // There will be LazyInitializationException
/*    @Test
    public void findFaculties() {
        List<Faculty> list = service.findFaculties();
        System.out.println("Ok faculties!");
        list.forEach(f -> System.out.println(f.getUniversity().getUniversityName()));
    }*/


    // <---------
    // SOLUTIONS
    // --------->
    // First (lazy to eager)
    // Just get it all together at once - make domain object's initialization type EAGER. There will be join
/*    @Test
    public void findFaculty() {
        Faculty faculty = service.findFaculty(1L);
        System.out.println(faculty.getUniversity().getUniversityName());
    }*/

    // Second one (no, please, no)
    // This works if we did select (by calling field of the object with this issue)
    // for university in transaction (in UniversityService) together with selecting faculty
    // Bad approach
    @Test
    public void getFaculty() {
        Faculty faculty = service.getFaculty(1L);
        System.out.println(faculty.getUniversity().getUniversityName());
    }

    // Second two (force initialization)
    // Pretty same but this is a good approach. Use Hibernate.initialize().
    // Get attention!
    // You should look into if it's better to use two selects or to make join (EAGER initialization or approach with query)
    @Test
    public void getFaculty2() {
        Faculty faculty = service.getFaculty2(1L);
        System.out.println(faculty.getUniversity().getUniversityName());
    }
    @Test
    public void getUniversity() {
        University university = service.getUniversity(1L);
        System.out.println(university.getUniversityName() + ": " + university.getFaculties().size());
    }

    // Third (custom query)
    // Make your own query in @repository (UniversityRepository) with join
    // Get attention!
    // You should look into if it's better to use two selects or to make join (EAGER initialization or approach with query)
    @Test
    public void findFullUniversities() {
        List<University> list = service.findFullUniversities();
        System.out.println("Ok universities!");
        list.forEach(u -> System.out.println(
                u.getUniversityId() + ": " + u.getUniversityName() + ": " + u.getFaculties().size()));
    }
}