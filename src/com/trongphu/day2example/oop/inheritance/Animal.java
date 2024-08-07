package com.trongphu.day2example.oop.inheritance;

/**
 * Created by Trong Phu on 07/08/2024 08:42:58
 *
 * @author Trong Phu
 */
public class Animal {
    //Thuộc tính lớp cha
    private String name;

    //Constructor lớp cha;
    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(this.name + " is eating.");
    }

    public void sleep() {
        System.out.println(this.name + " is sleeping.");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayDetail(){
        System.out.println("Animal: " + name);
    }
}
