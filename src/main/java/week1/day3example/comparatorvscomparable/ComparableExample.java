package week1.day3example.comparatorvscomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Trong Phu on 07/08/2024 16:20:20
 *
 * @author Trong Phu
 */
public class ComparableExample {
    /**
     * Comparable: Đây là một interface trong Java được sử dụng để sắp xếp các đối tượng
     * của một lớp. Lớp nào triển khai Comparable phải override phương thức compareTo(T o).
     * Phương thức này được sử dụng để xác định thứ tự tự nhiên của đối tượng.
     * */

}

/**Vị dụ Comparable
 * compareTo (Comparable Interface)
 * Phương thức compareTo của Comparable được sử dụng để so sánh
 * đối tượng hiện tại với đối tượng khác. Nó trả về:
 * Một số âm nếu đối tượng hiện tại nhỏ hơn đối tượng được so sánh.
 * Số 0 nếu đối tượng hiện tại bằng với đối tượng được so sánh.
 * Một số dương nếu đối tượng hiện tại lớn hơn đối tượng được so sánh.
 * */
 class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bob", 24));
        students.add(new Student("Alice", 23));
        students.add(new Student("Charlie", 25));
        Collections.sort(students);
        students.forEach(System.out::println);

        Student student = new Student("Phú", 18);
        Student student2 = new Student("Vân", 17);

        System.out.println(student.compareTo(student2));

    }
}
