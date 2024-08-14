package week1.day2example.oop;

/**
 * Created by Trong Phu on 06/08/2024 22:29:03
 *
 * @author Trong Phu
 */
public class Main {
    /**
     * 2. Đối tượng (Object)
     * Đối tượng là một thể hiện cụ thể của một lớp.
     * <br>
     * Khi một lớp được đính nghĩa, không có bộ nhớ nào được cấp phát cho nó đến khi các đối tượng của lớp đó được tạo ra*/

    public static void main(String[] args) {
        //Tạo 1 đối tượng của lớp TheoryOOP;
        TheoryOOP t = new TheoryOOP("Lý thuyết OOP", "OOP Basic");
        //Gọi phương thức của đối tượng;
        t.displayDetails();
        //Sử dụng getter và setter;
        t.setName("Phú học OOP");
        System.out.println("Update name TheoryOOP: " + t.getName());
    }
}
