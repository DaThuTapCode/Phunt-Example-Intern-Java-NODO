package com.trongphu.week1.day3example.listexample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Trong Phu on 07/08/2024 11:15:06
 *
 * @author Trong Phu
 */
public class ListExample {
    //Cách triển khai List
    //ArrayList
    List<String> arrayList = new ArrayList<>();
    //LinkedList
    List<String> linkedList = new LinkedList<>();
}

//Ví dụ với ArrayList
class ArrayListExample{
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        //Thêm phần tử;
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Chery");

        //Lấy phần tử thứ 2
        System.out.println("Lấy phần tử: " + arrayList.get(1));

        //Xóa phần tử
        arrayList.remove(2);

        //Cập nhật phần tử
        arrayList.set(1,"Phú");

        System.out.println(arrayList);
        //Lặp qua danh sách
        for (String item : arrayList){
            System.out.println(item);
        }
    }
}

//Ví dụ với LinkedList
class LinkedListExample{
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        //Thêm phần tử
        linkedList.add("Phú");
        linkedList.add("Vân");
        linkedList.add("Thảo");

        //Lấy phần tử
        String name = linkedList.get(1); //op: Vân

        //Xóa phần tử
        linkedList.remove(2);

        //Cập nhật phần tử
        linkedList.set(1, "Phúu");

        System.out.println(linkedList);
        //Lắp qua danh sách
        for (String item: linkedList){
            System.out.println(item);
        }
    }
}
