package com.ampel.drugsearch.model;

public class Specifications {
	
	private String name;
	private String type;
	
	public Specifications(){
		
	}
	
	public Specifications(String name, String type){
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
