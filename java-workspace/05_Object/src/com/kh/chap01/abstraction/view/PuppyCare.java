package com.kh.chap01.abstraction.view;

import java.util.Scanner;

import com.kh.chap01.abstraction.model.vo.Puppy;

public class PuppyCare {
	// 사용자에게 강아지의 정보를 입력받아서
	// 입력받은 강아지의 정보를 출력해주고
	// 강아지와 함께 놀아줄 수 있는 프로그램
	
	public void run() {
		System.out.println("🐕‍🦺🐕‍🦮강아지 다마고치🦮🐕🐕‍🦺‍‍");
		Scanner sc = new Scanner(System.in);
		
		Puppy puppy = new Puppy();
		
		System.out.print("키울 강아지의 이름을 지어주세요. > ");
		puppy.name = sc.nextLine();
		System.out.println("강아지 이름은 " + puppy.name + "이(가) 되었습니다.");
		System.out.print("키울 강아지의 품종을 정해주세요. > ");
		puppy.species = sc.nextLine();
		System.out.println("강아지 품종은 " + puppy.species + "이(가) 되었습니다.");
		System.out.print("키울 강아지의 성별을 정해주세요. > ");
		puppy.gender = sc.nextLine();
		System.out.println("강아지 성별은 " + puppy.gender + "이(가) 되었습니다.");
		System.out.print("키울 강아지의 나이를 정해주세요. > ");
		puppy.age = sc.nextInt();
		sc.nextLine();
		System.out.println("강아지 나이는 " + puppy.age + "이(가) 되었습니다.");
		System.out.print("키울 강아지의 몸무게를 정해주세요. > ");
		puppy.weight = sc.nextInt();
		sc.nextLine();
		System.out.println("강아지 무게는 " + puppy.weight + "이(가) 되었습니다.");
		
		while(true) {
			System.out.println("💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕");
			System.out.println(puppy.name + "의 정보!");
			System.out.println("나이 : " + puppy.age + "살");
			System.out.println("성별 : " + puppy.gender);
			System.out.println("종 : " + puppy.species);
			System.out.println("몸무게 : " + puppy.weight + "kg");
			System.out.println("💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕💕");
			System.out.println();
			
			System.out.println("메뉴를 선택해주세요 !");
			if(puppy.weight > 10) {
				System.out.println("※ 운동을 위해 앉기를 추천드립니다~ ※");
			}
			System.out.print("1번. 짖기 / 2. 앉기 / 3. 프로그램 종료 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			switch(menuNo) {
			case 1 : puppy.bark(); break;
			case 2 : puppy.sit(); break;
			case 3 : return;
			default : System.out.println("메뉴를 다시 선택해주세요!");
			}
			
			
			
			sc.close();
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	

}
