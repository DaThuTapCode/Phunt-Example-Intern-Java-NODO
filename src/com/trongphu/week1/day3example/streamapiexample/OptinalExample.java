package com.trongphu.week1.day3example.streamapiexample;

import java.util.Optional;

/**
 * Created by Trong Phu on 7/08/2024 15:48:00
 *
 * @author Trong Phu
 */
public class OptinalExample {
    /**
     * Optional là một class giúp xử lý các giá trị có thể là null một cách an toàn, tránh các lỗi NullPointerException.
     * Optional cung cấp các phương thức như isPresent(), ifPresent(), orElse(), orElseGet(), và orElseThrow() để xử lý các giá trị.*/
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);

        optional.ifPresent(System.out::println); // Không in ra gì cả

        String result = optional.orElse("Default value");
        System.out.println(result); // Output: Default value

    }

}
