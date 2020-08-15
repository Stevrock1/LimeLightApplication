package limelight;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {
	@JsonProperty("invoiceID")
	private String invoiceID;
	@JsonProperty("jobID")
	private String jobID;
	@JsonProperty("invoiceDate")
	private String invoiceDate;
	@JsonProperty("total")
	private String invoiceTotal;

	@JsonProperty("workPerformed")
	private ArrayList<WorkPerformed> workPerformed;
	
	@JsonProperty("parts")
	private ArrayList<Parts> parts;
	
	public Invoice(String invoiceID, String jobID, String invoiceDate, String total, ArrayList<WorkPerformed> workPerformed, ArrayList<Parts> parts) {
		this.invoiceID = invoiceID;
		this.jobID = jobID;
		this.invoiceDate = invoiceDate;
		this.invoiceTotal = total;
        this.workPerformed = workPerformed;
        this.parts = parts;
		
	}
	
	public Invoice() {
		
	}
	
	
    /*Getter and Setter Methods*/
    public String getInvoiceID() {return invoiceID;}
    public void setInvoiceID(String invoiceID) {this.invoiceID =  invoiceID;}
    
    public String getJobID() {return jobID;}
    public void setJobID(String jobID) {this.jobID = jobID;}
    
    
    public String getInvoiceDate() {return invoiceDate;}
    public void setInvoiceDate(String invoiceDate) {this.invoiceDate = invoiceDate;}
    
    
    public String getInvoiceTotal() {return invoiceTotal;}
    public void setInvoiceTotal(String invoiceTotal) {this.invoiceTotal = invoiceTotal;}
    
    public ArrayList<WorkPerformed> getWorkPerformed() {return workPerformed;}
    public void setworkPerformed(ArrayList<WorkPerformed> workPerformed) {this.workPerformed = workPerformed;}
    
    public ArrayList<Parts> getParts() {return parts;}
    public void setParts(ArrayList<Parts> parts) {this.parts = parts;}
    
}
