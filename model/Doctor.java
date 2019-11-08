package model;

import utility.Utility;

public class Doctor 
{
	String name;
	int id;
	String specialization;
	String availability;
	int patient_count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability() 
	{
		System.out.println("Enter ur choice\n1.AM\n2.PM");
		int choice=Utility.readInt();
		switch(choice)
		{
		case 1 :availability="AM";break;
		case 2 :availability = "PM";break;
		default:setAvailability();
		}
		
	}
	public int getPatient_count() {
		return patient_count;
	}
	public void setPatient_count(int patient_count) {
		this.patient_count = patient_count;
	}
}
