package week3.day2345example.controller.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import week3.day2345example.model.Classes;
import week3.day2345example.model.Student;
import week3.day2345example.repository.ClassesRepository;
import week3.day2345example.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Trong Phu on 20/08/2024 09:46:44
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping(value = "week3-day2/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public StudentController(
            StudentRepository studentRepository,
            ClassesRepository classesRepository
    ) {
        this.studentRepository = studentRepository;
        this.classesRepository = classesRepository;
    }

    //Lấy toàn bộ bản ghi của học sinh
    @GetMapping("get-all")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    //Lấy phân trang student
    @GetMapping("get-page")
    public ResponseEntity<?> getPageStudent(
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(studentRepository.findAll(pageable));
    }


    //Thêm 1 student mới
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(
            @RequestBody Student student
    ) {
        studentRepository.save(student);
        return ResponseEntity.ok(student);
    }

    //Thêm student mới với cascade ở khóa ngoại là persist
    @PostMapping("/add-persist")
//    @Transactional
    public ResponseEntity<String> addStudentPersists(@RequestBody Student student) {
        // Kiểm tra nếu đối tượng classes đã tồn tại
        if (student.getClasses() != null && student.getClasses().getId() != null) {
            Classes existingClass = classesRepository.findById(student.getClasses().getId())
                    .orElse(null);

            if (existingClass != null) {
                // Liên kết với đối tượng đã tồn tại
                student.setClasses(existingClass);
            } else {
                // Tạo mới đối tượng classes nếu không tồn tại
                Classes newClass = student.getClasses();
                Classes savedClass = classesRepository.save(newClass);
                student.setClasses(savedClass);
            }
        }
        boolean isStudentDetached = !entityManager.contains(student);
        boolean isClassesDetached = !entityManager.contains(student.getClasses());
        studentRepository.save(student);
        return ResponseEntity.ok("Student added successfully");
    }

//    @Transactional
    //Update 1 student
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student
    ) {
        Optional<Student> studentExisting = studentRepository.findById(id);
        if (studentExisting.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        student.setId(id);
//        studentExisting.get().setName(student.getName());
        studentRepository.save(student);
        return ResponseEntity.ok(studentExisting);
    }


    //Xóa student theo id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteStudent(
            @PathVariable Long id
    ) {
        Optional<Student> studentExisting = studentRepository.findById(id);
        if (studentExisting.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        studentRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/students/detach/{id}")
    public ResponseEntity<String> detachStudent(
            @PathVariable Long id,
            @RequestBody Student student2
    ) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
//            entityManager.detach(student); // Tách student khỏi persistence context
            entityManager.detach(student.getClasses()); // Tách cả đối tượng Classes

            boolean isStudentDetached = !entityManager.contains(student);
            boolean isClassesDetached = !entityManager.contains(student.getClasses());

            student.setAddress(student2.getAddress());
            student.setAge(student2.getAge());
            student.setStatus(student2.getStatus());
            student.setName(student2.getName());
            student.setClasses(student2.getClasses());
//            studentRepository.save(student);
            return ResponseEntity.ok("Student và Classes đã được tách khỏi persistence context");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy Student");
    }

    @GetMapping("/students/is-detached/{id}")
    public ResponseEntity<String> isDetached(@PathVariable Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
//            entityManager.detach(student); // Tách student khỏi persistence context
//            entityManager.detach(student.getClasses()); // Tách cả đối tượng Classes

            boolean isStudentDetached = !entityManager.contains(student);
            boolean isClassesDetached = !entityManager.contains(student.getClasses());

            if (isStudentDetached || isClassesDetached) {
                return ResponseEntity.ok("Student và Classes đã được tách khỏi persistence context");
            } else {
                return ResponseEntity.ok("Student hoặc Classes vẫn còn trong persistence context");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy Student");
    }

}
