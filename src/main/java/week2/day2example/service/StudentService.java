package week2.day2example.service;

import org.springframework.stereotype.Service;
import week2.day2example.enumexample.StatusStudent;
import week2.day2example.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Trong Phu on 13/08/2024 10:15:55
 *
 * @author Trong Phu
 */
@Service
public class StudentService {
    private List<Student> list = new ArrayList<>();

    public StudentService() {
        list.add(new Student(1l, "Nguyễn Trọng Phú", new Date("2004/09/13"), "Lạng Sơn", 19, StatusStudent.ACTIVE));
        list.add(new Student(2l, "Nguyễn Thị Thảo Vân", new Date("2004/11/29"), "Lạng Sơn", 19, StatusStudent.INACTIVE));
        list.add(new Student(3l, "Nguyễn Thanh Thảo", new Date("2004/07/24"),  "Lạng Sơn", 20, StatusStudent.INACTIVE));
    }

    public List<Student> getAll() {
        return this.list;
    }

    public Student getStudentById(Long id) {
        for (Student st : this.list
        ) {
            if (st.getId() == id) {
                return st;
            }
        }
        return null;
    }

    public Student add(Student student) {
        this.list.add(student);
        return student;
    }
}
