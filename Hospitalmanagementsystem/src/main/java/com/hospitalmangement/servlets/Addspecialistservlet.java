package com.hospitalmangement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmanagement.dao.SpecialistDao;
import com.hospitalmanagement.helper.Connectionprovider;

/**
 * Servlet implementation class Addspecialistservlet
 */
@WebServlet("/Addspecialistservlet")
public class Addspecialistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addspecialistservlet() {
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
		String specName = request.getParameter("specName");
		
		SpecialistDao dao = new SpecialistDao(Connectionprovider.connect());
		
		boolean f=dao.addspecialist(specName);
		
		HttpSession session = request.getSession();
		if(f==true) {
			session.setAttribute("succMsg", "Specialist Added");
			response.sendRedirect("admin/admin_index.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something went wrong");
			response.sendRedirect("admin_login.jsp");

		}

	}

}
