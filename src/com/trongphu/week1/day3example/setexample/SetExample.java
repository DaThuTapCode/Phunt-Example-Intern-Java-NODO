package com.trongphu.week1.day3example.setexample;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Trong Phu on 07/08/2024 12:14:31
 *
 * @author Trong Phu
 */
public class SetExample {
    /**
     * Set là một interfacevà kế thừa từ interface `Collection`. `Set` đại diện cho một tập hợp các phần tử
     * mà không cho phép các phần tử trùng lặp. `Set` không duy trì thứ tự của các phần tử ngoại trừ (LinkedHashSet),
     * cung cấp các lớp triển khai
     * <br>
     * HashSet, LinkedHashSet, TreeSet
     */
    public static void main(String[] args) {
        //Cách triển khai set
        Set<?> hashSet = new HashSet<>();
        Set<?> linkedHashSet = new LinkedHashSet<>();
        Set<?> treeSet = new TreeSet<>();
    }
}

/**
 * Ví dụ về HashSet
 * <br>
 *  HashSet là một lớp triển khai interface `Set` sử dụng bảng băm (hash table) để
 *  lưu trữ các phần tử;
 *  <br>
 *  - Thứ tự các phần tử: Không duy trì thứ tự các phần tử
 *  <br>
 *  - Hiệu suất: Nhanh cho các thao tác thêm, xóa và kiểm tra phần tử (O(1)).
 *  <br>
 *  - Khi nào dùng?: Khi cần lưu trữ các phần tử duy nhất mà không quan tâm đến thứ tự
 */
class HashSetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        //Thêm phần tử
        hashSet.add("Phú");
        hashSet.add("Thảo");
        hashSet.add("Vân");

        //Thêm phần tử trùng lặp (sẽ không được thêm vào set)
        hashSet.add("Phú");


        //Kiểm tra phần tử
        System.out.println("Chứa Phú: " + hashSet.contains("Phú")); //op: true;

        //Xóa phần tử
        hashSet.remove("Vân");

        //Lặp qua các phần tử
        for (String item : hashSet){
            System.out.println(item);
        }
    }
}

/**
 * Ví dụ về LinkedHashSet
 * <br>
 * - LinkedHashSet là một lớp triển khai của interface `Set` sử dụng bảng băm và danh sách liên kết
 * kép để lưu trữ dữ các phần tử. Nó duy trì thứ tự chèn của các phần tử.
 * <br>
 * - Thứ tự các phần tử: Duy trì thứ tự chèn
 * <br>
 * - Hiệu suất: Tương tự như HashSet, nhưng thêm bộ nhớ duy trì thứ tự (O(1) cho các thao tác cơ bản).
 * <br>
 * - Khi nào dùng: Khi cần lưu các phần tử duy nhất và duy trì thứ tự chèn
 * */
class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        //Thêm phần tử
        linkedHashSet.add("Phú");
        linkedHashSet.add("Thảo");
        linkedHashSet.add("Vân");

        // Thêm phần tử trùng lặp (sẽ không được thêm vào set)
        linkedHashSet.add("Phú");

        // Kiểm tra phần tử
        System.out.println("Chứa Phú: " + linkedHashSet.contains("Phú")); // op: true

        //Xóa phần tử
        linkedHashSet.remove("Thảo");

        //Lặp qua các phần tử
        for (String item : linkedHashSet){
            System.out.println(item);
        }
    }
}
/**
 * Ví dụ về `TreeSet`
 * <br>
 * - TreeSet là một lớp triển khai của `Set` sử dụng cây đỏ đen để lưu trữ các phần tử.
 * Nó duy trì thứ tự tự nhiên hoặc thứ tự được xác định bởi `Comparator`
 * <br>
 * - Thứ tự các phần tử: Duy trì thứ tự tự nhiên hoặc thứ tự được xác định bởi Comparator.
 * <br>
 * - Hiệu suất: Chậm hơn HashSet cho các thao tác thêm, xóa và kiểm tra phần tử (O(log n)).
 * <br>
 * - Khi nào dùng: Khi cần lưu trữ các phần tử duy nhất và duy trì thứ tự.
 * */

class TreeSetExample {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();

        //Thêm phần tử
        treeSet.add("Phú");
        treeSet.add("Vân");

        // Thêm phần tử trùng lặp (sẽ không được thêm vào set)
        treeSet.add("Phú");

        // Kiểm tra phần tử
        System.out.println("Chứa Phú: " + treeSet.contains("Phú")); // op: true

        //Xóa phần tử
        treeSet.remove("Phú");

        //Lắp qua các phần tử
        for (String item : treeSet){
            System.out.println(item);
        }
    }
}