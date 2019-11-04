package com.blabz.simple;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Writefile {
public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	ObjectMapper mapper=new ObjectMapper();
	Address address=new Address("abc", "123", "asd");
	Person person=new Person("Amar","Gunjal");
	String json1=mapper.writeValueAsString(address);
	ObjectWriter writer=mapper.writer();
	String path="/home/admin1/Documents/filewrite.json";	
	writer.writeValue(new File(path), json1);
	System.out.println("done");
			
	
}
}
