package com.lim.spring.chara.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CharaDto {
	private Long charNo;
	private String charName;
	private Long charTier;
	private Long memberNo;
	private Date releaseDate;

	private String memberName;
}
