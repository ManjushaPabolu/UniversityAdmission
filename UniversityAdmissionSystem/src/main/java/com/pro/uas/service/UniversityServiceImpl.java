package com.pro.uas.service;

import java.util.List;

import com.pro.uas.dao.UniversityDAO;
import com.pro.uas.dao.UniversityDAOImpl;
import com.pro.uas.dto.Application;
import com.pro.uas.dto.Programs_Offered;
import com.pro.uas.dto.Programs_Scheduled;
import com.pro.uas.dto.Users;

public class UniversityServiceImpl implements UniversityService{

	UniversityDAOImpl impl=new UniversityDAOImpl();
	@Override
	public Users login(String loginId, String password, String role) {
		// TODO Auto-generated method stub
		Users us= impl.login(loginId, password, role);
		if(us!=null)
		{
			return us;
		}
		return null;
	}

	@Override
	public boolean addProgramOffered(Programs_Offered po) {
		// TODO Auto-generated method stub
		
		boolean result=impl.addProgramOffered(po);
		if(result) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateProgramOffered(Programs_Offered po) {
		// TODO Auto-generated method stub
		
		boolean result=impl.updateProgramOffered(po);
		if(result) {
			return true;
		}
			return false;
	}

	@Override
	public boolean deleteProgramOffered(String Programname) {
		// TODO Auto-generated method stub
		boolean result=impl.deleteProgramOffered(Programname);
		if(result)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Programs_Offered> listAllPrograms() {
		List<Programs_Offered> al=impl.listAllPrograms();
		if(al!=null) {
			return al;
		}
		return null;
	}

	@Override
	public boolean createScheduledProgram(Programs_Scheduled ps) {
		// TODO Auto-generated method stub
		boolean result=impl.createScheduledProgram(ps);
		if(result) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateScheduledProgram(Programs_Scheduled ps) {
		// TODO Auto-generated method stub
		
			boolean result = impl.updateScheduledProgram(ps);
			if(result)
			{
				return true;
			}
		return false;
	}
	
	
	

	@Override
	public boolean deleteScheduledProgram(int programid) {
	boolean result = impl.deleteScheduledProgram(programid);
	if(result)
	{
		return true;
	}
	return false;
		
	}

	@Override
	public List<Programs_Scheduled> listAllScheduledPrograms() {
		
		List<Programs_Scheduled> as=impl.listAllScheduledPrograms();         
		if(as!=null)
		{
			return as;
		}
		return null;

	}

	@Override
	public boolean applyApplication(Application app) {

			boolean result= impl.applyApplication(app);
		if(result) {
			return true;
		}
		return false;
	}
	

	@Override
	public boolean deleteApplication(int applicationid) {
		boolean result=impl.deleteApplication(applicationid);
		if(result)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateApplication(Application app) {
		boolean result=impl.updateApplication(app);
		if(result)
		{
			return true;
		}
		
		return false;
	}
	@Override
	public List<Application> listAllApplications() {
		// TODO Auto-generated method stub
				List<Application> al=impl.listAllApplications();
				if(al!=null) {
					return al;
				}
		return null;
	}

	@Override
	public int getapplicationId(String email) {
		int applicationid=impl.getapplicationId(email);
		if(applicationid!=0) {
			return applicationid;
		}
		return 0;
	}

}
