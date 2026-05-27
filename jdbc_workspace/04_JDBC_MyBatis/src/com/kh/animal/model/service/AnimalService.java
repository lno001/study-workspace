package com.kh.animal.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.common.Template;
import com.kh.animal.model.dao.AnimalDao;
import com.kh.animal.model.dto.AnimalDto;

public class AnimalService {

	public int save(AnimalDto animal) {
		SqlSession session = Template.getSqlSession();
		
		int result = new AnimalDao().save(session, animal);
		
		if (result > 0) {
			session.commit();
		}
		session.close();
		
		return result;
	}

	public List<AnimalDto> animalFindAll() {
		SqlSession session = Template.getSqlSession();
		
		List<AnimalDto> animals = new AnimalDao().animalFindAll(session);
		
		session.close();
		
		return animals;
	}

	public AnimalDto animalFindById(String id) {
		SqlSession session = Template.getSqlSession();
		
		AnimalDto animal = new AnimalDao().animalFindById(session, id);
		
		session.close();
		
		return animal;
	}

	public List<AnimalDto> animalFindByKeyword(String keyword) {
		SqlSession session = Template.getSqlSession();
		
		List<AnimalDto> animals = new AnimalDao().animalFindByKeyword(session, keyword);
		
		session.close();
		
		return animals;
	}

	public int updateAnimal(AnimalDto animal) {
		SqlSession session = Template.getSqlSession();
		
		int result = new AnimalDao().updateAnimal(session, animal);
		
		if(result > 0) {
			session.commit();
		}
		session.close();
		
		return result;
	}

	public int deleteAnimal(String animalId) {
		SqlSession session = Template.getSqlSession();
		
		int result = new AnimalDao().deleteAnimal(session, animalId);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}

}
