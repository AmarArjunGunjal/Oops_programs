package controller;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import service.AtosData;
import utility.Utility;

public class Stockreport 
{
public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException 
	{
	 String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Stockreport/src/repository/Atos.json";

		int choice;
		do
		{
			System.out.println("1.add  stock record");
			System.out.println("2.read stock data");
			System.out.println("3.stock report");
			System.out.println("Enter your choice");
			choice=Utility.readInt();
			
			switch(choice)
			{
			case 1:
				AtosData.add();
				break;
				
			case 2:
				Utility.readData(path);
				
			case 3:
				AtosData.stockReport();
				break;
			}
			
		}while(choice!=4);
		
	
	}
}
