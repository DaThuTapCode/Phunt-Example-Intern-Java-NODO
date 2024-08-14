package main.java.week1.day2example.keywordfinal;

/**
 * Created by Trong Phu on 06/08/2024 18:04:26
 *
 * @author Trong Phu
 */
public class FinalVariableExample {
    //Khai báo biến final;
    //Biến final có giá trị không thay đổi sau khi khởi tạo
    public static final int MAX_COUNT = 100;

    public static void main(String[] args) {
        //In ra giá trị của biến final
        System.out.println("Giá trị của MAX_COUNT: " + MAX_COUNT);

        //Không thể gán lại giá trị mới cho biến final;
        //MAX_COUNT = 200;
    }
}
