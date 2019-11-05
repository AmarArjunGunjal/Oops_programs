package service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Atos;
import utility.Utility;

public class AtosData {
	static String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Stockreport/src/repository/Atos.json";
	static ObjectMapper mapper=new ObjectMapper();
	
	public static void add() throws JsonGenerationException, JsonMappingException, IOException
	{
		List<Atos>atos_data=Utility.readAtos(path);
		Atos add_Atos=new Atos();
		System.out.println("Enter name of stock name");
		add_Atos.setStock_name(Utility.readString());
		System.out.println("Enter no of shares");
		add_Atos.setNo_of_shares(Utility.readInt());
		System.out.println("Enter share price");
		add_Atos.setShare_price(Utility.readLong());
		
		atos_data.add(add_Atos);
		Utility.writeAtos(path,atos_data);
	}
	
	public static void stockReport() throws JsonParseException, JsonMappingException, IOException
	{
		int result=0;
		List<Atos>atos_data=Utility.readAtos(path);
		List<Atos>data=mapper.readValue(new File(path),new TypeReference<List<Atos>>() {
		});
		for(Atos d : data)
		{
			 result=result+(int) (d.getNo_of_shares()*d.getShare_price());
			
		}
		 System.out.println(result);
	}
}
