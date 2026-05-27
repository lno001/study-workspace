package com.grokproject.zoo;

import com.grokproject.zoo.model.Bird;
import com.grokproject.zoo.model.Cat;
import com.grokproject.zoo.model.Dog;
import com.grokproject.zoo.service.Zoo;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        zoo.addAnimal(new Dog("바둑이"));
        zoo.addAnimal(new Cat("나비"));
        zoo.addAnimal(new Bird("짹짹이"));

        zoo.showAllSounds();
    }
}