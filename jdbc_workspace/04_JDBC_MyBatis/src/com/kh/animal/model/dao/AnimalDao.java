package com.kh.animal.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.model.dto.AnimalDto;

public class AnimalDao {

	public int save(SqlSession session, AnimalDto animal) {
		// sqlSession타입이 제공하는 메소드를 호출해서
		// SQL문을 찾아서 실행하고 결과도 받아올 수 있음
		// SqlSession.SQL문 메소드("namespave속성값.SQL요소id속성값");
		return session.insert("animalMapper.save", animal);
	}

	public List<AnimalDto> animalFindAll(SqlSession session) {
		return session.selectList("animalMapper.animalFindAll");
	}

	public AnimalDto animalFindById(SqlSession session, String id) {
		return session.selectOne("animalMapper.animalFindById", id);
	}

	public List<AnimalDto> animalFindByKeyword(SqlSession session, String keyword) {
		return session.selectList("animalMapper.animalFindByKeyword", keyword);
	}

	public int updateAnimal(SqlSession session, AnimalDto animal) {
		return session.update("animalMapper.updateAnimal", animal);
	}

	public int deleteAnimal(SqlSession session, String animalId) {
		return session.delete("animalMapper.deleteAnimal", animalId);
	}
	
	

}
