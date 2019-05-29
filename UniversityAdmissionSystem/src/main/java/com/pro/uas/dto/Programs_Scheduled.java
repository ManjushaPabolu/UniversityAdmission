package com.pro.uas.dto;

import java.sql.Date;

public class Programs_Scheduled {

	private int programId;
	private String programName;
	private String location;
	private Date startDate;
	private Date endDate;
	private int sessionsPerWeek;
	
	public int getProgramid() {
		return programId;
	}
	public void setProgramid(int programid) {
		this.programId = programid;
	}
	public String getProgramname() {
		return programName;
	}
	public void setProgramname(String programname) {
		this.programName = programname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStartdate() {
		return startDate;
	}
	public void setStartdate(Date startdate) {
		this.startDate = startdate;
	}
	public Date getEnddate() {
		return endDate;
	}
	public void setEnddate(Date enddate) {
		this.endDate = enddate;
	}
	public int getSessionsperweek() {
		return sessionsPerWeek;
	}
	public void setSessionsperweek(int sessionsperweek) {
		this.sessionsPerWeek = sessionsperweek;
	}
	@Override
	public String toString() {
		return "ProgrammsScheduled [programid=" + programId + ", programname=" + programName + ", location=" + location
				+ ", startdate=" + startDate + ", enddate=" + endDate + ", sessionsperweek=" + sessionsPerWeek + "]";
	}
}
