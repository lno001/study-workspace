package com.grokproject.zoo.model;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);                  // private 필드에 값 전달
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " : 멍멍!");
    }
}