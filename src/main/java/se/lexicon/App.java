package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.service.StudentManagementConsoleImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentManagement studentManagement =
                context.getBean(StudentManagementConsoleImpl.class);

        studentManagement.save(new Student("Casper Nilsson"));
        studentManagement.save(new Student("Oscar Svensson"));
        studentManagement.save(new Student("Adam Karlsson"));


        List<Student> students = studentManagement.findAll();
        System.out.println("All students: ");
        students.forEach(System.out::println);

        context.close();
    }
}
