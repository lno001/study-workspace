package com.kh.animal.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.animal.controller.AnimalController;
import com.kh.animal.controller.KeeperController;
import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.dto.KeeperDto;

public class AnimalView {
	private Scanner sc = new Scanner(System.in);
	private AnimalController ac = new AnimalController();
	
	public void meinMenu() {
		while(true) {
			System.out.println("============================");
			System.out.println("동물 관리 시스템에 오신것을 환영합니다.");
			System.out.println("----------------------------");
			System.out.println("1. 동물 추가하기");
			System.out.println("2. 동물 전체 조회하기");
			System.out.println("3. 동물 아이디로 조회하기");
			System.out.println("4. 동물 이름으로 조회하기");
			System.out.println("5. 사육사 및 당담동물 조회하기");
			System.out.println("6. 사육사 검색하기");
			System.out.println("7. 동물 정보 수정하기");
			System.out.println("8. 동물 정보 삭제하기");
			System.out.println("0. 프로그램 종료");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : insertAnimal(); break;
			case "2" : animalFindAll(); break;
			case "3" : animalFindById(); break;
			case "4" : animalFindByKeyword(); break;
			case "5" : selectKeeperAndAnimals(); break;
			case "6" : selectKeeperByCondition(); break;
			case "7" : updateAnimal(); break;
			case "8" : deleteAnimal(); break;
			case "0" : System.out.println("----------------------------");
					   System.out.println("프로그램 종료합니다.");
					   sc.close(); return;
			default  : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
			
			
		}
	}

	private void insertAnimal() {
		System.out.println("============================");
		System.out.println("동물 추가 시스템입니다.");
		System.out.println("----------------------------");

		System.out.print("동물의 이름을 입력하세요. > ");
		String animalName = sc.nextLine();
		
		System.out.print("동물의 종 번호를 입력하세요. > (S01~S13)");
		String speciesId = sc.nextLine();
		
		System.out.print("동물의 구역 번호를 입력하세요. > (Z0~Z5)");
		String zoneId = sc.nextLine();
		
		System.out.print("동물 당담 사육사 이름을 입력하세요. > (K01~K06)");
		String keeperId = sc.nextLine();
		
		System.out.print("동물의 성별을 입력하세요. > (F 또는 M)");
		String gender = sc.nextLine();

		System.out.print("동물의 무게를 입력하세요. > (숫자만)");
		double weightKg = sc.nextDouble();
		
		int result = ac.save(new AnimalDto(animalName, speciesId, zoneId, keeperId, gender, weightKg));
		System.out.println("----------------------------");
		
		if (result > 0) {
			System.out.println(animalName + " 추가 성공!");
		} else {
			System.out.println(animalName + " 추가 실패...");
		}
	}
	
	private void animalFindAll() {
		System.out.println("============================");
		System.out.println("동물 전체 조회 시스템입니다.");
		System.out.println("----------------------------");

		List<AnimalDto> animals = ac.animalFindAll();
	
		if(animals.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		} else {
//			for(AnimalDto animal : animals) {
//				System.out.println("동물번호 : " + animal.getAnimalId() + " | 동물이름 : " + animal.getAnimalName() + " | 종 이름 : " + animal.getSpeciesId() 
//								   + " | 구역 이름 : " + animal.getZoneId() + " | 사육사 이름 : " + animal.getKeeperId() + " | 성별 : " + animal.getGender()
//								   + " | 몸무게 : " + animal.getWeightKg() + "Kg");
//			}
			animals.forEach(animal -> System.out.println(
			        "동물번호 : " + animal.getAnimalId() +
			        " | 동물이름 : " + animal.getAnimalName() +
			        " | 종 이름 : " + animal.getSpeciesId() +
			        " | 구역 이름 : " + animal.getZoneId() +
			        " | 사육사 이름 : " + animal.getKeeperId() +
			        " | 성별 : " + animal.getGender() +
			        " | 몸무게 : " + animal.getWeightKg() + "Kg"
			    )
			);
		}
	}
	
	private void animalFindById() {
		System.out.println("============================");
		System.out.println("동물 아이디 조회 시스템입니다.");
		System.out.println("----------------------------");
		
		System.out.print("검색하실 동물의 ID를 입력해주세요 > ");
		String id = sc.nextLine();
		
		AnimalDto animal = ac.animalFindById(id);

		System.out.println("----------------------------");
		if(animal == null) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		} else {
			System.out.println("동물번호 : " + animal.getAnimalId() + 
							   " | 동물이름 : " + animal.getAnimalName() + 
							   " | 종 이름 : " + animal.getSpeciesId() + 
							   " | 구역 이름 : " + animal.getZoneId() + 
							   " | 사육사 이름 : " + animal.getKeeperId() + 
							   " | 성별 : " + animal.getGender() + 
							   " | 몸무게 : " + animal.getWeightKg() + "Kg");
		}
	}
	
	private void animalFindByKeyword() {
		System.out.println("============================");
		System.out.println("동물 이름 조회 시스템입니다.");
		System.out.println("----------------------------");
		
		System.out.print("검색하실 동물의 이름을 입력해주세요 > ");
		String keyword = sc.nextLine();
		
		List<AnimalDto> animals = ac.animalFindByKeyword(keyword);
		
		System.out.println("----------------------------");
		if(animals.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		} else {
			animals.forEach(animal -> System.out.println(animal));
		}
	}
	
	private void selectKeeperAndAnimals() {
		// 사육사 전체조회 + 각 사육사들이 담당하는 애니멀 전체조회
		System.out.println("============================");
		System.out.println("사육사 및 당담동물 조회 시스템입니다.");
		System.out.println("----------------------------");
		
		List<KeeperDto> keepers = new KeeperController().selectKeeperAndAnimals();
		
		for(KeeperDto keeper : keepers) {
			System.out.println(keeper.getKeeperName() + "의 당담 동물들");
			System.out.println(keeper.getAnimals());
		}
//		keepers.forEach(keeper -> System.out.println(keeper.getKeeperName() + "의 당담 동물들\n"));
	}
	
	private void selectKeeperByCondition() {
		System.out.println("============================");
		System.out.println("사육사 검색 시스템입니다.");
		System.out.println("----------------------------");
		
		System.out.println("검색 조건을 선택해주세요.");
		System.out.print("1. 사육사 번호 | 2. 사육사 이름 | 3. 담당 구역 > ");
		String menuNo = sc.nextLine();
		System.out.println("검색하실 키워드를 입력해주세요 > ");
		String keyword = sc.nextLine();
		// 똑같은거만 찾기 Vs 포함되면 다 찾기
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("menuNo", menuNo);
		arguments.put("keyword", keyword);
		
		List<KeeperDto> keepers = new KeeperController().selectKeeperByCondition(arguments);
		
		if(keepers.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다");
		} else {
			keepers.forEach(keeper -> System.out.println("사육사 : " + keeper.getKeeperName()));
		}
	}
	
	private void updateAnimal() {
		System.out.println("============================");
		System.out.println("동물 정보 수정 시스템입니다.");
		System.out.println("----------------------------");
		
		System.out.print("정보를 수정할 동물 번호를 입력해주세요 > ");
		String animalId = sc.nextLine();
		System.out.print("변경할 구역 번호를 입력해주세요 > ");
		String zoneId = sc.nextLine();
		System.out.print("변경할 사육사 번호를 입력해주세요 > ");
		String keeperId = sc.nextLine();
		System.out.print("변경할 동물의 몸무게를 입력해주세요 > ");
		double weightKg = sc.nextDouble();
		sc.nextLine();
		
		AnimalDto animal = new AnimalDto();
		animal.setAnimalId(animalId);
		animal.setZoneId(zoneId);
		animal.setKeeperId(keeperId);
		animal.setWeightKg(weightKg);
		
		int result = ac.updateAnimal(animal);
		
		if(result > 0) {
			System.out.println("정보 수정에 성공!");
		} else {
			System.out.println("정보 수정에 실패...");
		}
	}
	
	private void deleteAnimal() {
		System.out.println("============================");
		System.out.println("동물 정보 삭제 시스템입니다.");
		System.out.println("----------------------------");
		
		System.out.print("정보를 삭제할 동물 번호를 입력해주세요 > ");
		String animalId = sc.nextLine();
		
		int result = ac.deleteAnimal(animalId);
		
		if(result > 0) {
			System.out.println("정보 삭제 성공!");
		} else {
			System.out.println("정보 삭제 실패...");
		}
	}
}
