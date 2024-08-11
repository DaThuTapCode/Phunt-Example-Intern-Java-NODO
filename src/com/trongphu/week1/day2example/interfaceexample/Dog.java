package com.trongphu.week1.day2example.interfaceexample;

/**
 * Created by Trong Phu on 06/08/2024 22:57:05
 *
 * @author Trong Phu
 */
public class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }

}
