package limelight;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.UIManager;

public class SearchInvoice extends JPanel implements ActionListener{
	private JPanel contentPanel;
	private JPanel searchPanel;
	private JPanel displayPanel;
	private JScrollPane displayScroll;
	private API myApi;
	
	private JTextField txtInvoiceID;
	private JTextField txtUserID;
	private JButton search;
	private ArrayList<ArrayList<String>> invoiceList;
	private ArrayList<ArrayList<String>> totalInvoiceElements;
	private JLabel lblInvoice;
	private int gridColumn= 0;
	private int gridRow= 0;
	private JButton btnSavetoFile;
	private String parts;
	private String format;
	
	//******************************* CONSTRUCTOR *********************************************
	public SearchInvoice(JPanel panel, String name, API myApi) {
		setBackground(UIManager.getColor("Button.background"));
		contentPanel = panel;
		name = "Search Invoice";
		this.myApi = myApi;
		
		
		setupSearchPanel();
		//setupDisplayPanel();
	}
	
	
	private void setupSearchPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0};
		gridBagLayout.rowHeights = new int[]{300, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
        searchPanel = new JPanel();
        GridBagConstraints gbc_searchPanel = new GridBagConstraints();
        gbc_searchPanel.insets = new Insets(0, 0, 5, 0);
        gbc_searchPanel.fill= GridBagConstraints.BOTH;
        gbc_searchPanel.gridx = 0;
        gbc_searchPanel.gridy = 0;
        this.add(searchPanel, gbc_searchPanel);
        GridBagLayout gbl_searchPanel = new GridBagLayout();
        gbl_searchPanel.columnWidths = new int[]{50, 100, 125, 100, 100, 125, 0};
        gbl_searchPanel.rowHeights = new int[]{21, 0, 0, 300, 0, 0};
        gbl_searchPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        gbl_searchPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        searchPanel.setLayout(gbl_searchPanel);
        
        JLabel lblSearchInvoiceID = new JLabel("Invoice ID:");
        GridBagConstraints gbc_lblSearchInvoiceID = new GridBagConstraints();
        gbc_lblSearchInvoiceID.anchor = GridBagConstraints.EAST;
        gbc_lblSearchInvoiceID.insets = new Insets(20, 0, 5, 5);
        gbc_lblSearchInvoiceID.gridx = 1;
        gbc_lblSearchInvoiceID.gridy = 0;
        searchPanel.add(lblSearchInvoiceID, gbc_lblSearchInvoiceID);
        
        txtInvoiceID = new JTextField("");
        GridBagConstraints gbc_txtLastName = new GridBagConstraints();
        gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLastName.anchor = GridBagConstraints.WEST;
        gbc_txtLastName.insets = new Insets(20, 0, 5, 5);
        gbc_txtLastName.gridx = 2;
        gbc_txtLastName.gridy = 0;
        searchPanel.add(txtInvoiceID, gbc_txtLastName);
        
        JLabel lblOr = new JLabel("-OR-");
        GridBagConstraints gbc_lblOr = new GridBagConstraints();
        gbc_lblOr.insets = new Insets(20, 0, 5, 5);
        gbc_lblOr.gridx = 3;
        gbc_lblOr.gridy = 0;
        searchPanel.add(lblOr, gbc_lblOr);
        
        JLabel lblSearchUserID = new JLabel("User ID:");
        GridBagConstraints gbc_lblSearchUserID = new GridBagConstraints();
        gbc_lblSearchUserID.anchor = GridBagConstraints.EAST;
        gbc_lblSearchUserID.insets = new Insets(20, 0, 5, 5);
        gbc_lblSearchUserID.gridx = 4;
        gbc_lblSearchUserID.gridy = 0;
        searchPanel.add(lblSearchUserID, gbc_lblSearchUserID);
        
        txtUserID = new JTextField("");
        GridBagConstraints gbc_txtUserID = new GridBagConstraints();
        gbc_txtUserID.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtUserID.insets = new Insets(20, 0, 5, 5);
        gbc_txtUserID.gridx = 5;
        gbc_txtUserID.gridy = 0;
        searchPanel.add(txtUserID, gbc_txtUserID);
        
        search = new JButton("Search");
        GridBagConstraints gbc_search = new GridBagConstraints();
        gbc_search.fill = GridBagConstraints.HORIZONTAL;
        gbc_search.insets = new Insets(20, 10, 5, 5);
        gbc_search.anchor = GridBagConstraints.NORTHWEST;
        gbc_search.gridx = 3;
        gbc_search.gridy = 1;
        searchPanel.add(search, gbc_search);
        
        displayPanel = new JPanel();
        displayPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc_displayPanel = new GridBagConstraints();
        gbc_displayPanel.fill = GridBagConstraints.BOTH;
        gbc_displayPanel.insets = new Insets(20, 10, 5, 5);
        gbc_displayPanel.gridwidth = 5; 
        gbc_displayPanel.gridx = 1;
        gbc_displayPanel.gridy = 3;
        displayScroll = new JScrollPane(displayPanel);
        GridBagLayout gbl_displayPanel = new GridBagLayout();
        gbl_displayPanel.columnWidths = new int[]{0};
        gbl_displayPanel.rowHeights = new int[]{0};
        gbl_displayPanel.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_displayPanel.rowWeights = new double[]{Double.MIN_VALUE};
        displayPanel.setLayout(gbl_displayPanel);
        displayScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        searchPanel.add(displayScroll, gbc_displayPanel);
        
        btnSavetoFile = new JButton("Save to File");
        GridBagConstraints gbc_btnSavetoFile = new GridBagConstraints();
        gbc_btnSavetoFile.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnSavetoFile.insets = new Insets(20, 10, 5, 5);
        gbc_btnSavetoFile.gridwidth = 1; 
        gbc_btnSavetoFile.gridx = 4;
        gbc_btnSavetoFile.gridy = 4;
        
        
        //add button listeners
        search.addActionListener(this);
        
        
        myApi.SendToAPI("getAllInvoices");
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		//******************************* Search User ID Invoices *************************************
		if(source == search)
		{
	    		
	    		if (!txtUserID.getText().isEmpty()) {
	    			myApi.setUserID(txtUserID.getText());
	    			String myResult = myApi.SendToAPI("searchInvoiceUserID");
	    			//System.out.println(myResult);
				
	    			JOptionPane.showMessageDialog(null, myResult);
	    			
	    			//clear after search is complete so another search can be performed
	    			txtUserID.setText(null);
	    		}
	    		else if (!txtInvoiceID.getText().isEmpty()) {
	    			myApi.setInvoiceID(txtInvoiceID.getText());
	    			String myResult = myApi.SendToAPI("searchInvoiceID");
	    			//System.out.println(myResult);
				
	    			JOptionPane.showMessageDialog(null, "Invoice has been found.");
	    			
	    			//clear after search is complete so another search can be performed
	    			txtInvoiceID.setText(null);
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Please search by searching a User ID or an Invoice ID.");
	    		}
	    	}
		
		
		/*get invoice data from API.java
		* that way we can create JLabels to hold the 
		* data and add it to the display panel.
		*/
			invoiceList = myApi.getInvoice();
			totalInvoiceElements = myApi.getTotalInvoiceElements();
			System.out.println(totalInvoiceElements.get(0).toString());
			System.out.println(invoiceList);
		

			/*
			 * this loop will get multiple invoices
			 */
			for(int i = 0; i < invoiceList.size(); i++) {
				//get number of workPerformed and number of parts for formatting

				String work = totalInvoiceElements.get(i).get(i+1);
				int numOfWorkEntries = Integer.parseInt(work);
				String parts = totalInvoiceElements.get(i).get(i+2);
				int numOfParts = Integer.parseInt(parts);
			
		
				setupDisplay("Invoice ID:");
	    		setupDisplay(invoiceList.get(i).get(0)); //InvoiceID
	    		setupDisplay("Job ID:");
	    		setupDisplay(invoiceList.get(i).get(1)); //JobID
	    		setupDisplay("Invoice Total:");
	    		setupDisplay(invoiceList.get(i).get(2)); //InvoiceTotal
	    		setupDisplay("Invoice Date:");
	    		setupDisplay(invoiceList.get(i).get(3)); //InvoiceDate
	    		
	    		//get work performed
	    		setupDisplay("Customer ID:");
	    		setupDisplay(invoiceList.get(i).get(4)); //CustomerID
	    		setupDisplay("Car Make: ");
	    		setupDisplay(invoiceList.get(i).get(5));	//CarMake
	    		setupDisplay("Car Model:");
	    		setupDisplay(invoiceList.get(i).get(6)); //CarModel
	    		setupDisplay("Car Year: ");
	    		setupDisplay(invoiceList.get(i).get(7)); //CarYear
	    		setupDisplay("Total Labor Hours:");
	    		setupDisplay(invoiceList.get(i).get(8)); //TotalJobHours
	    		
	    		
	    		if (numOfWorkEntries > 1) {
	    			int indexRef = numOfWorkEntries * 5 + 8;
	    			
	    			//get part information
	    			for (int y = 0; y < numOfParts; y++) {
	    				setupDisplay("Part ID:");
	    				setupDisplay(invoiceList.get(i).get(indexRef));	//PartID
	    				setupDisplay("Part Name:");
	    				setupDisplay(invoiceList.get(i).get(indexRef++)); //PartName
	    				setupDisplay("Part Description: ");
	    				setupDisplay(invoiceList.get(i).get(indexRef++));	//PartDescription
	    				setupDisplay("Part Quantity: ");
	    				setupDisplay(invoiceList.get(i).get(indexRef++)); 	//Quantity
	    				setupDisplay("Part Price: ");
	    				setupDisplay(invoiceList.get(i).get(indexRef++));	//PartPrice
	    			}
	    		}
	    		else {
	    			
	    			for (int y = 0; y < numOfParts; y++) {
	    				setupDisplay("Part ID:");
	    				setupDisplay(invoiceList.get(i).get(9+y));	//PartID
	    				setupDisplay("Part Name:");
	    				setupDisplay(invoiceList.get(i).get(10+y)); //PartName
	    				setupDisplay("Part Description: ");
	    				setupDisplay(invoiceList.get(i).get(11+y));	//PartDescription
	    				setupDisplay("Part Quantity: ");
	    				setupDisplay(invoiceList.get(i).get(12+y)); 	//Quantity
	    				setupDisplay("Part Price: ");
	    				setupDisplay(invoiceList.get(i).get(13+y));	//PartPrice
	    			}
	    			
	    			
	    		}
	    	}
	    	
			//add btn SaveToFile
			this.add(btnSavetoFile);
			btnSavetoFile.addActionListener(this);
			
			//reload displayPanel to show added invoice information
			this.validate();
			this.repaint();
			
		
			
			
			if(source == btnSavetoFile){
				/*
				for(int i = 0; i < invoiceList.size(); i++) {
					//get number of workPerformed and number of parts for formatting
					String work = totalInvoiceElements.get(i).get(i+1);
					int numOfWorkEntries = Integer.parseInt(work);
					String parts = totalInvoiceElements.get(i).get(i+2);
					int numOfParts = Integer.parseInt(parts);
					
			
					setupDisplay("Invoice ID:");
		    		setupDisplay(invoiceList.get(i).get(0)); //InvoiceID
		    		setupDisplay("Job ID:");
		    		setupDisplay(invoiceList.get(i).get(1)); //JobID
		    		setupDisplay("Invoice Total:");
		    		setupDisplay(invoiceList.get(i).get(2)); //InvoiceTotal
		    		setupDisplay("Invoice Date:");
		    		setupDisplay(invoiceList.get(i).get(3)); //InvoiceDate
		    		
		    		//get work performed
		    		setupDisplay("Customer ID:");
		    		setupDisplay(invoiceList.get(i).get(4)); //CustomerID
		    		setupDisplay("Car Make: ");
		    		setupDisplay(invoiceList.get(i).get(5));	//CarMake
		    		setupDisplay("Car Model:");
		    		setupDisplay(invoiceList.get(i).get(6)); //CarModel
		    		setupDisplay("Car Year: ");
		    		setupDisplay(invoiceList.get(i).get(7)); //CarYear
		    		setupDisplay("Total Labor Hours:");
		    		setupDisplay(invoiceList.get(i).get(8)); //TotalJobHours
		    		
		    		format = "\n\nLimeLight Automotive Restoration Services \n\n"
			            		+ "Invoice ID: " + invoiceList.get(i).get(0)
			            		+ "\n\nCustomer Information \n"
			            		+ "Customer ID: \n" + invoiceList.get(i).get(4)
			            		+ "Car Make: " + invoiceList.get(i).get(5)
			            		+ "\t Car Model: " + invoiceList.get(i).get(6)
			            		+ "\t Car Year: " + invoiceList.get(i).get(7)
			            		+ "\n\n\n"
			            		+ "Job Deatils: \n"
			            		+ "Total Labor Hours ($80 an hour): " + invoiceList.get(i).get(8)
			            		+ "\n\nParts\n";
		    		
		    	      PrintWriter userfile;
		    	      try{
		    	    	  //dialogbox
		    	    	  
		    	         System.out.println("Enter filename");
		    	         String filename= keyboard.nextLine();
		    	         userfile= new PrintWriter(filename);
		    	         userfile.println(format);
		    	         userfile.close();
		    	      } catch(Exception ex){
		    	         System.out.println("Exception caught.");
		    	      }
			            		
		    		if (numOfWorkEntries > 1) {
		    			int indexRef = numOfWorkEntries * 5 + 8;
		    			
		    			//get part information
		    			for (int y = 0; y < numOfParts; y++) {
		    				
		    			
		    				setupDisplay("Part ID:");
		    				setupDisplay(invoiceList.get(i).get(indexRef));	//PartID
		    				setupDisplay("Part Name:");
		    				setupDisplay(invoiceList.get(i).get(indexRef++)); //PartName
		    				setupDisplay("Part Description: ");
		    				setupDisplay(invoiceList.get(i).get(indexRef++));	//PartDescription
		    				setupDisplay("Part Quantity: ");
		    				setupDisplay(invoiceList.get(i).get(indexRef++)); 	//Quantity
		    				setupDisplay("Part Price: ");
		    				setupDisplay(invoiceList.get(i).get(indexRef++));	//PartPrice
		    				
		    				parts = "Part ID: " + invoiceList.get(i).get(indexRef)
	  			            		+ "\tPart Name: " + invoiceList.get(i).get(indexRef++)
	  			            		+ "\nPart Description: " + invoiceList.get(i).get(indexRef++)
	  			            		+ "\tPart Quantity: " + invoiceList.get(i).get(indexRef++)
	  			            		+ "\tPart Price: " + invoiceList.get(i).get(indexRef++);
		    				
		    			}
	
		    		}
		    		else {
		    			
		    			for (int y = 0; y < numOfParts; y++) {
		    				setupDisplay("Part ID:");
		    				setupDisplay(invoiceList.get(i).get(9+y));	//PartID
		    				setupDisplay("Part Name:");
		    				setupDisplay(invoiceList.get(i).get(10+y)); //PartName
		    				setupDisplay("Part Description: ");
		    				setupDisplay(invoiceList.get(i).get(11+y));	//PartDescription
		    				setupDisplay("Part Quantity: ");
		    				setupDisplay(invoiceList.get(i).get(12+y)); 	//Quantity
		    				setupDisplay("Part Price: ");
		    				setupDisplay(invoiceList.get(i).get(13+y));	//PartPrice
		    				
		    				parts = "Part ID: " + invoiceList.get(i).get(9+y)
	  			            		+ "\tPart Name: " + invoiceList.get(i).get(10+y)
	  			            		+ "\tPart Quantity: " + invoiceList.get(i).get(11+y)
	  			            		+ "\tPart Price: " + invoiceList.get(i).get(12+y)
	  			            		+ "\nPart Description: " + invoiceList.get(i).get(13+y);
		    			}
		    			
		    			
		    		}//end else
	
				} */
			}
	

	}//end action performed method
	
	private void setupDisplay(String s) {
		GridBagConstraints gbc_displayLabels = new GridBagConstraints();
		gbc_displayLabels.insets = new Insets(20, 10, 5, 5);
		
		if (gridColumn == 2) {
			gridColumn = 0;
			gridRow++;
		}
		
		if (gridColumn == 1) {
			gbc_displayLabels.anchor = GridBagConstraints.WEST;
		}
		
		if (gridColumn == 0) {
			gbc_displayLabels.anchor = GridBagConstraints.EAST;
		}
		
		
		gbc_displayLabels.gridx = gridColumn;
		gbc_displayLabels.gridy = gridRow;
		
		JLabel label = new JLabel();
		label.setText(s);
		displayPanel.add(label, gbc_displayLabels);
		
		gridColumn++;

	}
}//end class
	