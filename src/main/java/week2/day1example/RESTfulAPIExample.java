package week2.day1example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week2.day1example.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trong Phu on 12/08/2024 10:36:57
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("api")
public class RESTfulAPIExample {

    @Value("${api.in}")
    int a;

    // Sử dụng ArrayList thay vì List.of(...)
    List<User> list = new ArrayList<>(List.of(
            new User("1", "Phú", "130904"),
            new User("2", "Vân", "130904"),
            new User("3", "Thảo", "130904")
    ));


    @GetMapping("test-get")
    public ResponseEntity<?> testGet() {

        System.out.println(a);
        return ResponseEntity.ok(list);
    }

    @PostMapping(
            value = "/test-post",
            params = "action=add",
            headers = "X-Request-Header=custom-value",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> testPost(
            @RequestBody User user,
            @RequestParam("action") String action,
            @RequestHeader("X-Request-Header") String headerValue) {

        // Kiểm tra xem tham số và tiêu đề có đúng không
        if (!"add".equals(action)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if (!"custom-value".equals(headerValue)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Thêm người dùng vào danh sách
        list.add(user);

        // Trả về người dùng mới được thêm vào dưới dạng JSON
        return ResponseEntity.ok(user);
    }

}


