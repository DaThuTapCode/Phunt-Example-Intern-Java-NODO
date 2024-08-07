package com.trongphu.day2example.keywordstatic;

/**
 * Created by Trong Phu on 06/08/2024 17:24:48
 *
 * @author Trong Phu
 * Ở ví dụ này mình họa về các lớp tĩnh(static class)
 */
public class StaticClassDemo {



    /**
     * Biến không tĩnh trong lớp bên ngoài
     * */
    private String outerVariable = "Biến lớp ngoài";

    /**
     * Trong java, lớp tĩnh(static class) là một khái niệm đặc biệt.
     * <br>
     * - Thực tế java không hỗ trợ lớp tĩnh cấp độ cao.
     * <br>
     * - Thay vào đó, Java hỗ trọ lớp tĩnh bên trong lớp khác.
     * <br>
     * - Đây là một lớp được khai báo với từ khóa `static` bên trong một lớp khác
     * và có những đặc điểm khác biệt đáng chú ý so với lớp không tĩnh
     * <br>
     * 1. Lớp tĩnh (Static Nested Class):
     * <br>
     * Lớp tĩnh bên trong (static nested class) là một lớp được khai báo với từ khóa `static`
     * bên trong một lớp khác.  Nó có thể được tạo ra mà không cần đối tượng của lớp bên ngoài*/
    public static class StaticNestedClass{
        //Biến tĩnh lớp bên trong;
        private static String nestedVariable = "Nested variable";

        //Phương thức tĩnh trong lớp bên trong;
        public static void staticMedthod(){
            System.out.println("Đây là phương thức tĩnh trong lớp bên trong.");
            System.out.println("Giá trị của biến tĩnh: " + nestedVariable);
        }
        //Phương thức không tĩnh trong lớp bên trong;
        public void instanceMethod(){
            System.out.println("Đây là phương thức không tĩnh trong lớp bên trong.");
            //Không thể truy cập trực tiếp biến không tĩnh của lớp bên ngoài
//            System.out.println("Giá trị biến bên ngoài: " + outerVariable);
        }
    }

    public static void main(String[] args) {
        //Tạo đối tượng của lớp tĩnh bên trong  mà không cần tạo đối tượng của lớp bên ngoài;
        StaticClassDemo.StaticNestedClass nestedObject = new StaticClassDemo.StaticNestedClass();
        //Gọi phương thức tĩnh của lớp tĩnh bên trong
        StaticClassDemo.StaticNestedClass.staticMedthod();
        //Gọi phương thức không tĩnh của lớp tĩnh bên trong;
        nestedObject.instanceMethod();
    }
}
