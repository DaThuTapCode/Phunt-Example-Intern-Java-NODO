package week2.day1example.service;

import org.springframework.stereotype.Service;

/**
 * Created by Trong Phu on 14/08/2024 15:47:23
 *
 * @author Trong Phu
 */
@Service
public class ServiceExampleIMPL2 implements IServiceExample{

    @Override
    public String message() {
        return "Đây là tin nhắn của ServiceExample2";
    }
}
