package com.trongphu.week1.day2example.abstractclassexample;

/**
 * Created by Trong Phu on 07/08/2024 10:53:39
 *
 * @author Trong Phu
 */


abstract class Animal {
    static int a = 0;

    // Phương thức trừu tượng (không có thân phương thức)
    public abstract void makeSound();

    // Phương thức cụ thể (có thân phương thức)
    public void sleep() {
        System.out.println("Animal is sleeping");
    }
}

//Lớp Dog kế thừa từ lớp trừu tượng Animal
class Dog extends Animal {
    //Ghi đè phương thức trừu tượng
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class TheoryAbstractClass {
    /**
     * Lớp trừu tượng là một lớp không thể được khởi tạo trực tiếp.
     * Nó được sử dụng như một lớp cơ sở (base class)  để các lớp con có thể kế thừa và cài đặt các phương thức trừu tượng.
     * - Một lớp trừu tượng có thể có cả các phương thức trừu tượng (Không có thân)
     * và các phương thức cụ thể (Có thân phương thức)*/

    /**
     * Đặc điểm của lớp trừu tượng:
     * 1> Khônng thể tạo đối tượng trực tiếp: không thể tạo một đối tượng từ một lớp trừu tượng
     * 2. Chứa phương thức trừu tượng và cụ thể;
     * 3. DÙng từ khóa abstract để khai báo một lớp là trừu tượng.
     */
    public static void main(String[] args) {
        // Animal myAnimal = new Animal(); // Lỗi: không thể khởi tạo một lớp trừu tượng

        Animal myDog = new Dog(); // Tạo đối tượng từ lớp Dog

        myDog.makeSound(); // op: Dog barks
        myDog.sleep();
    }
}