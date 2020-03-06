package com.web.freeboard.vo;

public class FreeBoardVo {
	
	private int num;
	private String title;
	private String name;
	private String regdate;
	private String content;
	
	public FreeBoardVo(int num, String title, String name, String regdate, String content) {
		super();
		this.num = num;
		this.title = title;
		this.name = name;
		this.regdate = regdate;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "FreeBoardVo [num=" + num + ", title=" + title + ", name=" + name + ", regdate=" + regdate + ", content="
				+ content + "]";
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
