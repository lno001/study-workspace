package com.kh.animal.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	// SqlSession객체를 만드는 메소드 구현
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		// mybaris-config.xml파일에 작성한 environment요소의 내용을 읽어와서 해당 DB와 연결된 Sqlsession 객체 생성
		String config = "mybatis-config.xml";
		try {
			InputStream stream = Resources.getResourceAsStream(config);
			// 1단계 : SqlSessionFactoryBiulder 만들기 : SqlSessionFactoryBuilder() 호출
			// 2단계 : SqlSessionFactory 만들기 : 참조해서 .build(접속 내용을 담은 파일을 읽어온 입력스트림) 호출
			// 3단계 : SqlSession 만들기 : 참조해서 .openSession() 호출
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
	
	
	
	
}
