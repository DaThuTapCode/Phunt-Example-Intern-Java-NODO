package week1.day3example.streamapiexample;

/**
 * Created by Trong Phu on 7/08/2024 15:47:55
 *
 * @author Trong Phu
 */
public class DefaultMethodInInterfaceExample {
    /**
     * Default methods cho phép thêm các phương thức mặc định vào interface mà không làm ảnh hưởng đến các lớp cài đặt nó. Điều này giúp mở rộng các interface mà không phá vỡ tính tương thích ngược.*/
    public static void main(String[] args) {
        Car car = new Car();
        car.print(); // Output: This is a vehicle
    }

}
interface Vehicle {
    default void print() {
        System.out.println("This is a vehicle");
    }
}

class Car implements Vehicle {

}
