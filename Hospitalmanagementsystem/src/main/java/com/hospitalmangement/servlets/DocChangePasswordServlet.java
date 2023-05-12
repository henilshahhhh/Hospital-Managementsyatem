package com.hospitalmangement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmanagement.dao.DoctorDao;
import com.hospitalmanagement.dao.Userdao;
import com.hospitalmanagement.helper.Connectionprovider;

/**
 * Servlet implementation class DocChangePasswordServlet
 */
@WebServlet("/DocChangePasswordServlet")
public class DocChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocChangePasswordServlet() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");

		DoctorDao dao = new DoctorDao(Connectionprovider.connect());
		HttpSession session = request.getSession();

		if (dao.checkOldPassword(uid, oldPassword)) {

			if (dao.changePassword(uid, newPassword)) {
				session.setAttribute("succMsg", "Password Change Sucessfully");
				response.sendRedirect("doctor_login.jsp");

			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				response.sendRedirect("doctor/editprofile_doc.jsp");
			}

		} else {
			session.setAttribute("errorMsg", "Old Password Incorrect");
			response.sendRedirect("doctor/editprofile_doc.jsp");
		}

	}
	}


