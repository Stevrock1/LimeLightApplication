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

public class EnterParts extends JPanel implements ActionListener{
	
	private JPanel contentPanel;
	private API myApi;
	
	private JButton btnCancel;
	private JButton btnEnterParts;
	
	private JLabel lblPartID;
	private JLabel lblJobID;
	private JLabel lblPartName;
	private JLabel lblQuantity;
	private JLabel lblDescription;
	
	private JTextField txtPartID;
	private JTextField txtJobID;
	private JTextField txtPartName;
	private JTextField txtQuantity;
	private JTextField txtDescription;
		
	public EnterParts(JPanel panel, String name, API myApi) {
		contentPanel = panel;
		name = "Employee pane";
		this.myApi = myApi;
		setupPanel();
	} 
	
	private void setupPanel() {
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		//initialize components
		btnCancel = new JButton("Cancel");
		btnEnterParts = new JButton("Enter Parts");
		
		lblPartID = new JLabel("Part ID");
		txtPartID = new JTextField();
		lblJobID = new JLabel("Job ID");
		txtJobID = new JTextField();
		lblPartName = new JLabel("Part Name");
		txtPartName = new JTextField();
		lblQuantity = new JLabel("Quantity");
		txtQuantity = new JTextField();
		lblDescription = new JLabel("Description");
		txtDescription = new JTextField();
		
		//Grid Bag Constraints
		
		GridBagConstraints gbc_lblJobID = new GridBagConstraints();
		gbc_lblJobID.anchor = GridBagConstraints.EAST;
		gbc_lblJobID.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobID.gridx = 0;
		gbc_lblJobID.gridy = 0;
		
		GridBagConstraints gbc_txtJobID = new GridBagConstraints();
		gbc_txtJobID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtJobID.insets = new Insets(0, 0, 5, 5);
		gbc_txtJobID.gridx = 1;
		gbc_txtJobID.gridy = 0;
		
		GridBagConstraints gbc_lblPartID = new GridBagConstraints();
		gbc_lblPartID.anchor = GridBagConstraints.EAST;
		gbc_lblPartID.insets = new Insets(0, 0, 5, 5);
		gbc_lblPartID.gridx = 0;
		gbc_lblPartID.gridy = 1;
		
		GridBagConstraints gbc_txtPartID = new GridBagConstraints();
		gbc_txtPartID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPartID.insets = new Insets(0, 0, 5, 5);
		gbc_txtPartID.gridx = 1;
		gbc_txtPartID.gridy = 1;
		
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 2;
		gbc_lblQuantity.gridy = 1;
		
		GridBagConstraints gbc_txtQuantity = new GridBagConstraints();
		gbc_txtQuantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuantity.gridx = 3;
		gbc_txtQuantity.gridy = 1;
		
		GridBagConstraints gbc_lblPartName = new GridBagConstraints();
		gbc_lblPartName.anchor = GridBagConstraints.EAST;
		gbc_lblPartName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPartName.gridx = 0;
		gbc_lblPartName.gridy = 2;
		
		GridBagConstraints gbc_txtPartName = new GridBagConstraints();
		gbc_txtPartName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPartName.insets = new Insets(0, 0, 5, 5);
		gbc_txtPartName.gridx = 1;
		gbc_txtPartName.gridy = 2;
		
		
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 3;
		
		GridBagConstraints gbc_txtDescription = new GridBagConstraints();
		gbc_txtDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescription.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescription.gridx = 1;
		gbc_txtDescription.gridy = 3;
		
		GridBagConstraints gbc_btnEnterParts = new GridBagConstraints();
		gbc_btnEnterParts.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterParts.gridx = 1;
		gbc_btnEnterParts.gridy = 4;
		
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 4;
		
		//add components to frame
		
		this.add(lblJobID, gbc_lblJobID);
		this.add(txtJobID, gbc_txtJobID);
		this.add(lblPartID, gbc_lblPartID);
		this.add(txtPartID, gbc_txtPartID);
		this.add(lblQuantity, gbc_lblQuantity);
		this.add(txtQuantity, gbc_txtQuantity);
		this.add(lblPartName, gbc_lblPartName);
		this.add(txtPartName, gbc_txtPartName);
		this.add(lblDescription, gbc_lblDescription);
		this.add(txtDescription, gbc_txtDescription);
		
		this.add(btnEnterParts, gbc_btnEnterParts);
		this.add(btnCancel, gbc_btnCancel);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == btnEnterParts){
			
			myApi.EnterParts(txtPartID.getText(),txtJobID.getText(), txtPartName.getText(), txtQuantity.getText(), txtDescription.getText());
			String myResult = myApi.SendToAPI("enterParts");
			
	    	JOptionPane.showMessageDialog(null, myResult);

	    	
		}
		else if(source == btnCancel) {
			CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
			cardLayout.show(contentPanel, "Home pane");
		}
	}

}

//		  ':partID' => $values['partID'],
//        ':jobID' => $values['jobID'],
//        ':partName' => $values['partName'],
//        ':quantity' => $values['quantity'],
//        ':description' => $values['description']
//
