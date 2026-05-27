package com.grokproject.zoo.model;

public abstract class Animal {
    private String name;          // private으로 완전 캡슐화!

    public Animal(String name) {
        this.name = name;
    }

    // 자식 클래스에서만 이름을 읽을 수 있게 protected getter 제공
    protected String getName() {
        return name;
    }

    public abstract void makeSound();   // 자식이 반드시 구현해야 함
}
