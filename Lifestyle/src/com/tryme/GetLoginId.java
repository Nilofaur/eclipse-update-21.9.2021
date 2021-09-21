package com.tryme;

public class GetLoginId {
	
	//private int id;


	private String email;
	private String name;
	
	

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public String toString() {
		return  name;
		//return "GetLoginId [name=" + email + "]";

	}

}
