package com.kh.chap01.run;

import com.kh.chap01.model.vo.Child1;
import com.kh.chap01.model.vo.Child2;
import com.kh.chap01.model.vo.Parent;

public class Run {

	public static void main(String[] args) {
		
		Parent p1 = new Parent();
		p1.printParent();
		
		Child1 c1 = new Child1();
		c1.printChild1();
		c1.printParent();
		
		Parent p2 = new Child2();
		p2.printParent();
	//	p2.printChild2();
	//	p2로는 Parent타입 객체만 사용 가능
		
		
	/*	
		// Child1타입 객체 두 개, Child2타입 객체 두 개
		Child1 child1 = new Child1();
		Child1 child2 = new Child1();
		Child2 child3 = new Child2();
		Child2 child4 = new Child2();
		
		child1.printChild1();
		child2.printChild1();
		child3.printChild2();
		child4.printChild2();

		Child1[] arr1 = new Child1[2];
		Child2[] arr2 = new Child2[2];
		arr1[0] = new Child1();
		arr2[0] = new Child2();
		arr1[1] = new Child1();
		arr2[1] = new Child2();
		
		arr1[0].printChild1();
		arr1[1].printChild1();
		arr2[0].printChild2();
		arr2[1].printChild2();
	*/	
		System.out.println("\n\n\n\n\n다형성을 적용해볼까?");
		Parent[] arr = new Parent[4];
		arr[0] = new Child1();
		arr[1] = new Child2();
		arr[2] = (Parent)new Child1();
		arr[3] = new Child2();
		
		for(int i = 0; i < arr.length; i++) {
			
//			if(arr[i] instanceof Child1) {
//				((Child1)arr[i]).printChild1();
//			} else {
//				((Child2)arr[i]).printChild2();
//			}	
			arr[i].print();
		}
	
		
	}

}
