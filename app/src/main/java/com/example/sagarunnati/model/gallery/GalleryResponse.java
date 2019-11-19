package com.example.sagarunnati.model.gallery;

import com.google.gson.annotations.SerializedName;

public class GalleryResponse{

	@SerializedName("img_path")
	private String imgPath;

	@SerializedName("id")
	private String id;

	public void setImgPath(String imgPath){
		this.imgPath = imgPath;
	}

	public String getImgPath(){
		return imgPath;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"GalleryResponse{" + 
			"img_path = '" + imgPath + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}