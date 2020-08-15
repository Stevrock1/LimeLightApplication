package limelight;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCustomer extends JPanel implements ActionListener{

	private JPanel contentPanel;
	private JTextField txtUsername;
	private JTextField txtJobTitle;
	private JTextField txtPassword;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtEmail;
	private JTextField txtCity;
	private JComboBox<String> cbState;
	private JTextField txtZip;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JButton btnAddCust;
	private JButton btnClear;
	private JButton btnReturn;
	private API myApi;
	private GridBagConstraints gbc_btnReturn;

	
	
	
	public AddCustomer(JPanel panel, String name, API myApi) {
		contentPanel = panel;
		name = "Add Customer";
		this.myApi = myApi;
		setupPanel();
		
	}
	
	
	
	private void setupPanel() {
		
		//set panel to GridBagLayout and set Grid
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{125, 125, 125, 125, 125, 125, 0};
		gridBagLayout.rowHeights = new int[]{66, 66, 66, 66, 66, 66, 66, 66};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		
	    
		JLabel lblUsername = new JLabel("Username:");
		txtUsername = new JTextField();
		JLabel lblPassword = new JLabel("Password:");
		txtPassword = new JTextField();
		JLabel lblFName= new JLabel("First name:");
		txtFName = new JTextField();
		JLabel lblLName= new JLabel("Last name:");
		txtLName = new JTextField();
		JLabel lblAddress= new JLabel("Street address:");
		txtAddress = new JTextField();
		JLabel lblCity= new JLabel("City:");
		txtCity = new JTextField();
		
		JLabel lblState= new JLabel("State");
		String[] states = {" ", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", 
				"IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", 
				"NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
		cbState  = new JComboBox(states);
		
		JLabel lblZip= new JLabel("Zipcode:");
		txtZip = new JTextField();
		JLabel lblPhone= new JLabel("Phone number:");
		txtPhone = new JTextField();
		JLabel lblEmail= new JLabel("Email Address:");
		txtEmail = new JTextField();
		btnAddCust = new JButton("Add Customer");
		btnClear = new JButton("Clear Form");
		btnReturn = new JButton("Return Home");
		
		
		
		//set grid constraints
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 1;
				
		GridBagConstraints gbc_lblFName = new GridBagConstraints();
		gbc_lblFName.anchor = GridBagConstraints.EAST;
		gbc_lblFName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFName.gridx = 0;
		gbc_lblFName.gridy = 2;
		
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFName.gridx = 1;
		gbc_txtFName.gridy = 2;
		
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 1;
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;

		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 3;
		
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddress.gridx = 1;
		gbc_txtAddress.gridy = 3;
		gbc_txtAddress.gridwidth = 3;
		
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 4;
		
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity.gridx = 1;
		gbc_txtCity.gridy = 4;
		
		//changing to a dropdown------------------------
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.EAST;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 2;
		gbc_lblState.gridy = 4;
		
		cbState.setMaximumRowCount(5);
		GridBagConstraints gbc_txtState = new GridBagConstraints();
		gbc_txtState.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtState.insets = new Insets(0, 0, 5, 5);
		gbc_txtState.gridx = 3;
		gbc_txtState.gridy = 4;
		
		//changing to a dropdown--------------------------
		GridBagConstraints gbc_lblZip = new GridBagConstraints();
		gbc_lblZip.anchor = GridBagConstraints.EAST;
		gbc_lblZip.insets = new Insets(0, 0, 5, 5);
		gbc_lblZip.gridx = 4;
		gbc_lblZip.gridy = 4;
		
		GridBagConstraints gbc_txtZip = new GridBagConstraints();
		gbc_txtZip.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtZip.insets = new Insets(0, 0, 5, 5);
		gbc_txtZip.gridx = 5;
		gbc_txtZip.gridy = 4;
		
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.EAST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 5;
		
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone.gridx = 1;
		gbc_txtPhone.gridy = 5;
		
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 5;
		
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 5;
		gbc_txtEmail.gridwidth = 3;
		
		GridBagConstraints gbc_btnAddCust = new GridBagConstraints();
		gbc_btnAddCust.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddCust.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddCust.gridx = 1;
		gbc_btnAddCust.gridy = 6;
		
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 3;
		gbc_btnClear.gridy = 6;
		
		gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReturn.insets = new Insets(0, 0, 5, 5);
		gbc_btnReturn.gridx = 5;
		gbc_btnReturn.gridy = 6;
		
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 1;
		
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.gridx = 3;
		gbc_txtPassword.gridy = 1;
		
		GridBagConstraints gbc_lblLName = new GridBagConstraints();
		gbc_lblLName.anchor = GridBagConstraints.EAST;
		gbc_lblLName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLName.gridx = 2;
		gbc_lblLName.gridy = 2;
		
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLName.gridx = 3;
		gbc_txtLName.gridy = 2;
		
		
		
		//Add Elements to pane
		this.add(lblUsername, gbc_lblUsername);
		this.add(txtUsername, gbc_txtUsername);
		this.add(lblPassword, gbc_lblPassword);
		this.add(txtPassword, gbc_txtPassword);
		this.add(lblFName, gbc_lblFName);
		this.add(txtFName, gbc_txtFName);
		this.add(lblLName, gbc_lblLName);
		this.add(txtLName, gbc_txtLName);
		this.add(lblAddress, gbc_lblAddress);
		this.add(txtAddress, gbc_txtAddress);
		this.add(lblEmail, gbc_lblEmail);
		this.add(txtEmail, gbc_txtEmail);
		this.add(lblCity, gbc_lblCity);
		this.add(txtCity, gbc_txtCity);
		this.add(lblState, gbc_lblState);
		this.add(cbState, gbc_txtState);
		this.add(lblZip, gbc_lblZip);
		this.add(txtZip, gbc_txtZip);
		this.add(lblPhone, gbc_lblPhone);
		this.add(txtPhone, gbc_txtPhone);
		
		
		
		//add buttons
		this.add(btnAddCust, gbc_btnAddCust);
		this.add(btnClear, gbc_btnClear);
		this.add(btnReturn, gbc_btnReturn);
		
		
		//Add listeners
		btnReturn.addActionListener(this);
		btnAddCust.addActionListener(this);
		btnClear.addActionListener(this);
		cbState.addActionListener(this);
	}
	
	
	public void getAddJobButtons() {
		btnReturn.setVisible(false);
		this.revalidate();
		this.repaint();

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String selectedState = (String) cbState.getSelectedItem();
		
		if(source == btnReturn)
		{
			CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
			cardLayout.show(contentPanel, "Home pane");
		}
		if(source == btnAddCust)
		{
			if(		   txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtEmail.getText().equals("")
	    			|| txtAddress.getText().equals("") || selectedState.equals("") || txtCity.getText().equals("")
	    			|| txtZip.getText().equals("") || txtFName.getText().equals("") || txtLName.getText().equals("")
	    			|| txtJobTitle.getText().equals("") || txtPhone.getText().equals(""))
	    	{
	    		JOptionPane.showMessageDialog(null, "Please fill out all required fields!");
	    		return;
	    	}
			
			//user name validation
			String userString = txtUsername.getText();
			if (userString.length() > 12 || userString.length() < 6) {
				JOptionPane.showMessageDialog(null, "Username must be between 6 and 12 characters!");
				return;
			}
			//include validation that searches for user name matches within the database
			
			//password validation
			String passString = txtPassword.getText();
			Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,12}$", Pattern.CASE_INSENSITIVE);
			//this will search for passwords with at least 1 lower, upper, digit, special char-TT
			Matcher m = p.matcher(passString);
			if(!(m.find())) {
				JOptionPane.showMessageDialog(null,
						"Password must contain at least 1 digit, lowercase, uppercase and special character");
				return;
			}	
			
			//email validation - done(TT)
    		int emailFlag = 1;
    		String emailString = txtEmail.toString();
    		char[] emailCharArray = emailString.toCharArray();
    		for (char ech : emailCharArray) {
    			if (ech == '@') {
    				emailFlag = 0;
    			}}
    		if (emailFlag == 1) {
    			return;
    		} //this will parse through an email to find an '@' character to determine a valid email
			//address validation
    		
			//stateValidation
    		
    		//if we make state a dropdown menu, we wont have to validate

    		
			//city validation Dont really need validation?
			//zip validation
    		//String zip = "";
    		int zipInt;
    		try {
    		String zip =  txtZip.getText();
    		zipInt = Integer.parseInt(zip);
    		} catch (Exception nfe) {
    			JOptionPane.showMessageDialog(null, "Invalid zipcode.");
    			return;
    		}
    		if (zipInt < 2101 || zipInt > 99524) {
    			JOptionPane.showMessageDialog(null, "Invalid zipcode.");
    			return;
    			
    		}
			//
	    		
	    		myApi.SignUp(
	    		txtFName.getText(),
	    		txtLName.getText(),
	    		txtEmail.getText(),
				txtAddress.getText(),
	    		"Customer",
				txtPassword.getText(),
	    		txtUsername.getText(),
	    		selectedState,
				txtCity.getText(),
				txtZip.getText(),
				txtPhone.getText()
				);
				String myResult = myApi.SendToAPI("signup");
				

				JOptionPane.showMessageDialog(null, myResult);
	    	}
		if(source == btnClear)
		{
			
			txtUsername.setText("");
			txtFName.setText("");
			txtLName.setText("");
			txtAddress.setText("");
			txtCity.setText("");
			cbState.setSelectedIndex(0);
			txtZip.setText("");
			txtPhone.setText("");
			txtPassword.setText("");
			txtEmail.setText("");
		}
	}
}

