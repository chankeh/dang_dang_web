package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tarena.dao.ItemDAO;
import com.tarena.entity.Item;
import com.tarena.util.DBUtil;

public class ItemDAOImpl implements ItemDAO {
	private static final String SQL_INSERT="";
	public void savdItem(Item item) {
		try {
			Connection con = DBUtil.getConnection();
			String sql = "insert into d_item(order_id,book_id,book_name,dang_price,book_num,amount) values(?,?,?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, item.getOrderId());
			prep.setInt(2, item.getBookId());
			prep.setString(3, item.getBookName());
			prep.setDouble(4, item.getDangPrice());
			prep.setInt(5, item.getBookNum());
			prep.setDouble(6, item.getAmount());
			prep.executeUpdate();
			DBUtil.close(null, prep, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
