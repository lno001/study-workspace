package com.kh.chap04.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04.model.vo.Message;

public class ObjectDao {
	
	public void outputFile() {
		Message m = new Message("이일섭", "반갑습니다");
		
		try(ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("e_object.txt"))
			){
			fos.writeObject(m);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void inputFile() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_object.txt"))){
			Message m = (Message)ois.readObject();
			
			System.out.println(m);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
