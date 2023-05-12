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
 * Servlet implementation class DoctorUpdateProfileServlet
 */
@WebServlet("/DoctorUpdateProfileServlet")
public class DoctorUpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorUpdateProfileServlet() {
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

			String fullName = request.getParameter("fullname");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("qualification");
			String spec = request.getParameter("spec");
			String email = request.getParameter("email");
			String mobno = request.getParameter("mobno");

			int id = Integer.parseInt(request.getParameter("id"));

			Doctor d = new Doctor(id, fullName, dob, qualification, spec, email, mobno, "");

			DoctorDao dao = new DoctorDao(Connectionprovider.connect());
			HttpSession session = request.getSession();

			if (dao.editDoctorProfile(d)) {
				Doctor updateDoctor = dao.getDoctorById(id);
				session.setAttribute("succMsgd", "Doctor Update Sucessfully..");
				session.setAttribute("doctObj", updateDoctor);
				response.sendRedirect("doctor_login.jsp");
			} else {
				session.setAttribute("errorMsgd", "something wrong on server");
				response.sendRedirect("doctor/editprofile_doc.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
