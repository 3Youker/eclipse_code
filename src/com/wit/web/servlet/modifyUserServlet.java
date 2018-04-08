package com.wit.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wit.domain.User;
import com.wit.service.UserService;

/**
 * Servlet implementation class modifyUserServlet
 */
@WebServlet("/modifyUserServlet")
public class modifyUserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		User  user=new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			
			UserService us=new UserService();
			us.modifyUser(user);
			request.getSession().invalidate();//×¢Ïú
			response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().write(e.getMessage());
			
			
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
