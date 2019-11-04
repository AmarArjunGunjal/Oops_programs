package com.blabz.simple;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Readfile {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	{
	String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Oopsapp/src/com/blabz/simple/file.json";
	
	
		ObjectMapper mapper=new ObjectMapper();
		
		
		ArrayList<Person> al=mapper.readValue(new File(path), new TypeReference<ArrayList<Person>>() {
		});
		
		
		for(Person p:al)
		{
			System.out.println(p.firstname+" "+p.lastname+" "+p.age+" "+p.getAddress());
		}
		
		
	}

}
