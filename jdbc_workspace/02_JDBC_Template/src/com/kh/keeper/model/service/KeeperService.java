package com.kh.keeper.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.JdbcTemplate;
import com.kh.keeper.model.dao.KeeperDao;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

public class KeeperService {
	/* Service : Connertion을 생성해서 DAO로 전달
	 * 만약 SQL문을 수행하는데 필요한 값이 있다면 Controller로부터 전달받아서 Connection과 같이 넘겨줄 것
	 * DAO에서 DB작업이 끝나면 Service단에서 결과에 따른 트랜잭션 처리도 진행
	 * => DAO에는 순수하게 SQL문을 처리하는 부분만 남겨놓을 것
	 */

	public int insertKeeper(KeeperDto kd) {
		
		Connection conn = JdbcTemplate.getConnerction();
		
		int result = new KeeperDao().insertKeeper(conn, kd);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		
		JdbcTemplate.close(conn);
		
		return result;
	}

	public List<Keeper> selectKeeperList() {
		
		Connection conn = JdbcTemplate.getConnerction();
		
		List<Keeper> keepers = new KeeperDao().selectKeeperList(conn);
		
		JdbcTemplate.close(conn);
		
		return keepers;
	}

	public int updateKeeper(Map<String, String> keeper) {
		
		Connection conn = JdbcTemplate.getConnerction();
		
		int result = new KeeperDao().updateKeeper(conn, keeper);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		JdbcTemplate.close(conn);
		return result;
		
	}

	public int deleteKeeper(String keeperId) {
		
		Connection conn = JdbcTemplate.getConnerction();
		
		int result = new KeeperDao().deleteKeeper(conn, keeperId);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		JdbcTemplate.close(conn);
		
		return result;
	}

}
