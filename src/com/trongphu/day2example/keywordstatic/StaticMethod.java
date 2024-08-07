package com.trongphu.day2example.keywordstatic;

/**
 * Created by Trong Phu on 06/08/2024 15:02:10
 *
 * @author Trong Phu
 *
 *
 * Ở ví dụ này sẽ thực hiện minh họa cách sử dụng biến tĩnh và phương thức tĩnh trong java.
 * Dùng để hiểu sự khác biệt giữa các thành viên tĩnh và không tĩnh và không tĩnh của một lớp,
 * cũng như cách chúng được truy cập và hoạt động.
 */
public class StaticMethod {
    /**
     * Phương thức tĩnh static method trong java là phương thức thuộc vêg lớp,
     * không thuộc về đối tượng cụ thể nào của lớp. Phương thức tĩnh có thể được gọi mà không
     * cần tạo một đối tượng của lớp. Chúng có thể truy cập trực tiếp các thành viên tĩnh khác của lớp
     * nhưng không thể truy cập trực tiếp các thành viên không tĩnh;
     */
    public static void incremetStaticCounter() {
        staticCounter++;
        System.out.println("Static counter tăng lên: " + staticCounter);
    }

    /**
     * Biến tĩnh sử dụng để đếm số lần phương thức tĩnh incremetStaticCounter() được gọi;*/
    public static int staticCounter = 0;


    //Biến không tĩnh(instance variable);
    public int instanceCounter = 0;

    //Phương thức không tĩnh;
    public void incrementInstanceCounter() {
        instanceCounter++;
        System.out.println("Instance counter tăng lên: " + instanceCounter);
    }

    public static void main(String[] args) {
        //Gọi phương thức tĩnh mà không cần tạo đối tượng;
        StaticMethod.incremetStaticCounter(); //op: 1
        StaticMethod.incremetStaticCounter(); //op: 2

        //Tạo đối tượng của lớp;
        StaticMethod example1 = new StaticMethod();
        StaticMethod example2 = new StaticMethod();

        //Gọi phương thức không tĩnh qua đối tượng;
        example1.incrementInstanceCounter(); //op: 1
        example2.incrementInstanceCounter(); //op: 1

        //Gọi lại phương thức tĩnh qua tên lớp;
        StaticMethod.incremetStaticCounter(); //op: 3
    }
}
