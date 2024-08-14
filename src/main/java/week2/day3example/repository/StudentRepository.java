package week2.day3example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week2.day3example.entity.Student;

/**
 * Created by Trong Phu on 14/08/2024 11:40:33
 *
 * @author Trong Phu
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
