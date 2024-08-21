package week3.day2345example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import week3.day2345example.model.Classes;

import java.util.List;

/**
 * Created by Trong Phu on 20/08/2024 09:46:06
 *
 * @author Trong Phu
 */
public interface ClassesRepository extends JpaRepository<Classes, Long> {

    @Query(value = "select c.classes_id, c.classes_name from Classes c", nativeQuery = true)
    List<Classes> findAllCustom();

    @Query(value = "select c from Classes c join fetch c.students")
    List<Classes> findAllCustom2();
}
