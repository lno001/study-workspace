package com.kh.species.view;

import java.util.List;
import java.util.Scanner;

import com.kh.species.controller.SpeciesController;
import com.kh.species.model.dto.SpeciesDto;

public class SpeciesView {
	private Scanner sc = new Scanner(System.in);
	private SpeciesController speciesController = new SpeciesController();
	
	public void mainMenu() {
		while(true) {
			System.out.println(" --- 종 관리 프로그램 --- ");
			System.out.println("1. 종 추가하기");
			System.out.println("2. 종 전체조회하기");
			System.out.println("3. 종 정보변경하기");
			System.out.println("4. 종 삭제하기");
			System.out.println("5. 아이디로 검색하기");
			System.out.println("6. 이름으로 검색하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.println("-----------------------");
			System.out.print("메뉴를 선택해 주세요 > ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : save(); break;
			case "2" : findAll(); break;
			case "3" : update(); break;
			case "4" : delete(); break;
			case "5" : findById(); break;
			case "6" : findByKeyword(); break;
			case "9" : sc.close(); return;
			default : System.out.println("없는 메뉴 입니다.");
			}
		}
	}

	private void save() {
		
		System.out.println("종 추가~~");
		System.out.print("종 이름을 입력하세요 > ");
		String speciesName = sc.nextLine();
		System.out.print("종 분류를 입력하세요 > ");
		String speciesClass = sc.nextLine();
		
		int result = speciesController.save(speciesName, speciesClass);
		
		if(result > 0) {
			System.out.println("종 추가에 성공했습니다.");
		} else {
			System.out.println("종 추가에 실패했습니다.");
		}
	}
	
	private void findAll() {
		
		System.out.println("\n종 전체 조회하기");
		
		List<SpeciesDto> list = speciesController.findAll();
		
		System.out.println("\n조회된 종 수는 총 " + list.size() + "개 입니다.");
		
		if(list.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		} else {
			for(SpeciesDto sd : list) {
				System.out.println("===============================");
				System.out.println();
				System.out.println("번호 : " + sd.getSpeciesId() + ", ");
				System.out.println("종이름 : " + sd.getSpeciesName() + ", ");
				System.out.println("종분류 : " + sd.getSpeciesClass());
			}
		}
	}
	
	private void update() {
		
		System.out.println("종 수정기능 입니다.");
		System.out.print("수정하실 종의 ID값을 입력해주세요 > ");
		String speciesId = sc.nextLine();
		
		System.out.print("수정하실 종 이름을 입력하세요 > ");
		String speciesName = sc.nextLine();
		System.out.print("수정하실 종 분류를 입력하세요 > ");
		String speciesClass = sc.nextLine();
		
		int result =
		speciesController.update(new SpeciesDto(speciesId, speciesName, speciesClass));
		
		if(result > 0) {
			System.out.println("종 변경에 성공했습니다!");
		} else {
			System.out.println("종 변경에 실패했습니다...");
		}
	}
	
	private void delete() {
		System.out.println("종 삭제 서비스입니다.");
		System.out.print("삭제하실 아이디를 입력해 주세요 > ");
		String speciesId = sc.nextLine();
		
		int result =
		speciesController.delete(speciesId);
		
		if(result > 0) {
			System.out.println("종 삭제에 성공했습니다!");
		} else {
			System.out.println("종 삭제에 실패했습니다...");
		}
	}
	
	private void findById() {
		
		System.out.println("아이디로 검색하는 서비스입니다.");
		System.out.print("아이디를 입력해 주세요 > ");
		String speciesId = sc.nextLine();
		
		SpeciesDto result = speciesController.findById(speciesId);
		if (result != null) {
			System.out.println(result.getSpeciesId() + " 검색 결과!");
			System.out.println("종이름 : " + result.getSpeciesName());
			System.out.println("종분류 : " + result.getSpeciesClass());
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}
	
	private void findByKeyword() {
		System.out.println("키워드 검색 서비스 입니다.");
		System.out.print("키워드를 입력해 주세요 > ");
		String keyword = sc.nextLine();
		
		List<SpeciesDto> list =
		speciesController.findByKeyword(keyword);
		
		if(list.isEmpty()) {
			System.out.println("조회 결과 없음");
		} else {
			for(SpeciesDto sd : list) {
				System.out.println(sd);
			}
		}
	}
}
