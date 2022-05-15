package edu.javacourse.register;
/*
 *   Created by Kovalyov Anton 08.05.2022
 */

import edu.javacourse.register.rest.MarriageController;
import edu.javacourse.register.view.MarriageRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class Starter {
    public static void main(String[] args) {
        disableLogging();

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"springContext.xml"}
        );
//        MarriageController controller = context.getBean(MarriageController.class);
//        MarriageController controller = context.getBean("controller", MarriageController.class);
//        controller.findMarriageCertificate(new MarriageRequest());
    }
    private static void disableLogging() {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE); //could be Level.OFF
    }
}
