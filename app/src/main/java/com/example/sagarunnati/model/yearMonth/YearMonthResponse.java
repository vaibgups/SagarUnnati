package com.example.sagarunnati.model.yearMonth;


import com.google.gson.annotations.SerializedName;

public class YearMonthResponse{

	@SerializedName("msg")
	private String msg;

	@SerializedName("status_code")
	private String statusCode;

	@SerializedName("master_data")
	private MasterData masterData;

	@SerializedName("status")
	private boolean status;

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

	public void setMasterData(MasterData masterData){
		this.masterData = masterData;
	}

	public MasterData getMasterData(){
		return masterData;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"YearMonthResponse{" + 
			"msg = '" + msg + '\'' + 
			",status_code = '" + statusCode + '\'' + 
			",master_data = '" + masterData + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}