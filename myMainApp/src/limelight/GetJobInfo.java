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
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;

public class GetJobInfo extends JPanel implements ActionListener{
	private JPanel contentPanel;
	private JPanel searchPanel;
	private JScrollPane displayScroll;
	private API myApi;
	
	private JTextField txtJobID;
	private JTextField txtUserID;
	private JButton search;
	private Object[][] data;
	private String[] columns;
	private JTable displayTable;
	
	//******************************* CONSTRUCTOR *********************************************
	public GetJobInfo(JPanel panel, String name, API myApi) {
		setBackground(UIManager.getColor("Button.background"));
		contentPanel = panel;
		name = "Get Job Info";
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
        
        JLabel lblSearchJobID = new JLabel("Job ID:");
        GridBagConstraints gbc_lblSearchJobID = new GridBagConstraints();
        gbc_lblSearchJobID.anchor = GridBagConstraints.EAST;
        gbc_lblSearchJobID.insets = new Insets(20, 0, 5, 5);
        gbc_lblSearchJobID.gridx = 1;
        gbc_lblSearchJobID.gridy = 0;
        searchPanel.add(lblSearchJobID, gbc_lblSearchJobID);
        
        txtJobID = new JTextField("");
        GridBagConstraints gbc_txtLastName = new GridBagConstraints();
        gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLastName.anchor = GridBagConstraints.WEST;
        gbc_txtLastName.insets = new Insets(20, 0, 5, 5);
        gbc_txtLastName.gridx = 2;
        gbc_txtLastName.gridy = 0;
        searchPanel.add(txtJobID, gbc_txtLastName);
        
        JLabel lbAnd = new JLabel("-AND-");
        GridBagConstraints gbc_lbAnd = new GridBagConstraints();
        gbc_lbAnd.insets = new Insets(20, 0, 5, 5);
        gbc_lbAnd.gridx = 3;
        gbc_lbAnd.gridy = 0;
        searchPanel.add(lbAnd, gbc_lbAnd);
        
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
        GridBagConstraints gbc_displayPanel = new GridBagConstraints();
        gbc_displayPanel.fill = GridBagConstraints.BOTH;
        gbc_displayPanel.insets = new Insets(20, 10, 5, 5);
        gbc_displayPanel.gridwidth = 5; 
        gbc_displayPanel.gridx = 1;
        gbc_displayPanel.gridy = 3;
        displayScroll = new JScrollPane();
        displayScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        searchPanel.add(displayScroll, gbc_displayPanel);
        
        columns = new String[] {
                "Job ID", "User ID", "Car Make", "Car Model", "Car Year", "Total Job Hours",
                "Job Status","Workers"
            };
             
            //actual data for the table in a 2d array, this will be the API Results
             data = new Object[][] {
               /* {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true }, */
            };
        
        displayTable = new JTable();
        displayTable.setFillsViewportHeight(true);
        displayScroll.setViewportView(displayTable);
        displayScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        displayScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        //add button listeners
        search.addActionListener(this);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		//******************************* Search User ID Invoices *************************************
		if(source == search)
		{
	    		
	    		if (txtUserID.getText().isEmpty() && txtJobID.getText().isEmpty()) {
	    			JOptionPane.showMessageDialog(null, "Please search by searching a User ID or an Invoice ID.");
	    		}
	    		else {
	    			String myResult = "";
	    			myApi.GetJobInfo(Integer.parseInt(txtJobID.getText()),Integer.parseInt(txtUserID.getText()));
	    			myResult = myApi.SendToAPI("getJobInfo");
	    			JOptionPane.showMessageDialog(null, myResult);
	    			
	    		if(!myResult.contains("Error"))
	    		{	
	    			Object[][] data =  new Object[myApi.getJobs().size()][8];
	    				
	    			   for(int i = 0; i < myApi.getJobs().size(); i++){

	    			      

	    			         data[i][0] = myApi.getJobs().get(i).get(0);
	    			         data[i][1] = myApi.getJobs().get(i).get(1);
	    			         data[i][2] = myApi.getJobs().get(i).get(2);
	    			         data[i][3] = myApi.getJobs().get(i).get(3);
	    			         data[i][4] = myApi.getJobs().get(i).get(4);
	    			         data[i][5] = myApi.getJobs().get(i).get(5);
	    			         data[i][6] = myApi.getJobs().get(i).get(6);
	    			         data[i][7] = myApi.getJobs().get(i).get(7);
	    			         
	    			      
	    			   }

	    			   displayTable.setModel(new DefaultTableModel(data, columns));
	    			   
	    			txtJobID.setText(null);
	    			txtUserID.setText(null);
	    		}
	    		}
	    	}
		
		
		
			
		
		
		
		

	}//end action performed method
	

}//end class
	