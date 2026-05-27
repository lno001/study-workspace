package com.lim.spring.chara.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Chara {
	private Long charNo;
	private String charName;
	private Long charTier;
	private Long memberNo;
	private Date releaseDate;
}
