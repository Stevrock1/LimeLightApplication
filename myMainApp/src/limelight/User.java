package limelight;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("userID")
	private String userID;
	@JsonProperty("firstName")
	private String fName;
	@JsonProperty("lastName")
	private String lName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("address")
	private String address;	
	@JsonProperty("role")
	private String role;
	@JsonProperty("password")
	private String password;
	@JsonProperty("username")
	private String username;
	@JsonProperty("state")
	private String state;
	@JsonProperty("zipcode")
	private String zip;
	@JsonProperty("city")
	private String city;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("employeeHours")
	private String employeeHours;
	@JsonProperty("billingRate")
	private String billingRate;
	@JsonProperty("error")
	private String errorMessage = "";
    /*Getter and Setter Methods*/
    public String getUserID() {
        return userID;
    }
    public void SetUserID(String userID) {
        this.userID =  userID;
    }
    public String getFirstName() {
        return fName;
    }
    public void setFirstName(String fName) {
        this.fName = fName;
    }
    public String getLastName() {
        return lName;
    }
    public void setLastName(String lName) {
        this.lName = lName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
    public String getPhoneNumber() {
        return phone;
    }
    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getEmployeeHours() {
        return employeeHours;
    }
    public void setEmployeeHours(String employeeHours) {
        this.employeeHours = employeeHours;
    }
    public String getBillingRate() {
        return billingRate;
    }
    public void setBillingRate(String billingRate) {
        this.billingRate = billingRate;
   }
    public String getErrorMessage() {
        return errorMessage;
    }
    
    
    @Override
	public String toString(){
		return getFirstName() + ", "+getLastName()+", "+getRole();
	}
}