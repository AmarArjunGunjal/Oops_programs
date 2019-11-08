package service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;





public interface AccountData {
	
	public void createAccount() throws JsonGenerationException, JsonMappingException, IOException;
	public void totalBalance(int amount);
	public void buyShare() throws JsonParseException, JsonMappingException, IOException;
	public void sellShare();
	public void saveAccount();
	public void printReport() throws JsonParseException, JsonMappingException, IOException;
	
	
}
