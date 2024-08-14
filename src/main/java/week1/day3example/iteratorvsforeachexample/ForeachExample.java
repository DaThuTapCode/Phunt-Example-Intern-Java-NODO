package week1.day3example.iteratorvsforeachexample;

import java.util.*;

/**
 * Created by Trong Phu on 7/08/2024 15:15:06
 *
 * @author Trong Phu
 */
public class ForeachExample {

    /**
     * Định nghĩa:
     *
     * for-each là một vòng lặp đơn giản để duyệt qua các phần tử của một Collection, mảng,
     * hoặc bất kỳ đối tượng nào triển khai Iterable.
     * So sánh với for:
     *
     * for-each dễ sử dụng và giúp mã nguồn ngắn gọn hơn khi chỉ cần duyệt qua các phần tử,
     * trong khi vòng lặp for truyền thống có thể phức tạp hơn nhưng linh hoạt hơn trong việc điều khiển chỉ số lặp và các thao tác khác.*/
    public static void main(String[] args) {

        //Sử dụng với List
        List<String> list = Arrays.asList("A", "B", "C");

        for (String item : list) {
            System.out.println(item);
        }

        //Sử dụng với Set
        Set<String> set = new HashSet<>(Arrays.asList("X", "Y", "Z"));

        for (String item : set) {
            System.out.println(item);
        }

        //Sử dụng với Map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }


    }
}
