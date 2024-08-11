package com.trongphu.week1.day2example.keywordthis;

/**
 * Created by Trong Phu on 06/08/2024 20:45:35
 *
 * @author Trong Phu
 */
public class Example {
    private String message;
    private String from;

    public Example message(String message) {
        this.message = message;
        return this;
    }

    public Example from(String from) {
        this.from = from;
        return this;
    }

    /**1.Dùng để phâb biệt tham số có cùng tên  với các biến instance, `this` được sử
    dụng để phân biệt chúng.
    Ví dụ: Constructor sử dụng từ khóa this để phân biệt biến instance và tham số*/
    public Example(String message, String from) {
        this.message = message;
        this.from = from;
    }

    /**2. Gọi constructor khác trong cùng 1 lớp`this()` được sử dụng
     *  để gọi một constructor khác trong cùng một lớp.
     *  <br>
    Ví dụ: Constructor không tham số gọi constructor có tham số bằng từ khóa this*/
    //Constructor không tham số
    public Example(){
        this("Xin chào Phú", "Trong Phu");
    }

    /**
     * Phương thức sử dụng từ khóa this để gọi phương thức khác
     * */
    public void printX(){
        this.display();
    }
    /**
     * 3. Trả về tham chiếu đến đối tượng hiện tại
     * `this` có thể được sử dụng để trả về tham chiếu đến đối tượng hiện tại
     * <p style="color:red;">hehe</p>*/
    public Example buider(String message, String from){
        this.message = message;
        this.from = from;
        return this;
    }


    /**
     * Phương thức hiển thị giá trị của biến instance*/
    public void display(){
        System.out.println("Message: " + this.message);
        System.out.println("From: " + this.from);
    }


    public static void main(String[] args) {
        Example e = new Example();
        Example e2 = new Example("Xin chào Thảo","Trong Phu");
        Example builder = new Example();

        e.display();

        e2.display();

        //builder trả về tham chiếu đến đối tượng hiện tại  cho phép chuỗi gọi các phương thức
        builder.buider("Xây", "Phú").display();
        builder.message("Phú dz").from("hehe").display();
    }
}
