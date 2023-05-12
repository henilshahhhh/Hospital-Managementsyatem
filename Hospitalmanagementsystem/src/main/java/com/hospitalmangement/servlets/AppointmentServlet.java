package com.hospitalmangement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmanagement.dao.AppointmentDao;
import com.hospitalmanagement.helper.Connectionprovider;
import com.hospitalmanagment.entity.Appointment;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
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
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String appoint_date = request.getParameter("appoint_date");
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");
		String diseases = request.getParameter("diseases");
		int doctor_id = Integer.parseInt(request.getParameter("doct"));
		String address = request.getParameter("address");

		Appointment ap = new Appointment( fullname, gender, age, appoint_date, email, phno, diseases, doctor_id,
				address, "Pending");

		AppointmentDao dao = new AppointmentDao(Connectionprovider.connect());
		HttpSession session = request.getSession();

		if (dao.addAppointment(ap)) {
			session.setAttribute("succMsg", "Appointment Sucessfully");
			response.sendRedirect("user_appointment.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("user_appointment.jsp");
		}

	}

}
