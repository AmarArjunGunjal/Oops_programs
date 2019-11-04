package com.blabz.simple;

public class Person {
String firstname;
String lastname;
int age;
 String address;

public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public  Person(String firstname,String lastname)
{
	this.firstname=firstname;
	this.lastname=lastname;
}


}

	

