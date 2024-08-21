package week2.day1example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week2.day1example.beanexample.AppConfig;
import week2.day1example.service.ServiceExampleIMPL1;

/**
 * Created by Trong Phu on 14/08/2024 14:35:22
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/week2-day1")
public class Day1Controller2 {

    private final ServiceExampleIMPL1 serviceExampleIMPL1;
    private final AppConfig appConfig;

    @GetMapping("test2")
    public ResponseEntity<?> getTest(){
        appConfig.checkAppConfig();
        return ResponseEntity.ok(serviceExampleIMPL1.getAll());
    }
}
