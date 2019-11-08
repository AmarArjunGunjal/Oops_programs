package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Account;
import model.Appointment;
import model.Company;
import model.Doctor;
import model.Patient;
import model.Stockholder;
import service.CommercialData;

public class Utility implements CommercialData{
	static Scanner scanner=new Scanner(System.in);
	static ObjectMapper mapper=new ObjectMapper();
	
	/**
	 * purpose-to read the string data
	 * @return string
	 */
	public static String readString()
	{
		return scanner.next();
	}
	/**
	 * purpose-to read the int data
	 * @return int data
	 */
	public static int readInt()
	{
		return scanner.nextInt();
	}
	/**
	 * purpose-to read the long data
	 * @return long data
	 */
	public static long readLong()
	{
		return scanner.nextLong();
	}
	
	
	
	
	/**
	 * purpose-to read the appointment data
	 * @param path file path
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static List<Appointment> readAppointment(String path) throws JsonParseException, JsonMappingException, IOException
	{
		List<Appointment>appoint_data=new ArrayList<Appointment>();
		try
		{
			appoint_data=mapper.readValue(new File(path), new TypeReference<List<Appointment>>() {
			});
			return appoint_data;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return appoint_data;
	}
	/**
	 * purpose-to read the doctor data
	 * @param path file path
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static List<Doctor> readDoctor(String path) throws JsonParseException, JsonMappingException, IOException	{
		List<Doctor>doctor_data=new ArrayList<Doctor>();
		try {
			doctor_data=mapper.readValue(new File(path), new TypeReference<List<Doctor>>() {
			});
			return doctor_data;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return doctor_data;
		
		
	}
	
	/**
	 * purpose-to read the patient data
	 * @param path-file path
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static List<Patient>readPatient(String path) throws JsonParseException, JsonMappingException, IOException
	{
	
		List<Patient>patient_data=new ArrayList<Patient>();
		try {
			patient_data=mapper.readValue(new File(path),new TypeReference<List<Patient>>() {
			});
			return patient_data;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return patient_data;
		
	}
	public static List<Account>readAccount()
	{
		String path="/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/Clinique/src/repository/account.json";

		List<Account>account_data=new ArrayList<Account>();
		try {
			account_data=mapper.readValue(new File(path), new TypeReference<List<Account>>() {
			});
			return account_data;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return account_data;
	}
//	
	/**
	 * purpose-to write the doctor data
	 * @param path-file path
	 * @param doctor_data- doctor data which is read
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void writeDoctor(String path,List<Doctor>doctor_data) throws JsonGenerationException, JsonMappingException, IOException
	{
	mapper.writeValue(new File(path), doctor_data);
	}
	
	/**
	 * purpose-to write the appoint data
	 * @param path-file path
	 * @param appoint_data-appoint data which is read
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void writeAppointment(String path,List<Appointment>appoint_data) throws JsonGenerationException, JsonMappingException, IOException
	{
		mapper.writeValue(new File(path), appoint_data);
	}
	/**
	 * purpose-to write the patient data
	 * @param path-file path
	 * @param patient_data-patient data which is read
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void writepatient(String path,List<Patient>patient_data) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(new File(path), patient_data);
	}
	
//	public static void writeaccount(String path,List<Account>account_data) throws JsonGenerationException, JsonMappingException, IOException
//	{
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.writeValue(new File(path), account_data);
//	}
//	public static List<Company> readCompany(String path) throws JsonParseException, JsonMappingException, IOException
//	{
//		List<Company>company_data=new ArrayList<Company>();
//		try
//		{
//			company_data=mapper.readValue(new File(path), new TypeReference<List<Appointment>>() {
//			});
//			return company_data;
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return company_data;
//	}
//	public static void writecompany(String path,List<Account>company_data) throws JsonGenerationException, JsonMappingException, IOException
//	{
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.writeValue(new File(path), company_data);
//	}
//	public static List<Stockholder> readStockholder(String path) throws JsonParseException, JsonMappingException, IOException
//	{
//		List<Stockholder>stockholder_data=new ArrayList<Stockholder>();
//		try
//		{
//			stockholder_data=mapper.readValue(new File(path), new TypeReference<List<Stockholder>>() {
//			});
//			return stockholder_data;
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return stockholder_data;
//	}
//	public static void writestockholder(String path,List<Stockholder>stockholder_data) throws JsonGenerationException, JsonMappingException, IOException
//	{
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.writeValue(new File(path), stockholder_data);
//	}
	int set = 0;
	String buyer, seller, buy_symbol, sell_symbol;
	int bought_shares = 0, sold_shares = 0;
	int buy_amount = 0, sell_amount = 0;
	int balance_of_buyer = 0;
	LocalDate date;
	LocalTime start_time = null;
	LocalTime end_time = null;

	String path_of_stockHolder = "/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.1.RELEASE/Oops_program_clinic/src/repository/stockholder.json";
	String path_of_companies = "/home/admin1/Documents/workspace-spring-tool-suite-4-4.4.1.RELEASE/Oops_program_clinic/src/repository/company.json";

	
	/**
	 * purpose-to read the stock data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Stockholder> readStockholder() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Stockholder> list_of_buyers = mapper.readValue(new File(path_of_stockHolder),
				new TypeReference<List<Stockholder>>() {
				});
		return list_of_buyers;
	}

	
	/**
	 * purpose-to read company data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Company> readCompany() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Company> list_of_companies = mapper.readValue(new File(path_of_companies),
				new TypeReference<List<Company>>() {
				});
		return list_of_companies;
	}
	
	/**
	 * purpose-to write the data into stockholder
	 * @param list_of_buyers- holds the name of list  buyers name
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void writeStockholder(List<Stockholder> list_of_buyers)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(path_of_stockHolder), list_of_buyers);
	}

	/**
	 * purpose-to write the data into company
	 * @param list_of_companies-holds the name of company
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void writeCompany(List<Company> list_of_companies)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(path_of_companies), list_of_companies);
	}

	/**
	 *purpose-to create the stack holder account and write the data into stack holder account
	 */
	@Override
	public void createAccount() throws JsonParseException, JsonMappingException, IOException {
		date = LocalDate.now();
		start_time = LocalTime.now();
		System.out.println(start_time);
		List<Stockholder> list_of_buyers = readStockholder();
		Stockholder newUser = new Stockholder();
		System.out.println("Enter name of user");
		newUser.setName(Utility.readString());
		System.out.println("Enter balance of use");
		newUser.setBalance(Utility.readInt());
		int quantity[] = null;
		String stockHoldings[] = null;
		newUser.setQuantity(quantity);
		newUser.setShareholding(stockHoldings);
		list_of_buyers.add(newUser);
		writeStockholder(list_of_buyers);
		end_time = LocalTime.now();
		System.out.println("Account created successfully......");
	}

	/**
	 *purpose-buy the shares of company and write those data into the stockholder file
	 */
	@Override
	public void buy(int amount,String symbol) throws JsonParseException, JsonMappingException, IOException
	{
		date = LocalDate.now();
		start_time = LocalTime.now();
		List<Stockholder> list_of_buyers = readStockholder();
		List<Company> list_of_companies = readCompany();

		System.out.println("Enter name of buyer");
		String buyer = Utility.readString();

		int flag_buyer_cheak = 0, flag_symbol_cheak = 0;

		for (Stockholder i : list_of_buyers) {
			if (buyer.equals(i.getName())) {
				flag_buyer_cheak = 1;
				balance_of_buyer = i.getBalance();
				break;
			}
		}

		// it checks that buyer has account or not
		if (flag_buyer_cheak != 1) {
			System.out.println("Buyer no account");
			return;
		}

		// it checks that buyer has sufficient balance or not
		if (amount > balance_of_buyer) {
			System.out.println("Entered Amount is > balance");
			return;
		}
		int number_of_shares_avaliable = 0;
		int price_per_share = 0;
		for (Company i : list_of_companies) 
		{
			if (symbol.equals(i.getSymbol())) 
			{
				flag_symbol_cheak = 1;
				number_of_shares_avaliable = i.getShares();
				price_per_share = i.getPrice();
				break;
			}
		}
		// its check that the buyer has sufficient amount or not to buy 1 share
		if (amount < price_per_share) {
			System.out.println("Entered amount is < price of one share");
			return;
		}

		// check requested company is listed at Stock exchang
		if (flag_symbol_cheak != 1) {
			System.out.println("Company not present change it");
			return;
		}

		// it check that sufficient number of shares are present or not
		if (number_of_shares_avaliable * price_per_share < amount) 
		{
			System.out.println("Unsufficient share is present");
			return;
		}
		int number_of_shares_bought = amount / price_per_share;
		int total_value_of_shares = number_of_shares_bought * price_per_share;
		bought_shares = number_of_shares_bought;
		buy_amount = total_value_of_shares;
		this.buyer = buyer;
		buy_symbol = symbol;
		set = 1;
		for (Stockholder i : list_of_buyers) {
			if (buyer.equals(i.getName())) {
				// reducing balance of buyer account
				i.setBalance(i.getBalance() - total_value_of_shares);

				// adding bought Share symbol to buyer account
				String[] temp = i.getShareholding();
				int index_of_symbol = 0;
				for (int j = 0; j < temp.length; j++)
				{
					if (symbol.equals(temp[j])) {
						index_of_symbol = j;
						int quantity[] = new int[temp.length];
						quantity = i.getQuantity();
						quantity[j] = quantity[j] + number_of_shares_bought;
						i.setQuantity(quantity);
						break;
					}
				}
				if (symbol.equals(temp[index_of_symbol])) {

				} else {
					int size_of_share_holdings = i.getShareholding().length + 1;
					String share_holdings[] = new String[size_of_share_holdings];
					System.arraycopy(temp, 0, share_holdings, 0, temp.length);
					share_holdings[size_of_share_holdings - 1] = symbol;
					i.setShareholding(share_holdings);

					// Adding Bought share quantity to buyer account
					int size_of_quantity = i.getQuantity().length + 1;
					int quantity[] = new int[size_of_quantity];
					int temp1[] = i.getQuantity();
					System.arraycopy(temp1, 0, quantity, 0, temp1.length);
					quantity[size_of_quantity - 1] = number_of_shares_bought;
					i.setQuantity(quantity);
					break;
				}
			}

		}

		for (Company i : list_of_companies) {
			if (symbol.equals(i.getSymbol())) {
				// Adding balance of sold shares
				i.setBalance(i.getBalance() + total_value_of_shares);

				// subtracting Number of shares sold
				i.setShares(i.getShares() - number_of_shares_bought);
			}
		}
		System.out.println("if you want save transacation press 1 for save");
		int choice = Utility.readInt();
		if (choice == 1) {
			save(list_of_buyers, list_of_companies);
		}
		end_time = LocalTime.now();
		System.out.println("Transaction done successfully");
		return;

	}

	/**
	 *pupose-its sells the company shares and write the data into the file
	 */
	@Override
	public void sell(int amount ,String symbol) throws JsonParseException, JsonMappingException, IOException {
		date = LocalDate.now();
		start_time = LocalTime.now();
		List<Stockholder> list_of_sellers = readStockholder();
		List<Company> list_of_companies = readCompany();

		System.out.println("Enter name of Seller");
		String seller = Utility.readString();

		int flag_seller_cheak = 0;
		// int balance_of_seller = 0;
		Stockholder index_of_seller = null;
		for (Stockholder i : list_of_sellers) {
			if (seller.equals(i.getName())) {
				index_of_seller = i;
				flag_seller_cheak = 1;
				// balance_of_seller = i.getBalance();
				break;
			}
		}

		//its  check seller has account or not
		if (flag_seller_cheak != 1) {
			System.out.println("seller no account");
			return;
		}
		// its check seller have shares of requested company
		String[] shares = index_of_seller.getShareholding();
		boolean check_company = false;
		int index_of_required_symbol = 0;
		for (int i = 0; i < shares.length; i++) {
			if (symbol.equals(shares[i])) {
				index_of_required_symbol = i;
				check_company = true;
			}
		}
		if (check_company == false) {
			System.out.println("Seller donot have requested company shares");
			return;
		}
		// its check seller have sufficient shares
		int price_per_share = 0;
		boolean flag_symbol_cheak = false;
		Company index_of_company = null;
		for (Company i : list_of_companies) {
			if (symbol.equals(i.getSymbol())) {
				index_of_company = i;
				flag_symbol_cheak = true;
				price_per_share = i.getPrice();
			}
		}
		int quantity[] = index_of_seller.getQuantity();
		if (amount > quantity[index_of_required_symbol] * price_per_share) {
			System.out.println("Seller do not have sufficient number of shares");
			return;
		}

		// itc check buyer entered sufficient amount to buy at least one share
		if (amount < price_per_share) {
			System.out.println("Entered amount is less than price of one share");
			return;
		}

		// its check requested company is listed at Stock exchange or not
		if (flag_symbol_cheak == false) {
			System.out.println(" company is not listesd in stock exchange");
			return;
		}
		if (amount > index_of_company.getBalance()) {
			System.out.println("Company do not have sufficient balance");
			return;
		}

		int number_of_shares_sold = amount / price_per_share;
		int total_value_of_shares = number_of_shares_sold * price_per_share;
		sold_shares = number_of_shares_sold;
		this.seller = seller;
		sell_amount = total_value_of_shares;
		sell_symbol = symbol;
		set = 2;
		index_of_company.setBalance(index_of_company.getBalance() - total_value_of_shares);
		index_of_company.setShares(index_of_company.getShares() + number_of_shares_sold);

		index_of_seller.setBalance(index_of_seller.getBalance() + total_value_of_shares);
		quantity[index_of_required_symbol] = quantity[index_of_required_symbol] - number_of_shares_sold;
		index_of_seller.setQuantity(quantity);

		System.out.println("Want to save then press 1 else press 0");
		int choice = Utility.readInt();
		if (choice == 1) {
			save(list_of_sellers, list_of_companies);
		}
		end_time = LocalTime.now();
		System.out.println("Transaction done successfully");
		return;
	}

	/**
	 * @Purpose - Saves transaction into file
	 * @param list_of_buyers    - accepts list of buyers
	 * @param list_of_companies - accepts list of companies
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	void save(List<Stockholder> list_of_buyers, List<Company> list_of_companies)
			throws JsonGenerationException, JsonMappingException, IOException {
		writeStockholder(list_of_buyers);
		writeCompany(list_of_companies);
		System.out.println("Data save successfully....");
	}

	/**
	 * @Purpose - Calculate net worth of account holder
	 * @return - Returns net worth of account holder
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Override
	public double valueOf() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Enter name of account holder");
		String account_holder = Utility.readString();

		List<Stockholder> list_of_account_holders = readStockholder();
		List<Company> list_of_companies = readCompany();

		Stockholder index_of_account = null;
		boolean check_account = false;

		for (Stockholder i : list_of_account_holders) {
			if (account_holder.equals(i.getName())) {
				check_account = true;
				index_of_account = i;
			}
		}
		// validate account holder
		if (check_account == false) {
			
			System.out.println("Account holder is not present");
			//return 0;
		}

		double sum = 0;

		int quantity[] = index_of_account.getQuantity();
		int price_per_share = 0;

		String company[] = index_of_account.getShareholding();

		for (int j = 0; j < company.length; j++) {
			for (Company k : list_of_companies) {
				if (company[j].equals(k.getSymbol())) {
					price_per_share = k.getPrice();
					break;
				}
			}
			sum += (quantity[j] * price_per_share);
		}
		return sum;
	}

	/**
	 * @Purpose - its prints Transaction report
	 */
	public void printReport() {
		System.out.println();
		System.out.println("Date of Transaction :" + date);
		System.out.println("Time :" + (end_time));
		if (set == 1) {
			System.out.println("Name of Buyer :" + buyer);
			System.out.println("Total amount :" + buy_amount);
			System.out.println("Stock name :" + buy_symbol);
			System.out.println("Number of shares purchesed :" + bought_shares);
			System.out.println();
		}
		if (set == 2) {
			System.out.println("Name of Seller :" + seller);
			System.out.println("Total amount :" + sell_amount);
			System.out.println("Stock name :" + sell_symbol);
			System.out.println("Number of shares sold :" + sold_shares);
			System.out.println();
		}

	}
	
		
	
	
	
	
	
}
