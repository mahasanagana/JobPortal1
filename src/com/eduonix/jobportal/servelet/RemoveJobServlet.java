package com.eduonix.jobportal.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduonix.jobportal.dao.JobPostingDAO;
import com.eduonix.jobportal.entity.JobPosting;


@WebServlet(urlPatterns={"/RemoveJob","/JobRemove"})

public class RemoveJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RemoveJobServlet() {
    	super();
 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/removeJob.jsp");
		rd.forward(request,response);
}
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobPostingDAO dao = new JobPostingDAO();
	  int JobPostingId=Integer.parseInt(request.getParameter("id"));
	JobPosting post=dao.getJobPostingById(JobPostingId);
   
   if(post==(null))
   {
	   request.setAttribute("error",true);
	   RequestDispatcher rd=request.getRequestDispatcher("/removeJob.jsp");  
	   rd.forward(request,response);
   }
	if(post.getJobPostingPassword().equals(request.getParameter("password")));
        dao.removeJobPosting(JobPostingId);
        RequestDispatcher rd=request.getRequestDispatcher("/removeJobuccess.jsp");  
        rd.forward(request,response);
   }
   else
   {
	   request.setAttribute("error",true);
	   RequestDispatcher rd=request.getRequestDispatcher("/removeJob.jsp");  
	   rd.forward(request,response);
	  }
   }
}