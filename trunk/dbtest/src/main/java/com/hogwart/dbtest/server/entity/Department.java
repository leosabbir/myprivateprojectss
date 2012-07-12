package com.hogwart.dbtest.server.entity;

import javax.validation.constraints.NotNull;

public class Department extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@NotNull
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name; 
	}

}
