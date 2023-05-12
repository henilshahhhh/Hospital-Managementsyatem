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
 * Servlet implementation class UpdateDoctorServlet
 */
@WebServlet("/UpdateDoctorServlet")
public class UpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Doctor d = new Doctor(id,fullname, dob, qualification, spec, email, mobno, password);
			DoctorDao dao = new DoctorDao(Connectionprovider.connect());
			
			HttpSession session = request.getSession();
			if(dao.updateDoctor(d)) {
				session.setAttribute("succMsg", "Doctor updated successfully");
				response.sendRedirect("admin/view_doctor.jsp");
				
				
			}else {
				session.setAttribute("errorMsg", "Something went wrong");
				response.sendRedirect("admin/view_doctor.jsp");

				
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	}


