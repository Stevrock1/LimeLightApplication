package limelight;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Component; 
import javax.swing.DefaultComboBoxModel;
public class ViewCustomers extends JPanel implements ActionListener{

	private JPanel contentPanel;
	private JPanel viewCustPanel;
	private API myApi;
	
	private JLabel lblSearchCritera;
	
	private JTextField txtSearchCritera;
	private JButton search;
	private JTable displayTable;
	private String[] searchChoices = {"First Name","Last Name","Email","User ID"};
	private Object[][] data;
	private String[] columns;
	private int searchInt;
	private String searchType;
	
	//******************************* CONSTRUCTOR *********************************************
	public ViewCustomers(JPanel panel, String name, API myApi) {
		setBackground(UIManager.getColor("Button.background"));
		contentPanel = panel;
		searchType = name;
		this.myApi = myApi;
		searchInt = 1;
		
		setupSearchPanel();
		//setupDisplayPanel();
	}
	
	
	private void setupSearchPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{498, 0};
		gridBagLayout.rowHeights = new int[]{300, 184, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);

		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(searchChoices);
		
		
		//headers for the table
		columns = new String[] {
            "User ID", "First Name", "Last Name", "Email", "Address", "Role",
            "Password","Username","State","Zip","City","Phone","Employee Hours",
            "Billing Rate"
        };
         
        //actual data for the table in a 2d array, this will be the API Results
         data = new Object[][] {
           /* {1, "John", 40.0, false },
            {2, "Zorro", 60.0, true }, */
        };
        viewCustPanel = new JPanel();
        GridBagConstraints gbc_viewCustPanel = new GridBagConstraints();
        gbc_viewCustPanel.insets = new Insets(0, 0, 5, 0);
        gbc_viewCustPanel.fill= GridBagConstraints.BOTH;
        gbc_viewCustPanel.gridx = 0;
        gbc_viewCustPanel.gridy = 0;
        this.add(viewCustPanel, gbc_viewCustPanel);
        GridBagLayout gbl_viewCustPanel = new GridBagLayout();
        gbl_viewCustPanel.columnWidths = new int[]{50, 98, 63, 125, 0, 0};
        gbl_viewCustPanel.rowHeights = new int[]{21, 0, 0, 0, 0};
        gbl_viewCustPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_viewCustPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        viewCustPanel.setLayout(gbl_viewCustPanel);
        
        lblSearchCritera = new JLabel("Select a Search Type:");
        GridBagConstraints gbc_lblSearchCritera = new GridBagConstraints();
        gbc_lblSearchCritera.anchor = GridBagConstraints.WEST;
        gbc_lblSearchCritera.insets = new Insets(20, 0, 5, 5);
        gbc_lblSearchCritera.gridx = 1;
        gbc_lblSearchCritera.gridy = 0;
        viewCustPanel.add(lblSearchCritera, gbc_lblSearchCritera);
        
        final JComboBox<String> cboSearchCritera = new JComboBox<String>(comboModel);
        GridBagConstraints gbc_cboSearchCritera = new GridBagConstraints();
        gbc_cboSearchCritera.anchor = GridBagConstraints.WEST;
        gbc_cboSearchCritera.insets = new Insets(20, 0, 5, 5);
        gbc_cboSearchCritera.gridx = 2;
        gbc_cboSearchCritera.gridy = 0;
        viewCustPanel.add(cboSearchCritera, gbc_cboSearchCritera);
        
        txtSearchCritera = new JTextField("");
        GridBagConstraints gbc_txtSearchCritera = new GridBagConstraints();
        gbc_txtSearchCritera.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSearchCritera.anchor = GridBagConstraints.WEST;
        gbc_txtSearchCritera.insets = new Insets(20, 0, 5, 5);
        gbc_txtSearchCritera.gridx = 3;
        gbc_txtSearchCritera.gridy = 0;
        viewCustPanel.add(txtSearchCritera, gbc_txtSearchCritera);
        
        search = new JButton("Search");
        GridBagConstraints gbc_search = new GridBagConstraints();
        gbc_search.insets = new Insets(20, 10, 5, 0);
        gbc_search.anchor = GridBagConstraints.NORTHWEST;
        gbc_search.gridx = 4;
        gbc_search.gridy = 0;
        viewCustPanel.add(search, gbc_search);
        
        
           
		   

		   
        //create table with data
        displayTable = new JTable();
        displayTable.setFillsViewportHeight(true);
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
        viewCustPanel.add(scrollPane, gbc);
        
        
        
        ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) cboSearchCritera.getSelectedItem();//get the selected item

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
		search.addActionListener(this);
		
	}
	
	
	
	private void setupDisplayPanel() {
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String myResult = "";
		myApi.ViewAllCustomers(txtSearchCritera.getText(),searchInt);
		if(searchType.equals("View All Customers"))
			myResult = myApi.SendToAPI("viewAllCustomers");
		else if(searchType.equals("View All Employees"))
			myResult = myApi.SendToAPI("viewAllEmployees");
		JOptionPane.showMessageDialog(null, myResult);
		
		
		if(!(myResult.contains("Error") || myResult.contains("error")))
		{
			if(searchType.equals("View All Customers"))	
				{
					Object[][] data =  new Object[myApi.getCustomers().size()][14];
				
			
					for(int i = 0; i < myApi.getCustomers().size(); i++){
					
						data[i][0] = myApi.getCustomers().get(i).get(0);
						data[i][1] = myApi.getCustomers().get(i).get(1);
						data[i][2] = myApi.getCustomers().get(i).get(2);
						data[i][3] = myApi.getCustomers().get(i).get(3);
						data[i][4] = myApi.getCustomers().get(i).get(4);
						data[i][5] = myApi.getCustomers().get(i).get(5);
						data[i][6] = myApi.getCustomers().get(i).get(6);
						data[i][7] = myApi.getCustomers().get(i).get(7);
						data[i][8] = myApi.getCustomers().get(i).get(8);
						data[i][9] = myApi.getCustomers().get(i).get(9);
						data[i][10] = myApi.getCustomers().get(i).get(10);
						data[i][11] = myApi.getCustomers().get(i).get(11);
						data[i][12] = myApi.getCustomers().get(i).get(12);
						data[i][13] = myApi.getCustomers().get(i).get(13);
		         
		      
		   			}
					
					displayTable.setModel(new DefaultTableModel(data, columns));
					   txtSearchCritera.setText(null);
				}
			else if(searchType.equals("View All Employees"))	
			{
				Object[][] data =  new Object[myApi.getEmployees().size()][14];
			
		
				for(int i = 0; i < myApi.getEmployees().size(); i++){
				
					data[i][0] = myApi.getEmployees().get(i).get(0);
					data[i][1] = myApi.getEmployees().get(i).get(1);
					data[i][2] = myApi.getEmployees().get(i).get(2);
					data[i][3] = myApi.getEmployees().get(i).get(3);
					data[i][4] = myApi.getEmployees().get(i).get(4);
					data[i][5] = myApi.getEmployees().get(i).get(5);
					data[i][6] = myApi.getEmployees().get(i).get(6);
					data[i][7] = myApi.getEmployees().get(i).get(7);
					data[i][8] = myApi.getEmployees().get(i).get(8);
					data[i][9] = myApi.getEmployees().get(i).get(9);
					data[i][10] = myApi.getEmployees().get(i).get(10);
					data[i][11] = myApi.getEmployees().get(i).get(11);
					data[i][12] = myApi.getEmployees().get(i).get(12);
					data[i][13] = myApi.getEmployees().get(i).get(13);
	         
	      
	   			}
				
				displayTable.setModel(new DefaultTableModel(data, columns));
				   txtSearchCritera.setText(null);
			}
		   
		}
	}

	

		  

	
}
