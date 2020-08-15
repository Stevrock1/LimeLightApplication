package limelight;

import java.awt.CardLayout;

import javax.swing.JPanel;

/*
 * Limelight application
 * by Steven Kalis
 * Heather Garske
 * Raymond Grabowski
 * 
 */

public class MainApp {
	
	
	
	//************************ Main method *************************************************
		public static void main(String[] args)throws Exception{
			
			//create API object
			API myApi = new API();
			
			
		    JPanel contentPanel = new JPanel();
		    contentPanel.setLayout(new CardLayout(0, 0));
		    HomePane homePane = new HomePane(contentPanel, "Home pane", myApi);
		    EmployeePane employeePane = new EmployeePane(contentPanel, "Employee pane", myApi);
		    AddCustomer addCustomer = new AddCustomer(contentPanel, "Add Customer", myApi);
		    GetJobInfo getJobInfo = new GetJobInfo(contentPanel, "Get Job Info", myApi);
		    AddJob addJob = new AddJob(contentPanel, "Add Job", myApi);
		    HoursPane hoursPane = new HoursPane(contentPanel, "Hours Pane", myApi);
		    SearchInvoice searchInvoice = new SearchInvoice(contentPanel, "Search Invoice", myApi);
		    InvoicePane invoicePane = new InvoicePane(contentPanel, "Invoice Pane", myApi);
		    ViewCustomers viewAllCustomers = new ViewCustomers(contentPanel, "View All Customers", myApi);
		    ViewCustomers viewAllEmployees = new ViewCustomers(contentPanel, "View All Employees", myApi);
		    EnterParts enterParts = new EnterParts(contentPanel, "Enter Parts", myApi);
			contentPanel.add(homePane, "Home pane");
			contentPanel.add(employeePane, "Employee pane");
			contentPanel.add(addCustomer, "Add Customer");
			contentPanel.add(getJobInfo, "Get Job Info");
			contentPanel.add(addJob, "Add Job");
			contentPanel.add(hoursPane, "Hours Pane");
			contentPanel.add(searchInvoice, "Search Invoice");
			contentPanel.add(invoicePane, "Invoice Pane");
			contentPanel.add(viewAllCustomers, "View All Customers");
			contentPanel.add(viewAllEmployees, "View All Employees");
			contentPanel.add(enterParts, "Enter Parts");
			
			//Create Login to Main Panels
		    LoginPanel loginPanel = new LoginPanel();
		    MainGUIPanel mainPanel = new MainGUIPanel(myApi, contentPanel);
		    MainFrame mainFrame = new MainFrame(myApi, loginPanel, mainPanel);
		    
		    //Add limeLightController
		    
		   LimeLightController limeLightController = new LimeLightController(myApi, mainPanel, contentPanel, homePane, employeePane, 
				   												addJob, addCustomer, hoursPane, searchInvoice,viewAllCustomers,
				   												viewAllEmployees,getJobInfo, invoicePane, enterParts);
		    
			
			//Start Login
			mainFrame.getLoginFrame();
			mainFrame.getRootPane().setDefaultButton(loginPanel.getBtnLogin());
			loginPanel.getTxtUsername().requestFocusInWindow();
			
			/*
			 * We need a way to send the api in the MainFrame through the app, because that has the information in it!
			 * 
			 */
			
			
			
			
		}//end Main Method
		
		


}