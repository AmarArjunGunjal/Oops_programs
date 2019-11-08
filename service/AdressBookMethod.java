package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import model.Address;
import model.AdressBook;
import model.PersonalInfo;
import utility.Utility;

public class AdressBookMethod implements Operations 
{
	public static int choice;
	Scanner scanner=new Scanner(System.in);
	
	int counter=0;
	
	String path ="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.1.RELEASE/Oops_program_clinic/src/repository/adressbook.json";
	String statename="";
	
	static AdressBook model=new AdressBook();
	
	static ArrayList <PersonalInfo> personalInfo=new ArrayList<PersonalInfo>();
	
	/*
	 * Purpose:- Method for Creating New Address_Book
	 */
	@Override
	public void createNewAddressBook() 
	{
		System.out.println("Create an New Address Book");
		System.out.println("Enter the Statename");
	
		statename=scanner.next();
		
		boolean findstatename=false;
		
			for(int i=0;i<personalInfo.size();i++)
			{
				if(personalInfo.get(i).getAddressobj().getState().equals(statename))
				{
					findstatename=true;
					break;
				}
			}
			
		
		if(!findstatename)
		{
			System.out.println("State is added");
			do 
			{
				System.out.println("\n1.Add record\n2.Save Record\n3.Print Record\n4.Exit");
				
				System.out.println("Enter the choice");
				choice=scanner.nextInt();
				switch(choice)
				{
					case 1:
						//Add Person Record
							addPerson();
							break;
						
						
					case 2:
						//Save Record
							save();
							break;
						
					case 3:
						//Print Record
							if (counter > 0) 
							{
								System.out.println("address book records...");
								PrintPersonDetails(personalInfo, statename);
			
							}
							else
								System.out.println("There is no record to print...");
			
							break;
						
					default:
						//Exit 
							System.out.println("please Enter the valid option");
				}
				
			}while(choice!=4);
			
		}
		else
		{
			System.out.println("Statename is already exists");
		}
		
	}

	@Override
	public void openAddressBook() 
	{
		System.out.println("Open Address Book");
		
		HashMap<String,String> map=new HashMap<>();
		
		for(int i=0;i<personalInfo.size();i++)
		{
			map.put(personalInfo.get(i).getAddressobj().getState(),personalInfo.get(i).getAddressobj().getState());
				
		}
		
		System.out.println("state is available :"+map.keySet());
		
		statename=scanner.next();
		boolean findstatename=false;
		
		for(int i=0;i<personalInfo.size();i++)
		{
			if(personalInfo.get(i).getAddressobj().getState().equals(statename))
			{
				findstatename=true;
				PrintPersonDetails(personalInfo,statename);
				break;
			}
		}
		
		if(!findstatename)
		{
			System.out.println("State not Found in Address Book");
			
			do
			{
				System.out.println("1.Add Record\n2.Edit Record\n3.Delete Record\n4.Sort By last name\n5.Sort By Zip\n6.Print Address_Book\n7.Save Record \n8.Exit");
				choice =scanner.nextInt();
				
				switch(choice)
				{
				case 1:
					//Add Record
					addPerson();
					break;
					
				case 2:
					//Edit Record
					editPerson();
					break;
					
				case 3:
					//Delete Record
					deletePerson();
					break;
					
				case 4:
					//Sort By Last Name
					sortByLastName();
					break;
				
				case 5:
					//Sort By Zipcode
					sortByZip();
					break;
					
				case 6:
					//Print Record
					
						if(counter>0)
						{
							System.out.println("***Address Book*****");
							PrintPersonDetails(personalInfo, statename);
							
						}
							else
							{
								System.out.println("No Record to Print");
							}
							break;
				
				case 7:
					//Save Record
					save();
					break;
					
				case 8:
					//Exit
					System.out.println("Exit");
					break;
					
				default:
					System.out.println("Invalid Choice");
					
				}
			}while(choice!=8);
		}
		else
		{
			System.out.println("Try new statename");
		}
	
	}
	
	/*
	 * Purpose: Method for Saving Record
	 */
	

	@Override
	public void addPerson() 
	{
		System.out.println("Adding Personal Details");
		System.out.println("Enter the mobile NO");
		Long mobile=scanner.nextLong();
		PersonalInfo person=new PersonalInfo(); 
		boolean findmobileno=false;
		
		for(int i=0;i<personalInfo.size();i++)
		{
			long getmobile=personalInfo.get(i).getMobileno();
				if(mobile.equals(getmobile))
				{
					findmobileno=true;
					break;
				}
		}
			if(findmobileno)
			{
				System.out.println("mobileno already exists");
			}
				else
				{
	
					person.setMobileno(mobile);
					
					System.out.println("Enter person first name: ");
					person.setFirstname(scanner.next().toLowerCase());
					
					System.out.println("Enter person last name: ");
					person.setLastname(scanner.next().toLowerCase());
					
					System.out.println("Enter address Details: ");
					Address address = new Address(); //creating address object
					
					System.out.println("Enter address: ");
					address.setAddress(scanner.next());
					
					System.out.println("Enter city: ");
					address.setCity(scanner.next());
					
					address.setState(statename);
					
					System.out.println("Enter zip: ");
					address.setZip(scanner.nextInt());
					
					person.setAddressobj(address);
					personalInfo.add(person);
	                
					System.out.println();
					System.out.println("Person added");
					counter++;
				}
	
		
	}

	@Override
	public void deletePerson()
	{
		if(counter>0)
		{
			System.out.println("Enter the mobile number to delete");
			Long mobilesearch=scanner.nextLong();
			for(int i=0;i<personalInfo.size();i++)
			{
				long mobileno=(personalInfo.get(i).getMobileno());
				if(mobilesearch.equals(mobileno))
				{
					personalInfo.remove(i);
					counter--;
					System.out.println();
					System.out.println("Deleted Successfully");
					
				}
					else
					{
						System.out.println("record not found of this number");
						break;
					}
			}
			
		}
		else
		{
			System.out.println("No record found");
			
		}
		
	}
	

	@Override
	public void editPerson() 
	{
		if(counter>0)
		{
			System.out.println("Enter mobile number to edit");
			Long mobile =scanner.nextLong();
			
			for(int i=0;i<personalInfo.size();i++)
			{
				if(mobile.equals(personalInfo.get(i).getMobileno()))
						{
					 		System.out.println("Enter new address to edit");
					 		personalInfo.get(i).getAddressobj().setAddress(scanner.next());
					 		
					 		System.out.println("Enter city name");
					 		personalInfo.get(i).getAddressobj().setCity(scanner.next());
					 		
					 		System.out.println("Enter zip ");
					 		personalInfo.get(i).getAddressobj().setZip(scanner.nextInt());
					 		
					 		personalInfo.get(i).setMobileno(mobile);
					 		
					 		System.out.println();
					 		
					 		save();
					 		
					 		System.out.println("Edited Successfully");
					 		break;
					 		
					 	}
				
				else
				{
					System.out.println("No record found");
					break;
				}
			
			}
			
		}
	
		
	}

	@Override
	public void sortByLastName()
	{
		if(counter>1)
		{
			System.out.println("Sorting by last name");
			Collections.sort(personalInfo, (e1, e2) -> e1.getLastname().compareTo(e2.getLastname()));
			
			//Print after Sorting
			
			PrintPersonDetails(personalInfo, statename);
		
		}
			else
			{
				System.out.println("less record to sort");
			}
		
	}

	@Override
	public void sortByZip() 
	{
		if(counter>1)
		{
			System.out.println("Sorting By Zipcode");
			Collections.sort(personalInfo,(e1,e2)->String.valueOf(e1.getAddressobj().getZip()).
					compareTo(String.valueOf(e2.getAddressobj().getZip())));
		
			
			//Print after Sorting
			
			PrintPersonDetails(personalInfo, statename);
		
		}
		else
		{
			System.out.println("less record to sort");
		}
		
	}

	@Override
	public void readJson()
	{
		// checking whether it is empty or not
				File file = new File(path);
				if (file.exists() && file.length() != 0) 
				{
					try 
					{
						model = (AdressBook) Utility.readMapper(path, model);
					} 
						catch (IOException e) 
						{
							e.printStackTrace();
						}
					
					personalInfo.addAll(model.getPersonalInfo());
				    counter = personalInfo.size();   //getting size of counter
			
				}
	}

	@Override
	public void save()
	{
		System.out.println("Save into Json FIle");
		
		model.setPersonalInfo(personalInfo);
		
		try
		{
			Utility.writeMapper(path, model);
		}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		
	}

	@Override
	public void saveAs() throws FileNotFoundException 
	{
		System.out.println("*******Save As**********");
		String Inputpath="/home/admin-1/eclipse-workspace/AddressBook1/src/com/bridgelabz/addressbook1/JsonFile/AddressBook.json";
		
		System.out.println("Enter Filename ");
		Inputpath+=scanner.next();
		
		Inputpath+=".json";
		
		if(new File(Inputpath).exists())
		{

			throw new FileNotFoundException("You cannot rewrite existing file");
		} 
		
			else 
			{
				// writing into file
				System.out.println("****Saving into file****");
				model.setPersonalInfo(personalInfo);
				
				try 
				{
					Utility.writeMapper(Inputpath, model);
				} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
			}
		
	}

	@Override
	public void PrintPersonDetails(ArrayList<PersonalInfo> personalInfo, String statename) 
	{
		personalInfo.forEach(i->{
			if(!statename.isEmpty()&&statename.equals(i.getAddressobj().getState()))
			{
				System.out.println("Firstname:"+i.getFirstname()+"\nLastname:"+i.getLastname()+"\nMobileno: "+i.getMobileno()+"\nCity Name :"+
							i.getAddressobj().getCity()+"\nState Name "+i.getAddressobj().getState()+" \nAddress:"+i.getAddressobj().getAddress()+"\nPincode:"
							+i.getAddressobj().getZip());
			}
		});
		
	}
	


	
}