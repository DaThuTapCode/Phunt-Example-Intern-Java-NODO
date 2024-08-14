package week1.day3example.streamapiexample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Trong Phu on 7/08/2024 15:44:54
 *
 * @author Trong Phu
 */
public class SortExample {
    /**
     * `sort()` là phương thức được thêm vào `List`  interface từ java 8,
     * cho phép sắp xếp các phần tử trong danh sách dựa trên một comparator
     *
     * Có thể sử dụng với Stream API bằng các sử dụng phương thức `sorted()` */

    //Ví dụ
    public static void main(String[] args) {
        List<String> list = Arrays.asList("banana", "apple", "pear", "orange");

        List<String> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedList); // Output: [apple, banana, orange, pear]

    }

}
