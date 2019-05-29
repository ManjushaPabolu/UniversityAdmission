package com.pro.uas.dto;

public class Participant {
 
	private int rollno;
	private String emailid;
	private int applicationid;
	private int programmid;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}
	public int getProgrammid() {
		return programmid;
	}
	public void setProgrammid(int programmid) {
		this.programmid = programmid;
	}
	@Override
	public String toString() {
		return "Participant [rollno=" + rollno + ", emailid=" + emailid + ", applicationid=" + applicationid
				+ ", programmid=" + programmid + "]";
	}
	
	
	
}
