package com.example.sagarunnati.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("status_code")
	private String statusCode;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	@SerializedName("status")
	private boolean status;

	@SerializedName("token")
	private String token;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setStatusCode(String statusCode){
		this.statusCode = statusCode;
	}

	public String getStatusCode(){
		return statusCode;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponse{" + 
			"msg = '" + msg + '\'' + 
			",status_code = '" + statusCode + '\'' + 
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			",status = '" + status + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}