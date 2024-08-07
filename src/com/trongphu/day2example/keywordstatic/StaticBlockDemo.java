package com.trongphu.day2example.keywordstatic;

/**
 * Created by Trong Phu on 06/08/2024 13:45:11
 *
 * @author Trong Phu
 * Ở ví dụ này minh họa về cách sử dụng khối tĩnh trong java và sự tương tác
 * của nó với các biến tĩnh và constructor của lớp.
 */
public class StaticBlockDemo {
    //Ví dụ về khối tĩnh

    public static int staticVariable;

    /**
     * - Khối tĩnh trong java là một khối mã đặc biệt, được khai báo với từ khóa static, được thực thi khi lớp được nạp
     * vào bộ nhớ, trước khi bẩt kỳ đối tượng nào của lớp được tạo;
     * <br>
     * - Chức năng: Nó được sử dụng để thực hiện các tác vụ khởi tạo tĩnh, như khởi tạo các biến tĩnh
     * hoặc thực hiện các hành động cần thiết chỉ trong 1 lần cho lớp;
     * */
    static {
        System.out.println("Khối tĩnh đã được thực thi!");
        staticVariable = 42;
    }

    /**
     * Constructor được gọi khi đối tượng mới của class được tạo ra
     * */
    public StaticBlockDemo(){
        System.out.println("Contructor đã được thực thi!");
    }

    /**
     * Phương thức tĩnh để in ra giá trị của biến tĩnh*/
    public static void displayStaticVariable(){
        System.out.println("Giá trị của biến tĩnh: " + staticVariable);
    }

    public static void main(String[] args) {
        //Tạo đối tượng của lớp;
        StaticBlockDemo example =  new StaticBlockDemo();
        StaticBlockDemo.displayStaticVariable();
        StaticClassDemo.StaticNestedClass.staticMedthod();
    }

}

