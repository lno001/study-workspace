package com.kh.keeper.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.keeper.controller.KeeperController;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

public class KeeperView {
	private Scanner sc = new Scanner(System.in);
	private KeeperController kc = new KeeperController();
	
	public void mainMenu() {
	
		while(true) {
			System.out.println("=========================");
			System.out.println("사육사 관리 프로그램입니다.");
			System.out.println("-------------------------");
			System.out.println("1. 사육사 추가하기");
			System.out.println("2. 사육사 전체 조회하기");
			System.out.println("3. 사육사 정보 수정하기");
			System.out.println("4. 사육사 정보 삭제하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.print("원하시는 메뉴를 선택해주세요 > ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : insertKeeper(); break;
			case "2" : selectKeeperList(); break;
			case "3" : updateKeeper(); break;
			case "4" : deleteKeeper(); break;
			case "0" : sc.close(); 
					   System.out.println("-------------------------");
					   System.out.println("프로그램 종료합니다.");
					   return;
			default :  System.out.println("-------------------------");
					   System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}

	private void insertKeeper() {
		System.out.println("=========================");
		System.out.println("사육사 추가 서비스입니다.");
		System.out.print("추가하실 사육사의 이름을 입력하세요 > ");
		String name = sc.nextLine();
		System.out.print("사육사의 담당 구역을 입력하세요 > ");
		String zone = sc.nextLine();
		System.out.println("-------------------------");
		
		int result = kc.insertKeeper(new KeeperDto(name, zone));
		
		if(result > 0) {
			System.out.println("사육사 추가에 성공했습니다!");
		} else {
			System.out.println("사육사 추가에 실패했습니다...");
		}
	}
	
	private void selectKeeperList() {
		System.out.println("=========================");
		System.out.println("사육사 전체 조회 서비스입니다.");
		
		List<Keeper> keepers = kc.selectKeeperList();
		System.out.println("-------------------------");
		if(keepers.isEmpty()) {
			System.out.println("고용된 사육사가 없습니다.");
		} else {
			keepers.stream()
				   .map(k -> "사육사 아이디 : " + k.keeperId() + ", 이름 : " + k.keeperName() + 
		    				 ", 입사일 : " + k.hireDate() + ", 담당구역 : " + k.zoneId())
				   .forEach(System.out::println);
		}
	}
	
	private void updateKeeper() {
		System.out.println("=========================");
		System.out.println("사육사 정보 수정 서비스입니다.");
		System.out.println("-------------------------");
		System.out.print("정보를 수정할 사육사의 아이디를 입력해주세요 > ");
		String keeperId = sc.nextLine();
		System.out.print("새로운 이름을 입력해주세요 > ");
		String keeperName = sc.nextLine();
		System.out.print("새로운 담당구역을 입력해주세요 > ");
		String zoneId = sc.nextLine();
		System.out.print("새로운 입사일을 입력해주세요 (yyyy-MM-dd) > ");
		String hireDate = sc.nextLine();
		
		Map<String, String> keeper = new HashMap<String, String>();
		keeper.put("keeperId", keeperId);
		keeper.put("keeperName", keeperName);
		keeper.put("zoneId", zoneId);
		keeper.put("hireDate", hireDate);
		int result = kc.updateKeeper(keeper);
//		kc.updateKeeper(new KeeperDto(keeperId, keeperName, Date.valueOf(hireDate), zoneId));
		
		if(result > 0) {
			System.out.println("정보 수정에 성공했습니다!");
		} else {
			System.out.println("정보 수정에 실패했습니다...");
		}
	}
	
	private void deleteKeeper() {
		System.out.println("=========================");
		System.out.println("사육사 정보 삭제 서비스입니다.");
		System.out.println("-------------------------");
		System.out.print("정보를 삭제할 사육사의 아이디를 입력해주세요 > ");
		String keeperId = sc.nextLine();

		int result = kc.deleteKeeper(keeperId);
		
		if(result > 0) {
			System.out.println("정보 삭제에 성공했습니다!");
		} else {
			System.out.println("정보 삭제에 실패했습니다...");
		}
		
		
		
		
		
		
		
	}
}
