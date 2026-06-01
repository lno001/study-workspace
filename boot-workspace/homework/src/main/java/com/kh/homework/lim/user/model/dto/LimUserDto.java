package com.kh.homework.lim.user.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LimUserDto {
	
	private Long userNo;
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "아이디는 영어 / 숫자만 가능합니다.")
	@Size(min = 4, max = 20, message="아이디는 4글자 이상 20글자 이하만 사용할 수 있습니다.")
	@NotBlank(message="아이디는 비어있을 수 없습니다.")
	private String userId;
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "비밀번호는 영어 / 숫자만 가능합니다.")
	@Size(min = 4, max = 20, message="비밀번호는 4글자 이상 20글자 이하만 사용할 수 있습니다.")
	@NotBlank(message="비밀번호는 비어있을 수 없습니다.")
	private String userPwd;
	@Size(min = 2, max = 20, message="이름은 2글자 이상 20글자 이하만 사용할 수 있습니다.")
	@NotBlank(message="이름은 비어있을 수 없습니다.")
	private String userName;
	private String role;
	private String status;
	private Date regDate;
}
