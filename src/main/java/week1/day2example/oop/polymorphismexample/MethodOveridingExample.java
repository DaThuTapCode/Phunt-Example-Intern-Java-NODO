package week1.day2example.oop.polymorphismexample;


/**
 * Created by Trong Phu on 06/08/2024 23:25:00
 *
 * @author Trong Phu
 */

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

public class MethodOveridingExample {
    public static void main(String[] args) {
        Animal myAnimal = new Animal(); // Animal object
        Animal myDog = new Dog();       // Dog object
        Animal myCat = new Cat();       // Cat object

        myAnimal.makeSound(); // Animal makes a sound
        myDog.makeSound();    // Dog barks
        myCat.makeSound();    // Cat meows
    }
}
