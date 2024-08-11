package com.trongphu.week1.day3example.comparatorvscomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Trong Phu on 07/08/2024 16:26:29
 *
 * @author Trong Phu
 */
public class ComparatorExample {

    /**
     * Comparator: Đây là một interface trong Java được sử dụng để định nghĩa
     * các phương thức sắp xếp cho các lớp mà không thay đổi lớp đó.
     * Comparator cung cấp phương thức compare(T o1, T o2) để so sánh hai đối tượng.*/
}

class Student2 {
    String name;
    int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

class AgeComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 s1, Student2 s2) {
        return Integer.compare(s1.age, s2.age);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student2> students = new ArrayList<>();
        students.add(new Student2("John", 20));
        students.add(new Student2("Alice", 22));
        students.add(new Student2("Bob", 18));

        // Sắp xếp theo tuổi
        Collections.sort(students, new AgeComparator());

        System.out.println(students); // Output: [Bob (18), John (20), Alice (22)]
    }
}