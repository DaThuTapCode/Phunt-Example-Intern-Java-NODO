package com.trongphu.week1.day3example.streamapiexample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Trong Phu on 11/08/2024 17:33:49
 *
 * @author Trong Phu
 */
public class MapExample {
    /**
     * `map()` là một phương thức trong Stream API, giúp chuyển đổi các phần tử
     * của Stream từ kiểu này sang kiểu khác
     *
     * Mỗi phầnn tử trong Stream sẽ được biến đổi dựa trên logic được cung cấp trong hàm map*/
    public static void main(String[] args) {
        //Ví dụ về map
        List<String> list = Arrays.asList("1", "2", "3");
        List<Integer> inList = list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(inList);
    }
}
