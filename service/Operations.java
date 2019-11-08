package service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.PersonalInfo;

public interface Operations {
void createNewAddressBook();
	
	void openAddressBook();
	
	void addPerson();
	
	void deletePerson();

	void editPerson();
	
	void sortByLastName();
    
	void sortByZip();
	
	void readJson();

	void save();

	void saveAs() throws FileNotFoundException;

	void PrintPersonDetails(ArrayList<PersonalInfo> personalInfo, String statename);

}
