package com.kh.species.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.species.model.dto.SpeciesDto;

public class SpeciesDao {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int save(SpeciesDto sd) {
		
		// 0) 필요한 변수 선언 및 null 값으로 초기화
		Connection conn = null; // DB서버와의 연결정보를 담는 객체
		Statement stmt = null; // SQL문 실행 후 결과를 받는 객체
		int result = 0; // DML 수행 후 결과를 받기 위한 변수
		
		// SQL문(정적인 형태)
		/*
		 * INSERT 
		 *   INTO
		 * 		  SPECIES
		 * VALUES
		 * 		  (
		 * 		  'S' || SEQ_SPECIES.NEXTVAL
		 * 		, '사용자가 입력한값'
		 * 		, '사용자가 입력한값'
		 * 		  )
		 */
		String sql = "INSERT "
					 + "INTO "
					 	  + "SPECIES "
				   + "VALUES "
					 	  + "("
					 	  + "'S' || SEQ_SPECIES.NEXTVAL"
					 	+ ", '" + sd.getSpeciesName()  + "'"
					 	+ ", '" + sd.getSpeciesClass() + "'"
					 	  + ")";
		
		// System.out.println(sql);
		// SQL에 문법적인 문제가 존재한다
		// SQLSyntaxErrorException이 발생함
		
		// 1) JDBC Driver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 1. 패키지 경로 / 클래스식별자에서 오타가 날 경우
			// 2. 프로젝트에 라이브러리를 추가하지않아서 진짜로 클래스가 없는경우
			// -> ClassNotFoundException이 발생
			
			// 2) Connection 객체생성(URL, USERNAME, PASSWORD)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE"
										,"C##IL","il");
			// URL 경로 틀림, 서버 안열림, 계정명 틀림, 비번 틀림, 접속 권한 없음, 비번 갱신 오류
			// AutoCommit 끄기
			conn.setAutoCommit(false);
			
			conn.createStatement();
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			// INSERT 시 값에 문제가 있을 수 있음
			// 자료형 틀림, 제약조건 위배, 데이터 크기가 컬럼보다 큼 오류
			
			if(result > 0) {
				conn.commit();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<SpeciesDto> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<SpeciesDto> list = new ArrayList<SpeciesDto>();
		
		String sql = """
						SELECT
								SPECIES_ID
							 ,  SPECIES_NAME
							 ,  SPECIES_CLASS
						  FROM
						  		SPECIES
						 ORDER
						    BY
						    	SPECIES_ID DESC
					 """;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","C##IL","il");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			// 현재 조회 결과는 ResultSet에 담겨있음
			// => 한 행씩 접근해서 데이터를 뽑아서 => VO/DTO객체의 필드에 담기
			// rset.next()
			while(rset.next()) {
				SpeciesDto sd = new SpeciesDto();
				System.out.println(rset.getString("SPECIES_NAME"));
//				String speciesClass = rset.getString("SPECIES_CLASS");
//				System.out.println("클래스명 : " + speciesClass);
				sd.setSpeciesId(rset.getString("SPECIES_ID"));
				sd.setSpeciesName(rset.getString("SPECIES_NAME"));
				sd.setSpeciesClass(rset.getString("SPECIES_CLASS"));
				// System.out.println(sd);
				// ResultSet 객체로부터 어떤 컬럼의 값을 뽑을건지 메소드를 호출하면서 컬럼명을 명시
				list.add(sd);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int update(SpeciesDto sd) {
		
		int result = 0;
		String sql = "UPDATE "
						  + "SPECIES"
				   + "   SET "
						  + "SPECIES_NAME = '" + sd.getSpeciesName() + "'"
						+ ", SPECIES_CLASS = '" + sd.getSpeciesClass() + "'"
				   + " WHERE "
						  + "SPECIES_ID = '" + sd.getSpeciesId() + "'";
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##IL", "il");
			Statement stmt = conn.createStatement()){
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delete(String si) {
		int result = 0;
		String sql = "DELETE " + 
					   "FROM " +
						  	  "SPECIES " +
					  "WHERE " +
						 	  "SPECIES_ID = '" + si + "'";
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##IL", "il");
			Statement stmt = conn.createStatement();){
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public SpeciesDto findById(String speciesId) {
		SpeciesDto sd = null;
		String sql = """
						SELECT
								SPECIES_ID
							 ,  SPECIES_NAME
							 ,  SPECIES_CLASS
						  FROM  
						  		SPECIES
						 WHERE
						 		SPECIES_ID =
				""";
		sql += "'" + speciesId + "'";
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "c##IL", "il");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql)){
			if(rset.next()) {
				sd = new SpeciesDto(rset.getString("SPECIES_ID"),
									rset.getString("SPECIES_NAME"),
									rset.getString("SPECIES_CLASS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sd;
	}

	public List<SpeciesDto> findByKeyword(String keyword) {
		List<SpeciesDto> list = new ArrayList<SpeciesDto>();
		
		String sql = """
						SELECT
								SPECIES_ID
							 ,  SPECIES_NAME
							 ,  SPECIES_CLASS
						  FROM
						  		SPECIES
						 WHERE
						 		SPECIES_NAME LIKE 
				""";
		sql +="'%" +  keyword + "%' ORDER BY SPECIES_ID DESC";
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "c##IL", "il");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql)){
			
			while(rset.next()) {

					list.add(new SpeciesDto(
								rset.getString("SPECIES_ID"),
								rset.getString("SPECIES_NAME"),
								rset.getString("SPECIES_CLASS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
