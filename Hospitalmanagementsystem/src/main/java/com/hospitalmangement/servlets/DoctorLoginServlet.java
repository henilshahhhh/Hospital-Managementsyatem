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
 * Servlet implementation class DoctorLoginServlet
 */
@WebServlet("/DoctorLoginServlet")
public class DoctorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLoginServlet() {
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
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			HttpSession session =request.getSession();
			
			DoctorDao dao = new DoctorDao(Connectionprovider.connect());
			Doctor doc= dao.login(email, password);
			if(doc!=null) {
				session.setAttribute("docobj",doc);
				response.sendRedirect("doctor/doctor_index.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Invalid email or password");
				response.sendRedirect("doctor_login.jsp");

			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
