package com.pro.uas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pro.uas.dto.Application;
import com.pro.uas.dto.Participant;
import com.pro.uas.dto.Programs_Offered;
import com.pro.uas.dto.Programs_Scheduled;
import com.pro.uas.dto.Users;
import com.pro.uas.repositories.URL;

public class UniversityDAOImpl implements UniversityDAO{

	Connection con=null;
	PreparedStatement pstmt  = null;
	ResultSet rs = null;
	CallableStatement cstmt = null;
//	Users user=null;
	Users user=new Users();
	Programs_Offered po =new Programs_Offered();
	Programs_Scheduled ps=new Programs_Scheduled();
	Application app=new Application();
	URL url = new URL();
	@Override
	public Users login(String loginId, String password, String role) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url.getURL());
			pstmt = con.prepareStatement("select * from users where login_id = ? and password = ? and role = ?");
			pstmt.setString(1, loginId);
			pstmt.setString(2, password);
			pstmt.setString(3, role);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Users us = new Users();
				us.setLogin_id(rs.getString("login_id"));
				us.setPassword(rs.getString("password"));
				us.setRole(rs.getString("role"));
//				user = u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	@Override
	public boolean addProgramOffered(Programs_Offered po) {
		// TODO Auto-generated method stub
		boolean state = false;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		
		String query = "insert into programs_offered values(?,?,?,?,?)";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,po.getProgramname());
		pstmt.setString(2,po.getDescription());
		pstmt.setString(3,po.getEligibility());
		pstmt.setInt(4,po.getDuration());
		pstmt.setString(5, po.getDegreeoffered());
		int count = pstmt.executeUpdate();
		if(count>0)
		{
			state= true;
		}
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		      
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return state;
	}

	@Override
	public boolean updateProgramOffered(Programs_Offered po) {
		// TODO Auto-generated method stub
		boolean state = false;
		try
		{	
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url.getURL());
			
			
			String query = "update programs_offered set ProgramName=?, description=? applicant_eligility=?,"
					+ "duration=?,degree_certificate_offered=? ";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,po.getProgramname());
			pstmt.setString(2,po.getDescription());
			pstmt.setString(3,po.getEligibility());
			pstmt.setInt(4,po.getDuration());
			pstmt.setString(5, po.getDegreeoffered());

			
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				state = true;
			}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean deleteProgramOffered(String Programname) {
		// TODO Auto-generated method stub
		boolean state = false;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		String query = "delete from programs_offered where ProgramName=?";
		pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,Programname);
		
		int count = pstmt.executeUpdate();
		if(count>0)
		{
			state= true;
		}
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		    return false;
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
		}
	

	@Override
	public List<Programs_Offered> listAllPrograms() {
		// TODO Auto-generated method stub
		boolean state = false;
		List<Programs_Offered> list = new ArrayList<Programs_Offered>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url.getURL());
			cstmt=con.prepareCall("call getAllProgramName()");
			state = cstmt.execute();
			if(state) {
				rs = cstmt.getResultSet();
				while (rs.next()) {
					po.setProgramname(rs.getString(1));
					po.setDescription(rs.getString(2));
					po.setEligibility(rs.getString(3));
					po.setDuration(rs.getInt(4));
					po.setDegreeoffered(rs.getString(5));
					list.add(po);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cstmt != null) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public boolean createScheduledProgram(Programs_Scheduled ps) {
		// TODO Auto-generated method stub
		boolean state = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url.getURL());
			String query = "insert into programs_scheduled values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,ps.getProgramid());
			pstmt.setString(2,ps.getProgramname());
			pstmt.setString(3,ps.getLocation());
			pstmt.setDate(4,ps.getStartdate());
			pstmt.setDate(5, ps.getEnddate());
			pstmt.setInt(6, ps.getSessionsperweek());
			
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				state = true;
			}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
		}
		

	@Override
	public boolean updateScheduledProgram(Programs_Scheduled ps) {
		// TODO Auto-generated method stubtry
		boolean state = false;
		try
		{	
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url.getURL());
			
			
			String query = "update programs_offered set Program_Name=? Location=?,"
					+ "Start_Date=?,End_Date=?, Sessions_per_Week ";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,ps.getProgramname());
			pstmt.setString(2,ps.getLocation());
			pstmt.setDate(3,ps.getStartdate());;
			pstmt.setDate(4,ps.getEnddate());
			pstmt.setInt(5, ps.getSessionsperweek());

			
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				state = true;
			}
			
		}
	  catch(Exception e) {
		  e.printStackTrace();
	  }
		finally
		{
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean deleteScheduledProgram(int programid) {
		// TODO Auto-generated method stub
		boolean state = false;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		String query = "delete from programs_offered where Scheduled_Program_Id=?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,programid);
		
		int count = pstmt.executeUpdate();
		if(count>0)
		{
			state= true;
		}
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		    
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public List<Programs_Scheduled> listAllScheduledPrograms() {
		// TODO Auto-generated method stub
		boolean state = false;
		List<Programs_Scheduled> list = new ArrayList<Programs_Scheduled>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url.getURL());
			cstmt = con.prepareCall("call getAllScheduledPrograms()");
			state = cstmt.execute();
			if (state) {
				rs = cstmt.getResultSet();
				while (rs.next()) {
					ps.setProgramid(rs.getInt(1));
					ps.setProgramname(rs.getString(2));
					ps.setLocation(rs.getString(3));
					ps.setStartdate(rs.getDate(4));
					ps.setEnddate(rs.getDate(5));
					ps.setSessionsperweek(rs.getInt(6));
					list.add(ps);
					
				}
			}
		}
		catch(Exception e) {
			
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cstmt != null) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
		}
		

	@Override
	public boolean applyApplication(Application app) {
		// TODO Auto-generated method stub
		boolean state = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url.getURL());
			String query="insert into application values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1,app.getApplicationid());
			pstmt.setString(2, app.getName());
			pstmt.setString(3, app.getDateofbirth());
			pstmt.setString(4, app.getQualification());
			pstmt.setInt(5, app.getMarks());
			pstmt.setString(6, app.getGoals());
			pstmt.setString(7, app.getEmailid());
			pstmt.setInt(8,app.getProgramid());
			pstmt.setString(9, app.getStatus());
			pstmt.setString(10, app.getInterviewdate());
						
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				state= true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean deleteApplication(int applicationid) {
		// TODO Auto-generated method stub
		boolean state = false;
		try {
            Class.forName("com.mysql.jdbc.Driver");			
			con = DriverManager.getConnection(url.getURL());
			
			String query="delete from application where Application_id = ?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, applicationid);
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				state= true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean updateApplication(Application app) {
		// TODO Auto-generated method stub
		boolean state=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			con = DriverManager.getConnection(url.getURL());
			
			String query="update application set full_name = ?, date_of_birth = ?, highest_qualification = ?" + 
					"goals = ?, marks_obtained = ?, email_id = ?, scheduled_program_id = ?, status = ?, date_of_interview = ? where application_id = ?";
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setString(1, app.getName());
			pstmt.setString(2, app.getDateofbirth());
			pstmt.setString(3, app.getQualification());
			pstmt.setInt(4, app.getMarks());
			pstmt.setString(5, app.getGoals());
			pstmt.setString(6, app.getEmailid());
			pstmt.setInt(7,app.getProgramid());
			pstmt.setString(8, app.getStatus());
			pstmt.setString(9, app.getInterviewdate());
			pstmt.setInt(10,app.getApplicationid());
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				state= true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public List<Application> listAllApplications() {
		// TODO Auto-generated method stub
		boolean state = false;
		List<Application> list = new ArrayList<Application>();
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			con = DriverManager.getConnection(url.getURL());
			cstmt = con.prepareCall("call getAllApplications()");
			state = cstmt.execute();
			if (state) {
				rs = cstmt.getResultSet();
				while (rs.next()) {
					app.setApplicationid(rs.getInt(1));
					app.setName(rs.getString(2));
					app.setDateofbirth(rs.getString(3));
					app.setQualification(rs.getString(4));
					app.setMarks(rs.getInt(5));
					app.setGoals(rs.getString(6));
					app.setEmailid(rs.getString(7));
					app.setProgramid(rs.getInt(8));
					app.setStatus(rs.getString(9));
					app.setInterviewdate(rs.getString(10));
					list.add(app);
					
				}
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cstmt != null) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public int getapplicationId(String email) {
		// TODO Auto-generated method stub
		int applicationid=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url.getURL());
			String query="select application_id from application where email_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				 applicationid = rs.getInt("application_id");
				 
			}
		}
		catch(Exception e){
			
		}
		finally {
			if (con != null) {
				try {
					con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if (pstmt != null) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if (rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
return applicationid;
			
		}
	
}
