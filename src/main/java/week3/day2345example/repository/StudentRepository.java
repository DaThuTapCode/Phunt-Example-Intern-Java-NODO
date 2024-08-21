package week3.day2345example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week3.day2345example.model.Student;

/**
 * Created by Trong Phu on 20/08/2024 09:45:55
 *
 * @author Trong Phu
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
