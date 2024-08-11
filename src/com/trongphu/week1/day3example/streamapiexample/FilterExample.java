package com.trongphu.week1.day3example.streamapiexample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Trong Phu on 07/08/2024 14:29:42
 *
 * @author Trong Phu
 */
public class FilterExample {

    /**
     * filter() là một phương thức trong Stream API, giúp lọc các phần tử thỏa mãn
     * một điều kiện nhất định
     *
     * Thường được sử dụng với các biểu thức lamda*/

    public static void main(String[] args) {
        /// Ví dụ về filter
        List<String> list = Arrays.asList("apple", "banana", "orange", "pear");
        List<String> filteredList = list.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        System.out.println(filteredList); // Output: [apple]

    }
}
