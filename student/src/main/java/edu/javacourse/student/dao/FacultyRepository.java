package edu.javacourse.student.dao;

import edu.javacourse.student.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kovalyov Anton 16.05.2022
 */
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}