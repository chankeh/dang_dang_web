package com.tarena.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.entity.BookItem;
import com.tarena.entity.Cart;

public class CartServerlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session =request.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
		if(cart==null||cart.getItemList().size()==0){
			request.setAttribute("list", null);
		
		}else{
		ArrayList<BookItem>list =cart.getItemList();
		request.setAttribute("list",list);
		
		}
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}
