package com.Inventorymanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class InventoryManagement 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Oopsapp/src/com/Inventorymanagement/inventory.json";
		ObjectMapper mapper=new ObjectMapper();
		ArrayList<details> al=mapper.readValue(new File(path), new TypeReference<ArrayList<details>>() {
		});
		for(details obj:al)
		{
			System.out.println("name "+obj.name+" "+"weight "+obj.weight+" "+"price "+obj.price);
			System.out.println("total cost of "+obj.name+" "+obj.getWeight()*obj.getPrice());
		}

		
	}
}
