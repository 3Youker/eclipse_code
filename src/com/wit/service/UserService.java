package com.wit.service;

import java.sql.SQLException;

import com.wit.dao.UserDao;
import com.wit.domain.User;
import com.wit.exception.UserException;

public class UserService {
		UserDao ud=new UserDao();
	public void regist(User user) throws UserException{
		// TODO Auto-generated method stub
		try{
		ud.addUser(user);
		
		
		}catch(SQLException e){
			e.printStackTrace();
				throw new UserException("ע��ʧ��");
			} 
			
		}
	public User login(String username, String password) throws UserException{
		// TODO Auto-generated method stub
		
		User user=null;
		try{
		 user= ud.findUserByUserNameAndPassword(username,password);
		if(user==null){
			throw new UserException("�û������������");
		}
		}catch(SQLException e){
			e.printStackTrace();
			throw new UserException("�û������������");
			
		}
		return user;
		
	}
	public User findUserById(String id) throws UserException {
		// TODO Auto-generated method stub
		try {
			return ud.findUserById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("�û�����ʧ��");
		}
	}
	public void modifyUser(User user) throws UserException {
		// TODO Auto-generated method stub
		try {
			ud.modifyUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("�޸�ʧ��");
		}
	}
	
	}


