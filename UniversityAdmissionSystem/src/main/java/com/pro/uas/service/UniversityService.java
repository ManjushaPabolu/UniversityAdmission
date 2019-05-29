package com.pro.uas.service;

import java.util.List;

import com.pro.uas.dto.Application;
import com.pro.uas.dto.Programs_Offered;
import com.pro.uas.dto.Programs_Scheduled;
import com.pro.uas.dto.Users;

public interface UniversityService {

public Users login(String loginId,String password,String role);
	
	public boolean addProgramOffered(Programs_Offered po);
	
	public boolean updateProgramOffered(Programs_Offered po);
	
	public boolean deleteProgramOffered(String Programname);
	
	public List<Programs_Offered> listAllPrograms();
	
	public boolean createScheduledProgram(Programs_Scheduled ps);
	
	public boolean updateScheduledProgram(Programs_Scheduled ps);
	
	public boolean deleteScheduledProgram(int programid);
	
	public List<Programs_Scheduled>listAllScheduledPrograms();
	
	public boolean applyApplication(Application app);
	
	public boolean deleteApplication(int applicationid);
	
	public boolean updateApplication(Application app);
	
	public List<Application> listAllApplications();
	
	public int getapplicationId(String email);
}
