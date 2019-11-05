package utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Atos;


public class Utility {
	static Scanner scanner=new Scanner(System.in);
	public static String readString()
	{
		return scanner.next();
	}
	public static int readInt()
	{
		return scanner.nextInt();
	}
	public static long readLong()
	{
		return scanner.nextLong();
	}
	
	
	
	public static List<Atos>readAtos(String path)
	{
		List<Atos>atos_data=new ArrayList<Atos>();
		ObjectMapper mapper=new ObjectMapper();
		try {
			atos_data=mapper.readValue(new File(path),new TypeReference<List<Atos>>() {
			});
		}catch (Exception e) {
			// TODO: handle exception
		}
		return atos_data;
		
	}
	public static void readData(String path) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		List<Atos>Appointment_Data=Utility.readAtos(path);
		List<Atos>atos_data=mapper.readValue(new File(path), new TypeReference<List<Atos>>() {
		});
		for(Atos d:atos_data)
		{
			System.out.println(d.getStock_name()+" "+d.getNo_of_shares()+" "+d.getShare_price());
			
		}
		
	}
	
	public static void writeAtos(String path,List<Atos>atos_data) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(new File(path), atos_data);
	}
	
	
}
