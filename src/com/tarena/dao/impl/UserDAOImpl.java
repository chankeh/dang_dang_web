package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.DBUtil;

public class UserDAOImpl implements UserDAO{

	public User getUserByEmail(String email) {
		User user=null;
		try {
			Connection con=DBUtil.getConnection();
			String sql="select * from d_user where email=?";
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setString(1, email);
			ResultSet rs=prep.executeQuery();
			while(rs.next()){
			    user=new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
			}
			DBUtil.close(rs, prep, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void saveUser(String email, String nickname, String password) {
		try {
			Connection con= DBUtil.getConnection();
			String sql="insert into d_user(email,nickname,password) values(?,?,?)";
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setString(1, email);
			prep.setString(2, nickname);
			prep.setString(3, password);
			prep.executeUpdate();
			DBUtil.close(null, prep, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean isRegisterUser(User u) {
		boolean flag=false;
		try {
			Connection con = DBUtil.getConnection();
			String sql = "select * from d_user where email=? and password=?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, u.getEmail());
			prep.setString(2, u.getPassword());
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				flag = true;
			}
			DBUtil.close(rs, prep, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public User isRegisterUser(String email, String password) {
		User user = null;
		try {
			Connection con = DBUtil.getConnection();
			String sql = "select * from d_user where email=? and password=?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, email);
			prep.setString(2, password);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
			    user = new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
			}
			DBUtil.close(rs, prep, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
