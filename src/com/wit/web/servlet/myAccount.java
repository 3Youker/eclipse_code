package com.wit.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wit.domain.User;

/**
 * Servlet implementation class myAccount
 */
@WebServlet("/myAccount")
public class myAccount extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user=(User) request.getSession().getAttribute("user");
		
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else
		{
			String path="/myAccount.jsp";
			if("admin".equals(user.getRole())){
				path="admin/login/home.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
			
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
