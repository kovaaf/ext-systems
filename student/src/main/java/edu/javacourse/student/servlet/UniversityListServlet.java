package edu.javacourse.student.servlet;

import edu.javacourse.student.domain.University;
import edu.javacourse.student.service.UniversityService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Kovalyov Anton 16.05.2022
 */
@WebServlet(name = "UniversityListServlet", urlPatterns = {"/universityList"})
public class UniversityListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        WebApplicationContext webCtx = WebApplicationContextUtils.getWebApplicationContext(ctx);

        UniversityService service = webCtx.getBean(UniversityService.class);
        List<University> list = service.findUniversities();

        list.forEach(u -> System.out.println(
                u.getUniversityId() + ": " + u.getUniversityName()));

        // This will not work - lazy initialization
/*        list.forEach(u -> System.out.println(
                u.getUniversityId() + ": " + u.getUniversityName() + ": " + u.getFaculties().size()));*/

        req.setAttribute("today", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        req.setAttribute("universities", list);

//        getServletContext().getRequestDispatcher("/universityList.jsp").forward(req, resp);
        getServletContext().getRequestDispatcher("/universityList_jstl.jsp").forward(req, resp);
    }
}
