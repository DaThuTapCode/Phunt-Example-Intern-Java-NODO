package week2.day1example.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week2.day1example.beanexample.AppConfig;
import week2.day1example.beanexample.MyBean;
import week2.day1example.service.IServiceExample;
import week2.day1example.service.ServiceExampleIMPL1;

/**
 * Created by Trong Phu on 14/08/2024 14:33:23
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("api/week2-day1")
//@RequiredArgsConstructor
public class Day1Controller {

    private final ServiceExampleIMPL1 serviceExampleIMPL1;

    private final IServiceExample iServiceExample;

    private  MyBean myBean;

    public Day1Controller(ServiceExampleIMPL1 serviceExampleIMPL1
            , @Qualifier("serviceExampleIMPL1") IServiceExample iServiceExample
            , MyBean myBean
    ) {
        this.serviceExampleIMPL1 = serviceExampleIMPL1;
        this.iServiceExample = iServiceExample;
        this.myBean = myBean;
    }

    @GetMapping("test1")
    public ResponseEntity<?> getTest(){
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        myBean = context.getBean(MyBean.class);
//        context.close();
        System.out.println(iServiceExample.message());
        return ResponseEntity.ok(this.serviceExampleIMPL1.getAll());
    }

    @GetMapping("delete")
    public ResponseEntity<?> dl(){
        this.serviceExampleIMPL1.delete();
        return ResponseEntity.ok("Đã xóa");
    }
}
