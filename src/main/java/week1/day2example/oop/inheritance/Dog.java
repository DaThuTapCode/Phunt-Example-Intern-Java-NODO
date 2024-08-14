package week1.day2example.oop.inheritance;

import java.time.LocalDate;

/**
 * Created by Trong Phu on 07/08/2024 08:50:50
 *
 * @author Trong Phu
 */
public class Dog extends Pet{

    public int age;

    public Dog(String name, LocalDate dayOfBirth, int age) {
        super(name, dayOfBirth);
        this.age = age;
    }

    public void displayDetail(){
        System.out.println("Dog Name: " + getName());
        System.out.println("Dog age: " + getAge());
        System.out.println("Dog birth day: " + getDayOfBirth());
    }

    public void bark(){
        super.sleep();
        System.out.println(getName()  + " is barking.");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
