package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tarena.dao.AddressDAO;
import com.tarena.entity.Address;
import com.tarena.util.DBUtil;

public class AddressImpl implements AddressDAO{
	public void saveAddress(Address address) {
	 try {
		Connection con=	DBUtil.getConnection();
		String sql = "insert into d_receive_address(user_id,receive_name,full_address,postal_code,phone,mobile) values(?,?,?,?,?,?)";
		PreparedStatement prep = prep = con.prepareStatement(sql);
		prep.setInt(1, address.getUserId());
		prep.setString(2, address.getReceiveName());
		prep.setString(3, address.getFullAddress());
		prep.setString(4, address.getPostalCode());
		prep.setString(5, address.getPhone());
		prep.setString(6, address.getMobile());
		prep.executeUpdate();
		DBUtil.close(null, prep, con);
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	}

}
