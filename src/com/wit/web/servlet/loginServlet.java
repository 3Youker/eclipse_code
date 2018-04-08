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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	
       
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	String username=	request.getParameter("username");
		String password=request.getParameter("password");
		
		UserService us=new UserService();
		try {
			String path="/index.jsp";
			User user=us.login(username,password);
			if("admin".equals(user.getRole())){
			path="/admin/login/home.jsp";	
			}
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("user_msg", e.getMessage());
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
