package limelight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	private LoginPanel loginPanel;
	private MainGUIPanel mainPanel;
	private API myApi;
	 
	
	public MainFrame(API myApi, LoginPanel loginPanel, MainGUIPanel mainPanel) {
		this.myApi = myApi;
		this.loginPanel = loginPanel;
		this.mainPanel = mainPanel;
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		getLoginFrame();
		
		this.loginPanel.addLoginListener(new LoginListener(this));
		this.mainPanel.addLogoutListener(new LogoutListener(this));
	}
	
	
	void getLoginFrame() {
		//Login GUI
		this.setResizable(false);
		this.setSize(350,425);
		this.setContentPane(loginPanel);
		this.setLocationRelativeTo(null);
	} 
	
	
	
	void getMainFrame() {

		 //Main GUI Content Pane Change
		this.setSize(1366, 768);
		this.setResizable(false);
		this.setTitle("LimeLight Restoration Back Office");
		//mainPanel.setupPanel();
		this.setContentPane(mainPanel);
		this.setLocationRelativeTo(null);
		
		
	}
	
	
	
	class LoginListener implements ActionListener{
		
		private MainFrame mainFrame;
		
		public LoginListener(MainFrame mainFrame) {
			this.mainFrame = mainFrame;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
				String username = loginPanel.getUsername();
				String password = loginPanel.getPassword();
				
		    	 myApi.Login(username, password);
		    	 String myResult = myApi.SendToAPI("login");
		    	 
		    	 if(myResult.contains("Error")){
		    		 
		    		 loginPanel.displayErrorMessage(myResult);
		    		 
		    	 } else{
		    		 
		    		//clear text fields
		    		loginPanel.clearTextFields();
		    		
		    		//show the Main HomeScreen
		    		mainFrame.getMainFrame();
		    		
		 	
		    	}
			
		}//end action performed
		
		
	}//end LoginListener class
	
	
	
	
	class LogoutListener implements ActionListener{
		
		private MainFrame mainFrame;
		
		public LogoutListener(MainFrame mainFrame) {
			this.mainFrame = mainFrame;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		 
		   //clear the current saved api user fields
		    
		    		
		   //show the LoginScreen
		   mainFrame.getLoginFrame();
		 	
		  
			
		}//end action performed
		
		
	}//end LogoutListener class
	
	
	public API getCurrentEmployee() {return myApi;}
}//end MainFrame class