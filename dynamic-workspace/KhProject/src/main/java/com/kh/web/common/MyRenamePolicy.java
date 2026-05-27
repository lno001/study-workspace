package com.kh.web.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;


// FileRenamePolicy라는 인터페이스를 구현해서 이름 바꾸기 정책을 만들어주기
public class MyRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File origin) {
		
		String originName = origin.getName();
		
		// KH_년월일시분초_램덤값.원본파일확장자명
		// 1. 원본파일 확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		// 2. 년월일시분초
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		int randomNum = (int)(Math.random() * 900) + 100;
		
		String changeName = "KH_" + currentTime + "_" + randomNum + ext;
		
		// 기존 파일명을 바꾼 이름으로 적용시켜서 반환
		
		
		return new File(origin.getParent(), changeName);
	}

}
