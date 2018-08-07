package com.eduonix.jobportal.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduonix.jobportal.dao.JobPostingDAO;
import com.eduonix.jobportal.entity.JobPosting;


@WebServlet("/postJob")
public class PostJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public PostJobServlet() {
    	super();
   }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
	RequestDispatcher rd=request.getRequestDispatcher("/postJob.jsp");	
	rd.forward(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	String messageBody=request.getparameter("messsagebody");
	String contactPhone=request.getparameter("contactphone");
	String posterName=request.getparameter("postername");
	String jobName=request.getparameter("jobname");
	String jobPostingPassword=request.getparameter("password");
	
	JobPosting jobPost = new JobPosting();
	
	jobPost.setContactPhone(contactPhone);
	jobPost.setJobName(jobName);
	jobPost.setJobPostingPassword(jobPostingPassword);
	jobPost.setMessageBody(messageBody);
	jobPost.setPosterName(posterName);
	
	JobPostingDAO dao=new JobPostingDAO();
	
	dao.insertJobPosting(jobPost);
	
	RequestDispatcher rd=request.getRequestDispatcher("/postJob.jsp");	
	rd.forward(request,response);
	
	
	
	}

}
