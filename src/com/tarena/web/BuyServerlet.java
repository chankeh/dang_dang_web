package com.tarena.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.dao.BookDAO;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Book;
import com.tarena.entity.BookItem;
import com.tarena.entity.Cart;

public class BuyServerlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int index = -1;
		PrintWriter out=response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		BookDAO bookDAO= DAOFactory.getBookDAO();
		Book book=bookDAO.getBookById(id);
		HttpSession session =request.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
		if(cart==null){
			session.setAttribute("cart", new Cart());
			cart=(Cart)session.getAttribute("cart");
		}else{
			ArrayList<BookItem> list= cart.getItemList();
			for (BookItem bookItem : list) {
				System.out.println("dd"+bookItem.getBook().getId());
				System.out.println("id:"+id);
				if(bookItem.getBook().getId()==id){
					index=1;
				}
			}
		}
		if(index!=1){
			cart.getItemList().add(new BookItem(1,book));
			session.setAttribute("cart", cart);
		}
		if(index==1){
			out.write("1");
		}else{
			out.write("0");
		}
	}
}
