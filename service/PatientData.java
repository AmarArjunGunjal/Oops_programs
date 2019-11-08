package service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import model.Patient;
import utility.Utility;

public class PatientData 
{
	static String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Clinique/src/repository/patient.json";
	/**
	 * PURPOSE-add the patient data into file
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void add() throws JsonParseException, JsonMappingException, IOException
	{
		List<Patient>PatientData=Utility.readPatient(path);
		Patient add_patient=new Patient();
		System.out.println("Enter name of patient");
		add_patient.setName(Utility.readString());
		System.out.println("Enter age");
		add_patient.setAge(Utility.readInt());
		System.out.println("Enter id of patient");
		add_patient.setId(Utility.readInt());;
		System.out.println("Enter patient mobile numer");
		add_patient.setMob_no(Utility.readLong());
		PatientData.add(add_patient);
		
		Utility.writepatient(path, PatientData);
		System.out.println("Added patient data");
	}
	/**
	 * @param name-search the patient by name
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void  searchpatientbyname(String name) throws JsonParseException, JsonMappingException, IOException
	{
		List<Patient> temp=Utility.readPatient(path);
		List<Patient> list=temp.stream().filter(i->i.getName().equals(name)).collect(Collectors.toList());
		if(list.isEmpty())
		{
			System.out.println("patient is not present");
		}
		else
		{
			System.out.println("patient is present");
			
		}
	}
	/**
	 * purpose-search the patient by using patient id
	 * @param id-patient id
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void searchpatientbyid(int id) throws JsonParseException, JsonMappingException, IOException
	{
		List<Patient>doctor_data=Utility.readPatient(path);
		List<Patient>list=doctor_data.stream().filter(i->i.getId()==id).collect(Collectors.toList());
		if(list.isEmpty())
		{
			System.out.println("patient is not present");
		}
		else
		{
			System.out.println("patient is present");
			
		}
	}
	
	/**
	 * @param num--mobile number
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void searchpatientbyMobile_no(int num) throws JsonParseException, JsonMappingException, IOException
	{
		List<Patient>doctor_data=Utility.readPatient(path);
		List<Patient>list=doctor_data.stream().filter(i->i.getMob_no()==num).collect(Collectors.toList());
		if(list.isEmpty())
		{
			System.out.println("patient is not present");
		}
		else
		{
			System.out.println("patient is present");
			
		}
	}
}
