package week3.day2345example.controller.classes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week3.day2345example.dto.classes.request.ClassesRequestDTO;
import week3.day2345example.dto.classes.response.ClassesResponseDTO;
import week3.day2345example.mapper.classes.request.ClassesRequestDTOMapper;
import week3.day2345example.mapper.classes.response.ClassesResponseDTOMapper;
import week3.day2345example.mapper.student.request.StudentRequestDTOMapper;
import week3.day2345example.model.Classes;
import week3.day2345example.model.Student;
import week3.day2345example.repository.ClassesRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trong Phu on 20/08/2024 09:46:59
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping(value = "week3-day2/classes")
public class ClassesController {
    private final ClassesRepository classesRepository;
    private final ClassesResponseDTOMapper classesResponseDTOMapper;
    private final ClassesRequestDTOMapper classesRequestDTOMapper;
    private final StudentRequestDTOMapper studentRequestDTOMapper;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ClassesController(
            ClassesRepository classesRepository,
            ClassesResponseDTOMapper classesResponseDTOMapper,
            ClassesRequestDTOMapper classesRequestDTOMapper,
            StudentRequestDTOMapper studentRequestDTOMapper
    ) {
        this.classesRepository = classesRepository;
        this.classesResponseDTOMapper = classesResponseDTOMapper;
        this.classesRequestDTOMapper = classesRequestDTOMapper;
        this.studentRequestDTOMapper = studentRequestDTOMapper;
    }

    @GetMapping("get-all")
    public List<Classes> list() {
        List<Classes> list = this.classesRepository.findAllCustom();
        return list;
    }

    @GetMapping("get-all-2")
    public List<Classes> list2() {
        List<Classes> list = this.classesRepository.findAllCustom2();
        return list;
    }

    //Lấy danh sách classes không bao gồm các mối quan hệ của nó
    @GetMapping("get-all-dto")
    public ResponseEntity<?> getAllClassesDTO() {
        List<ClassesResponseDTO> dtoList = classesResponseDTOMapper.entityToRDTO(classesRepository.findAll());
        return ResponseEntity.ok(dtoList);
    }


    //Thêm 1 classes mới
    @PostMapping("add")
    public ResponseEntity<?> creatNewClasses(
            @RequestBody ClassesRequestDTO classesRequestDTO
    ) {
        Classes c = classesRequestDTOMapper.dtoToEntity(classesRequestDTO);
        for (Student student : c.getStudents()) {
            student.setClasses(c);
        }
        Classes classes1 = classesRepository.save(c);
        return ResponseEntity.ok(classes1);
    }

    // Xóa 1 classes theo id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteClasses(
            @PathVariable Long id
    ) {
        Classes classes = classesRepository.findById(id).orElse(null);
        if (classes == null) {
            return ResponseEntity.notFound().build();
        }
        classesRepository.delete(classes);
        return ResponseEntity.ok("Xóa thành công lớp với ID: " + id);
    }

    //Test FETCH
    @GetMapping("test-fetch")
    public ResponseEntity<?> testFetch() {
        // Tìm kiếm đối tượng Classes với ID 1
        Classes classes = classesRepository.findById(1L).orElse(null);

        // Detach the entity to simulate LazyInitializationException scenario
        if (classes != null) {
//            entityManager.detach(classes);

            try {
                // Attempt to access the lazy-loaded collection
                List<Student> students = new ArrayList<>(classes.getStudents());
                return ResponseEntity.ok("Students size: " + students.size());
            } catch (LazyInitializationException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("LazyInitializationException occurred: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class not found");
        }
    }

    @GetMapping("test-fetch2")
    public ResponseEntity<?> testFetch2() {
        Classes classes = classesRepository.findById(1l).orElse(null);

//        entityManager.detach(classes);

        List<Student> list = classes.getStudents();

        return ResponseEntity.ok(list);
    }

}
