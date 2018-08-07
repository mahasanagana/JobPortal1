package com.eduonix.jobportal.servelet;

import java.awt.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduonix.jobportal.dao.JobPostingDAO;
import com.eduonix.jobportal.entity.JobPosting;


@WebServlet("/ViewJobs")
public class ViewJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ViewJobServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		JobPostingDAO dao = new JobPostingDAO();
		
   List<JobPosting> jobs = dao.getAllJobPostings();
   request.setAttribute("jobs",jobs);
  
   RequestDispatcher rd = request.RequestDispatcher("/ViewJobServlet");
   rd.forward(request,response);
   
 }
}
