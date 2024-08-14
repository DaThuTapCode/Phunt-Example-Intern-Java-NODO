package week1.day3example.streamapiexample;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Trong Phu on 7/08/2024 15:38:04
 *
 * @author Trong Phu
 */
public class ParallelStream {
    /**
     * ParallelStream là một biến thể của Stream API, cho phép xử lý
     * các phần tử của Stream song song (parallel) để cải thiện hiệu suất, đặc
     * biệt với khối lượng dữ liệu lớn
     *
     * - Tuy nhiên việc sử dụng parallelStream cần cẩn thận vì nó có thể không phù hợp
     * trong 1 số trường hợp*/
    public static void main(String[] args) {
        //Ví dụ về ParallelStream
        List<String> list = Arrays.asList("apple", "banana", "orange");
        list.parallelStream().forEach(System.out::println);
    }

}
