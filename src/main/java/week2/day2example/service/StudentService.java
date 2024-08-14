package week2.day2example.service;

import org.springframework.stereotype.Service;
import week2.day2example.model.Student;

import java.util.ArrayList;
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
        list.add(new Student(1l, "Nguyễn Trọng Phú", "Lạng Sơn", 19));
        list.add(new Student(2l, "Nguyễn Thị Thảo Vân", "Lạng Sơn", 19));
        list.add(new Student(3l, "Nguyễn Thanh Thảo", "Lạng Sơn", 20));
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
