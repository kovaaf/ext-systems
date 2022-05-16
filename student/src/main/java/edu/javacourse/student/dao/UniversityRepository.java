package edu.javacourse.student.dao;

import edu.javacourse.student.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kovalyov Anton 16.05.2022
 */
@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

}
