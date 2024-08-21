package week2.day345example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import week2.day345example.dto.response.StudentResponseDTO;
import week2.day345example.entity.Student;

import java.util.List;

/**
 * Created by Trong Phu on 14/08/2024 11:40:33
 *
 * @author Trong Phu
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT st from Student st")
    List<Student> getStudentDTO();


    @Query("select new  week2.day345example.dto.response.StudentResponseDTO(st.id, st.name, st.age, st.address, st.status)  from Student st")
    List<StudentResponseDTO> gethehe();

    @Query(value = "select s.student_id, s.name_student, s.age, s.address, s.status from Student s where s.student_id = :id", nativeQuery = true)
    Student getStudentByID(
            Long id
    );

    @Query(
            value = "SELECT s.student_id, s.name_student, s.age, s.address, s.status " +
                    "FROM Student s",
            countQuery = "SELECT count(*) FROM Student s ",
            nativeQuery = true
    )
    Page<Object[]> getStudentsWithPagination(
            Pageable pageable
    );


    @Query("SELECT s FROM Student s WHERE s.name LIKE %:name%")
    List<Student> findByName(String name);

}
