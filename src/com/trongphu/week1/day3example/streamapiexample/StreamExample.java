package com.trongphu.week1.day3example.streamapiexample;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Trong Phu on 7/08/2024 15:27:28
 *
 * @author Trong Phu
 */
public class StreamExample {
    /**
     * `Stream` trong java 8 là 1 interface giúp xử lý các chuỗi dữ liệu
     * (sequences of elements) một cách dễ dàng, đồng thời hỗ trợ các phép toán
     * như filter, map, reduce, collect và foreach.
     *
     * `Stream` không lưu trữ dữ liệu mà chỉ thực hiện các thao tác trên nguồn dữ liệu
     * (Collections, Arrays, hoặc I/O channels)
     *
     * */
    public static void main(String[] args) {
        //Ví dụ cơ bản về Stream
        List<String> list = Arrays.asList("apple", "banana", "orange");
        list.stream().forEach(System.out::println);

    }
}
