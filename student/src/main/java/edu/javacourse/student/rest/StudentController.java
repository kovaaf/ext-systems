package edu.javacourse.student.rest;

import edu.javacourse.student.service.StudentService;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Kovalyov Anton 15.05.2022
 */
@RestController // @Controller
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<StudentResponse> getStudentInfo(@RequestBody StudentRequest request) {
        return studentService.getStudentInfo(request);
    }
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<StudentResponse> getStudentInfo(StudentRequest request) {
//        return studentService.getStudentInfo(request);
//    }

    @GetMapping(path = "/check")
    public String checkAdmin() {
        return "ReST service is running";
    }

    @GetMapping(path = "params/{checkId}")
    public String checkParams(@PathVariable("checkId") Long id,
                              @RequestParam("comment") String com) {
        return id + ": " + com;
    }

    @PostMapping(path = "/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadPhoto(@RequestParam(value = "comment", required = false) String comment,
                              @RequestParam("photoFile")MultipartFile file) {
        try(InputStream is = file.getInputStream()) {
            return "Comment: " + comment +
                    ", name: " + file.getName() +
                    ", filename: " + file.getOriginalFilename() +
                    ", size: " + is.available();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
