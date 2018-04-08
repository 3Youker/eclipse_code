package com.wit.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wit.domain.User;
import com.wit.exception.UserException;
import com.wit.service.UserService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/register")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ckcode=request.getParameter("ckcode");
	  
		String checkcode_session=(String) request.getSession().getAttribute("checkcode_session");
		
		if(!checkcode_session.equals(ckcode)){
			request.setAttribute("ckcode_msg","ÑéÖ¤Âë´íÎó");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return ;
		}
		User user=new User();
		
		try {
			BeanUtils.populate(user, request.getParameterMap());
			 user.setActiveCode(UUID.randomUUID().toString());
			UserService us=new UserService();
			
			us.regist(user);
			//request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
			
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("user_msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
