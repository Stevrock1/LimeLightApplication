package limelight;

import java.awt.List; 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;


/**
 * Limelite APi.java
 * By Steven Kalis
 * 11/4/2019
 * 
 * Purpose: to allow us to connect to the database and keep that connection
 * as well as not having 7 different posts
 */



public class API {
	
	
	//this will store what we get back from the database
	private String response;
	private String result;
	private String source;
	private HttpResponse<String> request;
	private HttpResponse<User[]> customerInfo;
	private String[] login;
	private String[] signup;
	private String[] currentUser;
	private int[] jobInfo;
	private String[] enterParts;
	private ArrayList<String> invoice; 
	private String userID; 
	private String invoiceID; 
	private String[] viewAllCustomers;
	private Map<String, String> userQuery;
	private ObjectMapper mapper;
	private String inputStream;
	User[] customers;
	User[] employees;
	Job[] jobs;
	Invoice[] invoices;
	ArrayList<ArrayList<String>> customerList;
	ArrayList<ArrayList<String>> employeeList;
	ArrayList<ArrayList<String>> jobList;
	ArrayList<ArrayList<String>> invoiceList;
	private ArrayList<ArrayList<String>> workPerformed;
	private ArrayList<ArrayList<String>> totalInvoiceElements;
	private String customerID, carMake, carModel, carYear;
	private String hours, firstDay, lastDay, jobID;
	
	
	
	
	public API()
	{
		currentUser =  new String[100];
		signup =  new String[13];
		login =  new String[2];
		viewAllCustomers = new String[4];
		enterParts = new String[5];
		jobInfo = new int[2];
		request = null;
		result = "";
		for(int x = 0; x < currentUser.length ;x++)
		{
			currentUser[x] = " ";
		}
	}
	public void Login(String username, String password) 
	{
		// for the login 
		login[0] = username;
		login[1] = password;
	}
	
	public void EnterParts(String jobID, String partID, String quantity, String partName, String description)
	{
		enterParts[0] = jobID;
		enterParts[1] = partID;
		enterParts[2] = quantity;
		enterParts[3] = partName;
		enterParts[4] = description;
	}
	
	public void SignUp(String fName,String lName, String email,String address, String role, String password, String username, String state, String zip, String city, String phone) 
	{
		// for the signup 
		signup[0] = fName;
		signup[1] = lName;
		signup[2] = email;
		signup[3] = address;		
		signup[4] = role;		
		signup[5] = password;
		signup[6] = username;
		signup[7] = state;
		signup[8] = zip;
		signup[9] = city;
		signup[10] = phone;
		signup[11] = null;
		signup[12] = null;
	}
	
	public void setHours(String hours) { 
		this.hours = hours; 
	} 
	
	public void getInvoiceID(String invoiceID) { 
		// for searching invoices 
		this.invoiceID = invoiceID; 
 
	} 
	 
	public void getUserID(String userID) { 
		// for searching invoices 
		this.userID = userID; 
 
	} 
	 
	public void ViewAllCustomers(String searchCriteria, int searchInt)
	{
		
		// --- If the searchInt is a certain number, we're sending a certain field --- //
		if(searchInt == 1)
			viewAllCustomers[0] = searchCriteria;
		else
			viewAllCustomers[0] = null;
		if(searchInt == 2)
			viewAllCustomers[1] = searchCriteria;
		else
			viewAllCustomers[1] = null;
		if(searchInt == 3)
			viewAllCustomers[2] = searchCriteria;
		else
			viewAllCustomers[2] = null;
		if(searchInt == 4)
			viewAllCustomers[3] = searchCriteria;
		else
			viewAllCustomers[3] = null;
		

	}

	public void setInvoiceID(String invoiceID) {
		// for searching invoices
		this.invoiceID = invoiceID;

	}
	
	public void setUserID(String userID) {
		// for searching invoices
		this.userID = userID;
  
	}
	
	public void setCreateInvoice(String fDay, String lDay, String jobID) {
		// for searching invoices
		this.firstDay = fDay;
		this.lastDay = lDay;
		this.jobID = jobID;
  
	}
	
	public void setCreateJob(String customerID, String carMake, String carModel, String carYear) {
		this.customerID= customerID;
		this.carMake= carMake;
		this.carModel= carModel;
		this.carYear= carYear;
	}
	
	public void GetJobInfo(int jobID, int userID) {
		jobInfo[0] = jobID;
		jobInfo[1] = userID;
	}
	 
	 
	public String SendToAPI(String source)
	{
		
		if(source.equals("login"))
		{
			
			
			Unirest.setTimeouts(0, 0);
			try {
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php")
				 .header("Content-Type", "application/x-www-form-urlencoded")
				 .field("request", "login")
				 .field("username",this.login[0].toString())
				 .field("password",this.login[1].toString())
				 .asString();
				response = request.getBody();
				
				
				}
			catch (UnirestException e1)
    			{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Authentication Failed - Try again");
					e1.printStackTrace();
    			}
			
			
		}
		else if(source.equals("enterParts"))
		{
			Unirest.setTimeouts(0, 0);
			try {
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php")
				 .header("Content-Type", "application/x-www-form-urlencoded")
				 .field("request", "addPart")
				 .field("partID",enterParts[0].toString())
				 .field("jobID",enterParts[1].toString())
				 .field("partName",enterParts[2].toString())
				 .field("quantity",enterParts[3].toString())
				 .field("description",enterParts[4].toString())
				 .asString();
				response = request.getBody();
				}
			catch (UnirestException e1)
				{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Authentication Failed - Try again");
				e1.printStackTrace();
				}
		}
		else if(source.equals("signup"))
		{
			Unirest.setTimeouts(0, 0);
			try {
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php")
				 .header("Content-Type", "application/x-www-form-urlencoded")
				 .field("request", "signup")
				 .field("firstName",signup[0].toString())
				 .field("lastName",signup[1].toString())
				 .field("email",signup[2].toString())
				 .field("address",signup[3].toString())
				 .field("role",signup[4].toString())
				 .field("password",signup[5].toString())
				 .field("username",signup[6].toString())
				 .field("state",signup[7].toString())
				 .field("zipcode",signup[8].toString())
				 .field("city",signup[9].toString())
				 .field("phone",signup[10].toString())
				 .field("employeeHours", signup[11])
				 .field("billingRate", signup[12])
				 .asString();
				response = request.getBody();
				}
			catch (UnirestException e1)
				{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Authentication Failed - Try again");
				e1.printStackTrace();
				}
		} else if (source.equals("addHours")) { 
 
			Unirest.setTimeouts(0, 0); 
 
			try { 
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php") 
						.header("Content-Type", "application/x-www-form-urlencoded").field("request", "setHours") 
						.field("employeeHours", hours).asString(); 
				response = request.getBody();
			} catch (UnirestException e1) { 
				JOptionPane.showMessageDialog(null, "Authentication Failed - Try again"); 
				e1.printStackTrace(); 
			}
			}
		
		else if(source.equals("searchInvoiceUserID")) 
		{ 
			Unirest.setTimeouts(0, 0); 
			try { 
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php") 
				 .header("Content-Type", "application/x-www-form-urlencoded") 
				 .field("request", "getInvoice") 
				 .field("userID", userID)
				 .asString(); 
				response = request.getBody(); 
				try {
					
					testJackson(source);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			catch (UnirestException e1) 
				{ 
				// TODO Auto-generated catch block 
				JOptionPane.showMessageDialog(null,"Authentication Failed - Try again"); 
				e1.printStackTrace(); 
				} 
		} 
		 
		else if(source.equals("searchInvoiceID")) {
			
			Unirest.setTimeouts(0, 0);
			try {
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php") 
						 .header("Content-Type", "application/x-www-form-urlencoded") 
						 .field("request", "getInvoice") 
						 .field("invoiceID", invoiceID) 
						 .asString(); 
						response = request.getBody(); 

				try {
					
					testJackson(source);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			}
			catch (UnirestException e1){
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Authentication Failed - Try again");
				e1.printStackTrace();
			} 
			
			
			
		}

		else if(source.equals("createInvoices")) {
			
			Unirest.setTimeouts(0, 0);
			try {
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php") 
						 .header("Content-Type", "application/x-www-form-urlencoded") 
						 .field("request", "getJobMonthDetails") 
						 .field("firstDay", firstDay) 
						 .field("firstDay", lastDay) 
						 .field("firstDay", jobID) 
						 .asString(); 
						response = request.getBody(); 
						System.out.println(response);
				try {
					
					testJackson(source);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			}
			catch (UnirestException e1){
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Authentication Failed - Try again");
				e1.printStackTrace();
			} 
			
			
		}
		
		else if(source.equals("viewAllCustomers"))
		{
			
			Unirest.setTimeouts(0, 0);
			try {
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php")
				 .header("Content-Type", "application/x-www-form-urlencoded")
				 .field("request", "getCustomer")
				 .field("firstName",viewAllCustomers[0])
				 .field("lastName",viewAllCustomers[1])
				 .field("email",viewAllCustomers[2])
				 .field("userID",viewAllCustomers[3])
				 .asString();
				response = request.getBody();
				
				
				try {
					
					testJackson(source);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			catch (UnirestException e1)
			{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Authentication Failed - Try again");
				e1.printStackTrace();
			} 
			
			
			
		}
		
		else if(source.equals("viewAllEmployees"))
		{
			
			Unirest.setTimeouts(0, 0);
			try {
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php")
				 .header("Content-Type", "application/x-www-form-urlencoded")
				 .field("request", "getEmployee")
				 .field("firstName",viewAllCustomers[0])
				 .field("lastName",viewAllCustomers[1])
				 .field("email",viewAllCustomers[2])
				 .field("userID",viewAllCustomers[3])
				 .asString();
				response = request.getBody();
				
				
				try {
					
					testJackson(source);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			catch (UnirestException e1)
				{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Authentication Failed - Try again");
				e1.printStackTrace();
				} 
			
			
			
		}
		
		else if(source.equals("getJobInfo"))
		{
			
			Unirest.setTimeouts(0, 0);
			try {
				request = Unirest.post("https://dev.cis294.hfcc.edu/api.php")
				 .header("Content-Type", "application/x-www-form-urlencoded")
				 .field("request", "getJobInfo")
				 .field("jobID",jobInfo[0])
				 .field("userID",jobInfo[1])
				 .asString();
				response = request.getBody();
				
				
				try {
					
					testJackson(source);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				}
			catch (UnirestException e1)
				{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Authentication Failed - Try again");
				e1.printStackTrace();
				} 
			
			
			
		}
		
		this.isSuccessful(source);
		return result;
		
	}//end of SendToAPI
	
	

	public void isSuccessful(String source) 
	{

		if(source.equals("login")){	

			Scanner s;
			
			if(response.contains("error"))
	    	{
	    		result = "Error - " + response.substring(response.lastIndexOf("error\":\"") + 8,response.length())
	    		.replace('"', ' ').replace('}', ' ').trim();
	    	}
			else {

		    	String role = response.substring(response.lastIndexOf("role\":\"") + 7,
		    				response.length());
		    	role = role.substring(0,role.indexOf('"')).trim();
		    		
		    	if(role.equalsIgnoreCase("customer"))
		    	{
		    			result = "Error - Customers Cannot Log In!";
		    			//return false;
		    	}
		    	else {
		    		result = "Login Successful!";
		    			//set the user information into the array to be retrieved when it's needed
		    		response = response.replaceAll("}", " ").replace("{", " ").replaceAll("\"", " ").trim();
		    			//System.out.println(response);
		    			
		    		s = new Scanner(response);
		    		int i = 0;
		    		s.useDelimiter(",");
		    		while(s.hasNext())
		    		{
		    			this.currentUser[i] = s.next();
		    			System.out.println(currentUser[i]);
		    			i++;
		    		}
		    			 	
		    	}
		    	
	    	}
			//return true;
		}
		
		
		else if(source.equals("signup"))
		{
			if(response.contains("error"))
	    	{
	    		result = "Error - " + response.substring(response.lastIndexOf("error\":\"") + 8,response.length())
	    		.replace('"', ' ').replace('}', ' ').trim();
	    	}
	    	else {
	    		
	    		
	    			result = "Account Created!"; //This message is shown wether or not I have errors 11/9/2019 - TT
	    		
	    	}
		}
		
		else if(source.equals("viewAllCustomers"))
		{
			if(response.contains("error"))
	    	{
	    		result = "Error - " + response.substring(response.lastIndexOf("error\":\"") + 8,response.length())
	    		.replace('"', ' ').replace('}', ' ').trim();
	    	}
	    	else {
	    		result = "Search Created!"; //This message is shown wether or not I have errors 11/9/2019 - TT
	    	}
		}
		else if(source.equals("viewAllEmployees"))
		{
			if(response.contains("error"))
	    	{
	    		result = "Error - " + response.substring(response.lastIndexOf("error\":\"") + 8,response.length())
	    		.replace('"', ' ').replace('}', ' ').trim();
	    	}
	    	else {
	    		
	    		
	    			result = "Search Created!"; //This message is shown wether or not I have errors 11/9/2019 - TT
	    		
	    	}
		}
		else if(source.equals("getJobInfo"))
		{
			if(response.contains("error"))
	    	{
	    		result = "Error - " + response.substring(response.lastIndexOf("error\":\"") + 8,response.length())
	    		.replace('"', ' ').replace('}', ' ').trim();
	    	}
	    	else {
	    		
	    		
	    			result = "Search Created!"; //This message is shown wether or not I have errors 11/9/2019 - TT
	    		
	    	}
		}
			//else
				//return false;
	}
	
	
	
	private void testJackson(String source) throws IOException {  
	    ObjectMapper mapper = new ObjectMapper(); 
	    StringWriter stringEmp = new StringWriter();
	    if(!response.contains("error"))
    	{
	    if(source.equals("viewAllCustomers"))
	    {
	    	customers = mapper.readValue(response, User[].class);
	    
	  
	    
	    	mapper.writeValue(stringEmp, customers);
	    	customerList = new ArrayList<>(customers.length);
	    
	    	for(int i = 0; i < customers.length; i++)
	    	{
	    		customerList.add(new ArrayList());
	    	}
	    
	    	for (int i = 0; i < customers.length; i++) {
	    		customerList.get(i).add(customers[i].getUserID());
	    		customerList.get(i).add(customers[i].getFirstName());
	    		customerList.get(i).add(customers[i].getLastName());
	    		customerList.get(i).add(customers[i].getEmail());
	    		customerList.get(i).add(customers[i].getAddress());
	    		customerList.get(i).add(customers[i].getRole());
	    		customerList.get(i).add(customers[i].getPassword());
	    		customerList.get(i).add(customers[i].getUsername());
	    		customerList.get(i).add(customers[i].getState());
	    		customerList.get(i).add(customers[i].getZip());
	    		customerList.get(i).add(customers[i].getCity());
	    		customerList.get(i).add(customers[i].getPhoneNumber());
	    		customerList.get(i).add(customers[i].getEmployeeHours());
	    		customerList.get(i).add(customers[i].getBillingRate());	
	    	
	    		}
	    }
	    
	    if(source.equals("viewAllEmployees"))
	    {
	    	employees = mapper.readValue(response, User[].class);
	    
	  
	    
	    	mapper.writeValue(stringEmp, employees);
	    	employeeList = new ArrayList<>(employees.length);
	    
	    	for(int i = 0; i < employees.length; i++)
	    	{
	    		employeeList.add(new ArrayList());
	    	}
	    
	    	for (int i = 0; i < employees.length; i++) {
	    		employeeList.get(i).add(employees[i].getUserID());
	    		employeeList.get(i).add(employees[i].getFirstName());
	    		employeeList.get(i).add(employees[i].getLastName());
	    		employeeList.get(i).add(employees[i].getEmail());
	    		employeeList.get(i).add(employees[i].getAddress());
	    		employeeList.get(i).add(employees[i].getRole());
	    		employeeList.get(i).add(employees[i].getPassword());
	    		employeeList.get(i).add(employees[i].getUsername());
	    		employeeList.get(i).add(employees[i].getState());
	    		employeeList.get(i).add(employees[i].getZip());
	    		employeeList.get(i).add(employees[i].getCity());
	    		employeeList.get(i).add(employees[i].getPhoneNumber());
	    		employeeList.get(i).add(employees[i].getEmployeeHours());
	    		employeeList.get(i).add(employees[i].getBillingRate());

	    	}
	    }
	    
	    if(source.equals("getJobInfo"))
	    {
	    	jobs = mapper.readValue(response, Job[].class);

		    mapper.writeValue(stringEmp, jobs);
		    jobList = new ArrayList<>(jobs.length);
		    
		    for(int i = 0; i < jobs.length; i++)
		    {
		    	jobList.add(new ArrayList());
		    }
		    
		    for (int i = 0; i < jobs.length; i++) {
		    	jobList.get(i).add(jobs[i].getUserID());
		    	jobList.get(i).add(jobs[i].getJobID());
		    	jobList.get(i).add(jobs[i].getCarMake());
		    	jobList.get(i).add(jobs[i].getCarModel());
		    	jobList.get(i).add(jobs[i].getCarYear());
		    	jobList.get(i).add(jobs[i].getTotalJobHours());
		    	jobList.get(i).add(jobs[i].getJobStatus());
		    	jobList.get(i).add(jobs[i].getWorkers());

		    }
	    }
	    
	    if(source.equals("searchInvoiceID"))
	    {
	    	StringWriter stringInv = new StringWriter();
	    	invoices = mapper.readValue(response, Invoice[].class);

	    	mapper.writeValue(stringInv, invoices);
	    	invoiceList = new ArrayList<>(invoices.length);
	    	totalInvoiceElements = new ArrayList<>(invoices.length);
	    	
	    	
	    	for(int i = 0; i < invoices.length; i++)
	    	{
	    		invoiceList.add(new ArrayList<>());
	    		totalInvoiceElements.add(new ArrayList<>());
	    	}
	    
	    	for (int i = 0; i < invoices.length; i++) {
	    		totalInvoiceElements.get(i).add(invoices[i].getInvoiceID());
	    		invoiceList.get(i).add(invoices[i].getInvoiceID());
	    		invoiceList.get(i).add(invoices[i].getJobID());
	    		invoiceList.get(i).add(invoices[i].getInvoiceTotal());
	    		invoiceList.get(i).add(invoices[i].getInvoiceDate());
	    		
	    		//get work performed
	    		for (int x = 0; x < invoices[i].getWorkPerformed().size(); x++) {
	    			totalInvoiceElements.get(i).add(Integer.toString(invoices[i].getWorkPerformed().size()));
	    			invoiceList.get(i).add(invoices[i].getWorkPerformed().get(x).getCustomerID());
	    			invoiceList.get(i).add(invoices[i].getWorkPerformed().get(x).getCarMake());
	    			invoiceList.get(i).add(invoices[i].getWorkPerformed().get(x).getCarModel());
	    			invoiceList.get(i).add(invoices[i].getWorkPerformed().get(x).getCarYear());
	    			invoiceList.get(i).add(invoices[i].getWorkPerformed().get(x).getTotalJobHours());
	    			
	    		}
	    		
	    		//get part information
	    		for (int y = 0; y < invoices[i].getParts().size(); y++) {
	    			totalInvoiceElements.get(i).add(Integer.toString(invoices[i].getParts().size()));
	    			invoiceList.get(i).add(invoices[i].getParts().get(y).getPartID());
	    			invoiceList.get(i).add(invoices[i].getParts().get(y).getPartName());
	    			invoiceList.get(i).add(invoices[i].getParts().get(y).getDescription());
	    			invoiceList.get(i).add(invoices[i].getParts().get(y).getQuantity());
	    			invoiceList.get(i).add(invoices[i].getParts().get(y).getPartPrice());
	    		}
	    		
	    	
	    	}
	    }
    	}
		
	}//end test Jackson
	
	
	
	 
	
 
     
	
	
	
	public String getUserID() {
		currentUser[0] = currentUser[0].replace("userID :", " ").trim();
		return currentUser[0];}
	public String getFirstName() {
		currentUser[1] = currentUser[1].replace(" firstName :", " ").trim();
		return currentUser[1];}
	public String getLastName() {
		currentUser[2] = currentUser[2].replace(" lastName :", " ").trim();
		return currentUser[2];}
	public String getEmail() {
		currentUser[3] = currentUser[3].replace(" email :", " ").trim();
		return currentUser[3];}
	public String getPhone() {
		currentUser[4] = currentUser[4].replace(" phone :", " ").trim();
		return currentUser[4];}
	public String getAddress() {
		currentUser[5] = currentUser[5].replace(" address :", " ").trim();
		return currentUser[5];}
	public String getRole() {
		currentUser[6] = currentUser[6].replace(" role :", " ").trim();
		return currentUser[6];}
	public String getUsername() {
		currentUser[8] = currentUser[8].replace(" username :", " ").trim();
		return currentUser[8];}
	public String getCity() {
		currentUser[9] = currentUser[9].replace(" city :", " ").trim();
		return currentUser[9];}
	public String getState() {
		currentUser[10] = currentUser[10].replace(" state :", " ").trim();
		return currentUser[10];}
	public String getZip() {
		currentUser[11] = currentUser[11].replace(" zipcode :", " ").trim();
		return currentUser[11];}
	public String getEmployeeHours() {
		currentUser[12] = currentUser[12].replace(" employeeHours :", " ").trim();
		return currentUser[12];}
	public String getBillingRate() {
		currentUser[13] = currentUser[13].replace(" billingRate :", " ").trim();
		return currentUser[13];}
	
	
	public ArrayList<ArrayList<String>> getInvoice() {return invoiceList;}
	public ArrayList<ArrayList<String>> getTotalInvoiceElements() {return totalInvoiceElements;}
	
	
	public ArrayList<ArrayList<String>> getCustomers() {
		
			return customerList;
		
	}
	
	public ArrayList<ArrayList<String>> getEmployees() {
		
		return employeeList;
		
	
}
	
	public ArrayList<ArrayList<String>> getJobs() {
		
		return jobList;
	
}
	
	
	
}


