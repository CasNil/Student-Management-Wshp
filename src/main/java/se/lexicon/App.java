package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDAO;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDAO studentDAO = context.getBean(StudentDAO.class);
    }
}
