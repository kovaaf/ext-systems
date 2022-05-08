package edu.javacourse.register;
/*
 *   Created by Kovalyov Anton 08.05.2022
 */

import edu.javacourse.register.dto.MarriageRequest;
import edu.javacourse.register.rest.MarriageController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"springContext.xml"}
        );
        MarriageController controller = context.getBean("controller", MarriageController.class);
        controller.findMarriageCertificate(new MarriageRequest());
    }
}
