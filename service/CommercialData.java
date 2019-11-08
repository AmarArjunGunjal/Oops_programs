package service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface CommercialData {
	
	public void createAccount()throws JsonParseException, JsonMappingException, IOException ;
	public void buy(int amount, String symobol)throws JsonParseException, JsonMappingException, IOException;
	public void sell(int amount, String symobol)throws JsonParseException, JsonMappingException, IOException;
	public double valueOf()throws JsonParseException, JsonMappingException, IOException;
	public void printReport();
	
}
