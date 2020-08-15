package limelight;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// HomePane class will construct the home screen
public class HomePane extends JPanel {

	// Pane elements as class attributes
	private JPanel contentPanel;
	private JPanel pnlAddEmployee;
	private JPanel pnlAddCustomer;
	private JPanel pnlReports;
	private JPanel pnlLogHours;
	private JPanel pnlPayroll;
	private JPanel pnlAddJob;
	private JPanel pnlInvoices;
	
	private JLabel lblEmployees;
	private JLabel lblManageEmployees;
	private JLabel lblCustomers;
	private JLabel lblManageCustomers;
	private JLabel lblReporting;
	
	
	private JButton btnLogHours;
	private JButton btnReports;
	//private JButton btnAddEmployees;
	//private JButton btnCustomers;
	private JButton btnPayroll;
	private JButton btnInvoice;
	private JButton btnJob;
	private JLabel welcomeLabel; 
	private JLabel greetLabel; 
	private JLabel lblLogo; 
	private BufferedImage logo; 
	private API myApi;
	
	
	// Constructor
	public HomePane(JPanel panel, String name, API myApi) {
		setBackground(new Color(245, 245, 245));
		contentPanel = panel;
		name = "Home pane";
		this.myApi = myApi;
		setupPanel();
	}

	
	
	// Builds panel
	private void setupPanel() {
		
		setBackground(Color.WHITE); 
		setLayout(null); 
		welcomeLabel = new JLabel("Welcome..."); 
		welcomeLabel.setBounds(10, 10, 225, 35); 
		welcomeLabel.setForeground(new Color(139, 0, 0)); 
		welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 36)); 
		add(welcomeLabel); 
 
		greetLabel = new JLabel("to the Limelight Classic Automotive Restoration management suite!"); 
		greetLabel.setBounds(10, 56, 590, 35); 
		greetLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20)); 
		add(greetLabel); 
		
		try { 
			logo = ImageIO.read(new File("img/scaledLogo.png")); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
		
		ImageIcon icon = new ImageIcon(logo); 
		
		lblLogo = new JLabel(); 
		lblLogo.setBounds(430, 230, 250, 250); 
		lblLogo.setIcon(icon); 
		add(lblLogo); 
		
	}//end setupPanel
	
}//end HomePane cLass

