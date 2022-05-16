package edu.javacourse.student.service;

import edu.javacourse.student.dao.FacultyRepository;
import edu.javacourse.student.dao.UniversityRepository;
import edu.javacourse.student.domain.Faculty;
import edu.javacourse.student.domain.University;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Kovalyov Anton 16.05.2022
 */
@Service // Handler
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    @Transactional(readOnly = true)
    public List<University> findUniversities(){
        return universityRepository.findAll();
    }
    @Transactional(readOnly = true)
    public List<University> findFullUniversities() {
        return universityRepository.findFullList();
    }

    @Transactional(readOnly = true)
    public List<Faculty> findFaculties() {
        return facultyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Faculty findFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).get();
    }
    @Transactional(readOnly = true)
    public Faculty getFaculty(Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId).get();
        faculty.getUniversity().getUniversityName(); // To force fetching university data
        return faculty;
    }
    @Transactional(readOnly = true)
    public Faculty getFaculty2(Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId).get();
        Hibernate.initialize(faculty.getUniversity());
        return faculty;
    }
    @Transactional(readOnly = true)
    public University getUniversity(Long universityId) {
        University university = universityRepository.findById(universityId).get();
        Hibernate.initialize(university.getFaculties());
        return university;
    }
}
