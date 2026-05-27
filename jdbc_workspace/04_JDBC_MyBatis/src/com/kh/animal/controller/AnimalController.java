package com.kh.animal.controller;

import java.util.List;

import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.service.AnimalService;

public class AnimalController {

	public int save(AnimalDto animal) {
		return new AnimalService().save(animal);
	}

	public List<AnimalDto> animalFindAll() {
		return new AnimalService().animalFindAll();
	}

	public AnimalDto animalFindById(String id) {
		return new AnimalService().animalFindById(id);
	}

	public List<AnimalDto> animalFindByKeyword(String keyword) {
		return new AnimalService().animalFindByKeyword(keyword);
	}

	public int updateAnimal(AnimalDto animal) {
		return new AnimalService().updateAnimal(animal);
	}

	public int deleteAnimal(String animalId) {
		return new AnimalService().deleteAnimal(animalId);
	}

}
