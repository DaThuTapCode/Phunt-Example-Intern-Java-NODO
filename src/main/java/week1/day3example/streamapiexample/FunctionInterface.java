package week1.day3example.streamapiexample;

/**
 * Created by Trong Phu on 11/08/2024 17:43:24
 *
 * @author Trong Phu
 */

/**
 * Functional Interface là một interface với chỉ một phương thức trừu tượng. Java 8 cung cấp nhiều Functional Interfaces như Predicate, Function, Supplier, Consumer,
 * giúp hỗ trợ lập trình hàm (functional programming).
 * Có thể sử dụng lambda expressions hoặc method references để cài đặt Functional Interfaces.
 *
 * */


@FunctionalInterface
interface MyFunctionalInterface {
    void printMessage(String message);
}
public class FunctionInterface {
        public static void main(String[] args) {
            MyFunctionalInterface msg = message -> System.out.println(message);
            msg.printMessage("Hello, Java 8!");
        }

}
