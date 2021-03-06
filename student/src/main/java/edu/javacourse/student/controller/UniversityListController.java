package edu.javacourse.student.controller;

import edu.javacourse.student.domain.University;
import edu.javacourse.student.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Kovalyov Anton 19.05.2022
 */
@Controller
@RequestMapping(path = "universityList")
public class UniversityListController {
    @Autowired
    UniversityService service;
//    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping(path = "/get")
    @GetMapping
    public String findUniversities(Model model) {
        List<University> universities = service.findUniversities();
        model.addAttribute("today", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        model.addAttribute("universities", universities);

        // Это имя нашей jsp по формату из springContext View Resolver
        return "universityList";
    }
}
