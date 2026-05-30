package com.kh.study.busan.model.dto;

public class UpdateReviewDto {
	private String content;
	private String updateContent;
	private Long ucSeq;
	public void setUcSeq(Long ucSeq) {
		this.ucSeq = ucSeq;
	}
	public Long getUcSeq() {
		return ucSeq;
	}
	public UpdateReviewDto(String content, String updateContent, Long ucSeq) {
		super();
		this.content = content;
		this.updateContent = updateContent;
		this.ucSeq = ucSeq;
	}
	public UpdateReviewDto() {
		super();
	}
	public UpdateReviewDto(String content, String updateContent) {
		super();
		this.content = content;
		this.updateContent = updateContent;
	}
	public String getContent() {
		return content;
	}
	public String getUpdateContent() {
		return updateContent;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}
	@Override
	public String toString() {
		return "UpdateReviewDto [content=" + content + ", updateContent=" + updateContent + ", ucSeq=" + ucSeq + "]";
	}
	
}
