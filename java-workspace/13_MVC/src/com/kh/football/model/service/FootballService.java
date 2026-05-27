package com.kh.football.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.football.model.dao.FootballPlayerDao;
import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;

public class FootballService {
	// 정석적으로 가려면 DAO클래스가 존재해야하지만 그러면 규모가 너무 커지기 떄문에 Service 단에서 저장
	private List<FootballPlayer> list = new ArrayList<FootballPlayer>();
	private int id;
	
	{ // 초기화 블럭
		list.add(new FootballPlayer(++id, "손흥민", "공격수", 7));
		list.add(new FootballPlayer(++id, "호날도", "공격수", 7));
		list.add(new FootballPlayer(++id, "메시", "미드필더", 10));
	}
	
	public List<FootballPlayer> selectAll() {
		return list;
	}

	public void addFootballPlayer(String name, String position, int backNumber) {
		list.add(new FootballPlayer(++id, name, position, backNumber));
	}

	public FootballPlayer addFootballPlayer(FootballPlayerDto fpd) {
		// 비즈니스로직 == 의사결정코드
		// 1. 이름은 두 글자 이상
		// 2. 포지션은 공격수/미드필더/수비수/골기퍼
		// 3. 등번호는 0 이상!
		
//		if(fpd != null && fpd.getName().length() >= 2) {
//			if("공격수".equals(fpd.getPosition()) || "미드필더".equals(fpd.getPosition()) ||	"수비수".equals(fpd.getPosition()) || "골기퍼".equals(fpd.getPosition())) {
//				if(fpd.getBackNumber() >= 0) {
//					// 값에 대한 유효성 검증 == validate
//					list.add(new FootballPlayer(++id, fpd.getName(), fpd.getPosition(), fpd.getBackNumber()));
//					return list.get(list.size() - 1);
//				}
//			}	
//		}
		if(validateFootballPlayer(fpd)) {
			list.add(new FootballPlayer(++id, fpd.getName(), fpd.getPosition(), fpd.getBackNumber()));
			return list.get(list.size() - 1);
		}
		
		return null;
		
	}

	public boolean idCheck(int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void updateFootballPlayer(int id, FootballPlayerDto player) {
//		int index = 0;
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getId() == id) {
//				index = i;
//				break;
//			}
//		}
		int index = indexOf(id);
		
		boolean result = validateFootballPlayer(player);
		
		if(result) {
			list.set(index, new FootballPlayer(id, player.getName(), player.getPosition(), player.getBackNumber()));
		}
	}
	
	private boolean validateFootballPlayer(FootballPlayerDto fpd) {
		if(fpd != null && fpd.getName().length() >= 2) {
			if("공격수".equals(fpd.getPosition()) || "미드필더".equals(fpd.getPosition()) ||	"수비수".equals(fpd.getPosition()) || "골기퍼".equals(fpd.getPosition())) {
				if(fpd.getBackNumber() >= 0) {
					return true;
				}
			}	
		}
		return false;
	}
	
	private int indexOf(int id) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		return index;
	}

	public String deleteFootballPlayer(int id) {
		int index = indexOf(id);
		if(index != -1) {
			return list.remove(index).getName();
		}
		return null;
	}
	
	public void outputFootballPlayer() {
		new FootballPlayerDao().outputFootballPlayer(list);; 
		
	}

	public List<FootballPlayer> findByKeyword(String keyword) {
		// 사용자가 입력한 keyword가 포함된 FootballPlayer의 name필드값을 하나하나 확인하면서
		// name 필드값에 포함되어 있다면 VO객체의 주소값을 전부다 View로 반환 해주어야 한다
		
		// boolean result = list.get(0).getName().contains(keyword);
		// System.out.println(result);
		
		List<FootballPlayer> searched = new ArrayList<FootballPlayer>();
		
		for(FootballPlayer player : list) {
			if (player.getName().contains(keyword)) {
				searched.add(player);
			}
		}
		return searched;
		
		
	}
	
}
