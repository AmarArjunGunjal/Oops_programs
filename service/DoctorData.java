package service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import model.Doctor;
import utility.Utility;

public class DoctorData {
	static String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Clinique/src/repository/doctor.json";
	/**
	 * purpose-add the doctor data into the file
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void add() throws JsonParseException, JsonMappingException, IOException
	{
		List<Doctor>doctor_data=Utility.readDoctor(path);
		Doctor addDoctor=new Doctor();
		System.out.println("Enter name of doctor");
		addDoctor.setName(Utility.readString());
		System.out.println("Enter id of doctor");
		addDoctor.setId(Utility.readInt());
		System.out.println("Enter specialization of doctor");
		addDoctor.setSpecialization(Utility.readString());
		doctor_data.add(addDoctor);
		addDoctor.setAvailability();
		Utility.writeDoctor(path, doctor_data);
		System.out.println("Doctor added successfully");
		
	}
	/**
	 * purpose-check the doctor availability by using the name
	 * @param name--doctor name
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void checkdoctorAvailabilitybyname(String name) throws JsonParseException, JsonMappingException, IOException
	{
	List<Doctor>doctor_data=Utility.readDoctor(path);
	
	List<Doctor>list=doctor_data.stream().filter(i->i.getName().equals(name)).collect(Collectors.toList());
	if(list.isEmpty()) {
		System.out.println("doctor is not available");
	}
	else
	{
		System.out.println("doctor is available");

	}
	}
	
	/**
	 * purpose-check the doctor is available or not by id 
	 * @param id - doctor  id
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void checkdoctorAvailabilitybyid(int id) throws JsonParseException, JsonMappingException, IOException
	{
		List<Doctor>doctor_data=Utility.readDoctor(path);
		List<Doctor>list=doctor_data.stream().filter(i->i.getId()==id).collect(Collectors.toList());
		if(list.isEmpty())
		{
			System.out.println("doctor is not available");
		}
		else
		{
			System.out.println("doctor is available");
		}
	}
	/**
	 *purpose-check the doctor availability by specialization name
	 * @param name-doctor specialization
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void checkdoctorAvailabilitybySpecialization(String name) throws JsonParseException, JsonMappingException, IOException
	{
		List<Doctor>temp=Utility.readDoctor(path);
		List<Doctor>list=temp.stream().filter(i->i.getSpecialization().equals(name)).collect(Collectors.toList());
		if(list.isEmpty())
		{
			System.out.println("doctor is not availaible");
		}
		else
		{
			System.out.println("doctor is available");
		}
		
	}
}
