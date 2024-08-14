package main.java.week1.day2example.keywordstatic;

/**
 * Created by Trong Phu on 06/08/2024 13:48:15
 *
 * @author Trong Phu
 * <br>
 * - Ở ví dụ này minh họa việc sử dụng biến tĩnh(static variable) để thực hiện đếm
 * số lượng các đối tượng được khởi tạo
 * <br>
 *
 */
public class StaticVariable {
    /**
     * - Biến tĩnh (static variable) trong java là biến thuộc về lớp, không thuộc về
     * các đối tượng cụ thể của lớp.
     *<br>
     * - Điều này có nghĩa là tất cả các đối tượng của lớp
     * chia sẻ cùng một biến tĩnh.
     * <br>
     * - Biến tĩnh thường được sử dụng để lưu trữ dữ liệu chung cho
     * tất các các đối tượng hoặc để theo dõi số lượng đối tượng đã được tạo;
     */
    public static int objCount = 0;

    /**
     * Biến không tĩnh (instance variable)
     */
    public String name;

    /**
     * Constructor
     */
    public StaticVariable(String name) {
        this.name = name;
        //Tăng biến static mỗi khi một đối tượng mới được khởi tạo từ lớp;
        objCount++;
    }

    /**
     * Phương thức tĩnh để hiển thị số lượng đối tượng
     * */
    public static void displayObjectCount(){
        System.out.println("Số đối tượng đã được khởi tạo: " + objCount);
    }

    public static void main(String[] args) {
        //Tạo đối tượng đầu tiên;
        StaticVariable obj1 = new StaticVariable("Object 1");
        //Tạo đối tượng thứ hai;
        StaticVariable obj2 = new StaticVariable("Object 2");
        //Tạo đối tượng thứ ba;
        StaticVariable obj3 = new StaticVariable("Object 3");
        //Gọi phương thức tĩnh của lớp để hiển thị số lượng đối tượng được khởi tạo;
        StaticVariable.displayObjectCount();
    }
}
