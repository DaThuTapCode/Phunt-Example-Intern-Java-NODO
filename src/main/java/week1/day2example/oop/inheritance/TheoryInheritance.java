package week1.day2example.oop.inheritance;

import java.time.LocalDate;

/**
 * Created by Trong Phu on 07/08/2024 08:34:51
 *
 * @author Trong Phu
 */
public class TheoryInheritance {
    /***
     * Kế thừa là một trong những tính năng quan trọng của lập trình hướng đối tượng OOP
     * <br>
     * - Nó cho phép 1 lớp con kết thừa các thuộc tính và phương thức từ lớp cha
     * <br>
     * - Các loại kế thừa:
     * <br>
     * - Đơn kế thừa (Single Inheritance): Một lớp con kế thừa 1 lớp cha duy nhất
     * <br>
     * - Đa kế thừa(Multilevel Inheritance): Một lớp kế thừa 1 lớp khác, lớp này lại kế thừa từ lớp khác nữa
     * <br>
     * - Kế thừa phân cấp (Hierarchical Inheritance): Nhiều lớp con kế thừa từ 1 lớp cha duy nhất
     */

    public static void main(String[] args) {
        Dog dog  = new Dog("Nick", LocalDate.MAX, 2);
        dog.displayDetail();
//        dog.bark();
//        dog.sleep();
    }
}
