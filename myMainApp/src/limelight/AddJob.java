package limelight;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



public class AddJob extends JPanel implements ActionListener{

	private JPanel contentPanel;
	private API myApi;
	
	private JLabel lblYear;
	private JLabel lblMake;
	private JLabel lblModel;
	private JLabel lblCustomerID;
	private JLabel lblSearchCritera;
	
	private JTextField txtSearchCritera;
	private JTextField txtModel;
	private JTextField txtCustName;
	private JTextField txtYear;
	private JTextField txtMake;
	
	private JButton btnSearch;
	private JButton btnAddJob;
	private JButton btnClear;
	private JButton btnCancel;
	
	private JTable displayTable;
	
	private JPanel pnlBorder;
	private JPanel pnlSearchCust;
	private JPanel pnlVehicleInfo;
	private JPanel pnlJobInfo;
	
	private LineBorder roundedLineBorder;
	private TitledBorder roundedTitleBorder;
	private LineBorder roundedLiteLineBorder;
	private TitledBorder roundedLiteTitleBorder;
	private TitledBorder roundedLiteVehicleBorder;
	private TitledBorder roundedLiteJobBorder;
	
	
	private int searchInt;
	private String[] searchChoices = {"", "First Name","Last Name","Email","User ID"};
	//this below can be initalized here
	private String[] columns;
	
	
	//******************************* CONSTRUCTOR *********************************************
	public AddJob(JPanel panel, String name, API myApi) {
		setBackground(Color.WHITE);
		contentPanel = panel;
		name = "Add Job";
		this.myApi = myApi;
		setupPanel();
	}
	
	
	
	
	//************************ SET UP PANEL METHOD ****************************************************
	private void setupPanel() {
		
		//***************Add border objects *****************
		roundedLineBorder = new LineBorder(Color.GRAY, 2, true);
	    roundedTitleBorder = new TitledBorder(roundedLineBorder, "Add New Job");
	    roundedLiteLineBorder = new LineBorder(Color.LIGHT_GRAY, 2, true);
	    roundedLiteTitleBorder = new TitledBorder(roundedLiteLineBorder, "Set Vehicle Owner");
	    roundedLiteVehicleBorder = new TitledBorder(roundedLiteLineBorder, "Set Vehicle Specifications");
	    roundedLiteJobBorder = new TitledBorder(roundedLiteLineBorder, "Job Description");
	    
	    
	  //*************** Set Layout of Add Job Panel *****************
	    GridBagLayout gridBagLayout = new GridBagLayout();
	    gridBagLayout.columnWidths = new int[]{30, 0, 0, 0};
	    gridBagLayout.rowHeights = new int[]{270, 30, 0};
	    gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
	    gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	    setLayout(gridBagLayout);
	    
	    
	  //*************** Place "Add New Job" BorderPanel on AddJobPanel*****************
	    GridBagConstraints gbc_pnlBorder = new GridBagConstraints();
	    gbc_pnlBorder.gridwidth = 3;
	    gbc_pnlBorder.fill = GridBagConstraints.BOTH;
	    gbc_pnlBorder.insets = new Insets(20, 20, 20, 20);
	    gbc_pnlBorder.gridx = 0;
	    gbc_pnlBorder.gridy = 0;
	    
	    
	    GridBagLayout gbl_pnlBorder = new GridBagLayout();
	    gbl_pnlBorder.columnWidths = new int[]{0, 0, 0, 0};
	    gbl_pnlBorder.rowHeights = new int[]{0, 23, 0};
	    gbl_pnlBorder.columnWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0};
	    gbl_pnlBorder.rowWeights = new double[]{Double.MIN_VALUE, 1.0, 0.0};
	    
	    
	    pnlBorder = new JPanel();
	    pnlBorder.setBackground(Color.WHITE);
	    pnlBorder.setLayout(gbl_pnlBorder);
	    this.add(pnlBorder, gbc_pnlBorder);
	    pnlBorder.setBorder(roundedTitleBorder);
	    
	    
	    
	    
	    
	    //************* Search Customer Panel *************************
	    
	    //.....Constraints
	    GridBagConstraints gbc_pnlSearchCust = new GridBagConstraints();
	    gbc_pnlSearchCust.gridx = 0;
	    gbc_pnlSearchCust.gridy = 0;
	    gbc_pnlSearchCust.insets = new Insets(20, 20, 30, 20);
	    gbc_pnlSearchCust.gridwidth = 4;
	    gbc_pnlSearchCust.fill = GridBagConstraints.BOTH;
	    
	    GridBagLayout gbl_pnlSearchCust = new GridBagLayout();
	    gbl_pnlSearchCust.columnWidths = new int[]{31, 60, 0, 0, 0, 0};
	    gbl_pnlSearchCust.rowHeights = new int[]{19, 0, 0};
	    gbl_pnlSearchCust.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	    gbl_pnlSearchCust.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	    
	    
	    //..... Create and Add Search Panel
	    pnlSearchCust = new JPanel();
	    pnlSearchCust.setBackground(Color.WHITE);
	    pnlSearchCust.setBorder(roundedLiteTitleBorder);
	    pnlSearchCust.setLayout(gbl_pnlSearchCust);
	    pnlBorder.add(pnlSearchCust, gbc_pnlSearchCust);
	    
	    
	    //.... Form element constraints (must remain above .add()'s)
	    GridBagConstraints gbc_lblCustName = new GridBagConstraints();
	    gbc_lblCustName.anchor = GridBagConstraints.EAST;
	    gbc_lblCustName.insets = new Insets(20, 10, 10, 5);
	    gbc_lblCustName.gridx = 0;
	    gbc_lblCustName.gridy = 0;
	    
	    GridBagConstraints gbc_txtCustName = new GridBagConstraints();
	    gbc_txtCustName.anchor = GridBagConstraints.WEST;
	    gbc_txtCustName.insets = new Insets(20, 0, 10, 5);
	    gbc_txtCustName.gridx = 1;
	    gbc_txtCustName.gridy = 0;
	    
	    GridBagConstraints gbc_txtSearchCritera = new GridBagConstraints();
	    gbc_txtSearchCritera.anchor = GridBagConstraints.WEST;
	    gbc_txtSearchCritera.insets = new Insets(20, 10, 10, 5);
	    gbc_txtSearchCritera.gridx = 2;
	    gbc_txtSearchCritera.gridy = 0;
	    
	    GridBagConstraints gbc_btnSearch = new GridBagConstraints();
	    gbc_btnSearch.insets = new Insets(20, 15, 10, 10);
	    gbc_btnSearch.gridx = 3;
	    gbc_btnSearch.gridy = 0;
	    
	    
	    //.... Add form elements
		//this will hold search criteria
		lblSearchCritera = new JLabel("Select a Search Type:");
	    pnlSearchCust.add(lblSearchCritera, gbc_lblCustName);
	    
	    //this will be the drop down
	    DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(searchChoices);
	    final JComboBox<String> cboSearchCritera = new JComboBox<String>(comboModel);
	    pnlSearchCust.add(cboSearchCritera, gbc_txtCustName);
	    
	    //this will be the text box for search info
	    txtSearchCritera = new JTextField("");
	    txtSearchCritera.setPreferredSize(new Dimension(100, 25));
	    pnlSearchCust.add(txtSearchCritera, gbc_txtSearchCritera);
	    	    
	    
	    btnSearch = new JButton("Search");
	    pnlSearchCust.add(btnSearch, gbc_btnSearch);
	    

	    JLabel lblCustID = new JLabel("Customer ID:");
	    GridBagConstraints gbc_lblCustID = new GridBagConstraints();
	    gbc_lblCustID.anchor = GridBagConstraints.EAST;
	    gbc_lblCustID.insets = new Insets(25, 0, 20, 5);
	    gbc_lblCustID.gridx = 0;
	    gbc_lblCustID.gridy = 1;
	    pnlSearchCust.add(lblCustID, gbc_lblCustID);
	    
	 //this will display the customerID once selected
	    lblCustomerID = new JLabel(" ");
	    GridBagConstraints gbc_lblCustomerID = new GridBagConstraints();
	    gbc_lblCustomerID.anchor = GridBagConstraints.WEST;
	    gbc_lblCustomerID.insets = new Insets(25, 0, 20, 5);
	    gbc_lblCustomerID.gridx = 1;
	    gbc_lblCustomerID.gridy = 1;
	    pnlSearchCust.add(lblCustomerID, gbc_lblCustomerID);
	    
	  //************* Vehicle Info Panel *************************
	    //.... Places Vehicle Info Panel on AddJob BorderPnl
	    GridBagConstraints gbc_pnlVehicleInfo = new GridBagConstraints();
	    gbc_pnlVehicleInfo.gridwidth = 4;
	    gbc_pnlVehicleInfo.fill = GridBagConstraints.BOTH;
	    gbc_pnlVehicleInfo.insets = new Insets(20, 20, 30, 20);
	    gbc_pnlVehicleInfo.gridx = 0;
	    gbc_pnlVehicleInfo.gridy = 1;
	    
	    //.... Add form elements
	    pnlVehicleInfo = new JPanel();
	    pnlVehicleInfo.setBackground(Color.WHITE);
	    pnlBorder.add(pnlVehicleInfo, gbc_pnlVehicleInfo);
	    pnlVehicleInfo.setBorder(roundedLiteVehicleBorder);
	    GridBagLayout gbl_pnlVehicleInfo = new GridBagLayout();
	    gbl_pnlVehicleInfo.columnWidths = new int[]{25, 73, 28, 73, 31, 73, 0, 0};
	    gbl_pnlVehicleInfo.rowHeights = new int[]{19, 0};
	    gbl_pnlVehicleInfo.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	    gbl_pnlVehicleInfo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	    pnlVehicleInfo.setLayout(gbl_pnlVehicleInfo);
	    
	    lblYear = new JLabel("Year:");
	    GridBagConstraints gbc_lblYear = new GridBagConstraints();
	    gbc_lblYear.anchor = GridBagConstraints.EAST;
	    gbc_lblYear.insets = new Insets(20, 0, 20, 5);
	    gbc_lblYear.gridx = 0;
	    gbc_lblYear.gridy = 0;
	    pnlVehicleInfo.add(lblYear, gbc_lblYear);
	    
	    txtYear = new JTextField(" ");
	    txtYear.setPreferredSize(new Dimension(100, 25));
	    GridBagConstraints gbc_txtYear = new GridBagConstraints();
	    gbc_txtYear.anchor = GridBagConstraints.NORTHWEST;
	    gbc_txtYear.insets = new Insets(20, 0, 20, 20);
	    gbc_txtYear.gridx = 1;
	    gbc_txtYear.gridy = 0;
	    pnlVehicleInfo.add(txtYear, gbc_txtYear);
	    
	    lblMake = new JLabel("Make:");
	    GridBagConstraints gbc_lblMake = new GridBagConstraints();
	    gbc_lblMake.anchor = GridBagConstraints.WEST;
	    gbc_lblMake.insets = new Insets(0, 0, 0, 5);
	    gbc_lblMake.gridx = 2;
	    gbc_lblMake.gridy = 0;
	    pnlVehicleInfo.add(lblMake, gbc_lblMake);
	    
	    txtMake = new JTextField(" ");
	    txtMake.setPreferredSize(new Dimension(100, 25));
	    GridBagConstraints gbc_txtMake = new GridBagConstraints();
	    gbc_txtMake.anchor = GridBagConstraints.NORTHWEST;
	    gbc_txtMake.insets = new Insets(20, 0, 20, 20);
	    gbc_txtMake.gridx = 3;
	    gbc_txtMake.gridy = 0;
	    pnlVehicleInfo.add(txtMake, gbc_txtMake);
	    
	    lblModel = new JLabel("Model:");
	    GridBagConstraints gbc_lblModel = new GridBagConstraints();
	    gbc_lblModel.anchor = GridBagConstraints.WEST;
	    gbc_lblModel.insets = new Insets(0, 0, 0, 5);
	    gbc_lblModel.gridx = 4;
	    gbc_lblModel.gridy = 0;
	    pnlVehicleInfo.add(lblModel, gbc_lblModel);
	    
	    txtModel = new JTextField(" ");
	    txtModel.setPreferredSize(new Dimension(100, 25));
	    GridBagConstraints gbc_txtModel = new GridBagConstraints();
	    gbc_txtModel.insets = new Insets(20, 0, 20, 5);
	    gbc_txtModel.anchor = GridBagConstraints.NORTH;
	    gbc_txtModel.gridx = 5;
	    gbc_txtModel.gridy = 0;
	    pnlVehicleInfo.add(txtModel, gbc_txtModel);
	    
	    
	  //************* Job Description Panel *************************
	    /*
	    //.... Places Job Description Panel on AddJob BorderPnl
	    GridBagConstraints gbc_pnlJobInfo = new GridBagConstraints();
	    gbc_pnlJobInfo.gridwidth = 4;
	    gbc_pnlJobInfo.fill = GridBagConstraints.BOTH;
	    gbc_pnlJobInfo.insets = new Insets(20, 20, 10, 20);
	    gbc_pnlJobInfo.gridx = 0;
	    gbc_pnlJobInfo.gridy = 2;
	    
	    GridBagLayout gbl_pnlJobInfo = new GridBagLayout();
	    gbl_pnlJobInfo.columnWidths = new int[]{59, 49, 54, 54, 300, 0, 0, 0};
	    gbl_pnlJobInfo.rowHeights = new int[]{114, 0, 0, 0, 0, 0, 0};
	    gbl_pnlJobInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    gbl_pnlJobInfo.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    
	    pnlJobInfo = new JPanel();
	    pnlJobInfo.setBackground(Color.WHITE);
	    pnlBorder.add(pnlJobInfo, gbc_pnlJobInfo);
	    pnlJobInfo.setBorder(roundedLiteJobBorder);
	    pnlJobInfo.setLayout(gbl_pnlJobInfo);
	    
	    
	    
	    //.... Job Description Constraints
	    GridBagConstraints gbc_lblDate = new GridBagConstraints();
	    gbc_lblDate.anchor = GridBagConstraints.WEST;
	    gbc_lblDate.insets = new Insets(0, 0, 5, 5);
	    gbc_lblDate.gridx = 1;
	    gbc_lblDate.gridy = 0;
	    
	    GridBagConstraints gbc_txtStartDate = new GridBagConstraints();
	    gbc_txtStartDate.anchor = GridBagConstraints.WEST;
	    gbc_txtStartDate.insets = new Insets(0, 0, 5, 5);
	    gbc_txtStartDate.gridx = 2;
	    gbc_txtStartDate.gridy = 0;
	    
	    GridBagConstraints gbc_lblJobDetails = new GridBagConstraints();
	    gbc_lblJobDetails.anchor = GridBagConstraints.SOUTHWEST;
	    gbc_lblJobDetails.insets = new Insets(0, 0, 5, 5);
	    gbc_lblJobDetails.gridx = 1;
	    gbc_lblJobDetails.gridy = 1;
	    
	    GridBagConstraints gbc_txtJobDetails = new GridBagConstraints();
	    gbc_txtJobDetails.fill = GridBagConstraints.BOTH;
	    gbc_txtJobDetails.gridheight = 5;
	    gbc_txtJobDetails.insets = new Insets(0, 10, 10, 10);
	    gbc_txtJobDetails.gridwidth = 5;
	    gbc_txtJobDetails.anchor = GridBagConstraints.NORTHWEST;
	    gbc_txtJobDetails.gridx = 2;
	    gbc_txtJobDetails.gridy = 1;
	   
	    
	    
	    //.... Add form elements
	    lblDate = new JLabel("Start date:");
	    pnlJobInfo.add(lblDate, gbc_lblDate);
	    
	    txtStartDate = new JTextField("enter start date");
	    pnlJobInfo.add(txtStartDate, gbc_txtStartDate);
	    
	    lblJobDetails = new JLabel("Job Details:");
	    pnlJobInfo.add(lblJobDetails, gbc_lblJobDetails);
	
	    txtJobDetails = new JTextArea("enter job details");
	    txtJobDetails.setBackground(Color.LIGHT_GRAY);
	    txtJobDetails.setRows(10);
	    txtJobDetails.setLineWrap(true);
	    txtJobDetails.setBounds(10, 30, 300, 200);
	    pnlJobInfo.add(txtJobDetails, gbc_txtJobDetails);
	    
	   */
	    
	    
	  //************* Lower Control Buttons *************************
	    btnAddJob = new JButton("Add Job");
	    GridBagConstraints gbc_btnAddJob = new GridBagConstraints();
	    gbc_btnAddJob.anchor = GridBagConstraints.EAST;
	    gbc_btnAddJob.insets = new Insets(0, 0, 0, 5);
	    gbc_btnAddJob.gridx = 0;
	    gbc_btnAddJob.gridy = 1;
	    this.add(btnAddJob, gbc_btnAddJob);
	    
	    btnClear = new JButton("Clear");
	    GridBagConstraints gbc_btnClear = new GridBagConstraints();
	    gbc_btnClear.insets = new Insets(0, 0, 0, 5);
	    gbc_btnClear.gridx = 1;
	    gbc_btnClear.gridy = 1;
	    this.add(btnClear, gbc_btnClear);
	    
	    btnCancel = new JButton("Cancel");
	    GridBagConstraints gbc_btnCancel = new GridBagConstraints();
	    gbc_btnCancel.anchor = GridBagConstraints.WEST;
	    gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
	    gbc_btnCancel.gridx = 2;
	    gbc_btnCancel.gridy = 1;
	    this.add(btnCancel, gbc_btnCancel);
	    
	    
	  //************* Button Listeners *************************
	    btnCancel.addActionListener(this);
		btnAddJob.addActionListener(this);
		btnClear.addActionListener(this);
		
		ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) cboSearchCritera.getSelectedItem();//get the selected item
                
                if (s.isBlank()) {
                	JOptionPane.showMessageDialog(null,"alert", "A search type must be selected.", JOptionPane.ERROR_MESSAGE);
                	
                }

                switch (s) {//check for a match
                    case "First Name":
                        searchInt = 1;
                        break;
                    case "Last Name":
                    	searchInt = 2;
                        break;
                    case "Email":
                    	searchInt = 3;
                        break;
                    case "User ID":
                    	searchInt = 4;
                        break;
                    
                }
            }
        };
        cboSearchCritera.addActionListener(cbActionListener);
        btnSearch.addActionListener(this);
	    
	}//end setupPanel
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnCancel){
			CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
			cardLayout.show(contentPanel, "Home pane");
		}
		
		else if(source == btnSearch){
			try {
				myApi.ViewAllCustomers(txtSearchCritera.getText(), searchInt);
				String myResult = myApi.SendToAPI("viewAllCustomers");
			
			
			
				Object[][] data =  new Object[myApi.getCustomers().size()][14];
				
				for(int i = 0; i < myApi.getCustomers().size(); i++){

			      // update this the only information that is shown is userID, fName, lname, email, and phone number

			         data[i][0] = myApi.getCustomers().get(i).get(0);
			         data[i][1] = myApi.getCustomers().get(i).get(1);
			         data[i][2] = myApi.getCustomers().get(i).get(2);
			         data[i][11] = myApi.getCustomers().get(i).get(11);
			         data[i][3] = myApi.getCustomers().get(i).get(3);    
			      
				}
			   
			   
				columns = new String[] {
		            "User ID", "First Name", "Last Name", "Phone", "Email"
		        };
				
			    displayTable = new JTable();
			    displayTable.setModel(new DefaultTableModel(data, columns));
		        displayTable.setFillsViewportHeight(true);
		        displayTable.setSelectionModel(new ForcedSingleListSelectionModel());
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.fill = GridBagConstraints.BOTH;
		        gbc.anchor = GridBagConstraints.WEST;
		        gbc.gridwidth = 4;
		        gbc.insets = new Insets(0, 0, 5, 5);
		        gbc.gridx = 1;
		        gbc.gridy = 1;
		        
		        JScrollPane scrollPane = new JScrollPane(displayTable);
		        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		        
		        JPanel pnlSelectCustID = new JPanel();
		        
		        pnlSelectCustID.add(scrollPane);

		        

		       
		        Object[] options = {"Add Customer to Job", "Cancel"};
		        
		  /*
		   * Opening an option dialog that allows user to select a customer from search results and
		   * add that customerID to a label to ensure the correct customer in the database is connected to 
		   * the job being added.
		   */
		        int result = JOptionPane.showOptionDialog(null,pnlSelectCustID,"Select Customer", 
		        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
		                null, options, null);
		        
		        if (result == JOptionPane.YES_OPTION){
		            
		        	int selected = displayTable.getSelectedRow();
	                
	                if (selected == -1) {
	                	
	                	JOptionPane.showMessageDialog(null, "A customer must be selected.", "ALERT", JOptionPane.ERROR_MESSAGE);
	                }
	                
	                else {
	                	
	                	String selectedCustomerID = (String) (data[selected][0] = myApi.getCustomers().get(selected).get(0));
	                	lblCustomerID.setText(selectedCustomerID);
	                	
	                	pnlSearchCust.revalidate();
	                	pnlSearchCust.repaint();	
	                }
		        }
		        
			}catch (Exception anyException) {
				
				Object[] newOption = {"Add New Customer", "Cancel"};
				int result = JOptionPane.showOptionDialog(null, "Customer not found. Would you like to add this customer?", "Error!", 
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
		                null, newOption, null);
		        
		        if (result == JOptionPane.YES_OPTION){
		            
		        //need to open add new customer panel
		        	AddCustomer createCustomer = new AddCustomer(contentPanel, "Add Customer", myApi);
		        	createCustomer.getAddJobButtons();
		        	JOptionPane.showOptionDialog(null, createCustomer,"Add New Customer", JOptionPane.DEFAULT_OPTION,
		        			JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
		        	
		        //have a dialog tell user that customer has been added and request them to search and add the newly created customer to the job
		        	JOptionPane.showMessageDialog(null, 
		        			"If new customer has been added sucessfully, please search newly customer to add them to the job.", 
		        			"Message", JOptionPane.INFORMATION_MESSAGE);
		        }
			}
		}
		
		else if(source == btnAddJob){
				if (txtMake.getText().isBlank()) {JOptionPane.showMessageDialog(null, 
						"ERROR: Please enter make of the vehicle.");
						return;
				}
				
				if (txtModel.getText().isBlank()) {JOptionPane.showMessageDialog(null, 
						"ERROR: Please enter model of the vehicle.");
						return;
				}
				
				if (txtYear.getText().isBlank()) {JOptionPane.showMessageDialog(null, 
						"ERROR: Please enter year of the vehicle.");
						return;
				}
				
				if (!lblCustomerID.getText().isBlank()) {
					
					myApi.setCreateJob(
			    			lblCustomerID.getText(), 
			    			txtMake.getText(), 
			    			txtModel.getText(), 
			    			txtYear.getText());
			    	String myResult = myApi.SendToAPI("createJob");
			    			
			    	JOptionPane.showMessageDialog(null, "The job has been created!");
			    			
			    	//clear all fields after add job is selected
			    	lblCustomerID.setText(null);
	    			txtMake.setText(null);
	    			txtModel.setText(null); 
	    			txtYear.setText(null);
				}
				else {
					//show an error message here that a customer must be selected first
					JOptionPane.showMessageDialog(null, "ERROR: A customer must be searched for and added to the job before a job can be created.");
					return;
					
				}
			
			}	
		
		else if(source == btnClear){
			
			// Finish clearing all textFields
			lblCustomerID.setText(null);
			txtMake.setText(null);
			txtModel.setText(null); 
			txtYear.setText(null);
		}
	}
	//******************************** Action Events **********************************
	
	
}//end class
