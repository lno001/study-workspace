package com.grokproject.zoo.service;

import com.grokproject.zoo.model.Animal;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getClass().getSimpleName() + "이(가) 동물원에 추가되었습니다.");
    }

    public void showAllSounds() {
        System.out.println("=== 동물원 소리 시간 ===");
        for (Animal animal : animals) {
            animal.makeSound();        // 다형성 핵심!
        }
    }
}