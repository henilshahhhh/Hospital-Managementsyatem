package com.hospitalmangement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmanagement.dao.Userdao;
import com.hospitalmanagement.helper.Connectionprovider;
import com.hospitalmanagment.entity.User;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		String fname = request.getParameter("fullname");
		String email = request.getParameter("email");

		String pass = request.getParameter("password");
		System.out.println(email+" "+fname+ " "+ pass);
		Userdao ud = new Userdao(Connectionprovider.connect());
		
		HttpSession session = request.getSession();
		
		User um = new User(fname,email,pass);
		try {
			session.setAttribute("succ", "Register successfully");
			System.out.println("data inserted");
			ud.insert(um);
			response.sendRedirect("user_login.jsp");

		}catch(Exception e) {
			session.setAttribute("fail", "userid already exist");
			System.out.println("data not inserted");
			e.printStackTrace();
			response.sendRedirect("signup.jsp");
		}

	}

}
