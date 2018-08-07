package com.eduonix.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eduonix.jobportal.entity.JobPosting;

public class JobPostingDAO {
	private Connection conn;

	public JobPostingDAO() {
		
		final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		final String Database_URL="jdbc:mysql://Localhost/JobPortal";
		final String Database_USER="root";
		final String Database_Pass="";
		try
		{
			Class.forName(JDBC_DRIVER);
		}
		catch (ClassNotFoundException e){
	    e.printStackTrace();
		}
		try {
			this.conn=DriverManager.getConnection(Database_URL,Database_USER,Database_Pass);
		} 
		  catch (SQLException e) {
	      e.printStackTrace();
		}
	}
	public JobPosting getJobPostingById(int id)
	{
	Statement st;
	try 
	{
		st=conn.createStatement();
	    ResultSet rs=st.executeQuery("select all from JobPostings where id= +id");
	   if(rs.next())
	   {
		   JobPosting jobPosttoReturn=new JobPosting();
		   jobPosttoReturn.setContactPhone(rs.getString("contactPhone"));
		   jobPosttoReturn.setMessageBody(rs.getString("messageBody"));
		   jobPosttoReturn.setJobName(rs.getString("jobName"));
		   jobPosttoReturn.setPosterName(rs.getString("posterName"));
		   jobPosttoReturn.setId(rs.getInt("id"));
		   jobPosttoReturn.setJobPostingPassword(rs.getString("jobPostingPassword"));
	   
		   return jobPosttoReturn;
      }
	   st.close();
	   rs.close();
	   }
		 catch (SQLException e){
		 e.printStackTrace();
	}
	finally{
		}
	return null;
	}
   public void insertJobPosting(JobPosting posting){
   String sep="','";
   {
	  try {
		Statement st=conn.createStatement();
	    String sqlQuery="insert into jobPostings(messageBody,jobName,"
	    		+ "posterName,contactPhone,jobPostingPassword)values('"
	    		+posting.getMessageBody()+sep + posting.getJobName() 
	    		      + sep + posting.getPosterName() 
	    		      + sep + posting.getContactPhone() 
	    		      + sep + posting.getJobPostingPassword()+"')";
	  st.executeUpdate(sqlQuery);
	  System.out.print(sqlQuery);
	  st.close();
	 } 
	  catch (SQLException e) {
	  e.printStackTrace();
	  }}
   }
   public void removeJobPosting(int jobPostId){
	   Statement st;
	   try{
		   st=conn.createStatement();
	       st.executeUpdate("DELETE FROM JOBPOSTINGS WHERE ID="+jobPostId);
	   }
	   catch (SQLException e) {
	   e.printStackTrace();
	   }
   }
   public List<JobPosting>getAllJobPostings()

   {
	   Statement st;
	   ResultSet rs;
	   try{
	     st=conn.createStatement();
		 rs=st.executeQuery("select* from jobPostings limit 200");
	    List<JobPosting> jobs=new ArrayList<JobPosting>();
	    while(rs.next())
	    {
	    	  JobPosting jobPosttoadd=new JobPosting();
	    	  jobPosttoadd.setContactPhone(rs.getString("contactPhone"));
	    	  jobPosttoadd.setMessageBody(rs.getString("messageBody"));
	    	  jobPosttoadd.setJobName(rs.getString("jobName"));
	    	  jobPosttoadd.setPosterName(rs.getString("posterName"));
	    	  jobPosttoadd.setId(rs.getInt("id"));
	    	  jobPosttoadd.setJobPostingPassword(rs.getString("jobPostingPassword"));
		   
	    	  jobs.add(jobPosttoadd);
	   } 
	    st.close();
	    rs.close();
	    return jobs;
	   }
	  catch (SQLException e) {
	  e.printStackTrace();
	}
	return null;
  
   }
   
   public void close(){
	try{
		conn.close();}
	catch(SQLException e){
    e.printStackTrace();
		
	}
}
}
