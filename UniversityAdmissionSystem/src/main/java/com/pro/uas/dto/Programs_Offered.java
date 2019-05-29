package com.pro.uas.dto;

public class Programs_Offered {
	private String programname;
	private String description;
	private String eligibility;
	private int duration;
	private String degreeoffered;
	
	public String getProgramname() {
		return programname;
	}
	public void setProgramname(String programname) {
		this.programname = programname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDegreeoffered() {
		return degreeoffered;
	}
	public void setDegreeoffered(String degreeoffered) {
		this.degreeoffered = degreeoffered;
	}
	@Override
	public String toString() {
		return "Programs_Offered [programname=" + programname + ", description=" + description + ", eligibility="
				+ eligibility + ", duration=" + duration + ", degreeoffered=" + degreeoffered + "]";
	}
	
	
	
}
