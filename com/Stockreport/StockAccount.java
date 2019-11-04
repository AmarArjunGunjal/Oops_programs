package com.Stockreport;

import java.io.File;
import java.io.IOException;

import com.blabz.utility.oops.Utility;


public class StockAccount {
	String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Oopsapp/src/Stockreport/stockdetails.java";

	

	
	
public static void main(String[] args) 
{
	Utility utility=new Utility();
	StockAccount object=new StockAccount();
	System.out.println("Enter Your choice");
	System.out.println("1.Create new Account");
	System.out.println("2.Buy Shares");
	System.out.println("3.Sell Shares");
	System.out.println("4.print report");
	int ch=utility.readInteger();
	switch(ch)
	{
	case 1:
		
	}
}
}
