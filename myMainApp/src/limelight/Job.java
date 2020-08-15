package limelight;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Job {
	@JsonProperty("jobID")
	private String jobID;
	@JsonProperty("userID")
	private String userID;
	@JsonProperty("carMake")
	private String carMake;
	@JsonProperty("carModel")
	private String carModel;
	@JsonProperty("carYear")
	private String carYear;	
	@JsonProperty("totalJobHours")
	private String totalJobHours;
	@JsonProperty("workers")
	private String workers;
	@JsonProperty("jobStatus")
	private String jobStatus;
	@JsonProperty("error")
	private String errorMessage;
    /*Getter and Setter Methods*/
    public String getUserID() {
        return userID;
    }
    public void SetUserID(String userID) {
        this.userID =  userID;
    }
    public String getJobID() {
        return jobID;
    }
    public void setJobID(String jobID) {
        this.jobID = jobID;
    }
    public String getCarMake() {
        return carMake;
    }
    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public String getTotalJobHours() {
        return totalJobHours;
    }
    public void setTotalJobHours(String totalJobHours) {
        this.totalJobHours = totalJobHours;
    }
    public String getCarYear() {
        return carYear;
    }
    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }
    public String getJobStatus() {
        return jobStatus;
    }
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    public String getWorkers() {
        return workers;
    }
    public void setWorkers(String workers) {
        this.workers = workers;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
}