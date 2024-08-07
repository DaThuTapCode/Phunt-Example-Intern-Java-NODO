package com.trongphu.day2example.oop;

/**
 * Created by Trong Phu on 06/08/2024 22:19:03
 *
 * @author Trong Phu
 * Lớp (Class) và đối tượng (Object) là hai khái niệm cơ bản trong lập trình hướng đối tượng
 * OOP
 * <br>
 * Ví dụ về lớp (Class)
 * <br>
 * Lớp là một khuân mẫu hoặc bản thiết kết để tạo ra các đối tượng
 * <br>
 * Nó định nghĩa các thuộc tính(field) và các hành vi (method) mà đối tượng của lớp đó sẽ có
 */
//Cấu trúc một lớp
public class TheoryOOP {
//Thuộc tính (biến instance)
    private String name;
    private String category;

    //Constructor (Phương thức khởi tạo);
    public TheoryOOP(String name, String category){
        this.name = name;
        this.category = category;
    }

    //Phương thức (method)
    public void displayDetails(){
        System.out.println("name: " + this.name);
        System.out.println("cate: " + this.category);
    }

    //Getter và setter cho các thuộc tính;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


/**
 * Tổng kết:
 *
 * Lớp (Class):
 * Là một khuôn mẫu hoặc bản thiết kế cho các đối tượng.
 * Định nghĩa các thuộc tính (biến instance) và hành vi (phương thức) của đối tượng.
 * Có thể chứa constructor để khởi tạo các đối tượng của lớp.
 *
 * Đối tượng (Object):
 * Là một thể hiện cụ thể của một lớp.
 * Được tạo ra bằng cách sử dụng từ khóa new theo sau là constructor của lớp.
 * Có thể truy cập và thay đổi các thuộc tính cũng như gọi các phương thức của lớp.**/
