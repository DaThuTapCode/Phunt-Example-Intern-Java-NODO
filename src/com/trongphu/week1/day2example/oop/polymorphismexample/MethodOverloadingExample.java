package com.trongphu.week1.day2example.oop.polymorphismexample;

/**
 * Created by Trong Phu on 07/08/2024 10:13:43
 *
 * @author Trong Phu
 */
public class MethodOverloadingExample {
    //Overloading
    // Phương thức cộng hai số nguyên
    public int add(int a, int b) {
        return a + b;
    }

    // Phương thức cộng ba số nguyên
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Phương thức cộng hai số thực
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        MethodOverloadingExample math = new MethodOverloadingExample();

        System.out.println("Sum of two integers: " + math.add(5, 3)); // 8
        System.out.println("Sum of three integers: " + math.add(5, 3, 2)); // 10
        System.out.println("Sum of two doubles: " + math.add(5.5, 3.3)); // 8.8
    }
}
