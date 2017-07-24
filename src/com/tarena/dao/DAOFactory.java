package com.tarena.dao;

import com.tarena.dao.impl.AddressImpl;
import com.tarena.dao.impl.BookDAOImpl;
import com.tarena.dao.impl.ItemDAOImpl;
import com.tarena.dao.impl.OrderImpl;
import com.tarena.dao.impl.UserDAOImpl;

public class DAOFactory {
	public static BookDAO getBookDAO(){
		return new BookDAOImpl();
	}
	public static UserDAO getUserDAO(){
		return new UserDAOImpl();
	}
	public static AddressDAO saveAddressDAO(){
		return new AddressImpl();
		
	}
	public static OrderDAO getOrderDAO(){
		return new OrderImpl();
	}
	public static ItemDAO getItemDAO(){
		return new ItemDAOImpl();
	}
}
