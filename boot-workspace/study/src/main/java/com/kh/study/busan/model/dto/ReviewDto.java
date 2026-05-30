package com.kh.study.busan.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ReviewDto {
	private Long ucSeq;
	// @NotNull 
	// @NotEmpty
	@NotBlank(message = "내용은 필수 작성 요소입니다.")
	private String content;
	@NotNull(message = "별점은 필수 작성 요소입니다.")
	@Max(value = 5, message = "별점은 5점 이하여야 합니다.")
	@Min(value = 1, message = "별점은 1점 이상이어야 합니다.")
	private Integer rating;
	private Date createDate;
	
	public ReviewDto(Long ucSeq, String content, Integer rating, Date createDate) {
		super();
		this.ucSeq = ucSeq;
		this.content = content;
		this.rating = rating;
		this.createDate = createDate;
	}
	public ReviewDto() {
		super();
	}
	public Long getUcSeq() {
		return ucSeq;
	}
	public String getContent() {
		return content;
	}
	public Integer getRating() {
		return rating;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setUcSeq(Long ucSeq) {
		this.ucSeq = ucSeq;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "ReviewDto [ucSeq=" + ucSeq + ", content=" + content + ", rating=" + rating + ", createDate="
				+ createDate + "]";
	}
	
}
