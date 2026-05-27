package com.grokproject.zoo.model;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " : 짹짹!");
    }
}