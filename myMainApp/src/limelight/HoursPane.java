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

public class HoursPane extends JPanel implements ActionListener {
	
	private JPanel contentPanel;
	private API myApi;
	private JButton btnCancel;
	private JButton btnEnterHours;
	private JLabel lblEnterHours;
	private JLabel lblUsername;
	private JTextField txtEnterHours;
	private JTextField txtUsername;

	public HoursPane(JPanel panel, String name, API api) {
		contentPanel = panel;
		name = "Hours Pane";
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
		
		// Initialize components
		btnCancel = new JButton("Cancel");
		btnEnterHours = new JButton("Enter hours");
		lblEnterHours = new JLabel("Hours worked:");
		txtEnterHours = new JTextField();
		lblUsername = new JLabel("Employee username:");
		txtUsername = new JTextField();
		
		// Set grid constraints
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 0;
		
		GridBagConstraints gbc_lblEnterHours = new GridBagConstraints();
		gbc_lblEnterHours.anchor = GridBagConstraints.EAST;
		gbc_lblEnterHours.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterHours.gridx = 0;
		gbc_lblEnterHours.gridy = 1;
		
		GridBagConstraints gbc_txtEnterHours = new GridBagConstraints();
		gbc_txtEnterHours.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterHours.insets = new Insets(0, 0, 5, 5);
		gbc_txtEnterHours.gridx = 1;
		gbc_txtEnterHours.gridy = 1;
		
		GridBagConstraints gbc_btnEnterHours = new GridBagConstraints();
		gbc_btnEnterHours.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterHours.gridx = 1;
		gbc_btnEnterHours.gridy = 2;
		
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 2;
	
		
		
		// Add components
		this.add(lblUsername, gbc_lblUsername);
		this.add(txtUsername, gbc_txtUsername);
		this.add(lblEnterHours, gbc_lblEnterHours);
		this.add(txtEnterHours, gbc_txtEnterHours);
		this.add(btnEnterHours, gbc_btnEnterHours);
		this.add(btnCancel, gbc_btnCancel);
		
		
		
		btnCancel.addActionListener(this);
		btnEnterHours.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		// Cancel button to return home
		if(source == btnCancel){
			CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
			cardLayout.show(contentPanel, "Home pane");
		}
		
		// Enter hours button
		if(source == btnEnterHours) {
			if(txtUsername.getText().equals("") || txtEnterHours.getText().equals("")) {
				JOptionPane.showMessageDialog(null, 
			    		"Please fill out all required fields!");
			    		return;
			} else {
				myApi.setHours(txtEnterHours.getText()); 
				String myResult = myApi.SendToAPI("addHours"); 
			}
			
		}
	}
	
	
}
