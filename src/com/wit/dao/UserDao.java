package com.wit.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.wit.domain.User;
import com.wit.util.C3P0Util;

public class UserDao {

	public void addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="INSERT INTO USER(username,PASSWORD,gender,email,telephone,introduce,activecode,state,registtime)"+"VALUE(?,?,?,?,?,?,?,?,?)";
		qr.update(sql,user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getTelephone(),
				user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRegistTime());
		
	}

	public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		
		return qr.query("select * from user where username=? and password=?",new BeanHandler<User>(User.class),username,password);
	}

	public User findUserById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where id=?", new BeanHandler<User>(User.class),id);
	}

	public void modifyUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("update user set password=?,gender=?,telephone=? where id=?",user.getPassword(),user.getGender(),user.getTelephone(),user.getId());
	}

}
