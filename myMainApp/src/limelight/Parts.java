package limelight;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parts {
	@JsonProperty("partID")
	private String partID;
	@JsonProperty("userID")
	private String userID;
	@JsonProperty("partPrice")
	private String partPrice;
	@JsonProperty("jobID")
	private String jobID;
	@JsonProperty("partName")
	private String partName;
	@JsonProperty("partDate")
	private String partDate;
	@JsonProperty("quantity")
	private String quantity;
	@JsonProperty("description")
	private String description;
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
	

	
	
	
	public Parts(){}
	
	
	
    /*Getter and Setter Methods*/
    public String getPartID() {return partID;}
    public void setPartID(String partID) {this.partID =  partID;}
    
    public String getUserID() {return userID;}
    public void setUserID(String userID) {this.userID =  userID;}
    
    public String getPartPrice() {return partPrice;}
    public void setPartPrice(String partPrice) {this.partPrice = partPrice;}
    
    public String getPartDate() {return partDate;}
    public void setPartDate(String partDate) {this.partDate = partDate;}
    
    public String getJobID() {return jobID;}
    public void setJobID(String jobID) {this.jobID = jobID;}
    
    public String getPartName() {return partName;}
    public void setPartName(String partName) {this.partName = partName;}
    
    public String getQuantity() {return quantity;}
    public void setQuantity(String quantity) {this.quantity = quantity;}
    
    
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    
    public String getCarMake() {return carMake;}
    public void setCarMake(String carMake) {this.carMake = carMake;}
    
    public String getCarModel() {return carModel;}
    public void setCarModel(String carModel) {this.carModel = carModel;}
    
    public String getCarYear() {return carYear;}
    public void setCarYear(String carYear) {this.carYear = carYear;}
    
    public String getWorkers() {return workers;}
    public void setWorkers(String workers) {this.workers = workers;}
    
    public String getTotalJobHours() {return totalJobHours;}
    public void setTotalJobHours(String totalJobHours) {this.totalJobHours = totalJobHours;}
    
    public String getJobStatus() {return jobStatus;}
    public void setJobStatus(String jobStatus) {this.jobStatus = jobStatus;}
    
    
}
