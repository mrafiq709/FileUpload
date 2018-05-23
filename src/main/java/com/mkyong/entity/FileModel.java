package com.mkyong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="file_model")
public class FileModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "name")
	private String name;
    
    @Column(name = "type")
	private String type;
	
	@Lob
    @Column(name="file")
    private byte[] file;
	
	public FileModel(){}
	
	public FileModel(String name, String type, byte[] file){
		this.name = name;
		this.type = type;
		this.file = file;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public byte[] getFile(){
		return this.file;
	}
	
	public void setFile(byte[] file){
		this.file = file;
	}
}
