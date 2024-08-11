package com.trongphu.week1.day3example.mapexample;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Trong Phu on 07/08/2024 12:14:03
 *
 * @author Trong Phu
 */


public class MapExample {
    /**
     * Map là một interface không kế thừa từ interface `Collection`. `Map` đại diện cho một tập hợp các
     * cặp khóa giá trị (key - value pairs), trong đó mỗi khóa liên kết với đúng một giá trị `Map` không cho phép
     * các khóa trùng lặp và mỗi khóa chỉ liên kết với một giá trị duy nhất
     * <br>
     * Các lớp triển khai phổ biến của `Map`
     * HashMap, LinkedHashMap, TreeMap
     */
    Map<String, Integer> hashMap = new HashMap<>();
    Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
    Map<String, Integer> treeMap = new TreeMap<>();


}

/**
 * Ví dụ về HashMap
 * <br>
 * HashMap là một triển khai của interface Map sử dụng để băm lưu trữ các cặp khóa - giá trị
 * <br>
 * Nó không duy trì thứ tự của các phần tử.
 */
class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        //Thêm phần tử;
        hashMap.put("Phú", 1);
        hashMap.put("Vân", 2);
        hashMap.put("Thảo", 3);

        //Lấy phần tử
        Integer value = hashMap.get("Vân"); //op: 2
        System.out.println("Value key Vân: " + value);

        //Xóa phần tử
        hashMap.remove("Thảo");
        //Kiểm tra khóa
        boolean containsKey = hashMap.containsKey("Phú"); //vl: true
        System.out.println("Check key: " + containsKey);
        //Kiểm tra giá trị
        boolean containsValue = hashMap.containsValue(3); // vl: false
        System.out.println("Check value: " + containsValue);

        System.out.println(hashMap);
        //Lặp các phần tử
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

}

/**
 * Ví dụ về TreeMap
 * <br>
 * TreeMap là một lớp triển khai của Map sử dụng cây đỏ-đen để lưu trữ các cặp khóa-giá trị.
 * Nó duy trì thứ tự tự nhiên hoặc thứ tự được xác định bởi một Comparator.
 * <br>
 * - Thứ tự các phần tử: Duy trì thứ tự tự nhiên hoặc thứ tự được xác định bởi Comparator.
 * <br>
 * - Hiệu suất: Chậm hơn HashMap cho các thao tác thêm, xóa và truy cập phần tử (O(log n)).
 * <br>
 * - Khi nào dùng: Khi cần lưu trữ các cặp khóa-giá trị và duy trì thứ tự.
 */

class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();

        //Thêm phần tử
        treeMap.put("Apple", 1);
        treeMap.put("Banana", 2);
        treeMap.put("Cherry", 3);

        //Lấy phần tử
        Integer value = treeMap.get("Banana"); //op: 2

        //xÓa phần tử
        treeMap.remove("Cherry");

        //Kiểm tra khóa
        boolean containsKey = treeMap.containsKey("Apple"); //op: true;

        //Kiểm tra giá trị
        boolean containValue = treeMap.containsValue(1); //op: true;

        //Lặp qua các phần tử
        for(Map.Entry<String, Integer> entry: treeMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    }
}

/**
 * Ví dụ về LinkedHashMap
 * <br>
 * LinkedHashMap là một lớp triển khai của Map sử dụng cây đỏ-đen để lưu trữ các cặp khóa-giá trị.
 * Nó duy trì thứ tự tự nhiên hoặc thứ tự được xác định bởi một Comparator.
 * <br>
 Thứ tự các phần tử: Duy trì thứ tự chèn.
 * <br>
 * Hiệu suất: Tương tự như HashMap, nhưng thêm chi phí duy trì thứ tự (O(1) cho các thao tác cơ bản).
 * <br>
 * - Khi nào dùng: Khi cần lưu trữ các cặp khóa-giá trị và duy trì thứ tự chèn.
 */
class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Thêm phần tử
        linkedHashMap.put("Apple", 1);
        linkedHashMap.put("Banana", 2);
        linkedHashMap.put("Cherry", 3);

        // Lấy phần tử
        Integer value = linkedHashMap.get("Banana"); // Kết quả: 2

        // Xóa phần tử
        linkedHashMap.remove("Cherry");

        // Kiểm tra khóa
        boolean containsKey = linkedHashMap.containsKey("Apple"); // Kết quả: true

        // Kiểm tra giá trị
        boolean containsValue = linkedHashMap.containsValue(3); // Kết quả: false

        // Lặp qua các phần tử
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}