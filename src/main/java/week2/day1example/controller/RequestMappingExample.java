package week2.day1example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Trong Phu on 14/08/2024 16:36:02
 *
 * @author Trong Phu
 */
@RestController
public class RequestMappingExample {

    @RequestMapping(
            value = "get"
            , method = RequestMethod.GET, params = "check=true"
            , produces = MediaType.APPLICATION_JSON_VALUE
    )

    public String get(){
        return "hehe";
    }

//    - Ánh xạ đơn giản: Ánh xạ 1 URL Đến một phương thức nhất định.
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
//- Ánh xạ với HTTP method: Chỉ xử lý các yêu cầu với một loại HTTP method cụ thể.
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String handleSubmit() {
        return "Form submitted!";
    }
//- Ánh xạ với nhiều loại method: Xử lý nhiều loại HTTP method cho cùng 1 phương thức.
    @RequestMapping(value = "/data", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleData() {
        return "Handled GET or POST request";
    }
//- Ánh xạ với tiêu đề: Xử lý các yêu cầu có tiêu đề HTTP cụ thể.
    @RequestMapping(value = "/content", headers = "content-type=application/json")
    public String handleContent() {
        return "Handling JSON content";
    }


}
