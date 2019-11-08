package service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Appointment;
import model.Doctor;
import utility.Utility;

public class AppointmentData 
{
	static String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Clinique/src/repository/appointment.json";
	static ObjectMapper mapper=new ObjectMapper();
	static String path1="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Clinique/src/repository/doctor.json";
//	public static void readApintmentData(String name) throws JsonParseException, JsonMappingException, IOException
//	{
//		boolean flag=false;
//		List<Appointment>appoint_data=Utility.readAppointment(path);
//		for(int i=0;i<appoint_data.size();i++)
//		{
//			System.out.println(appoint_data.get(i));
//		}
//		
//	}
	/**
	 * purpose- write the data into the file
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void addAppointment() throws JsonParseException, JsonMappingException, IOException
	{

		List<Appointment>Appointment_Data=Utility.readAppointment(path);
		Appointment add_appoint=new Appointment();
		System.out.println("Enter name of patient");
		add_appoint.setName(Utility.readString());
		System.out.println("Enter appointment for which specialization");
		add_appoint.setSpecialization(Utility.readString());
		System.out.println("Enter time of appointment");
		add_appoint.setTime(Utility.readString());
		System.out.println("Enter Date");
		add_appoint.setDate(Utility.readString());

		Appointment_Data.add(add_appoint);
		
		Utility.writeAppointment(path, Appointment_Data);
		System.out.println("appointment data added");
	}
		
	/**
	 * purpose-to show that the appointment is fixed or not fixed
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void getAppointment() throws JsonParseException, JsonMappingException, IOException
	{
		 boolean flag=false;
		@SuppressWarnings("unused")
		List<Appointment>Appointment_Data=Utility.readAppointment(path);
		@SuppressWarnings("unused")
		List<Doctor>doctor_data=Utility.readDoctor(path1);
		
	
		 List<Appointment> data = mapper.readValue(new File(path), new TypeReference<List<Appointment>>() {
			});
		 
		 String temp;
		 String temp1;
		 String temp2;
		 String temp3;
		 
		 for(Appointment d:data)
		 {
			 temp=d.getTime();
			 temp3=d.getSpecialization();
			// System.out.println(temp);
			
		 
		 List<Doctor> data1 = mapper.readValue(new File(path1), new TypeReference<List<Doctor>>() {
			});
		 for(Doctor p:data1)
		 {
			 temp1=p.getAvailability();
			// System.out.println(temp1);
			 temp2=p.getSpecialization();
			 if(temp.equals(temp1)&&temp2.equals(temp3))
			 {
				 flag=true;
			 }
			 else
			 {
				 flag=false;
			 }
			
		 }
		 if(flag==true)
		 {
			 System.out.println("Appointment is fix "+"of  "+d.getName());
		 }
		 else
		 {
			 System.out.println("Appointment is not fix of "+d.getName());
		 }
		 }
		
	
	}
	
}

