package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.dao.OrderDAO;
import com.tarena.entity.Order;
import com.tarena.util.DBUtil;

public class OrderImpl implements OrderDAO{

	public int saveOrder(Order order) {
		int orderId=0;
		try {
			Connection con=DBUtil.getConnection();
			String sql="insert into d_order(user_id,order_time,total_price) values(?,?,?)";
			PreparedStatement prep=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			prep.setInt(1, order.getUserId());
			prep.setString(2, order.getOrderTime());
			prep.setDouble(3, order.getTotalPrice());
			prep.executeUpdate();
			ResultSet rs=prep.getGeneratedKeys();
			if(rs.next()){
				orderId=rs.getInt(1);
			}
			DBUtil.close(rs, prep, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderId;
	}
	}


