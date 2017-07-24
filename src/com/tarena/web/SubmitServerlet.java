package com.tarena.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.dao.AddressDAO;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.ItemDAO;
import com.tarena.dao.OrderDAO;
import com.tarena.entity.Address;
import com.tarena.entity.BookItem;
import com.tarena.entity.Cart;
import com.tarena.entity.Item;
import com.tarena.entity.Order;


public class SubmitServerlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		String receiveName = request.getParameter("receiveName");
		String fullAddress = request.getParameter("fullAddress");
		String postalCode = request.getParameter("postalCode");
		String mobile = request.getParameter("mobile");
		String phone = request.getParameter("phone");
		Address address = new Address();
		address.setUserId(userId);
		address.setReceiveName(receiveName);
		address.setFullAddress(fullAddress);
		address.setPostalCode(postalCode);
		address.setPhone(phone);
		address.setMobile(mobile);
		AddressDAO addressDAO= DAOFactory.saveAddressDAO();
		addressDAO.saveAddress(address);
		Order order = new Order();//Order在购物车里
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		order.setOrderTime(sdf.format(date));
		HttpSession session =request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		order.setTotalPrice(cart.getTotleA());
		order.setUserId(userId);
		OrderDAO orderDAO= DAOFactory.getOrderDAO();
		int orderId=orderDAO.saveOrder(order);
		//存储具体的商品条目
		ItemDAO itemDAO= DAOFactory.getItemDAO();
		ArrayList<BookItem> list= cart.getItemList();
		for (BookItem bookItem : list) {
			Item item=new Item();
			item.setOrderId(orderId);
			item.setBookId(bookItem.getBook().getId());
			item.setBookName(bookItem.getBook().getProductName());
			item.setBookNum(bookItem.getCount());
			item.setAmount(bookItem.getTotleA());
			item.setDangPrice(bookItem.getBook().getDangPrice());
			itemDAO.savdItem(item);
		}
		cart.getItemList().clear();
		session.setAttribute("cart", cart);
		request.setAttribute("orderId", orderId);
		request.getRequestDispatcher("order_ok.jsp").forward(request, response);
	}	
	}


