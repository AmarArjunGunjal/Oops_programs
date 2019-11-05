package com.Inventorymanagement;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryDataManagement {
public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Oopsapp/src/com/Inventorymanagement/inv.json";
	ObjectMapper mapper=new ObjectMapper();
	
	Map<String, details>map=mapper.readValue(new File(path), new TypeReference<Map<String, details>>(){
	}) ;		

	details rice=map.get("list1");
	details wheat=map.get("list2");
	details pulses=map.get("list3");
	
	System.out.println("name "+rice.name);
	System.out.println("weight "+rice.weight);
	System.out.println("price of 1 kg "+rice.price);
	System.out.println("total cost "+(rice.weight)*(rice.price));
	
	System.out.println("name "+wheat.name);
	System.out.println("weight "+wheat.weight);
	System.out.println("price of 1 kg "+wheat.price);
	System.out.println("total cost "+(wheat.weight)*(wheat.price));

	
	System.out.println("name "+pulses.name);
	System.out.println("weight "+pulses.weight);
	System.out.println("price of 1 kg "+pulses.price);
	System.out.println("total cost "+(wheat.weight)*(wheat.price));

	
}
}
