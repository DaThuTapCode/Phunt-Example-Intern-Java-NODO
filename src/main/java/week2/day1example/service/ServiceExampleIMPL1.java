package week2.day1example.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trong Phu on 12/08/2024 15:57:05
 *
 * @author Trong Phu
 */
@Service
//Nếu để thuộc tính là prototype thì Khi gọi ở 1 class khác thì sẽ tạo ra 2 đối tượng khác nhau
//@Scope("prototype")
//1 instance dùng chung cho tất cả;
@Scope("singleton")
public class ServiceExampleIMPL1 implements IServiceExample{

    List<Object> list = new ArrayList<>();

    public ServiceExampleIMPL1(){
        System.out.println("ServiceExam1 vừa được khởi tạo");
        list.add(new Object[]{"Phú", 19});
        list.add(new Object[]{"Vân", 19});
        list.add(new Object[]{"Thảo", 20});
    }

    public List<Object> getAll(){
        return this.list;
    }

    public void delete(){
        list.remove(1);
    }

    @Override
    public String message() {
        return "Đây là tin nhắn của ServiceExample";
    }
}
