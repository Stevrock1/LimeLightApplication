package limelight;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JPanel;


public class LimeLightController {
	
	private API myApi;
	private MainGUIPanel mainPanel;
	private JPanel contentPanel;
	private HomePane homePane;
	private EmployeePane employeePane;
	private AddJob addJob;
	private AddCustomer addCustomer;
	private HoursPane hoursPane;
	private String source;
	private SearchInvoice searchInvoice;
	private ViewCustomers viewCustomers;
	private ViewCustomers viewEmployees;
	private GetJobInfo getJobInfo;
	private InvoicePane invoicePane;
	private EnterParts enterParts;
	
	public LimeLightController(API myApi, MainGUIPanel mainPanel, JPanel contentPanel,
			HomePane homePane, EmployeePane employeePane, AddJob addJob, AddCustomer addCustomer,
					HoursPane hoursPane, SearchInvoice searchInvoice, ViewCustomers viewCustomers,
					ViewCustomers viewEmployees, GetJobInfo getJobInfo, InvoicePane invoicePane, EnterParts enterParts) {
		
			this.myApi = myApi;
			this.mainPanel = mainPanel;
			this.contentPanel = contentPanel;
			this.homePane = homePane;
			this.employeePane = employeePane;
			this.addJob = addJob;
			this.addCustomer = addCustomer;
			this.hoursPane = hoursPane;
			this.searchInvoice = searchInvoice;
			this.viewCustomers = viewCustomers;
			this.viewEmployees = viewEmployees;
			this.getJobInfo = getJobInfo;
			this.invoicePane = invoicePane;
			this.enterParts = enterParts;
			
			
			
			//MainGUIPanel Listeners
			this.mainPanel.getEmployeePaneListener(new GetEmployeePaneListener(this));
			this.mainPanel.getAddCustomerPaneListener(new GetAddCustomerPaneListener(this));
			this.mainPanel.getAddJobPaneListener(new GetAddJobPaneListener(this));
			this.mainPanel.getAddHoursPaneListener(new GetAddHoursPaneListener(this));
			this.mainPanel.getViewAllCustomersListener(new GetViewAllCustomersListener(this));
			this.mainPanel.getViewAllEmployeesPaneListener(new GetViewAllEmployeesListener(this));
			this.mainPanel.getJobInfoListener(new GetJobInfoListener(this));
			this.mainPanel.getInvoicePaneListener(new GetInvoicePaneListener(this));
			this.mainPanel.getEnterPartsListener(new GetEnterPartsListener(this));

			
			//CustomerPane
			//this.addCustomer.getHomePane(new GetHomePane(this));

			
			//HomePane Listeners
			
			
			//EmployeePane Listeners
			//this.employeePane.goToHomePaneListener(new GoToHomePaneListener(this));
			
			//Search Invoice
			this.mainPanel.getSearchInvoice(new GetSearchInvoice(this));
		
	}//end constructor
	
	public JPanel getContentPanel() {return contentPanel;};
	
	
	
}//end class


class GetSearchInvoice implements ActionListener {
	

	private LimeLightController limeLightController;
	
	public GetSearchInvoice(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "Search Invoice");
	}
} //end class




class GetHomePane implements ActionListener {
	

	private LimeLightController limeLightController;
	
	public GetHomePane(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "Home Pane");
	}
} //end class




class GoToHomePaneListener implements ActionListener{
	
	private LimeLightController limeLightController;
	
	public GoToHomePaneListener(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "Home Pane");
	}
	
	
		
	}//end class




class GetEmployeePaneListener implements ActionListener{
	
	private LimeLightController limeLightController;
	
	public GetEmployeePaneListener(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "Employee pane");
	}
	
	
		
	}//end class






class GetAddCustomerPaneListener implements ActionListener{
	
	private LimeLightController limeLightController;
	
	public GetAddCustomerPaneListener(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "Add Customer");
	}
	
	
		
}//end class

class GetJobInfoListener implements ActionListener{
	
	private LimeLightController limeLightController;
	
	public GetJobInfoListener(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "Get Job Info");
	}
} 

class GetAddJobPaneListener implements ActionListener{
	
	private LimeLightController limeLightController;
	
	public GetAddJobPaneListener(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "Add Job");
	}
} 
	

class GetAddHoursPaneListener implements ActionListener {
		

		private LimeLightController limeLightController;
		
		public GetAddHoursPaneListener(LimeLightController limeLightController) {
			this.limeLightController = limeLightController;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel contentPanel;
			
			contentPanel = limeLightController.getContentPanel();
			
			CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
			cardLayout.show(contentPanel, "Hours Pane");
		}
	} //end class

class GetViewAllCustomersListener implements ActionListener {
private LimeLightController limeLightController;
	
	public GetViewAllCustomersListener(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "View All Customers");
	}
}

class GetViewAllEmployeesListener implements ActionListener {
private LimeLightController limeLightController;
	
	public GetViewAllEmployeesListener(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "View All Employees");
	}
}
class GetInvoicePaneListener implements ActionListener {
	
	private LimeLightController limeLightController;
	
	public GetInvoicePaneListener(LimeLightController limeLightController) {
		this.limeLightController = limeLightController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel contentPanel;
		
		contentPanel = limeLightController.getContentPanel();
		
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "Invoice Pane");
	}
}

	class GetEnterPartsListener implements ActionListener {
		
		private LimeLightController limeLightController;
		
		public GetEnterPartsListener(LimeLightController limeLightController) {
			this.limeLightController = limeLightController;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel contentPanel;
			
			contentPanel = limeLightController.getContentPanel();
			
			CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
			cardLayout.show(contentPanel, "Enter Parts");
		}

	
} //end class
	

