package week2.day2example.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import week2.day2example.model.Student;
import week2.day2example.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trong Phu on 13/08/2024 15:29:25
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentPostController {

    private final StudentService studentService;

    /**
     * Post Basic
     */
    @PostMapping("add")
    public Student add(
            @RequestBody Student student
    ) {
        return studentService.add(student);
    }

    /**
     * PostMapping với params
     * - Ở đây yêu cầu bắt buộc phải có params là role và role phải có giá trị = admin
     */
    @PostMapping(value = "/create", params = "role=admin")
    public String createStudent(@RequestBody Student student, HttpServletRequest req) {
        // Logic để tạo người dùng với vai trò admin
        System.out.println(req.getParameter("role"));
        System.out.println(req.getParameter("a"));
        return "Admin user created successfully!";
    }

    /**
     * PostMapping với headers để yêu cầu các tiêu đề HTTP cụ thể
     */
    @PostMapping(value = "/create2", headers = "X-API-KEY=12345")
    public String createHeader(@RequestBody Student student, HttpServletRequest req) {
        // Logic để tạo người dùng khi có tiêu đề HTTP cụ thể
        return "User created with header successfully!";
    }

    /**
     * PostMapping với consumes để chỉ định nội dung mà phương thức xử lý
     */
    @PostMapping(value = "create3", consumes = "application/json")
    public String createUserFromJson(@RequestBody Student student) {
        //Logic để tạo người dùng từ dữ liệu json
        return "Đã tạo thành công người dùng từ dữ liệu json";
    }

    /**
     * PostMapping với Multipart File Upload
     */
    @PostMapping("/upload")
    public ResponseEntity<?> login(
            @RequestParam("file") MultipartFile file
    ) {
        return ResponseEntity.ok("File uploaded: " + file.getOriginalFilename());
    }

    /**
     * PostMapping với List of Objects (JSON Array)
     */
    @PostMapping("/create-student")
    public ResponseEntity<String> createStudent(
            @RequestBody List<Student> students
    ) {
        return ResponseEntity.ok("Number of student created: " + this.studentService.getAll().size());
    }

    /**
     * PostMapping với @ModelAttribute
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @ModelAttribute Student student
    ) {
        return ResponseEntity.ok("Nam student: " + student.getName());
    }

    /**
     * PostMapping với @PathVariable
     */
    @PostMapping("/s/{id}/update")
    public ResponseEntity<?> updateStudent(
            @PathVariable("id") Long id,
            @RequestBody Student student
    ) {
        return ResponseEntity.ok("StudentId: " + id + "Update with name: " + student.getName());
    }

    /**
     * PostMapping với produces và consumes
     */
    @PostMapping(
            value = "json-data",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, String>> handleJSON(
            @RequestBody Map<String, String> json
    ) {
        Map<String, String> response = new HashMap<>();
        response.put("received", "true");
        response.put("data", json.toString());
        return ResponseEntity.ok(response);
    }
}
