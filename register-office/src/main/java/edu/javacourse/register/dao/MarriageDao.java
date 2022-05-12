package edu.javacourse.register.dao;
/*
 *   Created by Kovalyov Anton 04.05.2022
 */

import edu.javacourse.register.domain.MarriageCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarriageDao extends JpaRepository<MarriageCertificate, Long> {
    // findBy*parameter name*
    List<MarriageCertificate> findByNumber(String number);

    // findBy*parameter name*Containing
    List<MarriageCertificate> findByNumberContaining(String number);

    // findBy*any name*(@Param("*HQL parameter name*") Typeofparameter *parameter name*) || HQL: ...where tablename.columnname = :*parameter name*
    // findBy*any name*(Typeofparameter *parameter name*) || HQL: ...where tablename.columnname = ?*parameter ordinal*
    List<MarriageCertificate> findByNum(@Param("number") String number);

    // @Query right here("HQL")
    // find*any name*(@Param("*HQL parameter name*") Typeofparameter *parameter name*)
    @Query("SELECT mc FROM MarriageCertificate mc " +
            "WHERE mc.number = :number")
    List<MarriageCertificate> findSomething(@Param("number") String number);

}
