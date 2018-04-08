package com.wit.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wit.domain.User;
import com.wit.exception.UserException;
import com.wit.service.UserService;

/**
 * Servlet implementation class findUserById
 */
@WebServlet("/findUserById")
public class findUserById extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =request.getParameter("id");
		
		UserService us=new UserService();
		
	    try {
			User user=	us.findUserById(id);
			request.setAttribute("u",user);
			request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);
		} catch (UserException e) {
			// TODO Auto-generated catch block
		//	response.getWriter().write(e.getMessage());
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
	    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
