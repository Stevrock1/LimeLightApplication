package limelight;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkPerformed {
	@JsonProperty("jobWorkerID")
	private String employeeID;
	@JsonProperty("userID")
	private String customerID;
	@JsonProperty("jobID")
	private String jobID;
	@JsonProperty("totalHours")
	private String totalHours;
	@JsonProperty("lastWorkedDate")
	private String lastWorkedDate;
	@JsonProperty("workerDate")
	private String workerDate;
	@JsonProperty("workDescription")
	private String workDescription;
	@JsonProperty("carYear")
	private String carYear;
	@JsonProperty("carMake")
	private String carMake;
	@JsonProperty("carModel")
	private String carModel;
	@JsonProperty("totalJobHours")
	private String totalJobHours;
	@JsonProperty("workers")
	private String workers;
	@JsonProperty("jobStatus")
	private String jobStatus;
	
	
	
	public WorkPerformed(){}
	
	
	
    /*Getter and Setter Methods*/
    public String getEmployeeID() {return employeeID;}
    public void setEmployeeID(String employeeID) {this.employeeID =  employeeID;}
    
    public String getCustomerID() {return customerID;}
    public void setCustomerID(String customerID) {this.customerID = customerID;}
    
    public String getJobID() {return jobID;}
    public void setJobID(String jobID) {this.jobID = jobID;}
    
    public String getCarMake() {return carMake;}
    public void setCarMake(String carMake) {this.carMake = carMake;}
    
    public String getCarModel() {return carModel;}
    public void setCarModel(String carModel) {this.carModel = carModel;}
    
    
    public String getTotalHours() {return totalHours;}
    public void setTotalHours(String totalHours) {this.totalHours = totalHours;}
    
    
    public String getCarYear() {return carYear;}
    public void setCarYear(String carYear) {this.carYear = carYear;}
    
    
    public String getLastWorkedDate() {return lastWorkedDate;}
    public void setLastWorkedDate(String lastWorkedDate) {this.lastWorkedDate = lastWorkedDate;}
    
    
    public String getWorkerDate() {return workerDate;}
    public void setWorkerDate(String workerDate) {this.workerDate = workerDate;}
    
    public String getTotalJobHours() {return totalJobHours;}
    public void setTotalJobHours(String totalJobHours) {this.totalJobHours = totalJobHours;}
    
    public String getJobStatus() {return jobStatus;}
    public void setJobStatus(String jobStatus) {this.jobStatus = jobStatus;}
    

}
