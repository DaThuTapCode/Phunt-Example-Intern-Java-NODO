package week1.day3example.iteratorvsforeachexample;

import java.util.*;

/**
 * Created by Trong Phu on 7/08/2024 15:06:24
 *
 * @author Trong Phu
 */
public class IteratorExample {

    /**
     * Iterator là 1 interface trong java giúp duyệt qua các phần tử trong 1
     * Collection (như List, Set, Map). Nó cung cấp các phương thức để lặp qua các phần
     * tử mà không cần biết cấu trúc bên trong của Collection*/


    /**
     * Sử dụng khi nào?
     * Khi cần duyệt qua các phần tử trong 1 Collection một cách an toàn, đặc biệt
     * là khi cần xóa các phần tử trong quá trình lặp*/

    /**
     * So sánh với Foreach
     * Iterator cho phép xóa phần tử trong quá trình lặp trong khi foreach không cho phép.
     *
     * Iterator có thể sử dụng với bất kỳ Collection nào, còn foreach cso thể
     * dễ sử dụng hơn khi chỉ cần duyệt qua các phần tử mà không cần thao tác phức tạp
     * */




    public static void main(String[] args) {
        ///Sử dụng với List
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Sử dụng với Set
        Set<String> set = new HashSet<>();
        set.add("X");
        set.add("Y");
        set.add("Z");

        Iterator<String> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        //Sử dụng với Map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Iterator<Map.Entry<Integer, String>> iterator3 = map.entrySet().iterator();
        while (iterator3.hasNext()) {
            Map.Entry<Integer, String> entry = iterator3.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
