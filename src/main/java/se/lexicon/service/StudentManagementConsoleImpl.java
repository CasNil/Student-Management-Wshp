package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {
    private final UserInputService userInputService;
    private final StudentDAO studentDAO;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDAO studentDAO) {
        this.userInputService = userInputService;
        this.studentDAO = studentDAO;
    }

    @Override
    public Student create() {
        System.out.println("Enter a name: ");
        String name = userInputService.getString();

        Student newStudent = new Student(name);
        newStudent.setName(name);

        return newStudent;
    }

    @Override
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDAO.find(id);
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = studentDAO.find(id);
        if (studentToRemove != null) {
            studentDAO.delete(id);
            System.out.println("Student with ID: " + id + "has been removed.");
        } else System.out.println("Could not find student with ID: " + id);

        return studentToRemove;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student edit(Student student) {
        System.out.println("Editing student: " + student);
        System.out.println("Enter a new name. ");
        String newName = userInputService.getString();
        if (!newName.trim().isEmpty()) {
            student.setName(newName);
        }
        return studentDAO.save(student);
    }

}
