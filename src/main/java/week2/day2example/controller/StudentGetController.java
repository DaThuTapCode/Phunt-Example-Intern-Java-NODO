package week2.day2example.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import week2.day2example.model.Student;
import week2.day2example.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

/**
 * Created by Trong Phu on 13/08/2024 10:14:43
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentGetController {

    private final StudentService studentService;


    /**
     * GetMapping Basic
     */
    @GetMapping(value = "get-all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }


    /**
     * GetMapping với @RequestParam
     * <br>
     * required = false => Params bắt buộc phải có và ngược lại true thì có cũng được không có cũng được
     */
    @GetMapping(value = "get-by-id")
    public ResponseEntity<?> getById(
            @RequestParam(required = false, defaultValue = "1") Long id
    ) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }


    /**
     * GetMapping với @PathVariable
     */
    @GetMapping(value = "get/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable(name = "id", value = "id") Long id
    ) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    /**
     * GetMapping với params
     * Phương thức này chỉ được gọi khi tham số `type` có mặt trong query string.
     */
    @GetMapping(value = "fillter", params = "type")
    public ResponseEntity<?> fillterByType(
            @RequestParam("type") String type
    ) {
        return ResponseEntity.ok("Filtered by type: " + type);
    }

    /**
     * GetMapping với nhiều @RequestParam
     */
    @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> search(
            @RequestParam("query") String query,
            @RequestParam("page") int page) {
        return ResponseEntity.ok("Searching for: " + query + ", page: " + page);
    }

    /**
     * GetMapping với produces
     */
    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/json", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Map<String, String>> getJson() {
//    public ResponseEntity<?> getJson() {
        Map<String, String> response = new HashMap<>();
        response.put("ntp", "Hello, JSON");
//        return ResponseEntity.ok("{\"message\": \"Form submitted successfully as JSON!\"}");
//        return ResponseEntity.ok("response");
        return ResponseEntity.ok(response);

    }

    /**
     * GetMapping với @RequestHeader
     */
    @GetMapping("header")
    public ResponseEntity<?> getHeader(@RequestHeader("User-Agent") String userAgent) {
        return ResponseEntity.ok("User-Agent: " + userAgent);
    }

    /**
     * GetMapping  với List và @RequestParam
     */
    @GetMapping("items")
    public ResponseEntity<List<String>> getItems(
            @RequestParam List<String> ids
    ) {
        return ResponseEntity.ok(ids);
    }

    /**
     * GetMapping với Map và @RequestParam
     */
    @GetMapping("map")
    public ResponseEntity<Map<String, String>> getMap(
            @RequestParam Map<String, String> params
    ) {
        return ResponseEntity.ok(params);
    }

    /**
     * GetMapping với defaultValue và required = false
     */
    @GetMapping("optional")
    public ResponseEntity<String> getOptinal(
            @RequestParam(name = "param", required = false, defaultValue = "default") String param
    ) {
        return ResponseEntity.ok("Param: " + param);
    }

    /**
     * GetMapping với @MatrixVariable
     */
    @GetMapping("matrix/{path}")
    public ResponseEntity<?> getMatrixVariable(
            @PathVariable String path,
            @MatrixVariable Map<String, List<String>> matrixVars
    ) {
        return ResponseEntity.ok(matrixVars);
    }

    /**
     * GetMapping với @ModelAttribute
     */
    @GetMapping("/form")
    public ResponseEntity<?> handleForm(@ModelAttribute Student student) {
        return ResponseEntity.ok(student);
    }

    /**
     * GetMapping với ResponseEntity và mã trạng thái
     */
    @GetMapping("status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tài nguyên");
    }

    /**
     * GetMapping với Wildcard trong value
     */
    @GetMapping("files/**")
    public ResponseEntity<String> handleWildCard(
            HttpServletRequest req) {
        String restOfURL = (String) req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        return ResponseEntity.ok("Rest of the URL: " + restOfURL);
    }
}
