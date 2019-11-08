package controller;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import service.AppointmentData;
import service.DoctorData;
import service.PatientData;
import utility.Utility;

public class Clinique {
public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	
	
	int choice;
	do
	{
		System.out.println("1.add doctor");
		System.out.println("2.add patient");
		System.out.println("3.chek doctor availability by name");
		System.out.println("4.chek doctor availability by id");
		System.out.println("5.chek doctor availability by specialization");
		System.out.println("6.search patient by name");
		System.out.println("7.search patient by id");
		System.out.println("8.search patient by mobile no");
		System.out.println("9.Add appointment");
		System.out.println("10.check appointment");
		System.out.println("Enter your choice");
	 choice=Utility.readInt();
	
	switch(choice)
	{
	case 1:
		DoctorData.add();
		break;
		
	case 2:
		PatientData.add();
		break;
		
	case 3:
		System.out.println("Enter name of doctor ");
		String name=Utility.readString();
		DoctorData.checkdoctorAvailabilitybyname(name);
		break;
		
	case  4:
		System.out.println("Enter id");
		int id=Utility.readInt();
		DoctorData.checkdoctorAvailabilitybyid(id);
		break;
		
	case 5:
		System.out.println("Enter specialization");
		String specialization=Utility.readString();
		DoctorData.checkdoctorAvailabilitybySpecialization(specialization);
		
	case 6:
		System.out.println("Enter name of patient ");
		String name1=Utility.readString();
		PatientData.searchpatientbyname(name1);
		break;
		
	case 7:
		System.out.println("Enter id of patient ");
		int id1=Utility.readInt();
		PatientData.searchpatientbyid(id1);
		break;
		
	case 8:
		System.out.println("Enter mobile num patient ");
		int m_no=Utility.readInt();
		PatientData.searchpatientbyMobile_no(m_no);
		break;
		
	case 9:
		AppointmentData.addAppointment();
		break;
		
	case 10:
		AppointmentData.getAppointment();
		break;
	}
	}while(choice!=11);
}
}
