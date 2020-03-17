package com.lti.demo.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {


	
	/*
	 * public String toString() { return "Patient [Id=" + Id + ", name=" + name +
	 * ", nationality=" + nationality + "]"; }
	 */

public Patient( String PId, String name, String nationality) {
	super();
	
	this.PId = PId;
	this.name = name;
	this.nationality = nationality;
}

@Override
	public String toString() {
		return "Patient [PId=" + PId + ", name=" + name + ", nationality=" + nationality + ", getId()=" + getPId()
				+ ", getname()=" + getname() + ", getnationality()=" + getnationality() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

public String getPId() {
	return PId;
}
public void setId(String PId) {
	this.PId = PId;
}
public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
}
public String getnationality() {
	return nationality;
}
public void setnationality(String nationality) {
	this.nationality = nationality;
}
@Id
String PId;
String name;
String nationality;

}
