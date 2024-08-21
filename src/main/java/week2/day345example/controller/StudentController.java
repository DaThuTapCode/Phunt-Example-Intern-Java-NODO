package week2.day345example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week2.day345example.dto.response.StudentResponseDTO;
import week2.day345example.entity.Student;
import week2.day345example.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Trong Phu on 14/08/2024 10:46:29
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("week2-day3")
public class StudentController {

    private final StudentRepository repository;

    //Lấy ra toàn bộ danh sách Student
    @GetMapping("get-all")
    public List<Student> getAll() {
        return repository.findAll();
    }

    //Lấy student theo id
    @GetMapping("get-by-id/{id_student}")
    public Optional<Student> getById(
            @PathVariable(name = "id_student") Long id
    ) {
        return repository.findById(id);
    }

    //Lấy student có năm sinh
    @GetMapping("get-all-dto")
    public List<StudentResponseDTO> getAllDTO() {

        List<StudentResponseDTO> ldto = repository.findAll().stream().map(StudentResponseDTO::covert).collect(Collectors.toList());
        return ldto;
    }

    //Lấy student có năm sinh
    @GetMapping("get-all-dto2")
    public List<StudentResponseDTO> getAllDTO2() {

        List<StudentResponseDTO> ldto = repository.gethehe();
        return ldto;
    }

    //Tạo đối tượng student mới
    @PostMapping("create")
    public Student create(
            @RequestBody Student student
    ) {
        return repository.save(student);
    }

    //Update đối tượng theo id
    @PutMapping("update/{id_student}")
    public Student update(
            @PathVariable(name = "id_student") Long id,
            @RequestBody Student student
    ) throws Exception {
        Optional<Student> student1 = Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id)));

        student.setId(id);
        return repository.save(student);
    }

    //Delete student
    @DeleteMapping("delete/{id_student}")
    public ResponseEntity<String> delete(
            @PathVariable(name = "id_student") Long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Xóa thành công student với id: " + id);
        }
        return ResponseEntity.ok("Không có student nào với id: " + id);
    }



    ////////Ngày 5///////////////////////////////////
    //Native query
    @GetMapping("day5/get-by-id/{id_student}")
    public ResponseEntity<?> getnativeId(
            @PathVariable(name = "id_student") Long id) {

           Student student =  repository.getStudentByID(id);
            return ResponseEntity.ok(student);

    }

    //Phân trang
    @GetMapping("day5/get-page")
    public ResponseEntity<?> getnPage(
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> lStudent =  repository.findAll(pageable);
        return ResponseEntity.ok(lStudent);
    }

    //Phân trang native
    @GetMapping("day5/get-page-native")
    public ResponseEntity<?> getnPageNative(
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Object[]> studentsPage = repository.getStudentsWithPagination(pageable);

        return ResponseEntity.ok(studentsPage);
    }
    //Phân trang với @PageableDefault
    @GetMapping("day5/get-page-default")
    public Page<Student> getStudents(
            @PageableDefault(
                    size = 10,
                    page = 0,
                    sort = {"name", "age"}, // Sắp xếp theo name
                    direction = Sort.Direction.ASC) // Sắp xếp tăng dần
                    Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/search")
    public List<Student> searchByName(
            @RequestParam String name
    ) {
        // Phương thức này có thể bị SQL Injection vì nó sử dụng tham số đầu vào trực tiếp trong truy vấn.
        int a = 1;
        return repository.findByName(name);
    }
}
