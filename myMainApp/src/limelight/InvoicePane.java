package limelight;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InvoicePane extends JPanel implements ActionListener {
	
	private JPanel contentPanel;
	private API myApi;
	private JLabel lblInvoiceID;
	private JTextField txtInvoiceID;
	private JLabel lblJobID;
	private JTextField txtJobID;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JLabel lblInvoiceDate;
	private JTextField txtInvoiceDate;
	private JButton btnCreateInvoice;
	private JButton btnCancel;

	public InvoicePane(JPanel panel, String name, API api) {
		contentPanel = panel;
		name = "Invoice Pane";
		api = myApi;
		setupPanel();
	}
	
	private void setupPanel() {
		
		// Set panel layout
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		// initialize components
		lblInvoiceID = new JLabel("First Day:");
		txtInvoiceID = new JTextField();
		lblJobID = new JLabel("Job ID:");
		txtJobID = new JTextField();
		lblTotal = new JLabel("Last Day");
		txtTotal = new JTextField();
		lblInvoiceDate = new JLabel("Invoice date:");
		txtInvoiceDate = new JTextField();
		btnCreateInvoice = new JButton("Create invoice");
		btnCancel = new JButton("Cancel");
		
		// set grid constraints
		GridBagConstraints gbc_lblInvoiceID = new GridBagConstraints();
		gbc_lblInvoiceID.anchor = GridBagConstraints.EAST;
		gbc_lblInvoiceID.insets = new Insets(0, 0, 5, 5);
		
		GridBagConstraints gbc_txtInvoiceID = new GridBagConstraints();
		gbc_txtInvoiceID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInvoiceID.insets = new Insets(0, 0, 5, 5);
		
		GridBagConstraints gbc_lblJobID = new GridBagConstraints();
		gbc_lblJobID.anchor = GridBagConstraints.EAST;
		gbc_lblJobID.insets = new Insets(0, 0, 5, 5);
		
		GridBagConstraints gbc_txtJobID = new GridBagConstraints();
		gbc_txtJobID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtJobID.insets = new Insets(0, 0, 5, 5);
		
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridy = 1;

		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotal.gridy = 1;
		
		GridBagConstraints gbc_lblInvoiceDate = new GridBagConstraints();
		gbc_lblInvoiceDate.anchor = GridBagConstraints.EAST;
		gbc_lblInvoiceDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvoiceDate.gridy = 1;
		
		GridBagConstraints gbc_txtInvoiceDate = new GridBagConstraints();
		gbc_txtInvoiceDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInvoiceDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtInvoiceDate.gridy = 1;
		
		GridBagConstraints gbc_btnCreateInvoice = new GridBagConstraints();
		gbc_btnCreateInvoice.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateInvoice.gridx = 1;
		gbc_btnCreateInvoice.gridy = 2;
		
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 2;
		
		
		
		// add components
		this.add(lblInvoiceID, gbc_lblInvoiceID);
		this.add(txtInvoiceID, gbc_txtInvoiceID);
		this.add(lblJobID, gbc_lblJobID);
		this.add(txtJobID, gbc_txtJobID);
		this.add(lblTotal, gbc_lblTotal);
		this.add(txtTotal, gbc_txtTotal);
		//this.add(lblInvoiceDate, gbc_lblInvoiceDate);
		//this.add(txtInvoiceDate, gbc_txtInvoiceDate);
		//this.add(btnCreateInvoice, gbc_btnCreateInvoice);
		this.add(btnCancel, gbc_btnCancel);
		
		
		// add action listeners
		btnCreateInvoice.addActionListener(this);
		btnCancel.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		// Cancel button to return home
		if(source == btnCancel){
			CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
			cardLayout.show(contentPanel, "Home pane");
		}
		
		// create invoice button
		if(source == btnCreateInvoice) {
			
			
			txtInvoiceID.getText();
			txtTotal.getText();
			txtJobID.getText();
			
			String myResult = myApi.SendToAPI("createInvoices");
			//System.out.println(myResult);
		
			JOptionPane.showMessageDialog(null, myResult);
			
			
			if(txtInvoiceID.getText().equals("") || txtJobID.getText().equals("") || txtTotal.getText().equals("")
					|| txtInvoiceDate.getText().equals("")) {
				JOptionPane.showMessageDialog(null, 
			    		"Please fill out all required fields!");
			    		return;
			}
			else {
    			//String myResult = myApi.SendToAPI("createInvoices");
    			//System.out.println(myResult);
			
    			JOptionPane.showMessageDialog(null, myResult);
			}
			
			
			
			
			
		}//end btnCreateInvoice event
	}
	
	
}
