package com.jk.beans;

public enum Status {

	SUCCESS("通过"),NOTSUCCESS("未通过"),WAIT("待年检");
	private String name;

	private Status(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
