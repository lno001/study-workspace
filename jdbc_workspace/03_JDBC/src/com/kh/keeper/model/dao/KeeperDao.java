package com.kh.keeper.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.JdbcTemplate;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

public class KeeperDao {
	/* DAO (Data Access Object)
	 * 
	 * Database관련된 작업을 전문적으로 담당하는 객체
	 * 하나의 메소드는 하나의 SQL문만 실행
	 * DB에 직접 접근해서 SQL문을 실행 후 결과 받아오기(JDBC)
	 * 
	 * JDBC용 객체
	 * - Connection : DB와 연결정보를 담는 객체
	 * - Statement : SQL문 실행 응답을 받아오는 객체
	 * - ResultSet : SELECT응답 결과가 담겨있는 객체
	 * 
	 * - PrepatedDtatement : SQL문을 미리 준비하는 개념
	 * 						 미완성된 SQL문을 미리 전달하고 실행하기 전 값을 Bind해서 실행함
	 * 						 미완성된 SQL문에 사용자가 입력한 값이 들어갈 수 있도록 공간확보를 해놓음
	 * 						 ==> ?(placeholder)
	 * 
	 * - Statement와 PreparedStatement는 부모자식 관계
	 * 
	 * - 차이점
	 * 
	 * 1) Statement는 완성된 SQL문, PreparedStatement는 미완성 SQL문
	 * 
	 * 2) 객체 생성
	 * Statement == 커넥션객체.createStatment();
	 * PreparedStatement == 커넥션객체.prepareStatement(sql);
	 * 
	 * 3) SQL문 실행
	 * Statement == stmt.executeXXX(sql);
	 * PreparedStatement == pstmt.executeXXX();
	 * 
	 * ? == placeholder에 실제값을 Binding 해준 뒤 실행한다.
	 * pstmt.setString()
	 * pstmt.setInt()
	 */
	
	static {
		JdbcTemplate.registDriver();
	}
	
	public int insertKeeper(Connection conn, KeeperDto kd) {
		
		// Connection conn = null;
		// Statement stmt = null;
		int result = 0;
		String sql = """
						INSERT
						  INTO
						  		KEEPER
						VALUES
								(
								'K' || SEQ_KEEPER.NEXTVAL
							 ,  ?
							 ,  SYSDATE
							 ,  ?
								)
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, kd.getKeeperName());
			pstmt.setString(2, kd.getZoneId());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Keeper> selectKeeperList(Connection conn) {
		List<Keeper> keepers = new ArrayList<Keeper>();
		String sql = """
						SELECT
								KEEPER_ID
							 ,  KEEPER_NAME
							 ,  HIRE_DATE
							 , 	ZONE_ID
						  FROM
						  		KEEPER
						 ORDER
						    BY
						    	KEEPER_ID DESC
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery()){
			while(rset.next()) {
				Keeper keeper = new Keeper(rset.getString("KEEPER_ID"),rset.getString("KEEPER_NAME"),
										   rset.getDate("HIRE_DATE"), rset.getString("ZONE_ID"));
				keepers.add(keeper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return keepers;
	}

	public int updateKeeper(Connection conn, Map<String, String> keeper) {
		int result = 0;
		String sql = """
						UPDATE
								KEEPER
						   SET
						   		KEEPER_NAME = ?
						   	 ,  HIRE_DATE = ?
						   	 ,  ZONE_ID = ?
						 WHERE
						 		KEEPER_ID = ?
					 """;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, keeper.get("keeperName"));
			pstmt.setString(2, keeper.get("hireDate"));
			pstmt.setString(3, keeper.get("zoneId"));
			pstmt.setString(4, keeper.get("keeperId"));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteKeeper(Connection conn, String keeperId) {
		int result = 0;
		
		String sql = """
						DELETE
						  FROM
						  		KEEPER
						 WHERE
						 		KEEPER_ID = ?
					 """;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, keeperId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
