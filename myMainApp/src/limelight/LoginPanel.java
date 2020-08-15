package limelight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
	
	private BufferedImage bImg;
	private JLabel lblScaledLogo;
	private JLabel lblUsername; 
	private JTextField txtUsername; 
	private JLabel lblPassword; 
	private JPasswordField txtPassword; 
	private JButton btnLogin;
	private GridBagLayout gridBagLayout;
	
	
	//Constructor
	public LoginPanel() {
		setupPanel();
	}
	
	private void setupPanel() {
		this.setPreferredSize( new Dimension(400, 450));	
		//Get image
		try {
			bImg = ImageIO.read(new File("img/tempLogo.png")); 
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//Create instances of objects
		gridBagLayout = new GridBagLayout();
		lblUsername = new JLabel("Username:");
		txtUsername = new JTextField();
		lblPassword = new JLabel("Password:");
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLogin.setBackground(Color.GRAY);
		txtPassword = new JPasswordField();
		lblScaledLogo = new JLabel(new ImageIcon(bImg.getScaledInstance(175,175, Image.SCALE_SMOOTH)));
		//lblXClose = new JLabel("X");
		
		//set Colors and Font Attributes
		setBackground(Color.WHITE);
		//lblXClose.setFont(new Font("Segoe UI", Font.BOLD, 18));
		//lblXClose.setForeground(Color.RED);
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPassword.setForeground(Color.DARK_GRAY);
		this.setSize(400,450);
		
		
		
		//setup Grid
		setLayout(gridBagLayout);
		gridBagLayout.columnWidths = new int[]{103, 76, 137, 20, 0, 0, 24, 43, 0};
		gridBagLayout.rowHeights = new int[]{39, 0, -15, 21, 24, 22, 38, 33, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		
		
		//Set Grid Constraints on elements
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.anchor = GridBagConstraints.SOUTH;
		gbc_lblLogo.insets = new Insets(20, 0, 5, 5);
		gbc_lblLogo.gridx = 1;
		gbc_lblLogo.gridwidth = 2;
		gbc_lblLogo.gridheight = 2;
		gbc_lblLogo.gridy = 0;
		
		GridBagConstraints gbc_lblXClose = new GridBagConstraints();
		gbc_lblXClose.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblXClose.insets = new Insets(0, 0, 5, 0);
		gbc_lblXClose.gridx = 7;
		gbc_lblXClose.gridy = 0;
		
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 4; 
		
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.anchor = GridBagConstraints.SOUTHWEST;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 4;
		
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 5;
		
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.ipadx = 1;
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.anchor = GridBagConstraints.SOUTHWEST;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 5;
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 7;
		
		
		
		//Add elements to panel
		this.add(lblScaledLogo, gbc_lblLogo);
		//this.add(lblXClose, gbc_lblXClose);
		this.add(lblUsername, gbc_lblUsername);
		this.add(txtUsername, gbc_txtUsername); 
		this.add(lblPassword, gbc_lblPassword); 
		this.add(txtPassword, gbc_txtPassword); 
		this.add(btnLogin, gbc_btnLogin);
		
		// make enter button press login
		// this.getRootPane().setDefaultButton(btnLogin);
		
		
	}//end setupPanel
	
	
	
	public String getUsername() {
		
		return txtUsername.getText();
	}
	
	
	
	public String getPassword() {
		
		String password = new String(txtPassword.getPassword());
		return password;
		
	}
	
	
	
	public void clearTextFields() {
		
		txtUsername.setText("");
		txtPassword.setText("");
		
	}
	
	public JButton getBtnLogin() {
		return btnLogin;
	}
	
	public JTextField getTxtUsername() {
		return txtUsername;
	}
	
	
	
	//This is the button listener method used in MainFrame
	void addLoginListener(ActionListener listenForLoginButton){
		         
		        btnLogin.addActionListener(listenForLoginButton);
	}
		    
	
	
	// Open a popup that contains the error message passed
	void displayErrorMessage(String errorMessage){

		        JOptionPane.showMessageDialog(null, errorMessage);
		        return;
	}

}//end class