package week1.day2example.interfaceexample;

/**
 * Created by Trong Phu on 06/08/2024 22:46:57
 *
 * @author Trong Phu
 */
//Khai báo 1 interface
public interface Animal {
    /**
     * Interface trong java là tập hợp các phương thức trừu tượng (abstract method)
     * và các hằng số (constants).
     * Nó cung cấp một cách để đạt được sự trừu tượng hóa hoàn toàn và đa kế thừa trong java.
     * Các lớp có thể triển khai (implement) interface đó.
     * <br>
     * - Đặc điểm của interface:
     * <br>
     *     1. Phương thức trừu tượng: Các phương thức trong interface không có thân (body) và phải được triển
     *     khai bởi các lớp thực hiện (implement) interface đó;
     *     <br>
     *     2. Hằng số: Các biến trong interface mặc định là public, static, và final.
     *     <br>
     *     3. Đa kế thừa: Một lớp có thể triển khai nhiều interface, cho phếp đa kế thừa trong java
     * */
 int a = 0;
    //Phương thức trừu tượng;
    void eat();
    void sleep();

    // Phương thức mặc định
    //Từ java 8 interface có phương thức mặc định với thân body được định nghĩa sẵn;
    default void breathe() {
        System.out.println("Animal is breathing.");
    }
}
