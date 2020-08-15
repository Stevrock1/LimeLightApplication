package limelight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;




public class MainGUIPanel extends JPanel{
	private JPanel userPanel;
	private JPanel navPanel;
	private JPanel contentPanel;
	private API myApi;
	//user panel 
	private JLabel usersName;
	private JButton btnLogout;
	
	//nav panel 
	private JButton btnAddEmployees;
	private JButton btnViewAllEmployees;
	private JButton btnViewAllCustomers;
	private JButton btnAddCustomer;
	private JButton btnLogHours;
	private JButton btnPayroll;
	private JButton btnAddJob;
	private JButton btnEnterParts;
	private JButton btnCreateInvoice;
	private JButton btnSearchInvoice;
	private JLabel lblEmployeesNav;
	private JLabel lblCustomers;
	private JLabel lblReportingNav;
	private JLabel lblJobsNav;
	private JLabel lblInvoicesNav;
	private JButton btnGetJobInfo;
	
	
	//******************************** Constructor **************************************
	public MainGUIPanel(API myApi, JPanel contentPanel) {
		setBackground(new Color(245, 245, 245));
		this.myApi = myApi;
		this.contentPanel = contentPanel;
		
		/* Will be using this to insert icon images
		
		Get image
		try {
			bImg = ImageIO.read(new File("img/tempLogo.png")); 
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		*/
		
		
		
		//Build Panel
		setupPanel();
	}
	//******************************** Gets / Sets ***************************************************
	
	
	
	
	
	
	//******************************** Methods that builds Panels **************************************
	public void setupPanel() {
		this.setPreferredSize(new Dimension(1366, 768));
		/*Will be using this to insert icon images
		 * 
			lblScaledLogo = new JLabel(new ImageIcon(bImg.getScaledInstance(175,175, Image.SCALE_SMOOTH)));
		*/
		
		
		//Setup Grid for the MainGUIPanel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{311, 700, 0};
		gridBagLayout.rowHeights = new int[]{30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		setLayout(gridBagLayout);
		
		
		
		//Place User, Nav, and Content Panels in MainGUI Grid
		userPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) userPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_userPanel = new GridBagConstraints();
		gbc_userPanel.fill = GridBagConstraints.BOTH;
		gbc_userPanel.gridx = 1;
		gbc_userPanel.gridy = 0;
		this.add(userPanel, gbc_userPanel);
		
		navPanel = new JPanel();
		GridBagConstraints gbc_navPanel = new GridBagConstraints();
		gbc_navPanel.gridheight = 2;
		gbc_navPanel.fill = GridBagConstraints.BOTH;
		gbc_navPanel.gridx = 0;
		gbc_navPanel.gridy = 0;
		this.add(navPanel, gbc_navPanel);
				
		contentPanel.setBackground(UIManager.getColor("CheckBox.background"));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		this.add(contentPanel, gbc_panel);
		
		
		
		// Setup users panel
		setupUserPanel();
		
		
		// Setup Navigation Panel
		setupNavPanel();
		addNavMouseListeners();

		
		
		
	}//end setup Panel Method
	
	
	//******************************** Method that builds User Panel **************************************
	private void setupUserPanel() {
		userPanel.setBackground(new Color(220, 220, 220));
		
		/*
		String helloStr = "Hello, " + myApi.getFirstName() + "!";
		usersName = new JLabel(helloStr);
		userPanel.add(usersName);
		*/
		btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(new Color(128, 0, 0));
		btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnLogout.setBackground(new Color(220, 220, 220));
		userPanel.add(btnLogout);
		
	}
	
	
	
	//******************************** Method that builds Nav Panel ***************************************
	private void setupNavPanel() {
		navPanel.setBackground(new Color(51, 51, 51));
		GridBagLayout gbl_navPanel = new GridBagLayout();
		gbl_navPanel.columnWidths = new int[]{64, 0};
		gbl_navPanel.rowHeights = new int[]{21, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_navPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_navPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		navPanel.setLayout(gbl_navPanel);
		
		
		
		lblEmployeesNav = new JLabel("EMPLOYEES");
		lblEmployeesNav.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblEmployeesNav.setForeground(new Color(192, 192, 192));
		GridBagConstraints gbc_lblEmployeesNav = new GridBagConstraints();
		gbc_lblEmployeesNav.anchor = GridBagConstraints.NORTH;
		gbc_lblEmployeesNav.insets = new Insets(10, 0, 5, 0);
		gbc_lblEmployeesNav.gridx = 0;
		gbc_lblEmployeesNav.gridy = 0;
		navPanel.add(lblEmployeesNav, gbc_lblEmployeesNav);
		GridBagConstraints gbc_separator1 = new GridBagConstraints();
		gbc_separator1.fill = GridBagConstraints.BOTH;
		gbc_separator1.insets = new Insets(0, 5, 5, 0);
		gbc_separator1.gridx = 0;
		gbc_separator1.gridy = 1;
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.LIGHT_GRAY);
		navPanel.add(separator1, gbc_separator1);
		
		btnViewAllEmployees = new JButton("View All Employees");
		btnViewAllEmployees.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnViewAllEmployees.setForeground(new Color(192, 192, 192));
		btnViewAllEmployees.setBackground(new Color(51, 51, 51));
		btnViewAllEmployees.setBorderPainted(false);
		GridBagConstraints gbc_btnViewAllEmployees = new GridBagConstraints();
		gbc_btnViewAllEmployees.fill = GridBagConstraints.BOTH;
		gbc_btnViewAllEmployees.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewAllEmployees.gridx = 0;
		gbc_btnViewAllEmployees.gridy = 2;
		navPanel.add(btnViewAllEmployees, gbc_btnViewAllEmployees);
		
		btnAddEmployees = new JButton("Add Employee");
		btnAddEmployees.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnAddEmployees.setForeground(new Color(192, 192, 192));
		btnAddEmployees.setBackground(new Color(51, 51, 51));
		btnAddEmployees.setBorderPainted(false);
		GridBagConstraints gbc_btnAddEmployees = new GridBagConstraints();
		gbc_btnAddEmployees.fill = GridBagConstraints.BOTH;
		gbc_btnAddEmployees.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddEmployees.gridx = 0;
		gbc_btnAddEmployees.gridy = 3;
		navPanel.add(btnAddEmployees, gbc_btnAddEmployees);
		
		lblCustomers = new JLabel("CUSTOMERS");
		lblCustomers.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblCustomers.setForeground(new Color(192, 192, 192));
		GridBagConstraints gbc_lblCustomers = new GridBagConstraints();
		gbc_lblCustomers.anchor = GridBagConstraints.NORTH;
		gbc_lblCustomers.insets = new Insets(10, 0, 5, 0);
		gbc_lblCustomers.gridx = 0;
		gbc_lblCustomers.gridy = 4;
		navPanel.add(lblCustomers, gbc_lblCustomers);
		GridBagConstraints gbc_separator2 = new GridBagConstraints();
		gbc_separator2.fill = GridBagConstraints.BOTH;
		gbc_separator2.insets = new Insets(0, 5, 5, 0);
		gbc_separator2.gridx = 0;
		gbc_separator2.gridy = 5;
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(Color.LIGHT_GRAY);
		navPanel.add(separator2, gbc_separator2);
		
		btnViewAllCustomers = new JButton("View All Customers");
		btnViewAllCustomers.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnViewAllCustomers.setForeground(new Color(192, 192, 192));
		btnViewAllCustomers.setBackground(new Color(51, 51, 51));
		btnViewAllCustomers.setBorderPainted(false);
		GridBagConstraints gbc_btnViewAllCustomers = new GridBagConstraints();
		gbc_btnViewAllCustomers.fill = GridBagConstraints.BOTH;
		gbc_btnViewAllCustomers.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewAllCustomers.gridx = 0;
		gbc_btnViewAllCustomers.gridy = 6;
		navPanel.add(btnViewAllCustomers, gbc_btnViewAllCustomers);
		
		btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnAddCustomer.setForeground(new Color(192, 192, 192));
		btnAddCustomer.setBackground(new Color(51, 51, 51));
		btnAddCustomer.setBorderPainted(false);
		GridBagConstraints gbc_btnAddCustomer = new GridBagConstraints();
		gbc_btnAddCustomer.fill = GridBagConstraints.BOTH;
		gbc_btnAddCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddCustomer.gridx = 0;
		gbc_btnAddCustomer.gridy = 7;
		navPanel.add(btnAddCustomer, gbc_btnAddCustomer);
		
		lblReportingNav = new JLabel("REPORTING");
		lblReportingNav.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblReportingNav.setForeground(new Color(192, 192, 192));
		GridBagConstraints gbc_lblReportingNav = new GridBagConstraints();
		gbc_lblReportingNav.anchor = GridBagConstraints.NORTH;
		gbc_lblReportingNav.insets = new Insets(10, 0, 5, 0);
		gbc_lblReportingNav.gridx = 0;
		gbc_lblReportingNav.gridy = 8;
		navPanel.add(lblReportingNav, gbc_lblReportingNav);
		
		GridBagConstraints gbc_separator3 = new GridBagConstraints();
		gbc_separator3.fill = GridBagConstraints.BOTH;
		gbc_separator3.insets = new Insets(0, 5, 5, 0);
		gbc_separator3.gridx = 0;
		gbc_separator3.gridy = 9;
		JSeparator separator3 = new JSeparator();
		separator3.setForeground(Color.LIGHT_GRAY);
		navPanel.add(separator3, gbc_separator3);
		
		btnPayroll = new JButton("Payroll");
		btnPayroll.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnPayroll.setForeground(new Color(192, 192, 192));
		btnPayroll.setBackground(new Color(51, 51, 51));
		btnPayroll.setBorderPainted(false);
		GridBagConstraints gbc_btnPayroll = new GridBagConstraints();
		gbc_btnPayroll.fill = GridBagConstraints.BOTH;
		gbc_btnPayroll.insets = new Insets(0, 0, 5, 0);
		gbc_btnPayroll.gridx = 0;
		gbc_btnPayroll.gridy = 10;
		navPanel.add(btnPayroll, gbc_btnPayroll); 
		
		btnLogHours = new JButton("Log Hours");
		btnLogHours.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLogHours.setForeground(new Color(192, 192, 192));
		btnLogHours.setBackground(new Color(51, 51, 51));
		btnLogHours.setBorderPainted(false);
		GridBagConstraints gbc_btnLogHours = new GridBagConstraints();
		gbc_btnLogHours.fill = GridBagConstraints.BOTH;
		gbc_btnLogHours.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogHours.gridx = 0;
		gbc_btnLogHours.gridy = 11;
		navPanel.add(btnLogHours, gbc_btnLogHours);
		
		lblJobsNav = new JLabel("JOBS");
		lblJobsNav.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblJobsNav.setForeground(new Color(192, 192, 192));
		GridBagConstraints gbc_lblJobsNav = new GridBagConstraints();
		gbc_lblJobsNav.anchor = GridBagConstraints.NORTH;
		gbc_lblJobsNav.insets = new Insets(10, 0, 5, 0);
		gbc_lblJobsNav.gridx = 0;
		gbc_lblJobsNav.gridy = 12;
		navPanel.add(lblJobsNav, gbc_lblJobsNav);
		
		GridBagConstraints gbc_separator4 = new GridBagConstraints();
		gbc_separator4.fill = GridBagConstraints.BOTH;
		gbc_separator4.insets = new Insets(0, 5, 5, 0);
		gbc_separator4.gridx = 0;
		gbc_separator4.gridy = 13;
		JSeparator separator4 = new JSeparator();
		separator4.setForeground(Color.LIGHT_GRAY);
		navPanel.add(separator4, gbc_separator4);
		
		btnGetJobInfo = new JButton("Get Job Info");
		btnGetJobInfo.setForeground(Color.LIGHT_GRAY);
		btnGetJobInfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnGetJobInfo.setBorderPainted(false);
		btnGetJobInfo.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnGetJobInfo = new GridBagConstraints();
		gbc_btnGetJobInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetJobInfo.insets = new Insets(0, 0, 5, 0);
		gbc_btnGetJobInfo.gridx = 0;
		gbc_btnGetJobInfo.gridy = 14;
		navPanel.add(btnGetJobInfo, gbc_btnGetJobInfo);
		
		btnAddJob = new JButton("Add Job");
		btnAddJob.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnAddJob.setForeground(new Color(192, 192, 192));
		btnAddJob.setBackground(new Color(51, 51, 51));
		btnAddJob.setBorderPainted(false);
		GridBagConstraints gbc_btnAddJob = new GridBagConstraints();
		gbc_btnAddJob.fill = GridBagConstraints.BOTH;
		gbc_btnAddJob.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddJob.gridx = 0;
		gbc_btnAddJob.gridy = 15;
		navPanel.add(btnAddJob, gbc_btnAddJob);
		
		btnEnterParts = new JButton("Enter Parts");
		btnEnterParts.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnEnterParts.setForeground(new Color(192, 192, 192));
		btnEnterParts.setBackground(new Color(51, 51, 51));
		btnEnterParts.setBorderPainted(false);
		GridBagConstraints gbc_btnEnterParts = new GridBagConstraints();
		gbc_btnEnterParts.fill = GridBagConstraints.BOTH;
		gbc_btnEnterParts.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnterParts.gridx = 0;
		gbc_btnEnterParts.gridy = 16;
		navPanel.add(btnEnterParts, gbc_btnEnterParts);
		
		lblInvoicesNav = new JLabel("INVOICES");
		lblInvoicesNav.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblInvoicesNav.setForeground(new Color(192, 192, 192));
		GridBagConstraints gbc_lblInvoicesNav = new GridBagConstraints();
		gbc_lblInvoicesNav.anchor = GridBagConstraints.NORTH;
		gbc_lblInvoicesNav.insets = new Insets(10, 0, 5, 0);
		gbc_lblInvoicesNav.gridx = 0;
		gbc_lblInvoicesNav.gridy = 17;
		navPanel.add(lblInvoicesNav, gbc_lblInvoicesNav);
		
		GridBagConstraints gbc_separator5 = new GridBagConstraints();
		gbc_separator5.fill = GridBagConstraints.BOTH;
		gbc_separator5.insets = new Insets(0, 5, 5, 0);
		gbc_separator5.gridx = 0;
		gbc_separator5.gridy = 18;
		JSeparator separator5 = new JSeparator();
		separator5.setForeground(Color.LIGHT_GRAY);
		navPanel.add(separator5, gbc_separator5);
		
		btnCreateInvoice = new JButton("Create Invoices");
		btnCreateInvoice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnCreateInvoice.setForeground(new Color(192, 192, 192));
		btnCreateInvoice.setBackground(new Color(51, 51, 51));
		btnCreateInvoice.setBorderPainted(false);
		GridBagConstraints gbc_btnCreateInvoice = new GridBagConstraints();
		gbc_btnCreateInvoice.fill = GridBagConstraints.BOTH;
		gbc_btnCreateInvoice.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateInvoice.gridx = 0;
		gbc_btnCreateInvoice.gridy = 19;
		navPanel.add(btnCreateInvoice, gbc_btnCreateInvoice);
		
		btnSearchInvoice = new JButton("Search Invoice");
		btnSearchInvoice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnSearchInvoice.setForeground(new Color(192, 192, 192));
		btnSearchInvoice.setBackground(new Color(51, 51, 51));
		btnSearchInvoice.setBorderPainted(false);
		GridBagConstraints gbc_btnSearchInvoice = new GridBagConstraints();
		gbc_btnSearchInvoice.fill = GridBagConstraints.BOTH;
		gbc_btnSearchInvoice.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchInvoice.gridx = 0;
		gbc_btnSearchInvoice.gridy = 20;
		navPanel.add(btnSearchInvoice, gbc_btnSearchInvoice);

		
	}//end setup nav panel

	
	
	
	//******************************** Button Listeners ***************************************************
	
	//Listener for logout button, code in MainFrame
	void addLogoutListener(ActionListener listenForLogoutButton){
			         
		btnLogout.addActionListener(listenForLogoutButton);
	}
	
	//Listener for search invoice
	void getSearchInvoice(ActionListener listenForSearchInvoiceButton){
			         
		btnSearchInvoice.addActionListener(listenForSearchInvoiceButton);
	}
	
	
	
	//Listener for Add Employees button 
	void getEmployeePaneListener(ActionListener employeePaneListener){
			         
		btnAddEmployees.addActionListener(employeePaneListener);
	}
	
	//Listener for View All Employees button
	void getViewAllEmployeesPaneListener(ActionListener viewAllEmployeesPaneListener) {
		
		btnViewAllEmployees.addActionListener(viewAllEmployeesPaneListener);
	}
	
	//Listener for View All Employees button
	void getViewAllCustomersPaneListener(ActionListener viewAllCustomersPaneListener) {
		
		btnViewAllCustomers.addActionListener(viewAllCustomersPaneListener);
	}
	
	//Listener for Enter Parts button
		void getEnterPartsListener(ActionListener getEnterPartsListener) {
			
			btnEnterParts.addActionListener(getEnterPartsListener);
		}
	
	//Listener for Add Customers button 
	void getAddCustomerPaneListener(ActionListener customerPaneListener){
			         
		btnAddCustomer.addActionListener(customerPaneListener);
	}
	
	
	//Listener for Get Job Info button 
		void getJobInfoListener(ActionListener getJobInfoListener){
				         
			btnGetJobInfo.addActionListener(getJobInfoListener);
		}
	
	//Listener for Add Jobs button 
	void getAddJobPaneListener(ActionListener addJobPaneListener){
			         
		btnAddJob.addActionListener(addJobPaneListener);
	}
	
	//Listener for Add Hours button 
	void getAddHoursPaneListener(ActionListener addHoursPaneListener) {
		
		btnLogHours.addActionListener(addHoursPaneListener);
	}
	
	//Listener for View Customers button
	void getViewAllCustomersListener(ActionListener viewAllCustomersPaneListener)
	{
		btnViewAllCustomers.addActionListener(viewAllCustomersPaneListener);
	}
	void getInvoicePaneListener(ActionListener invoicePaneListener) {
		btnCreateInvoice.addActionListener(invoicePaneListener);		
	}
	
	
	
	
	//******************************** Nav Mouse Listeners ***************************************************
	private void addNavMouseListeners() {
		
		btnViewAllEmployees.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnViewAllEmployees.setForeground(Color.BLACK);
				btnViewAllEmployees.setBackground(Color.GRAY);
			}
												
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnViewAllEmployees.setBackground(new Color(51, 51, 51));
				btnViewAllEmployees.setForeground(new Color(192, 192, 192));
												}
		});
		
		
		btnAddEmployees.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnAddEmployees.setBackground(Color.GRAY);
				btnAddEmployees.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnAddEmployees.setBackground(new Color(51, 51, 51));
				btnAddEmployees.setForeground(new Color(192, 192, 192));
			}
		});
		
		
		btnViewAllCustomers.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnViewAllCustomers.setBackground(Color.GRAY);
				btnViewAllCustomers.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnViewAllCustomers.setBackground(new Color(51, 51, 51));
				btnViewAllCustomers.setForeground(new Color(192, 192, 192));
			}
		});
		
		
		btnAddCustomer.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnAddCustomer.setBackground(Color.GRAY);
				btnAddCustomer.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnAddCustomer.setBackground(new Color(51, 51, 51));
				btnAddCustomer.setForeground(new Color(192, 192, 192));
			}
		});
		
		
		btnPayroll.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnPayroll.setBackground(Color.GRAY);
				btnPayroll.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnPayroll.setBackground(new Color(51, 51, 51));
				btnPayroll.setForeground(new Color(192, 192, 192));
			}
		});
		
		
		btnLogHours.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnLogHours.setBackground(Color.GRAY);
				btnLogHours.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnLogHours.setBackground(new Color(51, 51, 51));
				btnLogHours.setForeground(new Color(192, 192, 192));
			}
		});
		
		btnGetJobInfo.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnGetJobInfo.setBackground(Color.GRAY);
				btnGetJobInfo.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnGetJobInfo.setBackground(new Color(51, 51, 51));
				btnGetJobInfo.setForeground(new Color(192, 192, 192));
			}
		});
		
		btnAddJob.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnAddJob.setBackground(Color.GRAY);
				btnAddJob.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnAddJob.setBackground(new Color(51, 51, 51));
				btnAddJob.setForeground(new Color(192, 192, 192));
			}
		});
		
		
		btnEnterParts.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnEnterParts.setBackground(Color.GRAY);
				btnEnterParts.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnEnterParts.setBackground(new Color(51, 51, 51));
				btnEnterParts.setForeground(new Color(192, 192, 192));
			}
		});
		
		
		btnCreateInvoice.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnCreateInvoice.setBackground(Color.GRAY);
				btnCreateInvoice.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnCreateInvoice.setBackground(new Color(51, 51, 51));
				btnCreateInvoice.setForeground(new Color(192, 192, 192));
			}
		});
		
		btnSearchInvoice.addMouseListener( new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) { 
				btnSearchInvoice.setBackground(Color.GRAY);
				btnSearchInvoice.setForeground(Color.BLACK);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSearchInvoice.setBackground(new Color(51, 51, 51));
				btnSearchInvoice.setForeground(new Color(192, 192, 192));
			}
		});
		
	}//end add mouse listeners



}//end class
