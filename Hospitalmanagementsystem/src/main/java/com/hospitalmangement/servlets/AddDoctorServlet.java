package com.hospitalmangement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmanagement.dao.DoctorDao;
import com.hospitalmanagement.helper.Connectionprovider;
import com.hospitalmanagment.entity.Doctor;

/**
 * Servlet implementation class AddDoctorServlet
 */
@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String fullname=request.getParameter("fullname");
			String dob=request.getParameter("dob");
			String qualification=request.getParameter("qualification");
			String spec=request.getParameter("spec");
			String email=request.getParameter("email");
			String mobno=request.getParameter("mobno");
			String password=request.getParameter("password");
			
			Doctor d = new Doctor(fullname, dob, qualification, spec, email, mobno, password);
			DoctorDao dao = new DoctorDao(Connectionprovider.connect());
			
			HttpSession session = request.getSession();
			if(dao.registerDoctor(d)) {
				session.setAttribute("succMsg", "Doctor added successfully");
				response.sendRedirect("admin/doctor.jsp");
				
				
			}else {
				session.setAttribute("errorMsg", "Something went wrong");
				response.sendRedirect("admin/doctor.jsp");

				
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
